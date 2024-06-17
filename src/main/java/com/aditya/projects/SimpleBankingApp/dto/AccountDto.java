package com.aditya.projects.SimpleBankingApp.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;

    String accountHolderName;

    double accountBalance;

}
