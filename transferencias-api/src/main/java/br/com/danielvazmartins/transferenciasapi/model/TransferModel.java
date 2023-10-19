package br.com.danielvazmartins.transferenciasapi.model;

import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
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

    @CreationTimestamp
    private Date createdAt;
    private Date dateOfTransfer;
    @ManyToOne
    private AccountModel sourceAccount;
    @ManyToOne
    private AccountModel destinationAccount;
    private Double valueToTransfer;
    private Double tax;
}
