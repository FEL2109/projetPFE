package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.CongeReportDTO;
import com.example.gestionconge.entities.ReportConge;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UtilisateurMapper.class})
public interface ReportCongeMapper {
    ReportConge toEntity(CongeReportDTO congeReportDTO);

    CongeReportDTO toDto(ReportConge reportConge);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ReportConge partialUpdate(CongeReportDTO congeReportDTO, @MappingTarget ReportConge reportConge);
}