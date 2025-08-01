package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeCongeInt {
    ApiResponse addDemande(DemandeCongeDTO demandeCongeDTO);
    ApiResponse updateDemande(Long id, DemandeCongeDTO demandeCongeDTO);
    ApiResponse deleteDemande(Long id);
    DemandeCongeDTO getDemandeById(Long id);
    List<DemandeCongeDTO> getAllDemandes();
    boolean accepterDemande(Long idDemande);
    boolean refuserDemande(Long idDemande);
    public Integer calculerCongerestant(Integer soldeannuel, Integer congepris);
}

