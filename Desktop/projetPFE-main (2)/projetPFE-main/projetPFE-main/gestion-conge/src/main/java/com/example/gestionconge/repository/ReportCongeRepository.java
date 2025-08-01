package com.example.gestionconge.repository;

import com.example.gestionconge.entities.ReportConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReportCongeRepository extends JpaRepository<ReportConge, Long> {
    List<ReportConge> findByUtilisateurId(Long utilisateurId);
    List<ReportConge> findByUtilisateurIdAndAnneeOrigine(Long utilisateurId, int anneeOrigine);


}
