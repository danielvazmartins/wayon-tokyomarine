package br.com.danielvazmartins.transferenciasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielvazmartins.transferenciasapi.model.AccountModel;
import br.com.danielvazmartins.transferenciasapi.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountModel> getAll() {
        return accountService.getAll();
    }
}
