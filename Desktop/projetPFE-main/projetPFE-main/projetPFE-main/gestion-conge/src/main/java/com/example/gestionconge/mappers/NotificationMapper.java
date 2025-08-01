package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.entities.Notification;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NotificationMapper {
    Notification toEntity(NotificationDTO notificationDTO);

    NotificationDTO toDto(Notification notification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Notification partialUpdate(NotificationDTO notificationDTO, @MappingTarget Notification notification);
}

