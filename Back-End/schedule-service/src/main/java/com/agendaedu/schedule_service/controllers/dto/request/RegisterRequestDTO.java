package com.agendaedu.schedule_service.controllers.dto.request;

import com.agendaedu.schedule_service.domain.user.UserRole;

public record RegisterRequestDTO(String email, String password, String name, UserRole role) {
}
