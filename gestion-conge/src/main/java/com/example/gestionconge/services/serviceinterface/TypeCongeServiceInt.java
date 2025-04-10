package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.TypeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeCongeServiceInt {
    ApiResponse addTypeConge(TypeCongeDTO dto);
    ApiResponse updateTypeConge(Long id, TypeCongeDTO dto);
    ApiResponse deleteTypeConge(Long id);
    TypeCongeDTO getTypeCongeById(Long id);
    List<TypeCongeDTO> getAllTypeConges();
}
