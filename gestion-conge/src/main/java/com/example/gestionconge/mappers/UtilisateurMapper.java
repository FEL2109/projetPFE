package com.example.gestionconge.mappers;


import com.example.gestionconge.dtos.UtilisateurDto;
import com.example.gestionconge.entities.Utilisateur;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
    public interface UtilisateurMapper {

        Utilisateur toEntity(UtilisateurDto userDtoRq);

         UtilisateurDto toDto(Utilisateur utilisateur);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        Utilisateur partialUpdate(UtilisateurDto userDtoRq, @MappingTarget Utilisateur utilisateur);

        UtilisateurDto toDtoRs(Utilisateur utilisateur);

        @Mapping(target = "nom")
        @Mapping(target = "prenom")
        @Mapping(target = "email")
        @Mapping(target = "role")
        UtilisateurDto toUtilisateurLightDto(Utilisateur utilisateur);

    }
