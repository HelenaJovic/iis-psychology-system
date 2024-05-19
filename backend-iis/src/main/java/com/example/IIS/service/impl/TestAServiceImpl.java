package com.example.IIS.service.impl;

import com.example.IIS.domain.WorkshopA;
import com.example.IIS.dto.WorkshopADto;
import com.example.IIS.repository.WorkshopTestARepo;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.TestAService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAServiceImpl implements TestAService {
    @Autowired
    private WorkshopTestARepo workshopTestARepo;


    @Autowired
    private ModelMapper mapper;

    private WorkshopADto mapToDTO(WorkshopA workshopA){
        WorkshopADto workshopADto = mapper.map(workshopA, WorkshopADto.class);
        return workshopADto;
    }

    // convert DTO to entity
    private WorkshopA mapToEntity(WorkshopADto workshopADto){
        WorkshopA workshopA = mapper.map(workshopADto, WorkshopA.class);
        return workshopA;
    }
}
