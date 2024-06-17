package com.aditya.projects.SimpleBankingApp.service;

import com.aditya.projects.SimpleBankingApp.dto.AccountDto;
import com.aditya.projects.SimpleBankingApp.entity.Account;

import java.util.List;

public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, Double amount);

    AccountDto withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    public void deleteAccount(Long id);
}
