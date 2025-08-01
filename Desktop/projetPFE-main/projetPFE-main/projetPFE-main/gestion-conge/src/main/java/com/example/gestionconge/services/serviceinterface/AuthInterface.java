package com.example.gestionconge.services.serviceinterface;

import com.example.gestionconge.dtos.LoginDto;
import com.example.gestionconge.dtos.RefreshTokenDto;
import com.example.gestionconge.dtos.TokenDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AuthInterface {
    TokenDto login(LoginDto loginDto);
    void logout(RefreshTokenDto refreshTokenDto);
    Map<String, Object> refreshAccessToken(RefreshTokenDto refreshToken);



}