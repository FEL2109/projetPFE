package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.entities.DemandeConge;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DemandeCongeMapper {
    @Mapping(target = "employe.idEmployee", source = "employeId")
    DemandeConge toEntity(DemandeCongeDTO demandeCongeDTO);

    @Mapping(target = "employeId", source = "employe.idEmployee")
    DemandeCongeDTO toDto(DemandeConge demandeConge);

    @Mapping(target = "employe.idEmployee", source = "employeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DemandeConge partialUpdate(DemandeCongeDTO demandeCongeDTO, @MappingTarget DemandeConge demandeConge);
}

