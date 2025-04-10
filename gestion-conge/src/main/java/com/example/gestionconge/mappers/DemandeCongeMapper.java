package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.entities.DemandeConge;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DemandeCongeMapper {
    @Mapping(target = "employe.idEmployee", source = "employeId")
    @Mapping(target = "manager.idManager", source = "managerId")
    @Mapping(target = "typeConge.idTypeConge", source = "typeCongeId")
    @Mapping(target = "regleConge.idRegle", source = "regleCongeId")
    DemandeConge toEntity(DemandeCongeDTO demandeCongeDTO);

    @Mapping(target = "employeId", source = "employe.idEmployee")
    @Mapping(target = "managerId", source = "manager.idManager")
    @Mapping(target = "typeCongeId", source = "typeConge.idTypeConge")
    @Mapping(target = "regleCongeId", source = "regleConge.idRegle")
    DemandeCongeDTO toDto(DemandeConge demandeConge);

    @Mapping(target = "employe.idEmployee", source = "employeId")
    @Mapping(target = "manager.idManager", source = "managerId")
    @Mapping(target = "typeConge.idTypeConge", source = "typeCongeId")
    @Mapping(target = "regleConge.idRegle", source = "regleCongeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DemandeConge partialUpdate(DemandeCongeDTO demandeCongeDTO, @MappingTarget DemandeConge demandeConge);
}

