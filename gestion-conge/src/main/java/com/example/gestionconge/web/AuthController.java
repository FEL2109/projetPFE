package com.example.gestionconge.web;


import com.example.gestionconge.dtos.LoginDto;
import com.example.gestionconge.dtos.RefreshTokenDto;
import com.example.gestionconge.dtos.TokenDto;
import com.example.gestionconge.services.serviceImpl.AuthServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class AuthController {

    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
    @GetMapping("/roles")
    public ResponseEntity<List<String>> getUserRoles(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        List<String> roles = authService.getUserRoles(token);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody RefreshTokenDto refreshToken) {
        authService.logout(refreshToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestParam RefreshTokenDto refreshToken) {
        try {
            Map<String, Object> response = authService.refreshAccessToken(refreshToken);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Refresh Token");
        }
    }
}