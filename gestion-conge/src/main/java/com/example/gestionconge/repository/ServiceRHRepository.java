package com.example.gestionconge.repository;

import com.example.gestionconge.entities.ServiceRH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRHRepository extends JpaRepository<ServiceRH, Long> {

}