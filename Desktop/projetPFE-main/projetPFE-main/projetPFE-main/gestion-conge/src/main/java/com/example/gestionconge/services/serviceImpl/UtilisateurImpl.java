package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.dtos.UtilisateurDto;
import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Utilisateur;
import com.example.gestionconge.mappers.UtilisateurMapper;
import com.example.gestionconge.repository.UtilisateurRepository;
import com.example.gestionconge.services.serviceinterface.UtilisateurInt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurImpl implements UtilisateurInt {


    private UtilisateurRepository utilisateurRepository;
    private UtilisateurMapper utilisateurMapper;

    private UtilisateurImpl(UtilisateurRepository utilisateurRepository,
                            UtilisateurMapper utilisateurMapper){
        this.utilisateurRepository= utilisateurRepository;
        this.utilisateurMapper=utilisateurMapper;
    }

    @Override
    public ApiResponse addUser(UtilisateurDto utilisateurDto) {

        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        utilisateurRepository.save(utilisateur);

        return ApiResponse.builder()
                .id(utilisateur.getId())
                .success("utilisateur ajoué")
                .build();
    }
    @Override
    public ApiResponse updateUser(Long id, UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        return null;
    }

    @Override
    public UtilisateurDto getDemandeById(Long id) {
        return null;
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        List<UtilisateurDto> utilisateurDtoList = new ArrayList<>();

        utilisateurs.forEach(demande -> utilisateurDtoList.add(utilisateurMapper.toDto(demande)));

        return utilisateurDtoList;
    }




}
