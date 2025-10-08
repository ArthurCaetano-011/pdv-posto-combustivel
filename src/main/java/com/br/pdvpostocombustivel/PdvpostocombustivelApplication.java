package com.br.pdvpostocombustivel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// OpenAPI / Swagger
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "PDV Posto Combustível API",
                version = "v1",
                description = "API de exemplo com CRUD de Pessoas (Spring Boot 3 / Java 17).",
                contact = @Contact(name = "Prof. Esp. Ednilton Rauh", email = "ednilton@example.com"),
                license = @License(name = "MIT")
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Ambiente Local")
        }
)
public class PdvpostocombustivelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdvpostocombustivelApplication.class, args);

        // Seu bloco de testes antigos pode ficar comentado aqui se quiser.
        // Como estamos usando Swagger, os testes podem ser feitos pela UI:
        // http://localhost:8080/swagger-ui.html
    }
}
       /*
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNomeCompleto("Kaio Jorge");
        pessoa1.setCpfCnpj("151.343.881-99");
        //pessoa1.setDataNascimento();
        pessoa1.setNumeroCtps(4581482L); // L maiúsculo indica Long

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomeCompleto("Matheus Pereira");
        pessoa2.setCpfCnpj("437.221.106-21");
        //pessoa2.setDataNascimento();
        pessoa2.setNumeroCtps(14999482L); // L maiúsculo indica Long

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNomeCompleto("Fabricio Bruno");
        pessoa3.setCpfCnpj("740.355.811-01");
        //pessoa1.setDataNascimento();
        pessoa3.setNumeroCtps(14581182L); // L maiúsculo indica Long

        //Instância Pessoa 1
        System.out.println("Nome Completo: " + pessoa1.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa1.getCpfCnpj());
        System.out.println("Numero CTPs: "+ pessoa1.getNumeroCtps());

        System.out.println("-------------------------------------------------");

        //Instância Pessoa 2
        System.out.println("Nome Completo: " + pessoa2.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa2.getCpfCnpj());
        System.out.println("Numero CTPs: "+ pessoa2.getNumeroCtps());

        System.out.println("-------------------------------------------------");

        //Instância Pessoa 3
        System.out.println("Nome Completo: " + pessoa3.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa3.getCpfCnpj());
        System.out.println("Numero CTPs: "+ pessoa3.getNumeroCtps());
        */





