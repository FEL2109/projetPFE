package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.CongeReportDTO;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.entities.ReportConge;
import com.example.gestionconge.entities.Utilisateur;
import com.example.gestionconge.mappers.ReportCongeMapper;
import com.example.gestionconge.repository.DemandeCongeRepository;
import com.example.gestionconge.repository.ReportCongeRepository;
import com.example.gestionconge.services.serviceinterface.ReportCongeInt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportCongeImpl implements ReportCongeInt {

    public final ReportCongeRepository reportCongeRepository;
    public final ReportCongeMapper reportCongeMapper;
    public final DemandeCongeRepository demandeCongeRepository;

    public ReportCongeImpl(ReportCongeRepository reportCongeRepository, ReportCongeMapper reportCongeMapper, DemandeCongeRepository demandeCongeRepository) {
        this.reportCongeRepository = reportCongeRepository;
        this.reportCongeMapper = reportCongeMapper;
        this.demandeCongeRepository = demandeCongeRepository;
    }

    public int calculerJoursPris(Long utilisateurId, int annee) {
        List<DemandeConge> demandes = demandeCongeRepository.findAll().stream()
                .filter(d -> d.getUtilisateur().getId().equals(utilisateurId))
                .filter(d -> d.getStatut() == StatutDemande.Approuvee)
                .filter(d -> {
                    LocalDate dateDebut = d.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return dateDebut.getYear() == annee;
                })
                .toList();

        int total = 0;
        for (DemandeConge d : demandes) {
            long jours = (d.getDateFin().getTime() - d.getDateDebut().getTime()) / (1000 * 60 * 60 * 24) + 1;
            total += jours;
        }
        return total;
    }

    public void cloturerAnnee(Long employeId, int anneeCourante) {
        int droitAnnuel = 18;
        int joursPris = calculerJoursPris(employeId, anneeCourante);
        int joursNonPris = droitAnnuel - joursPris;

        List<ReportConge> reports = reportCongeRepository.findByUtilisateurId(employeId);
        reports.stream()
                .filter(r -> r.getAnneeOrigine() <= anneeCourante - 2)
                .forEach(r -> reportCongeRepository.delete(r));

        if (joursNonPris > 0) {
            ReportConge report = new ReportConge();
            report.setUtilisateur(new Utilisateur(employeId));
            report.setJoursReportes(joursNonPris);
            report.setAnneeOrigine(anneeCourante);
            reportCongeRepository.save(report);
        }
    }

    @Override
   public ApiResponse addReportConge(CongeReportDTO congeReportDTO) {
        ReportConge reportConge = reportCongeMapper.toEntity(congeReportDTO);
        reportCongeRepository.save(reportConge);

        return ApiResponse.builder()
                .id(reportConge.getIdReport())
                .success("report de conge ajoutée avec succès")
                .build();
    }



    @Override
    public List<CongeReportDTO> getAllReports() {
        List<ReportConge> reportConges = reportCongeRepository.findAll();
        List<CongeReportDTO> congeReportDTOS = new ArrayList<>();

        reportConges.forEach(report -> congeReportDTOS.add(reportCongeMapper.toDto(report)));

        return congeReportDTOS;
    }


}