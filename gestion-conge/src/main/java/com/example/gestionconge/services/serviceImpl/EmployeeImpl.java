package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.mappers.EmployeMapper;
import com.example.gestionconge.repository.EmployeRepository;
import com.example.gestionconge.services.serviceinterface.EmployeeServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.EmployeDTO;
import com.example.gestionconge.dtos.ApiResponse;

import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeImpl implements EmployeeServiceInt{
    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    public EmployeeImpl(EmployeRepository employeRepository, EmployeMapper employeMapper) {
        this.employeRepository = employeRepository;
        this.employeMapper = employeMapper;
    }

    @Override
    public ApiResponse addEmploye(EmployeDTO employeDTO) {
        Employe employe = employeMapper.toEntity(employeDTO);
        employe = employeRepository.save(employe);

        return ApiResponse.builder()
                .id(employe.getIdEmployee())
                .success("Employé ajouté avec succès!")
                .build();
    }

    @Override
    public ApiResponse updateEmploye(Long id, EmployeDTO employeDTO) {
        Employe employe = employeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Aucun employé trouvé avec l'ID : " + id));

        employeMapper.partialUpdate(employeDTO, employe);
        employeRepository.save(employe);

        return ApiResponse.builder()
                .id(employe.getIdEmployee())
                .success("Employé mis à jour avec succès!")
                .build();
    }

    @Override
    public ApiResponse deleteEmploye(Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Aucun employé trouvé avec l'ID : " + id));

        employeRepository.delete(employe);

        return ApiResponse.builder()
                .id(id)
                .success("Employé supprimé avec succès!")
                .build();
    }

    @Override
    public EmployeDTO getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Aucun employé trouvé avec l'ID : " + id));

        return employeMapper.toDto(employe);
    }

    @Override
    public List<EmployeDTO> getAllEmployes() {
        List<EmployeDTO> dtoList = new ArrayList<>();
        List<Employe> employesList = employeRepository.findAll();
        employesList.forEach(employe -> dtoList.add(employeMapper.toDto(employe)));
        return dtoList;
    }
}
