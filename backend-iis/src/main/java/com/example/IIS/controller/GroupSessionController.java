package com.example.IIS.controller;

import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.service.GroupSessionService;
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
@RequestMapping("/api/groupSessions")
public class GroupSessionController {

    @Autowired
    private GroupSessionService groupSessionService;

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<GroupSessionDTO> createGroupSession(@Valid @RequestBody GroupSessionDTO groupSessionDTO){
        return new ResponseEntity<>(groupSessionService.create(groupSessionDTO), HttpStatus.CREATED);
    }
}
