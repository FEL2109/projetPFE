package com.example.gestionconge;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Builder
@SpringBootApplication
public class GestionCongeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCongeApplication.class, args);
    }

}


