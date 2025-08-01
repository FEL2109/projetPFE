package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.SoldeConge;
import com.example.gestionconge.repository.SoldeCongeRepository;
import com.example.gestionconge.services.serviceinterface.SoldeCongeServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.SoldeCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.mappers.SoldeCongeMapper;

@Service
public class SoldeCongeImpl implements SoldeCongeServiceInt {
    private final SoldeCongeRepository soldeCongeRepository;
    private final SoldeCongeMapper soldeCongeMapper;

    public SoldeCongeImpl(SoldeCongeRepository soldeCongeRepository, SoldeCongeMapper soldeCongeMapper) {
        this.soldeCongeRepository = soldeCongeRepository;
        this.soldeCongeMapper = soldeCongeMapper;
    }

    @Override
    public ApiResponse addSoldeConge(SoldeCongeDTO soldeCongeDTO) {
        SoldeConge soldeConge = soldeCongeMapper.toEntity(soldeCongeDTO);
        soldeConge = soldeCongeRepository.save(soldeConge);

        return ApiResponse.builder()
                .id(soldeConge.getIdSolde())
                .success("Solde de congé ajouté avec succès!")
                .build();
    }

    @Override
    public ApiResponse updateSoldeConge(Long id, SoldeCongeDTO soldeCongeDTO) {
        SoldeConge soldeConge = soldeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Solde de congé introuvable avec l'ID : " + id));

        soldeCongeMapper.partialUpdate(soldeCongeDTO, soldeConge);
        soldeCongeRepository.save(soldeConge);

        return ApiResponse.builder()
                .id(soldeConge.getIdSolde())
                .success("Solde de congé mis à jour avec succès!")
                .build();
    }

    @Override
    public ApiResponse deleteSoldeConge(Long id) {
        SoldeConge soldeConge = soldeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Solde de congé introuvable avec l'ID : " + id));

        soldeCongeRepository.delete(soldeConge);

        return ApiResponse.builder()
                .id(id)
                .success("Solde de congé supprimé avec succès!")
                .build();
    }

    @Override
    public SoldeCongeDTO getSoldeCongeById(Long id) {
        SoldeConge soldeConge = soldeCongeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Solde de congé introuvable avec l'ID : " + id));

        return soldeCongeMapper.toDto(soldeConge);
    }
}


