package com.example.IIS.service.impl;

import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.dto.WorkshopTestDto;
import com.example.IIS.dto.WorkshopTestDto;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.repository.WorkshopTestARepo;
import com.example.IIS.repository.WorkshopTestRepo;
import com.example.IIS.service.WorkshopTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopTestServiceImpl implements WorkshopTestService {
    @Autowired
    private WorkshopTestRepo workshopTestRepo;


    @Autowired
    private ModelMapper mapper;

    private WorkshopTestDto mapToDTO(WorkshopTest workshopTest){
        WorkshopTestDto workshopTestDto = mapper.map(workshopTest, WorkshopTestDto.class);
        return workshopTestDto;
    }

    // convert DTO to entity
    private WorkshopTest mapToEntity(WorkshopTestDto workshopTestDto){
        WorkshopTest workshopTest = mapper.map(workshopTestDto, WorkshopTest.class);
        return workshopTest;
    }
}
