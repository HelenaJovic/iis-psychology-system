package com.example.IIS.service.impl;

import com.example.IIS.domain.Role;
import com.example.IIS.domain.User;
import com.example.IIS.domain.enums.UserRole;
import com.example.IIS.dto.LoginDTO;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.exception.ApiResponse;
import com.example.IIS.exception.IISException;
import com.example.IIS.repository.RoleRepo;
import com.example.IIS.repository.UserRepo;
import com.example.IIS.security.JwtTokenProvider;
import com.example.IIS.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;




    @Override
    public String login(LoginDTO loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public ResponseEntity<ApiResponse> register(RegisterDTO registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new IISException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new IISException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role userRole = roleRepository.findByName(registerDto.getRole()).get();
        user.setRole(userRole);

        userRepository.save(user);

//        ApiResponse response = new ApiResponse("User registered successfully!.");
//        return String.valueOf(new ResponseEntity<>(response, HttpStatus.CREATED));
        // Create ApiResponse object with the success message
        ApiResponse response = new ApiResponse("User registered successfully!");

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
