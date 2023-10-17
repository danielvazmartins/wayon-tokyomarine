package br.com.danielvazmartins.transferenciasapi.dto;

import java.util.Date;
import lombok.Data;

@Data
public class NewTransferDTO {
    private Date dateOfTransfer;
    private Long sourceAccountNumber;
    private Long destinationAccountNumber;
    private Double valueToTransfer;
}
