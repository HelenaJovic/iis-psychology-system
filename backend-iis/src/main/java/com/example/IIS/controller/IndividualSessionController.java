package com.example.IIS.controller;

import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.IndividualSessionDTO;
import com.example.IIS.service.GroupSessionService;
import com.example.IIS.service.IndividualSessionService;
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
@RequestMapping("/api/individualSessions")
public class IndividualSessionController {

    @Autowired
    private IndividualSessionService individualSessionService;

    @PreAuthorize("hasRole('ROLE_REGISTERED_USER')")
    @PostMapping
    public ResponseEntity<IndividualSessionDTO> createIndividualSession(@Valid @RequestBody IndividualSessionDTO individualSessionDTO){
        return new ResponseEntity<>(individualSessionService.create(individualSessionDTO), HttpStatus.CREATED);
    }
}
