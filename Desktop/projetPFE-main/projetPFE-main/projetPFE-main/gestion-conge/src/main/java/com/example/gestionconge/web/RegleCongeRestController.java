package com.example.gestionconge.web;

import com.example.gestionconge.dtos.RegleCongeDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.RegleCongeServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regles-conge")
public class RegleCongeRestController {
    private final RegleCongeServiceInt regleCongeService;

    public RegleCongeRestController(RegleCongeServiceInt regleCongeService) {
        this.regleCongeService = regleCongeService;
    }

    @PostMapping
    public ApiResponse addRegle(@RequestBody RegleCongeDTO dto) {
        return regleCongeService.addRegleConge(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse updateRegle(@PathVariable Long id, @RequestBody RegleCongeDTO dto) {
        return regleCongeService.updateRegleConge(id, dto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteRegle(@PathVariable Long id) {
        return regleCongeService.deleteRegleConge(id);
    }

    @GetMapping("/{id}")
    public RegleCongeDTO getRegleById(@PathVariable Long id) {
        return regleCongeService.getRegleCongeById(id);
    }

    @GetMapping
    public List<RegleCongeDTO> getAllRegles() {
        return regleCongeService.getAllRegleConges();
    }
}

