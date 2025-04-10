package com.example.gestionconge.web;

import com.example.gestionconge.dtos.AbsenceDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.AbsenceServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceRestController {
    private final AbsenceServiceInt absenceServiceInt;

    public AbsenceRestController(AbsenceServiceInt absenceServiceInt) {
        this.absenceServiceInt = absenceServiceInt;
    }

    // Endpoint to add a new absence
    @PostMapping
    public ApiResponse addAbsence(@RequestBody AbsenceDTO absenceDTO) {
        return absenceServiceInt.addAbsence(absenceDTO);
    }

    // Endpoint to update an existing absence
    @PutMapping("/{id}")
    public ApiResponse updateAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDTO) {
        return absenceServiceInt.updateAbsence(id, absenceDTO);
    }

    // Endpoint to delete an absence
    @DeleteMapping("/{id}")
    public ApiResponse deleteAbsence(@PathVariable Long id) {
        return absenceServiceInt.deleteAbsence(id);
    }

    // Endpoint to get an absence by its ID
    @GetMapping("/{id}")
    public AbsenceDTO getAbsenceById(@PathVariable Long id) {
        return absenceServiceInt.getAbsenceById(id);
    }

    // Endpoint to get all absences
    @GetMapping
    public List<AbsenceDTO> getAllAbsences() {
        return absenceServiceInt.getAllAbsences();
    }
}
