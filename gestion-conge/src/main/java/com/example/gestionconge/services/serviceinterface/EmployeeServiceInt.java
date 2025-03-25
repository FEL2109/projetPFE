package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.entities.Employe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServiceInt {
    Employe getById(Long id);
    List<Employe> getAllEmployee();
    Employe createEmployee(Employe employe);
    void deleteEmployee(Long id);
    void updateEmployee(Long id,Employe employe);

}
