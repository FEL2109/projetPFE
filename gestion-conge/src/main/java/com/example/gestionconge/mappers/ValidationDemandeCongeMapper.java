package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.entities.ValidationDemandeConge;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ValidationDemandeCongeMapper {
    @Mapping(target = "manager.idManager", source = "managerId")
    ValidationDemandeConge toEntity(ValidationDemandeCongeDTO validationDemandeCongeDTO);

    @Mapping(target = "managerId", source = "manager.idManager")
    ValidationDemandeCongeDTO toDto(ValidationDemandeConge validationDemandeConge);

    @Mapping(target = "manager.idManager", source = "managerId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ValidationDemandeConge partialUpdate(ValidationDemandeCongeDTO validationDemandeCongeDTO, @MappingTarget ValidationDemandeConge validationDemandeConge);
}
