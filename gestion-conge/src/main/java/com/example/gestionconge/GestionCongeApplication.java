package com.example.gestionconge;

import com.example.gestionconge.repository.*;
import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.RegleConge;
import com.example.gestionconge.repository.EmployeRepository;
import com.example.gestionconge.repository.AbsenceRepository;
import com.example.gestionconge.entities.TypeConge;
import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.entities.Enumm.typeCongeLibelle;

import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Builder
@SpringBootApplication
public class GestionCongeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCongeApplication.class, args);
    }



    }
