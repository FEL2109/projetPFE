package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.EmployeDTO;
import com.example.gestionconge.entities.Employe;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmployeMapperImpl implements EmployeMapper {

    @Override
    public Employe toEntity(EmployeDTO employeDTO) {
        if ( employeDTO == null ) {
            return null;
        }

        Employe.EmployeBuilder employe = Employe.builder();

        employe.idEmployee( employeDTO.getIdEmployee() );
        employe.nom( employeDTO.getNom() );
        employe.prenom( employeDTO.getPrenom() );
        employe.email( employeDTO.getEmail() );
        employe.telephone( employeDTO.getTelephone() );
        employe.cheminPhoto( employeDTO.getCheminPhoto() );
        employe.poste( employeDTO.getPoste() );

        return employe.build();
    }

    @Override
    public EmployeDTO toDto(Employe employe) {
        if ( employe == null ) {
            return null;
        }

        EmployeDTO.EmployeDTOBuilder employeDTO = EmployeDTO.builder();

        employeDTO.idEmployee( employe.getIdEmployee() );
        employeDTO.nom( employe.getNom() );
        employeDTO.prenom( employe.getPrenom() );
        employeDTO.email( employe.getEmail() );
        employeDTO.telephone( employe.getTelephone() );
        employeDTO.cheminPhoto( employe.getCheminPhoto() );
        employeDTO.poste( employe.getPoste() );

        return employeDTO.build();
    }

    @Override
    public Employe partialUpdate(EmployeDTO employeDTO, Employe employe) {
        if ( employeDTO == null ) {
            return employe;
        }

        if ( employeDTO.getIdEmployee() != null ) {
            employe.setIdEmployee( employeDTO.getIdEmployee() );
        }
        if ( employeDTO.getNom() != null ) {
            employe.setNom( employeDTO.getNom() );
        }
        if ( employeDTO.getPrenom() != null ) {
            employe.setPrenom( employeDTO.getPrenom() );
        }
        if ( employeDTO.getEmail() != null ) {
            employe.setEmail( employeDTO.getEmail() );
        }
        if ( employeDTO.getTelephone() != null ) {
            employe.setTelephone( employeDTO.getTelephone() );
        }
        if ( employeDTO.getCheminPhoto() != null ) {
            employe.setCheminPhoto( employeDTO.getCheminPhoto() );
        }
        if ( employeDTO.getPoste() != null ) {
            employe.setPoste( employeDTO.getPoste() );
        }

        return employe;
    }
}
