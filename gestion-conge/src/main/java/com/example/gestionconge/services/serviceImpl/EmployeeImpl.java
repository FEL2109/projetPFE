package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.repository.EmployeRepository;
import com.example.gestionconge.services.serviceinterface.EmployeeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeServiceInt {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAllEmployee() {
        return employeRepository.findAll();
    }

    @Override
    public Employe createEmployee(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmployee(Long id) {
     if(employeRepository.existsById(id)){
    employeRepository.deleteById(id);
}
    }

    @Override
    public void updateEmployee(Long id, Employe employe) {
        Optional<Employe> existingEmployeeOpt=employeRepository.findById(id);
        if(existingEmployeeOpt.isPresent()){
            Employe existingEmployee = existingEmployeeOpt.get();

            existingEmployee.setNom(employe.getNom());
            existingEmployee.setPrenom(employe.getPrenom());
            existingEmployee.setEmail(employe.getEmail());
            existingEmployee.setMotDePasse(employe.getMotDePasse());
            existingEmployee.setCheminPhoto(employe.getCheminPhoto());
            existingEmployee.setTelephone(employe.getTelephone());
            existingEmployee.setPoste(employe.getPoste());

            employeRepository.save(existingEmployee);
 }
}

    }











