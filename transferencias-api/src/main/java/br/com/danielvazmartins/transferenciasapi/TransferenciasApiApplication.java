package br.com.danielvazmartins.transferenciasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info( title = "Transferências"))
public class TransferenciasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferenciasApiApplication.class, args);
	}

}
