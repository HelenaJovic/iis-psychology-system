package com.example.IIS.controller;

import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.service.TestQService;
import com.example.IIS.service.WorkshopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test_questions")
public class WorkshopQController {
    @Autowired
    private TestQService testQService;

    @PostMapping("/create")
    public ResponseEntity<WorkshopQDto> createQuestion(@RequestBody WorkshopQDto workshopQDto) {
        WorkshopQDto createdWorkshopQDto = testQService.createQuestion(workshopQDto);
        return ResponseEntity.ok(createdWorkshopQDto);
    }

    @GetMapping("/getQuestions/{id}")
    public List<WorkshopQDto> getAllQuestionsByTest(@PathVariable long id) {
        return testQService.getAllQuestionsByTestId(id);
    }



}
