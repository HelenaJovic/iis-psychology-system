package com.example.IIS.controller;

import com.example.IIS.dto.DocumentationJournalDTO;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.service.DocumentationJournalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentationJournal")
public class DocumentationJournalController {

    @Autowired
    private DocumentationJournalService documentationJournalService;

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @GetMapping
    public ResponseEntity<List<DocumentationJournalDTO>> getAll(){
        return new ResponseEntity<>(documentationJournalService.getAll(), HttpStatus.OK);
    }
}
