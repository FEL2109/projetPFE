package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.entities.ValidationDemandeConge;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ValidationDemandeCongeMapper {
    ValidationDemandeConge toEntity(ValidationDemandeCongeDTO validationDemandeCongeDTO);

    ValidationDemandeCongeDTO toDto(ValidationDemandeConge validationDemandeConge);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ValidationDemandeConge partialUpdate(ValidationDemandeCongeDTO validationDemandeCongeDTO, @MappingTarget ValidationDemandeConge validationDemandeConge);
}
