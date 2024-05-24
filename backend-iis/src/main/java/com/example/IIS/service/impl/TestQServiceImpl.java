package com.example.IIS.service.impl;

import com.example.IIS.domain.UserWorkshop;
import com.example.IIS.domain.WorkshopA;
import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.dto.*;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.TestQService;
import com.example.IIS.service.WorkshopTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestQServiceImpl implements TestQService {
    @Autowired
    private WorkshopTestQRepo workshopTestQRepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WorkshopTestService workshopTestService;

    private WorkshopQDto mapToDTO(WorkshopQ workshopQ){
        WorkshopQDto workshopQDto = mapper.map(workshopQ, WorkshopQDto.class);
        return workshopQDto;
    }

    // convert DTO to entity
    private WorkshopQ mapToEntity(WorkshopQDto workshopQDto){
        WorkshopQ workshopQ = mapper.map(workshopQDto, WorkshopQ.class);
        return workshopQ;
    }

    private WorkshopTest mapTestToEntity(WorkshopTestDto workshopTestDto){
        WorkshopTest workshopTest = mapper.map(workshopTestDto, WorkshopTest.class);
        return workshopTest;
    }



    @Override
    public WorkshopQDto createQuestion(WorkshopQDto workshopQDto) {
        WorkshopQ newWorkshopQ= mapToEntity(workshopQDto);
        WorkshopTestDto testDto=workshopTestService.getAll().getLast();
        WorkshopTest test=mapTestToEntity(testDto);
        newWorkshopQ.setWorkshopTest(test);
        workshopTestQRepo.save(newWorkshopQ);
        WorkshopQDto WorkshopResponse = mapToDTO(newWorkshopQ);
        return WorkshopResponse;     }

    @Override
    public WorkshopQDto getQuestion(long id) {
        WorkshopQ question=workshopTestQRepo.findById(id).get();
        WorkshopQDto dto=mapToDTO(question);
        return dto;
    }

    @Override
    public List<WorkshopQDto> getAll() {
        List<WorkshopQ> workshopsQ = workshopTestQRepo.findAll();
        List<WorkshopQDto> questionsDtos = new ArrayList<>();

        if (!workshopsQ.isEmpty()) {
            questionsDtos = workshopsQ.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        return questionsDtos;
    }

    @Override
    public List<WorkshopQDto> getAllQuestionsByTestId(long id) {
        List<WorkshopQDto> questions=getAll();

        List<WorkshopQDto> newQuestions=new ArrayList<>();

        for(WorkshopQDto workshopQDto: questions)
        {
            if (workshopQDto.getWorkshopTestId()==id)
            {
                newQuestions.add(workshopQDto);
            }
        }
        return  newQuestions;
    }

}
