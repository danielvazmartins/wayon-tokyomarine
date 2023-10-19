package br.com.danielvazmartins.transferenciasapi.dto;

import java.util.Date;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewTransferDTO {
    private Date dateOfTransfer;
    @Size(min = 10, max = 10, message = "Conta de origem inválida!")
    private Long sourceAccountNumber;
    @Size(min = 10, max = 10, message = "Conta de destino inválida!")
    private Long destinationAccountNumber;
    private Double valueToTransfer;
}
