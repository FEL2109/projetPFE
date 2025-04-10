package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.EmployeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServiceInt {
    ApiResponse addEmploye(EmployeDTO dto);
    ApiResponse updateEmploye(Long id, EmployeDTO dto);
    ApiResponse deleteEmploye(Long id);
    EmployeDTO getEmployeById(Long id);
    List<EmployeDTO> getAllEmployes();
}