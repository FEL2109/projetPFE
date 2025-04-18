package com.example.gestionconge.repository;

import com.example.gestionconge.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
