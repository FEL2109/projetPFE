package com.example.gestionconge.repository;

import com.example.gestionconge.entities.Absence;
import com.example.gestionconge.entities.Enumm.typeAbsence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {


}