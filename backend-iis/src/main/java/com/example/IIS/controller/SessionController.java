package com.example.IIS.controller;

import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PreAuthorize("hasAnyRole('ROLE_REGISTERED_USER', 'ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@Valid @RequestBody SessionDTO sessionDTO){
        return new ResponseEntity<>(sessionService.create(sessionDTO), HttpStatus.CREATED);
    }
}
