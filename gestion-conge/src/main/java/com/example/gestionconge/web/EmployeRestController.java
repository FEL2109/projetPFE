package com.example.gestionconge.web;

import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.services.serviceImpl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeRestController {

    @Autowired
    private EmployeeImpl employeeImp;


    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeeById(@PathVariable Long id) {
        Employe employe = employeeImp.getById(id);
        return employe != null ? ResponseEntity.ok(employe) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Employe> getAllEmployee() {
        return employeeImp.getAllEmployee();
    }

    @PostMapping
    public ResponseEntity<Employe> createEmployee(@RequestBody Employe employe) {
        Employe createEmployee = employeeImp.createEmployee(employe);
        return ResponseEntity.created(null).body(createEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmployee(@PathVariable Long id, @RequestBody Employe employe) {
        if (employe == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Employe existingEmployee = employeeImp.getById(id);
        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        employeeImp.updateEmployee(id, employe);
        return ResponseEntity.ok(employe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeImp.deleteEmployee(id);
        return ResponseEntity.noContent().build();


    }
}