package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.entities.Absence;
import com.example.gestionconge.entities.Employe;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:44+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AbsenceMapperImpl implements AbsenceMapper {

    @Override
    public Absence toEntity(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Absence.AbsenceBuilder absence = Absence.builder();

        absence.employe( absenceDTOToEmploye( absenceDTO ) );
        absence.idAbsence( absenceDTO.getIdAbsence() );
        absence.dateDebut( absenceDTO.getDateDebut() );
        absence.dateFin( absenceDTO.getDateFin() );
        absence.type( absenceDTO.getType() );
        absence.motif( absenceDTO.getMotif() );

        return absence.build();
    }

    @Override
    public AbsenceDTO toDto(Absence absence) {
        if ( absence == null ) {
            return null;
        }

        AbsenceDTO.AbsenceDTOBuilder absenceDTO = AbsenceDTO.builder();

        absenceDTO.employeId( absenceEmployeIdEmployee( absence ) );
        absenceDTO.idAbsence( absence.getIdAbsence() );
        absenceDTO.dateDebut( absence.getDateDebut() );
        absenceDTO.dateFin( absence.getDateFin() );
        absenceDTO.type( absence.getType() );
        absenceDTO.motif( absence.getMotif() );

        return absenceDTO.build();
    }

    @Override
    public Absence partialUpdate(AbsenceDTO absenceDTO, Absence absence) {
        if ( absenceDTO == null ) {
            return absence;
        }

        if ( absence.getEmploye() == null ) {
            absence.setEmploye( Employe.builder().build() );
        }
        absenceDTOToEmploye1( absenceDTO, absence.getEmploye() );
        if ( absenceDTO.getIdAbsence() != null ) {
            absence.setIdAbsence( absenceDTO.getIdAbsence() );
        }
        if ( absenceDTO.getDateDebut() != null ) {
            absence.setDateDebut( absenceDTO.getDateDebut() );
        }
        if ( absenceDTO.getDateFin() != null ) {
            absence.setDateFin( absenceDTO.getDateFin() );
        }
        if ( absenceDTO.getType() != null ) {
            absence.setType( absenceDTO.getType() );
        }
        if ( absenceDTO.getMotif() != null ) {
            absence.setMotif( absenceDTO.getMotif() );
        }

        return absence;
    }

    protected Employe absenceDTOToEmploye(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Employe.EmployeBuilder employe = Employe.builder();

        employe.idEmployee( absenceDTO.getEmployeId() );

        return employe.build();
    }

    private Long absenceEmployeIdEmployee(Absence absence) {
        if ( absence == null ) {
            return null;
        }
        Employe employe = absence.getEmploye();
        if ( employe == null ) {
            return null;
        }
        Long idEmployee = employe.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        return idEmployee;
    }

    protected void absenceDTOToEmploye1(AbsenceDTO absenceDTO, Employe mappingTarget) {
        if ( absenceDTO == null ) {
            return;
        }

        if ( absenceDTO.getEmployeId() != null ) {
            mappingTarget.setIdEmployee( absenceDTO.getEmployeId() );
        }
    }
}
