package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.UtilisateurDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurInt {
    ApiResponse addUser(UtilisateurDto utilisateurDto);
    ApiResponse updateUser(Long id, UtilisateurDto utilisateurDto);
    ApiResponse deleteUser(Long id);
    UtilisateurDto getDemandeById(Long id);
    List<UtilisateurDto> getAllUtilisateurs();

}
