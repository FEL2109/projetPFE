package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.entities.Manager;
import com.example.gestionconge.entities.ValidationDemandeConge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ValidationDemandeCongeMapperImpl implements ValidationDemandeCongeMapper {

    @Override
    public ValidationDemandeConge toEntity(ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        if ( validationDemandeCongeDTO == null ) {
            return null;
        }

        ValidationDemandeConge.ValidationDemandeCongeBuilder validationDemandeConge = ValidationDemandeConge.builder();

        validationDemandeConge.manager( validationDemandeCongeDTOToManager( validationDemandeCongeDTO ) );
        validationDemandeConge.idValidation( validationDemandeCongeDTO.getIdValidation() );
        validationDemandeConge.dateValidation( validationDemandeCongeDTO.getDateValidation() );
        validationDemandeConge.statut( validationDemandeCongeDTO.getStatut() );

        return validationDemandeConge.build();
    }

    @Override
    public ValidationDemandeCongeDTO toDto(ValidationDemandeConge validationDemandeConge) {
        if ( validationDemandeConge == null ) {
            return null;
        }

        ValidationDemandeCongeDTO.ValidationDemandeCongeDTOBuilder validationDemandeCongeDTO = ValidationDemandeCongeDTO.builder();

        validationDemandeCongeDTO.managerId( validationDemandeCongeManagerIdManager( validationDemandeConge ) );
        validationDemandeCongeDTO.idValidation( validationDemandeConge.getIdValidation() );
        validationDemandeCongeDTO.dateValidation( validationDemandeConge.getDateValidation() );
        validationDemandeCongeDTO.statut( validationDemandeConge.getStatut() );

        return validationDemandeCongeDTO.build();
    }

    @Override
    public ValidationDemandeConge partialUpdate(ValidationDemandeCongeDTO validationDemandeCongeDTO, ValidationDemandeConge validationDemandeConge) {
        if ( validationDemandeCongeDTO == null ) {
            return validationDemandeConge;
        }

        if ( validationDemandeConge.getManager() == null ) {
            validationDemandeConge.setManager( Manager.builder().build() );
        }
        validationDemandeCongeDTOToManager1( validationDemandeCongeDTO, validationDemandeConge.getManager() );
        if ( validationDemandeCongeDTO.getIdValidation() != null ) {
            validationDemandeConge.setIdValidation( validationDemandeCongeDTO.getIdValidation() );
        }
        if ( validationDemandeCongeDTO.getDateValidation() != null ) {
            validationDemandeConge.setDateValidation( validationDemandeCongeDTO.getDateValidation() );
        }
        if ( validationDemandeCongeDTO.getStatut() != null ) {
            validationDemandeConge.setStatut( validationDemandeCongeDTO.getStatut() );
        }

        return validationDemandeConge;
    }

    protected Manager validationDemandeCongeDTOToManager(ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        if ( validationDemandeCongeDTO == null ) {
            return null;
        }

        Manager.ManagerBuilder manager = Manager.builder();

        manager.idManager( validationDemandeCongeDTO.getManagerId() );

        return manager.build();
    }

    private Long validationDemandeCongeManagerIdManager(ValidationDemandeConge validationDemandeConge) {
        if ( validationDemandeConge == null ) {
            return null;
        }
        Manager manager = validationDemandeConge.getManager();
        if ( manager == null ) {
            return null;
        }
        Long idManager = manager.getIdManager();
        if ( idManager == null ) {
            return null;
        }
        return idManager;
    }

    protected void validationDemandeCongeDTOToManager1(ValidationDemandeCongeDTO validationDemandeCongeDTO, Manager mappingTarget) {
        if ( validationDemandeCongeDTO == null ) {
            return;
        }

        if ( validationDemandeCongeDTO.getManagerId() != null ) {
            mappingTarget.setIdManager( validationDemandeCongeDTO.getManagerId() );
        }
    }
}
