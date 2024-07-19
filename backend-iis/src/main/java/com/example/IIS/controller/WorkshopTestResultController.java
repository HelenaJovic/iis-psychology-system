package com.example.IIS.controller;

import com.example.IIS.dto.TestResultDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopADto;
import com.example.IIS.service.TestResultService;
import com.example.IIS.service.WorkshopTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test_results")
public class WorkshopTestResultController {

    @Autowired
    private TestResultService testResultService;

    @PostMapping("/evaluate/{testId}/{userId}")
    public ResponseEntity<TestResultDto> evaluateTest(
            @PathVariable long testId,
            @PathVariable long userId,
            @RequestBody List<WorkshopADto> answers) {

        TestResultDto testResult = testResultService.evaluateTest(answers, testId, userId);
        return ResponseEntity.ok(testResult);
    }

    @GetMapping("/allResultByUser/{userId}")
    public ResponseEntity<List<TestResultDto>> getTestsByUser(@PathVariable("userId") long userId) {
        List<TestResultDto> results = testResultService.testsByUser(userId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/resultsByWorkshopId/{workshopId}")
    public ResponseEntity<List<TestResultDto>> getResultsByWorkshop(@PathVariable("workshopId") long workshopId) {
        List<TestResultDto> results = testResultService.getAllResultsByWorkshop(workshopId);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<TestResultDto> getTestResultByUserId(@PathVariable long userId) {
        try {
            TestResultDto testResult = testResultService.getTestResultByUserId(userId);
            if (testResult != null) {
                return ResponseEntity.ok(testResult);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
