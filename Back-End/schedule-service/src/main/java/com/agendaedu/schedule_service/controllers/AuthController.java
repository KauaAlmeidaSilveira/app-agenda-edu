package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.controllers.dto.request.LoginRequestDTO;
import com.agendaedu.schedule_service.controllers.dto.request.RegisterRequestDTO;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.domain.user.UserDTO;
import com.agendaedu.schedule_service.services.AuthService;
import com.agendaedu.schedule_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO data) {
        return ResponseEntity.ok(this.authService.login(data));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserDTO user = new UserDTO(new User(data.email(), encryptedPassword, data.name(), data.role()));

        this.userService.insert(user);
        return ResponseEntity.ok().build();
    }

}
