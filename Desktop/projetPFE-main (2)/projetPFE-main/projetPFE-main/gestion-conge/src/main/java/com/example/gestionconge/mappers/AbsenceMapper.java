package com.example.gestionconge.mappers;

import org.mapstruct.*;
import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.entities.Absence;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AbsenceMapper {
    Absence toEntity(AbsenceDTO absenceDTO);

    AbsenceDTO toDto(Absence absence);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Absence partialUpdate(AbsenceDTO absenceDTO, @MappingTarget Absence absence);
}
