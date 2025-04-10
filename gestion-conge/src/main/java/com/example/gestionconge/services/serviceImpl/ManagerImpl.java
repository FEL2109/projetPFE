package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.services.serviceinterface.ManagerServiceInt;
import com.example.gestionconge.entities.Manager;
import com.example.gestionconge.repository.ManagerRepository;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.ManagerDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.mappers.ManagerMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerImpl implements ManagerServiceInt {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    public ManagerImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public ApiResponse addManager(ManagerDTO dto) {
        Manager manager = managerMapper.toEntity(dto);
        manager = managerRepository.save(manager);

        return ApiResponse.builder()
                .id(manager.getIdManager())
                .success("Manager saved successfully!")
                .build();
    }

    @Override
    public ApiResponse updateManager(Long id, ManagerDTO dto) {
        Manager manager = managerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No manager found with id: " + id));

        managerMapper.partialUpdate(dto, manager);
        managerRepository.save(manager);

        return ApiResponse.builder()
                .id(manager.getIdManager())
                .success("Manager updated successfully!")
                .build();
    }

    @Override
    public ApiResponse deleteManager(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No manager found with id: " + id));

        managerRepository.delete(manager);

        return ApiResponse.builder()
                .id(id)
                .success("Manager deleted successfully!")
                .build();
    }

    @Override
    public ManagerDTO getManagerById(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No manager found with id: " + id));

        return managerMapper.toDto(manager);
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        List<ManagerDTO> dtoList = new ArrayList<>();
        List<Manager> managerList = managerRepository.findAll();
        managerList.forEach(manager -> dtoList.add(managerMapper.toDto(manager)));
        return dtoList;
    }
}

