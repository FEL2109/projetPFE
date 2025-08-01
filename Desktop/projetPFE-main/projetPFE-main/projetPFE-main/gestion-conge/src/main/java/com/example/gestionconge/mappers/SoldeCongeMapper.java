package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.SoldeCongeDTO;
import com.example.gestionconge.entities.SoldeConge;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SoldeCongeMapper {

    SoldeConge toEntity(SoldeCongeDTO soldeCongeDTO);

    SoldeCongeDTO toDto(SoldeConge soldeConge);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SoldeConge partialUpdate(SoldeCongeDTO soldeCongeDTO, @MappingTarget SoldeConge soldeConge);
}
