package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.SoldeCongeDTO;
import com.example.gestionconge.entities.SoldeConge;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SoldeCongeMapper {
    @Mapping(target = "employe.idEmployee", source = "employeId")
    SoldeConge toEntity(SoldeCongeDTO soldeCongeDTO);
    @Mapping(target = "employeId", source = "employe.idEmployee")
    SoldeCongeDTO toDto(SoldeConge soldeConge);
    @Mapping(target = "employe.idEmployee", source = "employeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SoldeConge partialUpdate(SoldeCongeDTO soldeCongeDTO, @MappingTarget SoldeConge soldeConge);
}
