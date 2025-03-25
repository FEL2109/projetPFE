package com.example.gestionconge.repository;

import com.example.gestionconge.entities.ValidationDemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidationDemandeCongeRepository extends JpaRepository<ValidationDemandeConge, Long> {

}