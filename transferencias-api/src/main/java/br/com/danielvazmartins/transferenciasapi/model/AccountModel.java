package br.com.danielvazmartins.transferenciasapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accounts")
public class AccountModel {
    @Id
    @Size(min = 10, max = 10)
    private Long account;
    private Double total = 0.0;
}
