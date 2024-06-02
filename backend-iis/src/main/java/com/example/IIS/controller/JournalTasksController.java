package com.example.IIS.controller;

import com.example.IIS.dto.JournalingTasksDto;
import com.example.IIS.service.JournalTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks-journals")
public class JournalTasksController {

    @Autowired
    JournalTasksService journalTasksService;

    @GetMapping
    public ResponseEntity<JournalingTasksDto> getJournalTasksByiD(){
        return ResponseEntity.ok(journalTasksService.getLatest());
    }
}
