package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Employe;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DemandeCongeMapperImpl implements DemandeCongeMapper {

    @Override
    public DemandeConge toEntity(DemandeCongeDTO demandeCongeDTO) {
        if ( demandeCongeDTO == null ) {
            return null;
        }

        DemandeConge.DemandeCongeBuilder demandeConge = DemandeConge.builder();

        demandeConge.employe( demandeCongeDTOToEmploye( demandeCongeDTO ) );
        demandeConge.idDemande( demandeCongeDTO.getIdDemande() );
        demandeConge.dateDebut( demandeCongeDTO.getDateDebut() );
        if ( demandeCongeDTO.getNombreJours() != null ) {
            demandeConge.nombreJours( demandeCongeDTO.getNombreJours() );
        }
        demandeConge.statut( demandeCongeDTO.getStatut() );
        demandeConge.commentaire( demandeCongeDTO.getCommentaire() );

        return demandeConge.build();
    }

    @Override
    public DemandeCongeDTO toDto(DemandeConge demandeConge) {
        if ( demandeConge == null ) {
            return null;
        }

        DemandeCongeDTO.DemandeCongeDTOBuilder demandeCongeDTO = DemandeCongeDTO.builder();

        demandeCongeDTO.employeId( demandeCongeEmployeIdEmployee( demandeConge ) );
        demandeCongeDTO.idDemande( demandeConge.getIdDemande() );
        demandeCongeDTO.dateDebut( demandeConge.getDateDebut() );
        demandeCongeDTO.nombreJours( demandeConge.getNombreJours() );
        demandeCongeDTO.statut( demandeConge.getStatut() );
        demandeCongeDTO.commentaire( demandeConge.getCommentaire() );

        return demandeCongeDTO.build();
    }

    @Override
    public DemandeConge partialUpdate(DemandeCongeDTO demandeCongeDTO, DemandeConge demandeConge) {
        if ( demandeCongeDTO == null ) {
            return demandeConge;
        }

        if ( demandeConge.getEmploye() == null ) {
            demandeConge.setEmploye( Employe.builder().build() );
        }
        demandeCongeDTOToEmploye1( demandeCongeDTO, demandeConge.getEmploye() );
        if ( demandeCongeDTO.getIdDemande() != null ) {
            demandeConge.setIdDemande( demandeCongeDTO.getIdDemande() );
        }
        if ( demandeCongeDTO.getDateDebut() != null ) {
            demandeConge.setDateDebut( demandeCongeDTO.getDateDebut() );
        }
        if ( demandeCongeDTO.getNombreJours() != null ) {
            demandeConge.setNombreJours( demandeCongeDTO.getNombreJours() );
        }
        if ( demandeCongeDTO.getStatut() != null ) {
            demandeConge.setStatut( demandeCongeDTO.getStatut() );
        }
        if ( demandeCongeDTO.getCommentaire() != null ) {
            demandeConge.setCommentaire( demandeCongeDTO.getCommentaire() );
        }

        return demandeConge;
    }

    protected Employe demandeCongeDTOToEmploye(DemandeCongeDTO demandeCongeDTO) {
        if ( demandeCongeDTO == null ) {
            return null;
        }

        Employe.EmployeBuilder employe = Employe.builder();

        employe.idEmployee( demandeCongeDTO.getEmployeId() );

        return employe.build();
    }

    private Long demandeCongeEmployeIdEmployee(DemandeConge demandeConge) {
        if ( demandeConge == null ) {
            return null;
        }
        Employe employe = demandeConge.getEmploye();
        if ( employe == null ) {
            return null;
        }
        Long idEmployee = employe.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        return idEmployee;
    }

    protected void demandeCongeDTOToEmploye1(DemandeCongeDTO demandeCongeDTO, Employe mappingTarget) {
        if ( demandeCongeDTO == null ) {
            return;
        }

        if ( demandeCongeDTO.getEmployeId() != null ) {
            mappingTarget.setIdEmployee( demandeCongeDTO.getEmployeId() );
        }
    }
}
