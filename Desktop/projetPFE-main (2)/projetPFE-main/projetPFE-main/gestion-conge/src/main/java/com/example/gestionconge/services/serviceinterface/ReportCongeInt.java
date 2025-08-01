package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.CongeReportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportCongeInt {
    public int calculerJoursPris(Long utilisateurId, int annee);
    ApiResponse addReportConge(CongeReportDTO congeReportDTO);
    List<CongeReportDTO> getAllReports();
}
