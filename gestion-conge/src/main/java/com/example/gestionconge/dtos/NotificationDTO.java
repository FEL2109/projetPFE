package com.example.gestionconge.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class NotificationDTO {
    @NotNull
    private Long idNotification;

    private String type;

    @NotEmpty(message = "message de la notification est requis")
    private String message;

    @NotNull
    private LocalDate date;

    private Long employeId;
}



