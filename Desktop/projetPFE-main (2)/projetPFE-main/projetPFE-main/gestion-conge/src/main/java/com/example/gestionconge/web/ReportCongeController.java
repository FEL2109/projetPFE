package com.example.gestionconge.web;


import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.CongeReportDTO;
import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.services.serviceImpl.ReportCongeImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report-conge")
public class ReportCongeController{

    private final ReportCongeImpl reportCongeService;

    public ReportCongeController(ReportCongeImpl reportCongeService) {
        this.reportCongeService = reportCongeService;
    }


    @PostMapping
    public ApiResponse addReport(@RequestBody CongeReportDTO congeReportDTO) {
        return reportCongeService.addReportConge(congeReportDTO);
    }

    @GetMapping
    public List<CongeReportDTO> getAllReports() {
        return reportCongeService.getAllReports();
    }

    @GetMapping("/jours-pris/{utilisateurId}/{annee}")
    public int getJoursPris(@PathVariable Long utilisateurId, @PathVariable int annee) {
        return reportCongeService.calculerJoursPris(utilisateurId, annee);
    }

    @PostMapping("/cloture/{utilisateurId}/{annee}")
    public String cloturerAnnee(@PathVariable Long utilisateurId, @PathVariable int annee) {
        reportCongeService.cloturerAnnee(utilisateurId, annee);
        return "Clôture effectuée pour l'utilisateur " + utilisateurId + " et l'année " + annee;
    }
}