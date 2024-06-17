package com.aditya.projects.SimpleBankingApp.repository.mapper;

import com.aditya.projects.SimpleBankingApp.dto.AccountDto;
import com.aditya.projects.SimpleBankingApp.entity.Account;

public class AccountDtoMapper {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getAccountBalance());
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(account.getId(),account.getAccountHolderName(),account.getAccountBalance());
    }
}
