package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.TypeCongeDTO;
import com.example.gestionconge.entities.RegleConge;
import com.example.gestionconge.entities.TypeConge;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TypeCongeMapperImpl implements TypeCongeMapper {

    @Override
    public TypeConge toEntity(TypeCongeDTO typeCongeDTO) {
        if ( typeCongeDTO == null ) {
            return null;
        }

        TypeConge.TypeCongeBuilder typeConge = TypeConge.builder();

        typeConge.regleConge( typeCongeDTOToRegleConge( typeCongeDTO ) );
        typeConge.idTypeConge( typeCongeDTO.getIdTypeConge() );
        typeConge.libelle( typeCongeDTO.getLibelle() );
        typeConge.description( typeCongeDTO.getDescription() );
        typeConge.nombreJours( typeCongeDTO.getNombreJours() );

        return typeConge.build();
    }

    @Override
    public TypeCongeDTO toDto(TypeConge typeConge) {
        if ( typeConge == null ) {
            return null;
        }

        TypeCongeDTO.TypeCongeDTOBuilder typeCongeDTO = TypeCongeDTO.builder();

        typeCongeDTO.regleCongeId( typeCongeRegleCongeIdRegle( typeConge ) );
        typeCongeDTO.idTypeConge( typeConge.getIdTypeConge() );
        typeCongeDTO.libelle( typeConge.getLibelle() );
        typeCongeDTO.description( typeConge.getDescription() );
        typeCongeDTO.nombreJours( typeConge.getNombreJours() );

        return typeCongeDTO.build();
    }

    @Override
    public TypeConge partialUpdate(TypeCongeDTO typeCongeDTO, TypeConge typeConge) {
        if ( typeCongeDTO == null ) {
            return typeConge;
        }

        if ( typeConge.getRegleConge() == null ) {
            typeConge.setRegleConge( RegleConge.builder().build() );
        }
        typeCongeDTOToRegleConge1( typeCongeDTO, typeConge.getRegleConge() );
        if ( typeCongeDTO.getIdTypeConge() != null ) {
            typeConge.setIdTypeConge( typeCongeDTO.getIdTypeConge() );
        }
        if ( typeCongeDTO.getLibelle() != null ) {
            typeConge.setLibelle( typeCongeDTO.getLibelle() );
        }
        if ( typeCongeDTO.getDescription() != null ) {
            typeConge.setDescription( typeCongeDTO.getDescription() );
        }
        typeConge.setNombreJours( typeCongeDTO.getNombreJours() );

        return typeConge;
    }

    protected RegleConge typeCongeDTOToRegleConge(TypeCongeDTO typeCongeDTO) {
        if ( typeCongeDTO == null ) {
            return null;
        }

        RegleConge.RegleCongeBuilder regleConge = RegleConge.builder();

        regleConge.idRegle( typeCongeDTO.getRegleCongeId() );

        return regleConge.build();
    }

    private Long typeCongeRegleCongeIdRegle(TypeConge typeConge) {
        if ( typeConge == null ) {
            return null;
        }
        RegleConge regleConge = typeConge.getRegleConge();
        if ( regleConge == null ) {
            return null;
        }
        Long idRegle = regleConge.getIdRegle();
        if ( idRegle == null ) {
            return null;
        }
        return idRegle;
    }

    protected void typeCongeDTOToRegleConge1(TypeCongeDTO typeCongeDTO, RegleConge mappingTarget) {
        if ( typeCongeDTO == null ) {
            return;
        }

        if ( typeCongeDTO.getRegleCongeId() != null ) {
            mappingTarget.setIdRegle( typeCongeDTO.getRegleCongeId() );
        }
    }
}
