package com.example.gestionconge.repository;

import com.example.gestionconge.entities.SoldeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldeCongeRepository extends JpaRepository<SoldeConge, Long > {
}
