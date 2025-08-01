package com.example.gestionconge.web;


import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.dtos.DemandeCongeDTO;
import com.example.gestionconge.dtos.UtilisateurDto;
import com.example.gestionconge.services.serviceinterface.UtilisateurInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UtilisateurController {


    private UtilisateurInt utilisateurInt;

    private UtilisateurController(UtilisateurInt utilisateurInt){
        this.utilisateurInt=utilisateurInt;
    }

    @PostMapping
    public ApiResponse addUser(@RequestBody UtilisateurDto utilisateurDto) {
        return utilisateurInt.addUser(utilisateurDto);
    }


    @GetMapping
    public List<UtilisateurDto> getAllUtilisateurs() {
        return utilisateurInt.getAllUtilisateurs();
    }

}
