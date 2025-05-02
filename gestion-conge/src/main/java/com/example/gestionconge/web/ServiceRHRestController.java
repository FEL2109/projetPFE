package com.example.gestionconge.web;

import com.example.gestionconge.dtos.ServiceRHDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.ServiceRHServiceInt;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-rh")
public class ServiceRHRestController {
    private final ServiceRHServiceInt serviceRHServiceInt;

    public ServiceRHRestController(ServiceRHServiceInt serviceRHServiceInt) {
        this.serviceRHServiceInt = serviceRHServiceInt;
    }

    @PostMapping
    public ApiResponse addServiceRH(@RequestBody ServiceRHDTO dto) {
        return serviceRHServiceInt.addServiceRH(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse updateServiceRH(@PathVariable Long id, @RequestBody ServiceRHDTO dto) {
        return serviceRHServiceInt.updateServiceRH(id, dto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteServiceRH(@PathVariable Long id) {
        return serviceRHServiceInt.deleteServiceRH(id);
    }

    @GetMapping("/{id}")
    public ServiceRHDTO getServiceRHById(@PathVariable Long id) {
        return serviceRHServiceInt.getServiceRHById(id);
    }

    @GetMapping
    public List<ServiceRHDTO> getAllServiceRHs() {
        return serviceRHServiceInt.getAllServiceRHs();
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}

