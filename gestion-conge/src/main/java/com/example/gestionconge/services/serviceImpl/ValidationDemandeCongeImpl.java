package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.ValidationDemandeConge;
import com.example.gestionconge.repository.ValidationDemandeCongeRepository;
import com.example.gestionconge.services.serviceinterface.ValidationDemandeCongeServiceInt;
import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;
import com.example.gestionconge.mappers.ValidationDemandeCongeMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationDemandeCongeImpl implements ValidationDemandeCongeServiceInt {

    private final ValidationDemandeCongeRepository validationDemandeCongeRepository;
    private final ValidationDemandeCongeMapper validationDemandeCongeMapper;

    public ValidationDemandeCongeImpl(ValidationDemandeCongeRepository validationDemandeCongeRepository,
                                      ValidationDemandeCongeMapper validationDemandeCongeMapper) {
        this.validationDemandeCongeRepository = validationDemandeCongeRepository;
        this.validationDemandeCongeMapper = validationDemandeCongeMapper;
    }

    @Override
    public ApiResponse addValidationDemandeConge(ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        ValidationDemandeConge validationDemandeConge = validationDemandeCongeMapper.toEntity(validationDemandeCongeDTO);
        validationDemandeConge = validationDemandeCongeRepository.save(validationDemandeConge);

        return ApiResponse.builder()
                .id(validationDemandeConge.getIdValidation())
                .success("Validation Demande Conge saved successfully!")
                .build();
    }

    @Override
    public ApiResponse updateValidationDemandeConge(Long id, ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        ValidationDemandeConge validationDemandeConge = validationDemandeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no validation demande conge with id: " + id));

        validationDemandeCongeMapper.partialUpdate(validationDemandeCongeDTO, validationDemandeConge);
        validationDemandeCongeRepository.save(validationDemandeConge);

        return ApiResponse.builder()
                .id(validationDemandeConge.getIdValidation())
                .success("Validation Demande Conge updated successfully!")
                .build();
    }

    @Override
    public ApiResponse deleteValidationDemandeConge(Long id) {
        ValidationDemandeConge validationDemandeConge = validationDemandeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no validation demande conge with id: " + id));

        validationDemandeCongeRepository.delete(validationDemandeConge);

        return ApiResponse.builder()
                .id(id)
                .success("Validation Demande Conge deleted successfully!")
                .build();
    }

    @Override
    public ValidationDemandeCongeDTO getValidationDemandeCongeById(Long id) {
        ValidationDemandeConge validationDemandeConge = validationDemandeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no validation demande conge with id: " + id));

        return validationDemandeCongeMapper.toDto(validationDemandeConge);
    }

    @Override
    public List<ValidationDemandeCongeDTO> getAllValidationDemandeConges() {
        List<ValidationDemandeCongeDTO> dtoList = new ArrayList<>();
        List<ValidationDemandeConge> validationDemandeCongeList = validationDemandeCongeRepository.findAll();
        validationDemandeCongeList.forEach(validationDemandeConge -> dtoList.add(validationDemandeCongeMapper.toDto(validationDemandeConge)));
        return dtoList;
    }
}