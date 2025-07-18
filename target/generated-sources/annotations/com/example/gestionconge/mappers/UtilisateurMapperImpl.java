package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.UtilisateurDto;
import com.example.gestionconge.entities.Utilisateur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:45+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public Utilisateur toEntity(UtilisateurDto userDtoRq) {
        if ( userDtoRq == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setUsername( userDtoRq.getUsername() );
        utilisateur.setPassword( userDtoRq.getPassword() );
        utilisateur.setNom( userDtoRq.getNom() );
        utilisateur.setPrenom( userDtoRq.getPrenom() );
        utilisateur.setEmail( userDtoRq.getEmail() );
        utilisateur.setMotDePasse( userDtoRq.getMotDePasse() );
        utilisateur.setRole( userDtoRq.getRole() );
        utilisateur.setTelephone( userDtoRq.getTelephone() );
        utilisateur.setCheminPhoto( userDtoRq.getCheminPhoto() );

        return utilisateur;
    }

    @Override
    public UtilisateurDto toDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto.UtilisateurDtoBuilder utilisateurDto = UtilisateurDto.builder();

        utilisateurDto.username( utilisateur.getUsername() );
        utilisateurDto.password( utilisateur.getPassword() );
        utilisateurDto.nom( utilisateur.getNom() );
        utilisateurDto.prenom( utilisateur.getPrenom() );
        utilisateurDto.email( utilisateur.getEmail() );
        utilisateurDto.role( utilisateur.getRole() );
        utilisateurDto.motDePasse( utilisateur.getMotDePasse() );
        utilisateurDto.telephone( utilisateur.getTelephone() );
        utilisateurDto.cheminPhoto( utilisateur.getCheminPhoto() );

        return utilisateurDto.build();
    }

    @Override
    public Utilisateur partialUpdate(UtilisateurDto userDtoRq, Utilisateur utilisateur) {
        if ( userDtoRq == null ) {
            return utilisateur;
        }

        if ( userDtoRq.getUsername() != null ) {
            utilisateur.setUsername( userDtoRq.getUsername() );
        }
        if ( userDtoRq.getPassword() != null ) {
            utilisateur.setPassword( userDtoRq.getPassword() );
        }
        if ( userDtoRq.getNom() != null ) {
            utilisateur.setNom( userDtoRq.getNom() );
        }
        if ( userDtoRq.getPrenom() != null ) {
            utilisateur.setPrenom( userDtoRq.getPrenom() );
        }
        if ( userDtoRq.getEmail() != null ) {
            utilisateur.setEmail( userDtoRq.getEmail() );
        }
        if ( userDtoRq.getMotDePasse() != null ) {
            utilisateur.setMotDePasse( userDtoRq.getMotDePasse() );
        }
        if ( userDtoRq.getRole() != null ) {
            utilisateur.setRole( userDtoRq.getRole() );
        }
        if ( userDtoRq.getTelephone() != null ) {
            utilisateur.setTelephone( userDtoRq.getTelephone() );
        }
        if ( userDtoRq.getCheminPhoto() != null ) {
            utilisateur.setCheminPhoto( userDtoRq.getCheminPhoto() );
        }

        return utilisateur;
    }

    @Override
    public UtilisateurDto toDtoRs(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto.UtilisateurDtoBuilder utilisateurDto = UtilisateurDto.builder();

        utilisateurDto.username( utilisateur.getUsername() );
        utilisateurDto.password( utilisateur.getPassword() );
        utilisateurDto.nom( utilisateur.getNom() );
        utilisateurDto.prenom( utilisateur.getPrenom() );
        utilisateurDto.email( utilisateur.getEmail() );
        utilisateurDto.role( utilisateur.getRole() );
        utilisateurDto.motDePasse( utilisateur.getMotDePasse() );
        utilisateurDto.telephone( utilisateur.getTelephone() );
        utilisateurDto.cheminPhoto( utilisateur.getCheminPhoto() );

        return utilisateurDto.build();
    }

    @Override
    public UtilisateurDto toUtilisateurLightDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDto.UtilisateurDtoBuilder utilisateurDto = UtilisateurDto.builder();

        utilisateurDto.nom( utilisateur.getNom() );
        utilisateurDto.prenom( utilisateur.getPrenom() );
        utilisateurDto.email( utilisateur.getEmail() );
        utilisateurDto.role( utilisateur.getRole() );
        utilisateurDto.username( utilisateur.getUsername() );
        utilisateurDto.password( utilisateur.getPassword() );
        utilisateurDto.motDePasse( utilisateur.getMotDePasse() );
        utilisateurDto.telephone( utilisateur.getTelephone() );
        utilisateurDto.cheminPhoto( utilisateur.getCheminPhoto() );

        return utilisateurDto.build();
    }
}
