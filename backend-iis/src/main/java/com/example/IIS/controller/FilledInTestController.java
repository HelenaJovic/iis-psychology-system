package com.example.IIS.controller;

import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.FilledInTestDTO;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.service.FilledInTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/filledInTests")
public class FilledInTestController {

    @Autowired
    private FilledInTestService filledInTestService;

    @PreAuthorize("hasRole('ROLE_REGISTERED_USER')")
    @PostMapping
    public ResponseEntity<FilledInTestDTO> createTest(@Valid @RequestBody FilledInTestDTO filledInTestDTO){
        return new ResponseEntity<>(filledInTestService.createTest(filledInTestDTO), HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<FilledInTestDTO>> getByUser(@PathVariable Long userId){
        return new ResponseEntity<>(filledInTestService.getByUserId(userId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_REGISTERED_USER')")
    @PostMapping("/finishTest/{id}")
    public ResponseEntity<FilledInTestDTO> finishTest(@PathVariable Long id , @RequestBody FilledInTestDTO filledInTestDTO){
        return new ResponseEntity<>(filledInTestService.finishTest(id), HttpStatus.OK);
    }
}
