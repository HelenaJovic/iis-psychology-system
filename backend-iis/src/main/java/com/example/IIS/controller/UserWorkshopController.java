package com.example.IIS.controller;

import com.example.IIS.dto.UserWorkshopDto;
import com.example.IIS.service.UserWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userWorkshops")
public class UserWorkshopController {
    @Autowired
     UserWorkshopService userWorkshopService;

    @PostMapping("/add")
    public ResponseEntity<String> addUserToWorkshop(
            @RequestParam("workshopId") long workshopId,
            @RequestParam("userId") long userId
    ) {
        try {
            userWorkshopService.addUserToWorkshop(workshopId, userId);
            return ResponseEntity.ok("User successfully added to workshop.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add user to workshop.");
        }
    }

    @PutMapping("/cancel/{workshopId}")
    public ResponseEntity<?> cancelWorkshop(@PathVariable("workshopId") long workshopId) {
        try {
            UserWorkshopDto cancelledWorkshop = userWorkshopService.cancelWorkshop(workshopId);
            return ResponseEntity.ok(cancelledWorkshop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
