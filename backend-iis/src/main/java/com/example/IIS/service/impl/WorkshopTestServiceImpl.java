package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.dto.*;
import com.example.IIS.dto.WorkshopTestDto;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.repository.WorkshopTestARepo;
import com.example.IIS.repository.WorkshopTestRepo;
import com.example.IIS.service.TestAService;
import com.example.IIS.service.TestQService;
import com.example.IIS.service.WorkshopService;
import com.example.IIS.service.WorkshopTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkshopTestServiceImpl implements WorkshopTestService {
    @Autowired
    private WorkshopTestRepo workshopTestRepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    WorkshopService workshopService;


    private WorkshopTestDto mapToDTO(WorkshopTest workshopTest){
        WorkshopTestDto workshopTestDto = mapper.map(workshopTest, WorkshopTestDto.class);
        return workshopTestDto;
    }

    // convert DTO to entity
    private WorkshopTest mapToEntity(WorkshopTestDto workshopTestDto){
        WorkshopTest workshopTest = mapper.map(workshopTestDto, WorkshopTest.class);
        return workshopTest;
    }


    private WorkshopADto mapAnswerToDTO(WorkshopA workshopA){
        WorkshopADto workshopADto = mapper.map(workshopA, WorkshopADto.class);
        return workshopADto;
    }

    // convert DTO to entity
    private WorkshopA mapAnswerToEntity(WorkshopADto workshopADto){
        WorkshopA workshopA = mapper.map(workshopADto, WorkshopA.class);
        return workshopA;
    }

    private WorkshopQDto mapQuestionToDTO(WorkshopQ workshopQ){
        WorkshopQDto workshopQDto = mapper.map(workshopQ, WorkshopQDto.class);
        return workshopQDto;
    }

    // convert DTO to entity
    private WorkshopQ mapQuestionToEntity(WorkshopQDto workshopQDto){
        WorkshopQ workshopQ = mapper.map(workshopQDto, WorkshopQ.class);
        return workshopQ;
    }

    private Workshop mapWorkshopToEntity(WorkShopDto workshopDto){
        Workshop workshop = mapper.map(workshopDto, Workshop.class);
        return workshop;
    }
    @Override
    public WorkshopTestDto createTest(WorkshopTestDto testDto) {
        WorkshopTest workshop = mapToEntity(testDto);
        workshop.setWorkshop(mapWorkshopToEntity(workshopService.getAll().getLast()));

        WorkshopTest newWorkshop = workshopTestRepo.save(workshop);

        WorkshopTestDto WorkshopResponse = mapToDTO(newWorkshop);
        return WorkshopResponse;    }

    @Override
    public WorkshopTestDto getTest(long id) {
        WorkshopTest workshopTest= workshopTestRepo.findById(id).get();
        WorkshopTestDto workshopTestDto=mapToDTO(workshopTest);
        return workshopTestDto;
    }

    @Override
    public List<WorkshopTestDto> getAll() {
        List<WorkshopTest> workshopsTests = workshopTestRepo.findAll();
        List<WorkshopTestDto> testDtos = new ArrayList<>();

        if (!workshopsTests.isEmpty()) {
            testDtos = workshopsTests.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        return testDtos;
    }

    @Override
    public WorkshopTestDto getWorkshopTestByWorkshopId(long workshopId) {
        List<WorkshopTestDto> workshopTestDtos=getAll();
        WorkshopTestDto newWorkshopTest =new WorkshopTestDto();
        for(WorkshopTestDto workshopTestDto:workshopTestDtos)
        {
            if( workshopTestDto.getWorkshopId().equals(workshopId))
            {
                newWorkshopTest=workshopTestDto;            }
        }

        return newWorkshopTest;
    }
}

