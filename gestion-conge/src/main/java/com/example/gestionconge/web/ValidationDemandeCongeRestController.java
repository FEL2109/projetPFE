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

    @PostMapping
    public ApiResponse addValidationDemandeConge(@RequestBody ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        return validationDemandeCongeServiceInt.addValidationDemandeConge(validationDemandeCongeDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateValidationDemandeConge(@PathVariable Long id, @RequestBody ValidationDemandeCongeDTO validationDemandeCongeDTO) {
        return validationDemandeCongeServiceInt.updateValidationDemandeConge(id, validationDemandeCongeDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteValidationDemandeConge(@PathVariable Long id) {
        return validationDemandeCongeServiceInt.deleteValidationDemandeConge(id);
    }

    @GetMapping("/{id}")
    public ValidationDemandeCongeDTO getValidationDemandeCongeById(@PathVariable Long id) {
        return validationDemandeCongeServiceInt.getValidationDemandeCongeById(id);
    }

    @GetMapping
    public List<ValidationDemandeCongeDTO> getAllValidationDemandeConges() {
        return validationDemandeCongeServiceInt.getAllValidationDemandeConges();
    }
}




