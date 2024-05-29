package com.example.IIS.controller;

import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.SessionDocumentationDTO;
import com.example.IIS.service.SessionDocumentationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessionDocumentations")
public class SessionDocumentationController {

    @Autowired
    private SessionDocumentationService sessionDocumentationService;

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<SessionDocumentationDTO> createSessionDocumentation(@Valid @RequestBody SessionDocumentationDTO sessionDocumentationDTO){
        return new ResponseEntity<>(sessionDocumentationService.create(sessionDocumentationDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SessionDocumentationDTO>> getAll(){
        return new ResponseEntity<>(sessionDocumentationService.getAll(), HttpStatus.OK);
    }


}
