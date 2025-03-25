package com.example.gestionconge.repository;

import com.example.gestionconge.entities.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long > {

}
