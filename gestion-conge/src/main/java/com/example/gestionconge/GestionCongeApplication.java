package com.example.gestionconge;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Builder
@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.gestionconge.feign")
public class GestionCongeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCongeApplication.class, args);
    }

}


