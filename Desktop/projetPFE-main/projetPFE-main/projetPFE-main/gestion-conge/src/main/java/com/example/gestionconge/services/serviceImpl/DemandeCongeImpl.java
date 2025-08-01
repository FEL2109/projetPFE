package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.entities.Enumm.StatutDemande;
import com.example.gestionconge.services.serviceinterface.DemandeCongeInt;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.DemandeCongeDTO;
import org.springframework.stereotype.Service;
import com.example.gestionconge.mappers.DemandeCongeMapper;
import com.example.gestionconge.repository.DemandeCongeRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class DemandeCongeImpl implements DemandeCongeInt{
    private final DemandeCongeRepository demandeCongeRepository;
    private final DemandeCongeMapper demandeCongeMapper;

    public DemandeCongeImpl(DemandeCongeRepository demandeCongeRepository, DemandeCongeMapper demandeCongeMapper) {
        this.demandeCongeRepository = demandeCongeRepository;
        this.demandeCongeMapper = demandeCongeMapper;
    }

    @Override
    public ApiResponse addDemande(DemandeCongeDTO demandeCongeDTO) {
        DemandeConge demandeConge = demandeCongeMapper.toEntity(demandeCongeDTO);
        demandeConge.setCongerestant(
                calculerCongerestant(demandeConge.getSoldeannuel(), demandeConge.getCongepris())
        );
        demandeCongeRepository.save(demandeConge);

        return ApiResponse.builder()
                .id(demandeConge.getIdDemande())
                .success("Demande de congé ajoutée avec succès")
                .build();
    }

    @Override
    public ApiResponse updateDemande(Long id, DemandeCongeDTO demandeCongeDTO) {
        DemandeConge existingDemande = demandeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande de congé non trouvée"));

        demandeCongeMapper.partialUpdate(demandeCongeDTO, existingDemande);
        existingDemande.setCongerestant(
                calculerCongerestant(existingDemande.getSoldeannuel(), existingDemande.getCongepris())
        );
        demandeCongeRepository.save(existingDemande);

        return ApiResponse.builder()
                .id(existingDemande.getIdDemande())
                .success("Demande de congé mise à jour avec succès")
                .build();
    }

    @Override
    public ApiResponse deleteDemande(Long id) {
        DemandeConge demandeConge = demandeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande de congé non trouvée"));

        demandeCongeRepository.delete(demandeConge);

        return ApiResponse.builder()
                .id(id)
                .success("Demande de congé supprimée avec succès")
                .build();
    }

    @Override
    public DemandeCongeDTO getDemandeById(Long id) {
        DemandeConge demandeConge = demandeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande de congé non trouvée"));

        return demandeCongeMapper.toDto(demandeConge);
    }

    @Override
    public List<DemandeCongeDTO> getAllDemandes() {
        List<DemandeConge> demandes = demandeCongeRepository.findAll();
        List<DemandeCongeDTO> demandeCongeDTOList = new ArrayList<>();

        demandes.forEach(demande -> demandeCongeDTOList.add(demandeCongeMapper.toDto(demande)));

        return demandeCongeDTOList;
    }


    @Override
    public boolean accepterDemande(Long idDemande) {
        DemandeConge demande = demandeCongeRepository.findById(idDemande).orElse(null);
        if (demande != null && demande.getStatut() == StatutDemande.EnAttente) {
            demande.setStatut(StatutDemande.Approuvee);
            demandeCongeRepository.save(demande);
            return true;
        }
        return false;
    }

    @Override
    public boolean refuserDemande(Long idDemande) {
        DemandeConge demande = demandeCongeRepository.findById(idDemande).orElse(null);
        if (demande != null && demande.getStatut() == StatutDemande.EnAttente) {
            demande.setStatut(StatutDemande.Refusee);
            demandeCongeRepository.save(demande);
            return true;
        }
        return false;
    }

    @Override
    public Integer calculerCongerestant(Integer soldeannuel, Integer congepris) {
        if (soldeannuel != null && congepris != null) {
            return soldeannuel - congepris;
        }
        return null;
    }
}

