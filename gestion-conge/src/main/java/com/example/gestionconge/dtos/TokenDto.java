package com.example.gestionconge.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TokenDto {
    private String accessToken;
    private String refreshToken;
    private Long expIn;
    private Long refExpIn;
    private Long refreshExpiresIn;
    private String tokenType;
}