package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.TypeConge;
import com.example.gestionconge.repository.TypeCongeRepository;
import com.example.gestionconge.services.serviceinterface.TypeCongeServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.TypeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.mappers.TypeCongeMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeCongeImpl implements TypeCongeServiceInt {
    private final TypeCongeRepository typeCongeRepository;
    private final TypeCongeMapper typeCongeMapper;

    public TypeCongeImpl(TypeCongeRepository typeCongeRepository, TypeCongeMapper typeCongeMapper) {
        this.typeCongeRepository = typeCongeRepository;
        this.typeCongeMapper = typeCongeMapper;
    }

    @Override
    public ApiResponse addTypeConge(TypeCongeDTO typeCongeDTO) {
        TypeConge typeConge = typeCongeMapper.toEntity(typeCongeDTO);
        typeConge = typeCongeRepository.save(typeConge);

        return ApiResponse.builder()
                .id(typeConge.getIdTypeConge())
                .success("Type de congé ajouté avec succès!")
                .build();
    }

    @Override
    public ApiResponse updateTypeConge(Long id, TypeCongeDTO typeCongeDTO) {
        TypeConge typeConge = typeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucun type de congé trouvé avec l'ID: " + id));

        typeCongeMapper.partialUpdate(typeCongeDTO, typeConge);
        typeCongeRepository.save(typeConge);

        return ApiResponse.builder()
                .id(typeConge.getIdTypeConge())
                .success("Type de congé mis à jour avec succès!")
                .build();
    }

    @Override
    public ApiResponse deleteTypeConge(Long id) {
        TypeConge typeConge = typeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucun type de congé trouvé avec l'ID: " + id));

        typeCongeRepository.delete(typeConge);

        return ApiResponse.builder()
                .id(id)
                .success("Type de congé supprimé avec succès!")
                .build();
    }

    @Override
    public TypeCongeDTO getTypeCongeById(Long id) {
        TypeConge typeConge = typeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucun type de congé trouvé avec l'ID: " + id));

        return typeCongeMapper.toDto(typeConge);
    }

    @Override
    public List<TypeCongeDTO> getAllTypeConges() {
        List<TypeCongeDTO> dtoList = new ArrayList<>();
        List<TypeConge> typeCongeList = typeCongeRepository.findAll();
        typeCongeList.forEach(typeConge -> dtoList.add(typeCongeMapper.toDto(typeConge)));
        return dtoList;
    }
}