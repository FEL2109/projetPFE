package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.ServiceRHDTO;
import com.example.gestionconge.entities.ServiceRH;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ServiceRHMapperImpl implements ServiceRHMapper {

    @Override
    public ServiceRH toEntity(ServiceRHDTO serviceRHDTO) {
        if ( serviceRHDTO == null ) {
            return null;
        }

        ServiceRH.ServiceRHBuilder serviceRH = ServiceRH.builder();

        serviceRH.nom( serviceRHDTO.getNom() );
        serviceRH.prenom( serviceRHDTO.getPrenom() );
        serviceRH.email( serviceRHDTO.getEmail() );
        serviceRH.telephone( serviceRHDTO.getTelephone() );
        serviceRH.cheminPhoto( serviceRHDTO.getCheminPhoto() );

        return serviceRH.build();
    }

    @Override
    public ServiceRHDTO toDto(ServiceRH serviceRH) {
        if ( serviceRH == null ) {
            return null;
        }

        ServiceRHDTO.ServiceRHDTOBuilder serviceRHDTO = ServiceRHDTO.builder();

        serviceRHDTO.nom( serviceRH.getNom() );
        serviceRHDTO.prenom( serviceRH.getPrenom() );
        serviceRHDTO.email( serviceRH.getEmail() );
        serviceRHDTO.telephone( serviceRH.getTelephone() );
        serviceRHDTO.cheminPhoto( serviceRH.getCheminPhoto() );

        return serviceRHDTO.build();
    }

    @Override
    public ServiceRH partialUpdate(ServiceRHDTO serviceRHDTO, ServiceRH serviceRH) {
        if ( serviceRHDTO == null ) {
            return serviceRH;
        }

        if ( serviceRHDTO.getNom() != null ) {
            serviceRH.setNom( serviceRHDTO.getNom() );
        }
        if ( serviceRHDTO.getPrenom() != null ) {
            serviceRH.setPrenom( serviceRHDTO.getPrenom() );
        }
        if ( serviceRHDTO.getEmail() != null ) {
            serviceRH.setEmail( serviceRHDTO.getEmail() );
        }
        if ( serviceRHDTO.getTelephone() != null ) {
            serviceRH.setTelephone( serviceRHDTO.getTelephone() );
        }
        if ( serviceRHDTO.getCheminPhoto() != null ) {
            serviceRH.setCheminPhoto( serviceRHDTO.getCheminPhoto() );
        }

        return serviceRH;
    }
}
