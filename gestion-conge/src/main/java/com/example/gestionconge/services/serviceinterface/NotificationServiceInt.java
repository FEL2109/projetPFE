package com.example.gestionconge.services.serviceinterface;

import org.springframework.stereotype.Service;
import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.dtos.ApiResponse;

import java.util.List;

@Service
public interface NotificationServiceInt {
    ApiResponse addNotification(NotificationDTO notificationDTO);
    ApiResponse updateNotification(Long id, NotificationDTO notificationDTO);
    ApiResponse deleteNotification(Long id);
    NotificationDTO getNotificationById(Long id);
    List<NotificationDTO> getAllNotifications();
}