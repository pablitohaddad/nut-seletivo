package io.github.pablitohaddad.apipncp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Preparando a aplicação para utilizar o feign
public class ApiPncpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPncpApplication.class, args);
    }

}
