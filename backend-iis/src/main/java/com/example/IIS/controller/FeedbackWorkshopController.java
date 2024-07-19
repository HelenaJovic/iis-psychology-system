package com.example.IIS.controller;

import com.example.IIS.dto.FeedbackWorkshopDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopEvaluationDto;
import com.example.IIS.service.FeedbackWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/feedbacksWorkshop")
public class FeedbackWorkshopController {
    @Autowired
    FeedbackWorkshopService feedbackWorkshopService;

    @PostMapping
    public ResponseEntity<FeedbackWorkshopDto> createTest( @RequestBody FeedbackWorkshopDto feedbackWorkshopDto){
        return new ResponseEntity<>(feedbackWorkshopService.createFeedback(feedbackWorkshopDto), HttpStatus.CREATED);
    }

    @GetMapping("/evaluation/{workshopId}")
    public ResponseEntity<WorkshopEvaluationDto> getWorkshopEvaluation(@PathVariable long workshopId) {
        try {
            WorkshopEvaluationDto evaluation = feedbackWorkshopService.getEvaluationByWorkshop(workshopId);
            return ResponseEntity.ok(evaluation);
        } catch (Exception e) {
            // You can handle different types of exceptions here and return different responses accordingly
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{workshopId}")
    public ResponseEntity<List<FeedbackWorkshopDto>> getWorkshopsByUser(@PathVariable("workshopId") long workshopId) {
        List<FeedbackWorkshopDto> workshops = feedbackWorkshopService.getAllByWorkshopId(workshopId);
        if (workshops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workshops);
    }
}
