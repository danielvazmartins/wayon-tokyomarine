package br.com.danielvazmartins.transferenciasapi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.danielvazmartins.transferenciasapi.model.AccountModel;
import br.com.danielvazmartins.transferenciasapi.repository.AccountRepository;

@Configuration
public class InitializeDatabaseRunner implements CommandLineRunner{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando base de dados...");

        AccountModel account1 = new AccountModel(1111111111L, 1000.0);
        accountRepository.save(account1);

        AccountModel account2 = new AccountModel(2222222222L, 50.0);
        accountRepository.save(account2);

        AccountModel account3 = new AccountModel(3333333333L, 250.0);
        accountRepository.save(account3);
        
        AccountModel account4 = new AccountModel(4444444444L, 670.0);
        accountRepository.save(account4);

        AccountModel account5 = new AccountModel(5555555555L, 290.0);
        accountRepository.save(account5);
    }
    
}
