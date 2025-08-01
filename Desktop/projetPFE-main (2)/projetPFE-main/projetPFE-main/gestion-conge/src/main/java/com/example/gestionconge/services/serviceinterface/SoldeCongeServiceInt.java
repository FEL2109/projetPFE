package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.SoldeCongeDTO;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.ApiResponse;
import java.util.List;

@Service
public interface SoldeCongeServiceInt {
    ApiResponse addSoldeConge(SoldeCongeDTO dto);
    ApiResponse updateSoldeConge(Long id, SoldeCongeDTO dto);
    ApiResponse deleteSoldeConge(Long id);
    SoldeCongeDTO getSoldeCongeById(Long id);
}