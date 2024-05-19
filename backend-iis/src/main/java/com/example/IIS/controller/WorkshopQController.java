package com.example.IIS.controller;

import com.example.IIS.service.TestQService;
import com.example.IIS.service.WorkshopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test_questions")
public class WorkshopQController {
    @Autowired
    private TestQService testQService;

}
