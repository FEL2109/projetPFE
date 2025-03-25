package com.example.gestionconge.repository;

import com.example.gestionconge.entities.TypeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCongeRepository extends JpaRepository<TypeConge, Long > {
}
