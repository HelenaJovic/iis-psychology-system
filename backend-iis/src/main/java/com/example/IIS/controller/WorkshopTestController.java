package com.example.IIS.controller;

import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.TestCreationRequest;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopTestDto;
import com.example.IIS.service.WorkshopTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workshop_tests")
public class WorkshopTestController {

    @Autowired
    private WorkshopTestService workshopTestService;

    @GetMapping("/{id}")
    public WorkshopTestDto getTest(@PathVariable("id") long id) {
        return workshopTestService.getWorkshopTestByWorkshopId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<WorkshopTestDto> createWorkshop(@Valid @RequestBody WorkshopTestDto workShopDto){
        return new ResponseEntity<>(workshopTestService.createTest(workShopDto), HttpStatus.CREATED);
    }

}
