package com.example.gestionconge.mappers;

import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.entities.Notification;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-13T23:01:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public Notification toEntity(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Notification.NotificationBuilder notification = Notification.builder();

        notification.employe( notificationDTOToEmploye( notificationDTO ) );
        notification.idNotification( notificationDTO.getIdNotification() );
        notification.type( notificationDTO.getType() );
        notification.message( notificationDTO.getMessage() );
        notification.date( notificationDTO.getDate() );

        return notification.build();
    }

    @Override
    public NotificationDTO toDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDTO.NotificationDTOBuilder notificationDTO = NotificationDTO.builder();

        notificationDTO.employeId( notificationEmployeIdEmployee( notification ) );
        notificationDTO.idNotification( notification.getIdNotification() );
        notificationDTO.type( notification.getType() );
        notificationDTO.message( notification.getMessage() );
        notificationDTO.date( notification.getDate() );

        return notificationDTO.build();
    }

    @Override
    public Notification partialUpdate(NotificationDTO notificationDTO, Notification notification) {
        if ( notificationDTO == null ) {
            return notification;
        }

        if ( notification.getEmploye() == null ) {
            notification.setEmploye( Employe.builder().build() );
        }
        notificationDTOToEmploye1( notificationDTO, notification.getEmploye() );
        if ( notificationDTO.getIdNotification() != null ) {
            notification.setIdNotification( notificationDTO.getIdNotification() );
        }
        if ( notificationDTO.getType() != null ) {
            notification.setType( notificationDTO.getType() );
        }
        if ( notificationDTO.getMessage() != null ) {
            notification.setMessage( notificationDTO.getMessage() );
        }
        if ( notificationDTO.getDate() != null ) {
            notification.setDate( notificationDTO.getDate() );
        }

        return notification;
    }

    protected Employe notificationDTOToEmploye(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Employe.EmployeBuilder employe = Employe.builder();

        employe.idEmployee( notificationDTO.getEmployeId() );

        return employe.build();
    }

    private Long notificationEmployeIdEmployee(Notification notification) {
        if ( notification == null ) {
            return null;
        }
        Employe employe = notification.getEmploye();
        if ( employe == null ) {
            return null;
        }
        Long idEmployee = employe.getIdEmployee();
        if ( idEmployee == null ) {
            return null;
        }
        return idEmployee;
    }

    protected void notificationDTOToEmploye1(NotificationDTO notificationDTO, Employe mappingTarget) {
        if ( notificationDTO == null ) {
            return;
        }

        if ( notificationDTO.getEmployeId() != null ) {
            mappingTarget.setIdEmployee( notificationDTO.getEmployeId() );
        }
    }
}
