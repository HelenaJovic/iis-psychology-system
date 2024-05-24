package com.example.IIS.controller;

import com.example.IIS.domain.WorkshopA;
import com.example.IIS.dto.WorkshopADto;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.service.TestAService;
import com.example.IIS.service.TestQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test_answers")
public class WorkshopAController {
    @Autowired
    private TestAService testAService;

    @PostMapping("/create")
    public ResponseEntity<WorkshopADto> createQuestion(@RequestBody WorkshopADto workshopADto) {
        WorkshopADto createdWorkshopQDto = testAService.createAnswer(workshopADto);
        return ResponseEntity.ok(createdWorkshopQDto);
    }

    @GetMapping("/getAnswers/{id}")
    public List<WorkshopADto> getAllAnswerssByQ(@PathVariable long id) {
        return testAService.getAllAnswersByTestId(id);
    }
}
