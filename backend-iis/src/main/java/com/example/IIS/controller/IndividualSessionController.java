package com.example.IIS.controller;

import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.IndividualSessionDTO;
import com.example.IIS.dto.SessionDocumentationDTO;
import com.example.IIS.service.GroupSessionService;
import com.example.IIS.service.IndividualSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/getByPsychologist/{id}")
    public ResponseEntity<List<IndividualSessionDTO>> getByPsychologist(@PathVariable Long id ){
        return new ResponseEntity<>(individualSessionService.getByPsychologistId(id), HttpStatus.OK);
    }
}
