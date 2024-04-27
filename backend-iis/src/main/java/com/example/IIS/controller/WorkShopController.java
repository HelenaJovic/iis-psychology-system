package com.example.IIS.controller;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.PostService;
import com.example.IIS.service.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
public class WorkShopController {
    @Autowired
    private WorkshopService workshopService;



    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<WorkShopDto> createWorkshop(@Valid @RequestBody WorkShopDto workShopDto){
        return new ResponseEntity<>(workshopService.createWorkshop(workShopDto), HttpStatus.CREATED);
    }

    @GetMapping("/workshops/{psychologistId}")
    public List<WorkShopDto> getAllWorkshopsByPsychologistId(@PathVariable long psychologistId) {
        return workshopService.getAllWorkshopsByPsychologistId(psychologistId);
    }

//    @PutMapping("/workshops/{id}/users/{userId}")
//    public WorkShopDto userAdded(@RequestBody WorkShopDto workShopDto, @PathVariable long id, @PathVariable long userId) {
//        return workshopService.userAdded(workShopDto, id, userId);
//    }
}



