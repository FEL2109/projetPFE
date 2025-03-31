package com.example.gestionconge.web;

import com.example.gestionconge.entities.DemandeConge;
import com.example.gestionconge.services.serviceImpl.DemandeCongeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandesconges")
public class DemandeCongeService {
    @Autowired
    private DemandeCongeImpl demandeCongeImpl;

    @GetMapping("/{id}")
    public ResponseEntity<DemandeConge> getDemandeCongeById(@PathVariable Long id) {
        DemandeConge demandeConge = demandeCongeImpl.getById(id);
        return demandeConge != null ? ResponseEntity.ok(demandeConge) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<DemandeConge> getAllDemandeConge() {
        return demandeCongeImpl.getAllDemandeConge();
    }

    @PostMapping
    public ResponseEntity<DemandeConge> createDemandeConge(@RequestBody DemandeConge demandeConge) {
        DemandeConge createDemandeConge = demandeCongeImpl.createDemandeConge(demandeConge);
        return ResponseEntity.created(null).body(createDemandeConge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeConge> updateDemandeConge(@PathVariable Long id, @RequestBody DemandeConge demandeConge) {
        if (demandeConge == null) {
            return ResponseEntity.badRequest().body(null);
        }

        DemandeConge existingDemandeConge = demandeCongeImpl.getById(id);
        if (existingDemandeConge == null) {
            return ResponseEntity.notFound().build();
        }

        demandeCongeImpl.updateDemandeConge(id, demandeConge);
        return ResponseEntity.ok(demandeConge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemandeConge(@PathVariable Long id) {
        demandeCongeImpl.deleteDemandeConge(id);
        return ResponseEntity.noContent().build();


    }
}

