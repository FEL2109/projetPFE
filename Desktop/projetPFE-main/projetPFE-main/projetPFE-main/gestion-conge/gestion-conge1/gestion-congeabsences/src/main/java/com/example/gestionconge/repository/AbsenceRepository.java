package com.example.gestionconge.repository;

import com.example.gestionconge.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
