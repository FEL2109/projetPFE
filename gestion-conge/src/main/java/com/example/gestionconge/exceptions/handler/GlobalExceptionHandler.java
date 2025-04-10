package com.example.gestionconge.exceptions.handler;

import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.exceptions.RessourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(RessourceNotFoundException ex) {
        // Création de la réponse avec un message d'erreur
        ApiResponse response = ApiResponse.builder()
                .id(null)  // Vous pouvez laisser l'ID à null ou utiliser un ID spécifique si vous le souhaitez.
                .success("Resource not found: " + ex.getMessage()) // Le message d'erreur dans "success"
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        // Création de la réponse avec un message d'erreur générique
        ApiResponse response = ApiResponse.builder()
                .id(null)  // Id laissé à null
                .success("Internal server error: " + ex.getMessage()) // Le message d'erreur dans "success"
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

