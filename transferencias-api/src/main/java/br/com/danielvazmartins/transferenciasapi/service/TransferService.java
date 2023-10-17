package br.com.danielvazmartins.transferenciasapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.danielvazmartins.transferenciasapi.dto.NewTransferDTO;
import br.com.danielvazmartins.transferenciasapi.model.AccountModel;
import br.com.danielvazmartins.transferenciasapi.model.TransferModel;
import br.com.danielvazmartins.transferenciasapi.repository.AccountRepository;
import br.com.danielvazmartins.transferenciasapi.repository.TransferRepository;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<TransferModel> getAll() {
        return transferRepository.findAll();
    }
    
    public void newTransfer(NewTransferDTO newTransfer) {

        TransferModel transfer = new TransferModel();
        transfer.setDateOfTransfer(newTransfer.getDateOfTransfer());
        
        Optional<AccountModel> sourceAccount = accountRepository.findById(newTransfer.getSourceAccountNumber());
        if (sourceAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de origem não encontrada!");
        }
        transfer.setSourceAccount(sourceAccount.get());

        Optional<AccountModel> destinationAccount = accountRepository.findById(newTransfer.getDestinationAccountNumber());
        if (destinationAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de destino não encontrada!");
        }
        transfer.setDestinationAccount(destinationAccount.get());

        transfer.setValueToTransfer(newTransfer.getValueToTransfer());
        
        transferRepository.save(transfer);
    }
}
