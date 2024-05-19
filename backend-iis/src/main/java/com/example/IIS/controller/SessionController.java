package com.example.IIS.controller;

import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.TimeSlotDTO;
import com.example.IIS.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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


    @PreAuthorize("hasAnyRole('ROLE_REGISTERED_USER', 'ROLE_PSYCHOLOG')")
    @GetMapping("/{psychologistId}/{date}")
    public ResponseEntity<List<TimeSlotDTO>>  generateFreeSlots(@PathVariable Long psychologistId, @PathVariable LocalDate date){
        return new ResponseEntity<>(sessionService.generateFreeTimeSlots(psychologistId,date), HttpStatus.OK);
    }

}
