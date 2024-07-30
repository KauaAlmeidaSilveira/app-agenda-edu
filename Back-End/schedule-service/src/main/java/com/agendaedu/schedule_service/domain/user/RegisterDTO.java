package com.agendaedu.schedule_service.domain.user;

public record RegisterDTO(String email, String password, String name, UserRole role) {
}
