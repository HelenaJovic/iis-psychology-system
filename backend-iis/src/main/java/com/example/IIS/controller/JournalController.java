package com.example.IIS.controller;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.WorkshopTestResultJournalJNDto;
import com.example.IIS.service.WorkshopJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    @Autowired
    WorkshopJournalService workshopJournalService;

    @GetMapping(value="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkshopTestResultJournalJNDto> getJournalByiD(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(workshopJournalService.getById(id));
    }
}
