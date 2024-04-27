package com.example.IIS.controller;


import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.service.CommentService;
import com.example.IIS.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registeredUser")
public class RegisteredUserController {

    @Autowired
    RegisteredUserService registeredUserService;


    @GetMapping("/{workshopId}/users")
    public List<RegisteredUserDto> getUsersByWorkshopId(@PathVariable long workshopId) {
        return registeredUserService.getUsersByWorkshopId(workshopId);
    }
}
