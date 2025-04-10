package com.example.gestionconge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.example.gestionconge.dtos.NotificationDTO;
import com.example.gestionconge.entities.Notification;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "employe.idEmployee", source = "employeId")
    Notification toEntity(NotificationDTO notificationDTO);

    @Mapping(target = "employeId", source = "employe.idEmployee")
    NotificationDTO toDto(Notification notification);

    @Mapping(target = "employe.idEmployee", source = "employeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Notification partialUpdate(NotificationDTO notificationDTO, @MappingTarget Notification notification);
}

