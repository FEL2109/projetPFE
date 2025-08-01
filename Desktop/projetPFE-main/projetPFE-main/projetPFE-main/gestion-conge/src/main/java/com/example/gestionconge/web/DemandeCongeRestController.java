package com.example.gestionconge.web;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.services.serviceinterface.DemandeCongeInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeCongeRestController {
    private final DemandeCongeInt demandeCongeInt;

    public DemandeCongeRestController(DemandeCongeInt demandeCongeInt) {
        this.demandeCongeInt = demandeCongeInt;
    }

    @PostMapping
    public ApiResponse addDemande(@RequestBody DemandeCongeDTO demandeCongeDTO) {
        return demandeCongeInt.addDemande(demandeCongeDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateDemande(@PathVariable Long id, @RequestBody DemandeCongeDTO demandeCongeDTO) {
        return demandeCongeInt.updateDemande(id, demandeCongeDTO);
    }

    @GetMapping("/{id}")
    public DemandeCongeDTO getDemandeById(@PathVariable Long id) {
        return demandeCongeInt.getDemandeById(id);
    }

    @GetMapping
    public List<DemandeCongeDTO> getAllDemandes() {
        return demandeCongeInt.getAllDemandes();
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteDemande(@PathVariable Long id) {
        return demandeCongeInt.deleteDemande(id);
    }



    @PutMapping("/{id}/accepter")
    public ApiResponse accepterDemande(@PathVariable Long id) {
        boolean result = demandeCongeInt.accepterDemande(id);
        if (result) {
            return new ApiResponse(id, "Demande approuvée avec succès.");
        } else {
            return new ApiResponse(null, "Impossible d'approuver la demande.");
        }
    }

    @PutMapping("/{id}/refuser")
    public ApiResponse RefuserDemande(@PathVariable Long id) {
        boolean result = demandeCongeInt.refuserDemande(id);
        if (result) {
            return new ApiResponse(id, "Demande refusee avec succès.");
        } else {
            return new ApiResponse(null, "Impossible de refuser la demande.");
        }
    }
}