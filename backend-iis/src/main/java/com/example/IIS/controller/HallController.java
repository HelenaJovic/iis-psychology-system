package com.example.IIS.controller;


import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    @Autowired
    HallService hallService;

    @GetMapping
    public List<HallDto> getAllHalls() {
        return hallService.getAllHalls();
    }
}
