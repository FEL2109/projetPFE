package com.example.gestionconge.mappers;

import org.mapstruct.*;
import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.entities.Absence;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AbsenceMapper {
    @Mapping(target = "employe.idEmployee", source = "employeId")
    Absence toEntity(AbsenceDTO absenceDTO);

    @Mapping(target = "employeId", source = "employe.idEmployee")
    AbsenceDTO toDto(Absence absence);

    @Mapping(target = "employe.idEmployee", source = "employeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Absence partialUpdate(AbsenceDTO absenceDTO, @MappingTarget Absence absence);
}
