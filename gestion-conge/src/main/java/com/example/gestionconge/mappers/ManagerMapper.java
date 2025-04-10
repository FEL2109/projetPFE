package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.gestionconge.dtos.ManagerDTO;
import com.example.gestionconge.entities.Manager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ManagerMapper {
    Manager toEntity(ManagerDTO managerDTO);
    ManagerDTO toDto(Manager manager);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Manager partialUpdate(ManagerDTO managerDTO, @MappingTarget Manager manager);
}

