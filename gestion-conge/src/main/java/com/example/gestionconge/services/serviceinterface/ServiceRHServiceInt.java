package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.ServiceRHDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRHServiceInt {
    ApiResponse addServiceRH(ServiceRHDTO dto);
    ApiResponse updateServiceRH(Long id, ServiceRHDTO dto);
    ApiResponse deleteServiceRH(Long id);
    ServiceRHDTO getServiceRHById(Long id);
    List<ServiceRHDTO> getAllServiceRHs();
}
