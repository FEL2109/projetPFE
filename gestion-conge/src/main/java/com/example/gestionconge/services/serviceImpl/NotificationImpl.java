package com.example.gestionconge.services.serviceImpl;

import com.example.gestionconge.entities.Notification;
import com.example.gestionconge.repository.NotificationRepository;
import com.example.gestionconge.services.serviceinterface.NotificationServiceInt;
import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.entities.Employe;
import com.example.gestionconge.repository.EmployeRepository;
import com.example.gestionconge.mappers.NotificationMapper;

import java.util.List;
import java.util.ArrayList;

@Service
public class NotificationImpl implements NotificationServiceInt {
    private final NotificationRepository notificationRepository;
    private final EmployeRepository employeRepository;
    private final NotificationMapper notificationMapper;

    public NotificationImpl(NotificationRepository notificationRepository, EmployeRepository employeRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.employeRepository = employeRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public ApiResponse addNotification(NotificationDTO dto) {
        Notification notification = notificationMapper.toEntity(dto);
        Employe employe = employeRepository.findById(dto.getEmployeId())
                .orElseThrow(() -> new RuntimeException("Employé introuvable avec l'ID : " + dto.getEmployeId()));
        notification.setEmploye(employe);

        notification = notificationRepository.save(notification);

        return ApiResponse.builder()
                .id(notification.getIdNotification())
                .success("Notification ajoutée avec succès !")
                .build();
    }

    @Override
    public ApiResponse updateNotification(Long id, NotificationDTO dto) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable avec l'ID : " + id));

        notificationMapper.partialUpdate(dto, notification);
        notificationRepository.save(notification);

        return ApiResponse.builder()
                .id(notification.getIdNotification())
                .success("Notification mise à jour avec succès !")
                .build();
    }

    @Override
    public ApiResponse deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable avec l'ID : " + id));

        notificationRepository.delete(notification);

        return ApiResponse.builder()
                .id(id)
                .success("Notification supprimée avec succès !")
                .build();
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable avec l'ID : " + id));
        return notificationMapper.toDto(notification);
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        List<NotificationDTO> dtoList = new ArrayList<>();
        List<Notification> notificationList = notificationRepository.findAll();
        notificationList.forEach(n -> dtoList.add(notificationMapper.toDto(n)));
        return dtoList;
    }
}

