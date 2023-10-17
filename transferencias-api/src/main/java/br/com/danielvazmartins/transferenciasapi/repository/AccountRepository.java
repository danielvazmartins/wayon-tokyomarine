package br.com.danielvazmartins.transferenciasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielvazmartins.transferenciasapi.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>{
    
}
