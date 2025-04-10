package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ValidationDemandeCongeServiceInt {
    ApiResponse addValidationDemandeConge(ValidationDemandeCongeDTO validationDemandeCongeDTO);
    ApiResponse updateValidationDemandeConge(Long id, ValidationDemandeCongeDTO validationDemandeCongeDTO);
    ApiResponse deleteValidationDemandeConge(Long id);
    ValidationDemandeCongeDTO getValidationDemandeCongeById(Long id);
    List<ValidationDemandeCongeDTO> getAllValidationDemandeConges();
}
