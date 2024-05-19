package com.example.IIS.controller;

import com.example.IIS.service.WorkshopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workshop_tests")
public class WorkshopTestController {

    @Autowired
    private WorkshopTestService workshopTestService;

}
