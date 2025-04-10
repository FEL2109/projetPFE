package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.entities.Manager;
import com.example.gestionconge.entities.RegleConge;
import com.example.gestionconge.entities.TypeConge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-10T02:53:40+0100",
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
        demandeConge.manager( demandeCongeDTOToManager( demandeCongeDTO ) );
        demandeConge.typeConge( demandeCongeDTOToTypeConge( demandeCongeDTO ) );
        demandeConge.regleConge( demandeCongeDTOToRegleConge( demandeCongeDTO ) );
        demandeConge.idDemande( demandeCongeDTO.getIdDemande() );
        demandeConge.dateDebut( demandeCongeDTO.getDateDebut() );
        demandeConge.dateDemande( demandeCongeDTO.getDateDemande() );
        demandeConge.nombreJours( demandeCongeDTO.getNombreJours() );
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
        demandeCongeDTO.managerId( demandeCongeManagerIdManager( demandeConge ) );
        demandeCongeDTO.typeCongeId( demandeCongeTypeCongeIdTypeConge( demandeConge ) );
        demandeCongeDTO.regleCongeId( demandeCongeRegleCongeIdRegle( demandeConge ) );
        demandeCongeDTO.idDemande( demandeConge.getIdDemande() );
        demandeCongeDTO.dateDebut( demandeConge.getDateDebut() );
        demandeCongeDTO.dateDemande( demandeConge.getDateDemande() );
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
        if ( demandeConge.getManager() == null ) {
            demandeConge.setManager( Manager.builder().build() );
        }
        demandeCongeDTOToManager1( demandeCongeDTO, demandeConge.getManager() );
        if ( demandeConge.getTypeConge() == null ) {
            demandeConge.setTypeConge( TypeConge.builder().build() );
        }
        demandeCongeDTOToTypeConge1( demandeCongeDTO, demandeConge.getTypeConge() );
        if ( demandeConge.getRegleConge() == null ) {
            demandeConge.setRegleConge( RegleConge.builder().build() );
        }
        demandeCongeDTOToRegleConge1( demandeCongeDTO, demandeConge.getRegleConge() );
        if ( demandeCongeDTO.getIdDemande() != null ) {
            demandeConge.setIdDemande( demandeCongeDTO.getIdDemande() );
        }
        if ( demandeCongeDTO.getDateDebut() != null ) {
            demandeConge.setDateDebut( demandeCongeDTO.getDateDebut() );
        }
        if ( demandeCongeDTO.getDateDemande() != null ) {
            demandeConge.setDateDemande( demandeCongeDTO.getDateDemande() );
        }
        demandeConge.setNombreJours( demandeCongeDTO.getNombreJours() );
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

    protected Manager demandeCongeDTOToManager(DemandeCongeDTO demandeCongeDTO) {
        if ( demandeCongeDTO == null ) {
            return null;
        }

        Manager.ManagerBuilder manager = Manager.builder();

        manager.idManager( demandeCongeDTO.getManagerId() );

        return manager.build();
    }

    protected TypeConge demandeCongeDTOToTypeConge(DemandeCongeDTO demandeCongeDTO) {
        if ( demandeCongeDTO == null ) {
            return null;
        }

        TypeConge.TypeCongeBuilder typeConge = TypeConge.builder();

        typeConge.idTypeConge( demandeCongeDTO.getTypeCongeId() );

        return typeConge.build();
    }

    protected RegleConge demandeCongeDTOToRegleConge(DemandeCongeDTO demandeCongeDTO) {
        if ( demandeCongeDTO == null ) {
            return null;
        }

        RegleConge.RegleCongeBuilder regleConge = RegleConge.builder();

        regleConge.idRegle( demandeCongeDTO.getRegleCongeId() );

        return regleConge.build();
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

    private Long demandeCongeManagerIdManager(DemandeConge demandeConge) {
        if ( demandeConge == null ) {
            return null;
        }
        Manager manager = demandeConge.getManager();
        if ( manager == null ) {
            return null;
        }
        Long idManager = manager.getIdManager();
        if ( idManager == null ) {
            return null;
        }
        return idManager;
    }

    private Long demandeCongeTypeCongeIdTypeConge(DemandeConge demandeConge) {
        if ( demandeConge == null ) {
            return null;
        }
        TypeConge typeConge = demandeConge.getTypeConge();
        if ( typeConge == null ) {
            return null;
        }
        Long idTypeConge = typeConge.getIdTypeConge();
        if ( idTypeConge == null ) {
            return null;
        }
        return idTypeConge;
    }

    private Long demandeCongeRegleCongeIdRegle(DemandeConge demandeConge) {
        if ( demandeConge == null ) {
            return null;
        }
        RegleConge regleConge = demandeConge.getRegleConge();
        if ( regleConge == null ) {
            return null;
        }
        Long idRegle = regleConge.getIdRegle();
        if ( idRegle == null ) {
            return null;
        }
        return idRegle;
    }

    protected void demandeCongeDTOToEmploye1(DemandeCongeDTO demandeCongeDTO, Employe mappingTarget) {
        if ( demandeCongeDTO == null ) {
            return;
        }

        if ( demandeCongeDTO.getEmployeId() != null ) {
            mappingTarget.setIdEmployee( demandeCongeDTO.getEmployeId() );
        }
    }

    protected void demandeCongeDTOToManager1(DemandeCongeDTO demandeCongeDTO, Manager mappingTarget) {
        if ( demandeCongeDTO == null ) {
            return;
        }

        if ( demandeCongeDTO.getManagerId() != null ) {
            mappingTarget.setIdManager( demandeCongeDTO.getManagerId() );
        }
    }

    protected void demandeCongeDTOToTypeConge1(DemandeCongeDTO demandeCongeDTO, TypeConge mappingTarget) {
        if ( demandeCongeDTO == null ) {
            return;
        }

        if ( demandeCongeDTO.getTypeCongeId() != null ) {
            mappingTarget.setIdTypeConge( demandeCongeDTO.getTypeCongeId() );
        }
    }

    protected void demandeCongeDTOToRegleConge1(DemandeCongeDTO demandeCongeDTO, RegleConge mappingTarget) {
        if ( demandeCongeDTO == null ) {
            return;
        }

        if ( demandeCongeDTO.getRegleCongeId() != null ) {
            mappingTarget.setIdRegle( demandeCongeDTO.getRegleCongeId() );
        }
    }
}
