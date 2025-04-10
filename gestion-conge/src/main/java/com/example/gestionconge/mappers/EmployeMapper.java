package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import com.example.gestionconge.dtos.EmployeDTO;
import com.example.gestionconge.entities.Employe;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeMapper {
    Employe toEntity(EmployeDTO employeDTO);
    EmployeDTO toDto(Employe employe);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employe partialUpdate(EmployeDTO employeDTO, @MappingTarget Employe employe);
}

