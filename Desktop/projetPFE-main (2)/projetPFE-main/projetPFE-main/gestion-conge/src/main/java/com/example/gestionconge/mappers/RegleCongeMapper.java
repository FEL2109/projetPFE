package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.gestionconge.dtos.RegleCongeDTO;
import com.example.gestionconge.entities.RegleConge;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegleCongeMapper {
    RegleConge toEntity(RegleCongeDTO regleCongeDTO);
    RegleCongeDTO toDto(RegleConge regleConge);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RegleConge partialUpdate(RegleCongeDTO regleCongeDTO, @MappingTarget RegleConge regleConge);
}

