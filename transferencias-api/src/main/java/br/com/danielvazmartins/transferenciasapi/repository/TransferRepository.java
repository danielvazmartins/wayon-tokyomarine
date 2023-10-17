package br.com.danielvazmartins.transferenciasapi.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielvazmartins.transferenciasapi.model.TransferModel;

@Repository
public interface TransferRepository extends JpaRepository<TransferModel, UUID> {
    
}
