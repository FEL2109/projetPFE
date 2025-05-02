package com.example.gestionconge.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.gestionconge.dtos.ManagerDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.ManagerServiceInt;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerRestController {
    private final ManagerServiceInt managerServiceInt;

    public ManagerRestController(ManagerServiceInt managerServiceInt) {
        this.managerServiceInt = managerServiceInt;
    }

    @PostMapping
    public ApiResponse addManager(@RequestBody ManagerDTO dto) {
        return managerServiceInt.addManager(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse updateManager(@PathVariable Long id, @RequestBody ManagerDTO dto) {
        return managerServiceInt.updateManager(id, dto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteManager(@PathVariable Long id) {
        return managerServiceInt.deleteManager(id);
    }

    @GetMapping("/{id}")
    public ManagerDTO getManagerById(@PathVariable Long id) {
        return managerServiceInt.getManagerById(id);
    }

    @GetMapping
    public List<ManagerDTO> getAllManagers() {
        return managerServiceInt.getAllManagers();
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}
