package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbsenceServiceInt {
    ApiResponse addAbsence(AbsenceDTO absenceDTO);
    ApiResponse updateAbsence(Long id, AbsenceDTO absenceDTO);
    ApiResponse deleteAbsence(Long id);
    AbsenceDTO getAbsenceById(Long id);
    List<AbsenceDTO> getAllAbsences();
}
