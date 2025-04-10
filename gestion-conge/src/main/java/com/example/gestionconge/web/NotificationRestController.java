package com.example.gestionconge.web;

import org.springframework.web.bind.annotation.*;
import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.dtos.ApiResponse;
import com.example.gestionconge.services.serviceinterface.NotificationServiceInt;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestController {
    private final NotificationServiceInt notificationServiceInt;

    public NotificationRestController(NotificationServiceInt notificationServiceInt) {
        this.notificationServiceInt = notificationServiceInt;
    }

    @PostMapping
    public ApiResponse addNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationServiceInt.addNotification(notificationDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse updateNotification(@PathVariable Long id, @RequestBody NotificationDTO notificationDTO) {
        return notificationServiceInt.updateNotification(id, notificationDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteNotification(@PathVariable Long id) {
        return notificationServiceInt.deleteNotification(id);
    }

    @GetMapping("/{id}")
    public NotificationDTO getNotificationById(@PathVariable Long id) {
        return notificationServiceInt.getNotificationById(id);
    }

    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationServiceInt.getAllNotifications();
    }
}

