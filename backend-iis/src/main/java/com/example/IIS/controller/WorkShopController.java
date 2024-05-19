package com.example.IIS.controller;

import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.PsychologistDto;
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



//    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping("/create")
    public ResponseEntity<WorkShopDto> createWorkshop(@Valid @RequestBody WorkShopDto workShopDto){
        return new ResponseEntity<>(workshopService.createWorkshop(workShopDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<WorkShopDto> getAllWorkshops() {
        return workshopService.getAll();
    }

    @GetMapping("psychologist/{id}")
    public PsychologistDto getPsychologist(@PathVariable("id") long id) {
        return workshopService.getPsycho(id);
    }
    @GetMapping("/one/{id}")
    public WorkShopDto getWorkshop(@PathVariable("id") long id) {
        return workshopService.getWorkshopById(id);
    }
    @GetMapping("/workshops/{psychologistId}")
    public List<WorkShopDto> getAllWorkshopsByPsychologistId(@PathVariable long psychologistId) {
        return workshopService.getAllWorkshopsByPsychologistId(psychologistId);
    }

    @GetMapping("/{userId}/past-workshops")
    public ResponseEntity<List<WorkShopDto>> getPastWorkshopsByUser(@PathVariable("userId") long userId) {
        List<WorkShopDto> pastWorkshops = workshopService.pastWorkshopsByUser(userId);
        if (pastWorkshops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pastWorkshops);
    }

    @GetMapping("/{userId}/future-workshops")
    public ResponseEntity<List<WorkShopDto>> getFutureWorkshopsByUser(@PathVariable("userId") long userId) {
        List<WorkShopDto> futureWorkshops = workshopService.futureWorkshopsByUser(userId);
        if (futureWorkshops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(futureWorkshops);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkShopDto>> getWorkshopsByUser(@PathVariable("userId") long userId) {
        List<WorkShopDto> workshops = workshopService.workshopsByUser(userId);
        if (workshops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workshops);
    }

    @PutMapping("/{workshopId}")
    public ResponseEntity<WorkShopDto> updateWorkshop(@RequestBody WorkShopDto workshopDto, @PathVariable("workshopId") long workshopId) {
        try {
            WorkShopDto updatedWorkshop = workshopService.manageWorkshop(workshopDto, workshopId);
            return ResponseEntity.ok(updatedWorkshop);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Consider more specific error handling
        }
    }
}



