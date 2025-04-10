package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.RegleConge;
import com.example.gestionconge.repository.RegleCongeRepository;
import com.example.gestionconge.services.serviceinterface.RegleCongeServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.RegleCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.mappers.RegleCongeMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegleCongeImpl implements RegleCongeServiceInt{
    private final RegleCongeRepository regleCongeRepository;
    private final RegleCongeMapper regleCongeMapper;

    public RegleCongeImpl(RegleCongeRepository regleCongeRepository, RegleCongeMapper regleCongeMapper) {
        this.regleCongeRepository = regleCongeRepository;
        this.regleCongeMapper = regleCongeMapper;
    }

    @Override
    public ApiResponse addRegleConge(RegleCongeDTO dto) {
        RegleConge regle = regleCongeMapper.toEntity(dto);
        regle = regleCongeRepository.save(regle);

        return ApiResponse.builder()
                .id(regle.getIdRegle())
                .success("Règle de congé enregistrée avec succès !")
                .build();
    }

    @Override
    public ApiResponse updateRegleConge(Long id, RegleCongeDTO dto) {
        RegleConge regle = regleCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucune règle trouvée avec l'id : " + id));

        regleCongeMapper.partialUpdate(dto, regle);
        regleCongeRepository.save(regle);

        return ApiResponse.builder()
                .id(regle.getIdRegle())
                .success("Règle de congé mise à jour avec succès !")
                .build();
    }

    @Override
    public ApiResponse deleteRegleConge(Long id) {
        RegleConge regle = regleCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucune règle trouvée avec l'id : " + id));
        regleCongeRepository.delete(regle);

        return ApiResponse.builder()
                .id(id)
                .success("Règle de congé supprimée avec succès !")
                .build();
    }

    @Override
    public RegleCongeDTO getRegleCongeById(Long id) {
        RegleConge regle = regleCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucune règle trouvée avec l'id : " + id));
        return regleCongeMapper.toDto(regle);
    }

    @Override
    public List<RegleCongeDTO> getAllRegleConges() {
        List<RegleCongeDTO> dtoList = new ArrayList<>();
        List<RegleConge> regles = regleCongeRepository.findAll();
        regles.forEach(regle -> dtoList.add(regleCongeMapper.toDto(regle)));
        return dtoList;
    }
}

