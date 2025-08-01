package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.entities.Absence;
import com.example.gestionconge.mappers.AbsenceMapper;
import com.example.gestionconge.repository.AbsenceRepository;
import com.example.gestionconge.services.serviceinterface.AbsenceServiceInt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceImpl implements AbsenceServiceInt{
    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;

    public AbsenceImpl(AbsenceRepository absenceRepository, AbsenceMapper absenceMapper) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
    }

    @Override
    public ApiResponse addAbsence(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.toEntity(absenceDTO);
        absence = absenceRepository.save(absence);

        return ApiResponse.builder()
                .id(absence.getIdAbsence())
                .success("Absence saved successfully!")
                .build();
    }

    @Override
    public ApiResponse updateAbsence(Long id, AbsenceDTO absenceDTO) {

        Absence absence = absenceRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no absence with id: " + id));

        absenceMapper.partialUpdate(absenceDTO, absence);
        absenceRepository.save(absence);

        return ApiResponse.builder()
                .id(absence.getIdAbsence())
                .success("Absence updated successfully!")
                .build();
    }

    @Override
    public ApiResponse deleteAbsence(Long id) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no absence with id: " + id));

        absenceRepository.delete(absence);

        return ApiResponse.builder()
                .id(id)
                .success("Absence deleted successfully!")
                .build();
    }

    @Override
    public AbsenceDTO getAbsenceById(Long id) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is no absence with id: " + id));

        return absenceMapper.toDto(absence);
    }

    @Override
    public List<AbsenceDTO> getAllAbsences() {
        List<AbsenceDTO> dtoList = new ArrayList<>();
        List<Absence> absenceList = absenceRepository.findAll();
        absenceList.forEach(absence -> dtoList.add(absenceMapper.toDto(absence)));
        return dtoList;
    }
}