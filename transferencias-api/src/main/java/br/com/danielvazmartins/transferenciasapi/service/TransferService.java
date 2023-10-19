package br.com.danielvazmartins.transferenciasapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

        transfer.setTax(getTaxForTransfer(newTransfer.getDateOfTransfer(), newTransfer.getValueToTransfer()));
        transferRepository.save(transfer);
    }

    private Double getTaxForTransfer(Date dateOfTransfer, Double valueToTransfer) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNow;
        try {
            dateNow = formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
            dateNow = new Date();
        }
        long diffInMilliSeconds = dateOfTransfer.getTime() - dateNow.getTime();
        long daysToTransfer = TimeUnit.DAYS.convert(diffInMilliSeconds, TimeUnit.MILLISECONDS);

        if (daysToTransfer == 0) {
            return 3 + (0.025 * valueToTransfer);
        } else if (daysToTransfer >= 1 && daysToTransfer <= 10) {
            return 12.0;
        } else if (daysToTransfer >= 11 && daysToTransfer <= 20) {
            return 0.082 * valueToTransfer;
        } else if (daysToTransfer >= 21 && daysToTransfer <= 30) {
            return 0.069 * valueToTransfer;
        } else if (daysToTransfer >= 31 && daysToTransfer <= 40) {
            return 0.047 * valueToTransfer;
        } else if (daysToTransfer >= 41 && daysToTransfer <= 50) {
            return 0.017 * valueToTransfer;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao calcular a taxa! Verifique a data do agendamento");
    }
}
