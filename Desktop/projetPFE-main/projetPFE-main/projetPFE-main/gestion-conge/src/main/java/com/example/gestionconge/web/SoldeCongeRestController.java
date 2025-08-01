package com.example.gestionconge.web;

import com.example.gestionconge.services.serviceinterface.SoldeCongeServiceInt;
import com.example.gestionconge.dtos.SoldeCongeDTO;
import org.springframework.web.bind.annotation.*;
import com.example.gestionconge.dtos.ApiResponse;

@RestController
@RequestMapping("/api/solde-conges")
public class SoldeCongeRestController {private final SoldeCongeServiceInt soldeCongeServiceInt;

    public SoldeCongeRestController(SoldeCongeServiceInt soldeCongeServiceInt) {
        this.soldeCongeServiceInt = soldeCongeServiceInt;
    }

    @PostMapping
    public ApiResponse addSoldeConge(@RequestBody SoldeCongeDTO soldeCongeDTO) {
        return soldeCongeServiceInt.addSoldeConge(soldeCongeDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateSoldeConge(@PathVariable Long id, @RequestBody SoldeCongeDTO soldeCongeDTO) {
        return soldeCongeServiceInt.updateSoldeConge(id, soldeCongeDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteSoldeConge(@PathVariable Long id) {
        return soldeCongeServiceInt.deleteSoldeConge(id);
    }

    @GetMapping("/{id}")
    public SoldeCongeDTO getSoldeCongeById(@PathVariable Long id) {
        return soldeCongeServiceInt.getSoldeCongeById(id);
    }
}



