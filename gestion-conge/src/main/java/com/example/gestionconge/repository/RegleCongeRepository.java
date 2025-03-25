package com.example.gestionconge.repository;

import com.example.gestionconge.entities.RegleConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegleCongeRepository extends JpaRepository<RegleConge, Long> {

}