package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.user.AuthenticationDTO;
import com.agendaedu.schedule_service.domain.user.LoginResponseDTO;
import com.agendaedu.schedule_service.domain.user.RegisterDTO;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.infra.security.TokenService;
import com.agendaedu.schedule_service.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.email(), encryptedPassword, data.name(), data.role());

        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }

}
