package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.RegleCongeDTO;
import com.example.gestionconge.entities.RegleConge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RegleCongeMapperImpl implements RegleCongeMapper {

    @Override
    public RegleConge toEntity(RegleCongeDTO regleCongeDTO) {
        if ( regleCongeDTO == null ) {
            return null;
        }

        RegleConge.RegleCongeBuilder regleConge = RegleConge.builder();

        regleConge.idRegle( regleCongeDTO.getIdRegle() );
        regleConge.typeConge( regleCongeDTO.getTypeConge() );
        regleConge.joursAnnuels( regleCongeDTO.getJoursAnnuels() );

        return regleConge.build();
    }

    @Override
    public RegleCongeDTO toDto(RegleConge regleConge) {
        if ( regleConge == null ) {
            return null;
        }

        RegleCongeDTO.RegleCongeDTOBuilder regleCongeDTO = RegleCongeDTO.builder();

        regleCongeDTO.idRegle( regleConge.getIdRegle() );
        regleCongeDTO.typeConge( regleConge.getTypeConge() );
        regleCongeDTO.joursAnnuels( regleConge.getJoursAnnuels() );

        return regleCongeDTO.build();
    }

    @Override
    public RegleConge partialUpdate(RegleCongeDTO regleCongeDTO, RegleConge regleConge) {
        if ( regleCongeDTO == null ) {
            return regleConge;
        }

        if ( regleCongeDTO.getIdRegle() != null ) {
            regleConge.setIdRegle( regleCongeDTO.getIdRegle() );
        }
        if ( regleCongeDTO.getTypeConge() != null ) {
            regleConge.setTypeConge( regleCongeDTO.getTypeConge() );
        }
        regleConge.setJoursAnnuels( regleCongeDTO.getJoursAnnuels() );

        return regleConge;
    }
}
