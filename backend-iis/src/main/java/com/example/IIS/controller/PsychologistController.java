package com.example.IIS.controller;

import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/psychologist")
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @GetMapping
    public ResponseEntity<List<PsychologistDto>> getAll(){
        return new ResponseEntity<>(psychologistService.getAll(), HttpStatus.OK);
    }
}
