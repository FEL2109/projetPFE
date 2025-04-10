package com.example.gestionconge.web;

import com.example.gestionconge.dtos.ValidationDemandeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.ValidationDemandeCongeServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validation-demandes")
public class ValidationDemandeCongeRestController {private final ValidationDemandeCongeServiceInt validationDemandeCongeServiceInt;

    public ValidationDemandeCongeRestController(ValidationDemandeCongeServiceInt validationDemandeCongeServiceInt) {
        this.validationDemandeCongeServiceInt = validationDemandeCongeServiceInt;
    }

    // Endpoint to add a new validation demande conge
    @PostMapping
    public ApiResponse addValidationDemandeConge(@RequestBody ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        return validationDemandeCongeServiceInt.addValidationDemandeConge(validationDemandeCongeDTO);
    }

    // Endpoint to update an existing validation demande conge
    @PutMapping("/{id}")
    public ApiResponse updateValidationDemandeConge(@PathVariable Long id, @RequestBody ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        return validationDemandeCongeServiceInt.updateValidationDemandeConge(id, validationDemandeCongeDTO);
    }

    // Endpoint to delete a validation demande conge
    @DeleteMapping("/{id}")
    public ApiResponse deleteValidationDemandeConge(@PathVariable Long id) {
        return validationDemandeCongeServiceInt.deleteValidationDemandeConge(id);
    }

    // Endpoint to get a validation demande conge by its ID
    @GetMapping("/{id}")
    public ValidationDemandeCongeDTO getValidationDemandeCongeById(@PathVariable Long id) {
        return validationDemandeCongeServiceInt.getValidationDemandeCongeById(id);
    }

    // Endpoint to get all validation demande conges
    @GetMapping
    public List<ValidationDemandeCongeDTO> getAllValidationDemandeConges() {
        return validationDemandeCongeServiceInt.getAllValidationDemandeConges();
    }
}




