package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.controllers.dto.request.LoginRequestDTO;
import com.agendaedu.schedule_service.controllers.dto.request.RegisterRequestDTO;
import com.agendaedu.schedule_service.controllers.dto.response.LoginResponseDTO;
import com.agendaedu.schedule_service.controllers.dto.response.RegisterReponseDTO;
import com.agendaedu.schedule_service.domain.user.User;
import com.agendaedu.schedule_service.domain.user.UserDTO;
import com.agendaedu.schedule_service.infra.security.TokenService;
import com.agendaedu.schedule_service.repositories.UserRepository;
import com.agendaedu.schedule_service.services.exceptions.InvalidCredentialsException;
import com.agendaedu.schedule_service.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada !!"));
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO authDTO) {
        User user = (User) this.loadUserByUsername(authDTO.email());
        if (passwordEncoder.matches(authDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new LoginResponseDTO(user.getEmail(), token);
        } else {
            throw new InvalidCredentialsException("Dados de login invalidos !!");
        }
    }

    @Transactional
    public RegisterReponseDTO register(RegisterRequestDTO authDTO) {
        if (this.userRepository.findByEmail(authDTO.email()).isEmpty()) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(authDTO.password());
            UserDTO user = new UserDTO(new User(authDTO.email(), encryptedPassword, authDTO.name(), authDTO.role()));
            this.userService.insert(user);
            return new RegisterReponseDTO(authDTO.email(), authDTO.name());
        } else {
            throw new UserAlreadyExistsException("Conta já existente com este email.");
        }
    }

}
