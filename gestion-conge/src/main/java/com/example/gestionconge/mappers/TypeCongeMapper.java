package com.example.gestionconge.mappers;

import org.mapstruct.*;
import com.example.gestionconge.dtos.TypeCongeDTO;
import com.example.gestionconge.entities.TypeConge;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeCongeMapper {
    @Mapping(target = "regleConge.idRegle", source = "regleCongeId")
    TypeConge toEntity(TypeCongeDTO typeCongeDTO);

    @Mapping(target = "regleCongeId", source = "regleConge.idRegle")
    TypeCongeDTO toDto(TypeConge typeConge);

    @Mapping(target = "regleConge.idRegle", source = "regleCongeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TypeConge partialUpdate(TypeCongeDTO typeCongeDTO, @MappingTarget TypeConge typeConge);
}
