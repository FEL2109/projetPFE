package com.example.gestionconge.web;

import com.example.gestionconge.dtos.EmployeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.EmployeeServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeRestController {
    private final EmployeeServiceInt employeeServiceInt;

    public EmployeRestController(EmployeeServiceInt employeeServiceInt) {
        this.employeeServiceInt = employeeServiceInt;
    }

    @PostMapping
    public ApiResponse addEmploye(@RequestBody EmployeDTO employeDTO) {
        return employeeServiceInt.addEmploye(employeDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateEmploye(@PathVariable Long id, @RequestBody EmployeDTO employeDTO) {
        return employeeServiceInt.updateEmploye(id, employeDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteEmploye(@PathVariable Long id) {
        return employeeServiceInt.deleteEmploye(id);
    }

    @GetMapping("/{id}")
    public EmployeDTO getEmployeById(@PathVariable Long id) {
        return employeeServiceInt.getEmployeById(id);
    }

    @GetMapping
    public List<EmployeDTO> getAllEmployes() {
        return employeeServiceInt.getAllEmployes();
    }
}

