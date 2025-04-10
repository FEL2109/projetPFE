package com.example.gestionconge.services.serviceinterface;

import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.ManagerDTO;
import com.example.gestionconge.dtos.ApiResponse;
import java.util.List;

@Service
public interface ManagerServiceInt {
    ApiResponse addManager(ManagerDTO managerDTO);
    ApiResponse updateManager(Long id, ManagerDTO managerDTO);
    ApiResponse deleteManager(Long id);
    ManagerDTO getManagerById(Long id);
    List<ManagerDTO> getAllManagers();
}