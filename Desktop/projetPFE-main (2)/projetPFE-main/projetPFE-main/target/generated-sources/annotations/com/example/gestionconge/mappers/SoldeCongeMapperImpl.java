package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.SoldeCongeDTO;
import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.entities.SoldeConge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SoldeCongeMapperImpl implements SoldeCongeMapper {

    @Override
    public SoldeConge toEntity(SoldeCongeDTO soldeCongeDTO) {
        if ( soldeCongeDTO == null ) {
            return null;
        }

        SoldeConge.SoldeCongeBuilder soldeConge = SoldeConge.builder();

        soldeConge.employe( soldeCongeDTOToEmploye( soldeCongeDTO ) );
        soldeConge.idSolde( soldeCongeDTO.getIdSolde() );
        soldeConge.annee( soldeCongeDTO.getAnnee() );
        soldeConge.joursRestants( soldeCongeDTO.getJoursRestants() );

        return soldeConge.build();
    }

    @Override
    public SoldeCongeDTO toDto(SoldeConge soldeConge) {
        if ( soldeConge == null ) {
            return null;
        }

        SoldeCongeDTO.SoldeCongeDTOBuilder soldeCongeDTO = SoldeCongeDTO.builder();

        soldeCongeDTO.employeId( soldeCongeEmployeIdEmployee( soldeConge ) );
        soldeCongeDTO.idSolde( soldeConge.getIdSolde() );
        soldeCongeDTO.annee( soldeConge.getAnnee() );
        soldeCongeDTO.joursRestants( soldeConge.getJoursRestants() );

        return soldeCongeDTO.build();
    }

    @Override
    public SoldeConge partialUpdate(SoldeCongeDTO soldeCongeDTO, SoldeConge soldeConge) {
        if ( soldeCongeDTO == null ) {
            return soldeConge;
        }

        if ( soldeConge.getEmploye() == null ) {
            soldeConge.setEmploye( Employe.builder().build() );
        }
        soldeCongeDTOToEmploye1( soldeCongeDTO, soldeConge.getEmploye() );
        if ( soldeCongeDTO.getIdSolde() != null ) {
            soldeConge.setIdSolde( soldeCongeDTO.getIdSolde() );
        }
        if ( soldeCongeDTO.getAnnee() != null ) {
            soldeConge.setAnnee( soldeCongeDTO.getAnnee() );
        }
        if ( soldeCongeDTO.getJoursRestants() != null ) {
            soldeConge.setJoursRestants( soldeCongeDTO.getJoursRestants() );
        }

        return soldeConge;
    }

    protected Employe soldeCongeDTOToEmploye(SoldeCongeDTO soldeCongeDTO) {
        if ( soldeCongeDTO == null ) {
            return null;
        }

        Employe.EmployeBuilder employe = Employe.builder();

        employe.idEmployee( soldeCongeDTO.getEmployeId() );

        return employe.build();
    }

    private Long soldeCongeEmployeIdEmployee(SoldeConge soldeConge) {
        if ( soldeConge == null ) {
            return null;
        }
        Employe employe = soldeConge.getEmploye();
        if ( employe == null ) {
            return null;
        }
        Long idEmployee = employe.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        return idEmployee;
    }

    protected void soldeCongeDTOToEmploye1(SoldeCongeDTO soldeCongeDTO, Employe mappingTarget) {
        if ( soldeCongeDTO == null ) {
            return;
        }

        if ( soldeCongeDTO.getEmployeId() != null ) {
            mappingTarget.setIdEmployee( soldeCongeDTO.getEmployeId() );
        }
    }
}
