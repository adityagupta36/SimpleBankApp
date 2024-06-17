package com.aditya.projects.SimpleBankingApp.repository;

import com.aditya.projects.SimpleBankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
