package com.example.gestionconge.repository;

import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Enumm.StatutDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {


}