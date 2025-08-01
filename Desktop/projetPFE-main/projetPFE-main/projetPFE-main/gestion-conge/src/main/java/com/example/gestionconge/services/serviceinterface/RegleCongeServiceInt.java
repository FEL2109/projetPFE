package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.RegleCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RegleCongeServiceInt {
    ApiResponse addRegleConge(RegleCongeDTO regleCongeDTO);
    ApiResponse updateRegleConge(Long id, RegleCongeDTO regleCongeDTO);
    ApiResponse deleteRegleConge(Long id);
    RegleCongeDTO getRegleCongeById(Long id);
    List<RegleCongeDTO> getAllRegleConges();
}
