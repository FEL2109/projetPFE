package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.ManagerDTO;
import com.example.gestionconge.entities.Manager;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public Manager toEntity(ManagerDTO managerDTO) {
        if ( managerDTO == null ) {
            return null;
        }

        Manager.ManagerBuilder manager = Manager.builder();

        manager.nom( managerDTO.getNom() );
        manager.prenom( managerDTO.getPrenom() );
        manager.email( managerDTO.getEmail() );
        manager.telephone( managerDTO.getTelephone() );
        manager.cheminPhoto( managerDTO.getCheminPhoto() );

        return manager.build();
    }

    @Override
    public ManagerDTO toDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        ManagerDTO.ManagerDTOBuilder managerDTO = ManagerDTO.builder();

        managerDTO.nom( manager.getNom() );
        managerDTO.prenom( manager.getPrenom() );
        managerDTO.email( manager.getEmail() );
        managerDTO.telephone( manager.getTelephone() );
        managerDTO.cheminPhoto( manager.getCheminPhoto() );

        return managerDTO.build();
    }

    @Override
    public Manager partialUpdate(ManagerDTO managerDTO, Manager manager) {
        if ( managerDTO == null ) {
            return manager;
        }

        if ( managerDTO.getNom() != null ) {
            manager.setNom( managerDTO.getNom() );
        }
        if ( managerDTO.getPrenom() != null ) {
            manager.setPrenom( managerDTO.getPrenom() );
        }
        if ( managerDTO.getEmail() != null ) {
            manager.setEmail( managerDTO.getEmail() );
        }
        if ( managerDTO.getTelephone() != null ) {
            manager.setTelephone( managerDTO.getTelephone() );
        }
        if ( managerDTO.getCheminPhoto() != null ) {
            manager.setCheminPhoto( managerDTO.getCheminPhoto() );
        }

        return manager;
    }
}
