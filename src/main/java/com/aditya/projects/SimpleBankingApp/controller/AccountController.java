package com.aditya.projects.SimpleBankingApp.controller;

import com.aditya.projects.SimpleBankingApp.dto.AccountDto;
import com.aditya.projects.SimpleBankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banking/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 = accountService.createAccount(accountDto);
        return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


/*    @PutMapping("/deposit/{id}/{amount}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @PathVariable double amount) {
        AccountDto accountDto =  accountService.deposit(id, amount);
       return ResponseEntity.ok(accountDto);
    }*/

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("ammount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("ammount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    @GetMapping
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Deletion Success!!");
    }
}
