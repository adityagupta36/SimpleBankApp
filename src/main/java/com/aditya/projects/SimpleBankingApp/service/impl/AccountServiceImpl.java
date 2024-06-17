package com.aditya.projects.SimpleBankingApp.service.impl;

import com.aditya.projects.SimpleBankingApp.dto.AccountDto;
import com.aditya.projects.SimpleBankingApp.entity.Account;
import com.aditya.projects.SimpleBankingApp.repository.AccountRepo;
import com.aditya.projects.SimpleBankingApp.repository.mapper.AccountDtoMapper;
import com.aditya.projects.SimpleBankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo repo;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountDtoMapper.mapToAccount(accountDto);
        repo.save(account);
        return AccountDtoMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = repo.findById(id).orElseThrow(()->new RuntimeException("Account Not Exist"));
        AccountDto accountDto = AccountDtoMapper.mapToAccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = repo.findById(id).orElseThrow(()->new RuntimeException("Account Not Exist"));
        Double total = account.getAccountBalance() + amount;
        account.setAccountBalance(total);
        repo.save(account);

        return AccountDtoMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        Account account = repo.findById(id).orElseThrow(()->new RuntimeException("Account Not Exist"));
        if (amount>account.getAccountBalance()){
            throw new RuntimeException("InSufficient Balance");
        }
        Double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);
        repo.save(account);

        return AccountDtoMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> listOfAccounts = repo.findAll();
        List<AccountDto> list = listOfAccounts.stream().map((account)-> AccountDtoMapper.mapToAccountDto(account)).collect(Collectors.toList());
        return list;
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = repo.findById(id).orElseThrow(()->new RuntimeException("Account Not Exist"));
        repo.deleteById(id);
    }
}
