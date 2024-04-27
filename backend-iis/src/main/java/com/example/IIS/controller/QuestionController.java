package com.example.IIS.controller;

import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@Valid @RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<>(questionService.createQuestion(questionDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAll(){
        return ResponseEntity.ok(questionService.getAll());
    }

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping("/invisible/{id}")
    public ResponseEntity<QuestionDTO> changeVisibility(@PathVariable Long id){
        return new ResponseEntity<>(questionService.changeVisibility(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PutMapping("/update/{id}")
    public ResponseEntity<QuestionDTO> update(@RequestBody QuestionDTO questionDTO, @PathVariable Long id){
        return new ResponseEntity<>(questionService.update(questionDTO,id), HttpStatus.OK);
    }

}
