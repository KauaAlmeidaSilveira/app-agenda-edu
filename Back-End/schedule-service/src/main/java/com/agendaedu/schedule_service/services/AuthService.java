package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.controllers.dto.request.LoginRequestDTO;
import com.agendaedu.schedule_service.controllers.dto.response.LoginResponseDTO;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.infra.security.TokenService;
import com.agendaedu.schedule_service.repositories.UserRepository;
import com.agendaedu.schedule_service.services.exceptions.InvalidCredentialsExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public LoginResponseDTO login(LoginRequestDTO authDTO) {
        User user = this.userRepository.findByEmail(authDTO.email()).orElseThrow(() -> new UsernameNotFoundException("User not Found !!"));
        if (passwordEncoder.matches(authDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new LoginResponseDTO(user.getEmail(), token);
        } else {
            throw new InvalidCredentialsExceptions("Dados de login invalidos !!");
        }
    }
}
