package com.example.IIS.controller;

import com.example.IIS.service.TestAService;
import com.example.IIS.service.TestQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test_answers")
public class WorkshopAController {
    @Autowired
    private TestAService testAService;
}
