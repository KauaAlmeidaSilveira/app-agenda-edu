package com.agendaedu.schedule_service.controllers.dto.request;

import com.agendaedu.schedule_service.domain.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        @NotBlank(message = "Nome é obrigatório")
        String name,
        UserRole role) {
}