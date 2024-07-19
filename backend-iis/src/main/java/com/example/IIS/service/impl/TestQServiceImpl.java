package com.example.IIS.service.impl;

import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.TestQService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestQServiceImpl implements TestQService {
    @Autowired
    private WorkshopTestQRepo workshopTestQRepo;


    @Autowired
    private ModelMapper mapper;

    private WorkshopQDto mapToDTO(WorkshopQ workshopQ){
        WorkshopQDto workshopQDto = mapper.map(workshopQ, WorkshopQDto.class);
        return workshopQDto;
    }

    // convert DTO to entity
    private WorkshopQ mapToEntity(WorkshopQDto workshopQDto){
        WorkshopQ workshopQ = mapper.map(workshopQDto, WorkshopQ.class);
        return workshopQ;
    }
}
