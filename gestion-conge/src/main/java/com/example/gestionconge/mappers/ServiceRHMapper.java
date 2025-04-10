package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.gestionconge.dtos.ServiceRHDTO;
import com.example.gestionconge.entities.ServiceRH;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ServiceRHMapper {
    ServiceRH toEntity(ServiceRHDTO serviceRHDTO);
    ServiceRHDTO toDto(ServiceRH serviceRH);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ServiceRH partialUpdate(ServiceRHDTO serviceRHDTO, @MappingTarget ServiceRH serviceRH);
}


