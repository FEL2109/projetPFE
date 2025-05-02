package com.example.gestionconge.web;

import com.example.gestionconge.dtos.TypeCongeDTO;
import com.example.gestionconge.services.serviceinterface.TypeCongeServiceInt;
import com.example.gestionconge.dtos.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-conges")
public class TypeCongeRestController { private final TypeCongeServiceInt typeCongeServiceInt;

    public TypeCongeRestController(TypeCongeServiceInt typeCongeServiceInt) {
        this.typeCongeServiceInt = typeCongeServiceInt;
    }

    @PostMapping
    public ApiResponse addTypeConge(@RequestBody TypeCongeDTO typeCongeDTO) {
        return typeCongeServiceInt.addTypeConge(typeCongeDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateTypeConge(@PathVariable Long id, @RequestBody TypeCongeDTO typeCongeDTO) {
        return typeCongeServiceInt.updateTypeConge(id, typeCongeDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteTypeConge(@PathVariable Long id) {
        return typeCongeServiceInt.deleteTypeConge(id);
    }

    @GetMapping("/{id}")
    public TypeCongeDTO getTypeCongeById(@PathVariable Long id) {
        return typeCongeServiceInt.getTypeCongeById(id);
    }

    @GetMapping
    public List<TypeCongeDTO> getAllTypeConges() {
        return typeCongeServiceInt.getAllTypeConges();
    }
}


