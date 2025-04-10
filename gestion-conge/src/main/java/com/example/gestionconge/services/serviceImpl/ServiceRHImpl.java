package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.ServiceRHDTO;
import com.example.gestionconge.entities.ServiceRH;
import com.example.gestionconge.repository.ServiceRHRepository;
import com.example.gestionconge.services.serviceinterface.ServiceRHServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.mappers.ServiceRHMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRHImpl implements ServiceRHServiceInt {
    private final ServiceRHRepository serviceRHRepository;
    private final ServiceRHMapper serviceRHMapper;

    public ServiceRHImpl(ServiceRHRepository serviceRHRepository, ServiceRHMapper serviceRHMapper) {
        this.serviceRHRepository = serviceRHRepository;
        this.serviceRHMapper = serviceRHMapper;
    }

    @Override
    public ApiResponse addServiceRH(ServiceRHDTO dto) {
        ServiceRH entity = serviceRHMapper.toEntity(dto);
        entity = serviceRHRepository.save(entity);
        return ApiResponse.builder()
                .id(entity.getIdRH())
                .success("Service RH ajouté avec succès !")
                .build();
    }

    @Override
    public ApiResponse updateServiceRH(Long id, ServiceRHDTO dto) {
        ServiceRH existing = serviceRHRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service RH introuvable avec l'id: " + id));
        serviceRHMapper.partialUpdate(dto, existing);
        serviceRHRepository.save(existing);
        return ApiResponse.builder()
                .id(existing.getIdRH())
                .success("Service RH mis à jour avec succès !")
                .build();
    }

    @Override
    public ApiResponse deleteServiceRH(Long id) {
        ServiceRH serviceRH = serviceRHRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service RH introuvable avec l'id: " + id));
        serviceRHRepository.delete(serviceRH);
        return ApiResponse.builder()
                .id(id)
                .success("Service RH supprimé avec succès !")
                .build();
    }

    @Override
    public ServiceRHDTO getServiceRHById(Long id) {
        ServiceRH entity = serviceRHRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service RH introuvable avec l'id: " + id));
        return serviceRHMapper.toDto(entity);
    }

    @Override
    public List<ServiceRHDTO> getAllServiceRHs() {
        List<ServiceRH> list = serviceRHRepository.findAll();
        List<ServiceRHDTO> dtoList = new ArrayList<>();
        list.forEach(serviceRH -> dtoList.add(serviceRHMapper.toDto(serviceRH)));
        return dtoList;
    }
}


