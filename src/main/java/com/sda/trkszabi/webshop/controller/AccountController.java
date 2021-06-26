package com.sda.trkszabi.webshop.controller;

import com.sda.trkszabi.webshop.model.Account;
import com.sda.trkszabi.webshop.model.Product;
import com.sda.trkszabi.webshop.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        if (accountService.accountExist(account.getLogin())) {
            return ResponseEntity.badRequest().build();
        }
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created!");
    }

    @GetMapping("/accounts")
    public List<Account> getAllProducts() {
        return accountService.findAll();
    }

}
