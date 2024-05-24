package com.example.IIS.service.impl;

import com.example.IIS.domain.WorkshopA;
import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopADto;
import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.dto.WorkshopTestDto;
import com.example.IIS.repository.WorkshopTestARepo;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.TestAService;
import com.example.IIS.service.TestQService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestAServiceImpl implements TestAService {
    @Autowired
    private WorkshopTestARepo workshopTestARepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TestQService testQService;

    private WorkshopADto mapToDTO(WorkshopA workshopA){
        WorkshopADto workshopADto = mapper.map(workshopA, WorkshopADto.class);
        return workshopADto;
    }

    // convert DTO to entity
    private WorkshopA mapToEntity(WorkshopADto workshopADto){
        WorkshopA workshopA = mapper.map(workshopADto, WorkshopA.class);
        return workshopA;
    }

    private WorkshopQ mapQuestionToEntity(WorkshopQDto workshopQDto){
        WorkshopQ workshopQ = mapper.map(workshopQDto, WorkshopQ.class);
        return workshopQ;
    }

//    @Override
//    public WorkshopADto createAnswer(WorkshopADto workshopADto) {
//        WorkshopQDto workshopQDto=testQService.getAll().getLast();
//        WorkshopQ workshopQ=mapQuestionToEntity(workshopQDto);
//        workshopADto.setQuestionId(workshopQ.getId());
//        WorkshopA newWorkshopA= mapToEntity(workshopADto);
//        WorkshopQDto question=testQService.getQuestion(workshopQ.getId());
//        newWorkshopA.setWorkshopQ(mapQuestionToEntity(question));
//        workshopTestARepo.save(newWorkshopA);
//        WorkshopADto WorkshopResponse = mapToDTO(newWorkshopA);
//        return WorkshopResponse;    }


    @Override
    public WorkshopADto createAnswer(WorkshopADto workshopADto) {
        WorkshopA newWorkshopA= mapToEntity(workshopADto);
        WorkshopQDto workshopQDto=testQService.getAll().getLast();
        WorkshopQ workshopQ=mapQuestionToEntity(workshopQDto);
        newWorkshopA.setWorkshopQ(workshopQ);
        workshopTestARepo.save(newWorkshopA);
        WorkshopADto WorkshopResponse = mapToDTO(newWorkshopA);
        return WorkshopResponse;    }





    @Override
    public List<WorkshopADto> getAllAnswersByTestId(long id) {
        List<WorkshopA> answers=workshopTestARepo.findAll();

        List<WorkshopADto> newAnswers=new ArrayList<>();
        List<WorkshopADto> answersDtos=new ArrayList<>();


        if (!answers.isEmpty()) {
            answersDtos = answers.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        for(WorkshopADto workshopQDto: answersDtos)
        {
//            if (workshopQDto.getWorkshopQ().getId()==id)
//            {
//                newAnswers.add(workshopQDto);
//            }
        }
        return  newAnswers;
    }
}
