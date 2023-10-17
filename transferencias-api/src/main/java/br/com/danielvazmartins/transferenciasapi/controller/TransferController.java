package br.com.danielvazmartins.transferenciasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielvazmartins.transferenciasapi.dto.NewTransferDTO;
import br.com.danielvazmartins.transferenciasapi.model.AccountModel;
import br.com.danielvazmartins.transferenciasapi.model.TransferModel;
import br.com.danielvazmartins.transferenciasapi.service.TransferService;

@RestController
@RequestMapping("transfers")
public class TransferController {

    @Autowired
    TransferService transferService;
    
    @GetMapping
    public List<TransferModel> getAll() {
        return transferService.getAll();
    }

    @PostMapping()
    public String newTransfer(@RequestBody() NewTransferDTO newTransfer) {
        transferService.newTransfer(newTransfer);
        return "newTransfer";
    }
}
