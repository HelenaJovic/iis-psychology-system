package com.example.IIS.controller;

import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.service.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PreAuthorize("hasAnyRole('ROLE_REGISTERED_USER', 'ROLE_STUDENT')")
    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@Valid @RequestBody AnswerDTO answerDTO){
        return new ResponseEntity<>(answerService.createAnswer(answerDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAll(){
        return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }
}
