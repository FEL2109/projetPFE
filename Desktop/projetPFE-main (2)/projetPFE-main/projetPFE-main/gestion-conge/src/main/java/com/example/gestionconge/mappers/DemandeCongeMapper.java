package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.entities.DemandeConge;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DemandeCongeMapper {
    DemandeConge toEntity(DemandeCongeDTO demandeCongeDTO);

    DemandeCongeDTO toDto(DemandeConge demandeConge);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DemandeConge partialUpdate(DemandeCongeDTO demandeCongeDTO, @MappingTarget DemandeConge demandeConge);

    // Ajoute la logique de calcul du solde de congé restant
    @AfterMapping
    default void setCongerestant(DemandeConge demandeConge, @MappingTarget DemandeCongeDTO dto) {
        if (demandeConge.getSoldeannuel() != null && demandeConge.getCongepris() != null) {
            dto.setCongerestant(demandeConge.getSoldeannuel() - demandeConge.getCongepris());
        } else {
            dto.setCongerestant(null);
        }
    }
}

