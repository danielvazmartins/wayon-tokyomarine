package br.com.danielvazmartins.transferenciasapi.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "transfers")
public class TransferModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @CreatedDate
    private Date date;
    private Date dateOfTransfer;
    @ManyToOne
    private AccountModel sourceAccount;
    @ManyToOne
    private AccountModel destinationAccount;
    private Double valueToTransfer;
}
