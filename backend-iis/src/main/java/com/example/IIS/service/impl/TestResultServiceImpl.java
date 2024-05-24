package com.example.IIS.service.impl;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.domain.WorkshopTestResult;
import com.example.IIS.dto.*;
import com.example.IIS.repository.WokrshopTestResultRepo;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.RegisteredUserService;
import com.example.IIS.service.TestQService;
import com.example.IIS.service.TestResultService;
import com.example.IIS.service.WorkshopTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestResultServiceImpl implements TestResultService {
    @Autowired
    private WokrshopTestResultRepo workshopTestResultRepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RegisteredUserService registeredUserService;
    @Autowired
    private WorkshopTestService workshopTestService;

    @Autowired
    private TestQService testQService;

    private TestResultDto mapToDTO(WorkshopTestResult workshopTestResult) {
        TestResultDto testResultDto = mapper.map(workshopTestResult, TestResultDto.class);
        return testResultDto;
    }

    // convert DTO to entity
    private WorkshopTestResult mapToEntity(TestResultDto testResultDto) {
        WorkshopTestResult workshopTestResult = mapper.map(testResultDto, WorkshopTestResult.class);
        return workshopTestResult;
    }

    private WorkshopTestDto mapTestToDTO(WorkshopTest workshopTest) {
        WorkshopTestDto workshopTestDto = mapper.map(workshopTest, WorkshopTestDto.class);
        return workshopTestDto;
    }

    public TestResultDto evaluateTest(List<WorkshopADto> answers, long testId, long userId) {
        double totalPoints = 0;
        double achievedPoints = 0;

        for (WorkshopADto answer : answers) {
            WorkshopQDto question = testQService.getQuestion(answer.getWorkshopQId());
            totalPoints += question.getPointsPerQuestion();
            if (answer.isTrue()) {
                achievedPoints += question.getPointsPerQuestion();
            }
        }

        double percentageScore = (achievedPoints / totalPoints) * 100;

        TestResultDto testResultDTO = new TestResultDto();

        // Setting properties for TestResultDto
        LocalDate today = LocalDate.now();
        Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        testResultDTO.setWorkshopTest(workshopTestService.getTest(testId));
        testResultDTO.setPassed(percentageScore >= 85);
        testResultDTO.setAchievedPoints((long) achievedPoints);
        testResultDTO.setRegisteredUser(registeredUserService.getById(userId));
        testResultDTO.setDateFilled(date);

        // Save the result
        workshopTestResultRepo.save(mapToEntity(testResultDTO));

        // Return the TestResultDto object
        return testResultDTO;
    }

    @Override
    public TestResultDto getTestResultByUserId(long userId) {
        List<WorkshopTestResult > results= workshopTestResultRepo.findAll();
        List<TestResultDto> resultDtos = new ArrayList<>();
        List<TestResultDto> userResultDtos = new ArrayList<>();
        TestResultDto result=new TestResultDto();

        if (!results.isEmpty()) {
            resultDtos = results.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        for(TestResultDto resultDto: resultDtos)
        {
            if(resultDto.getRegisteredUser().getId()==userId)
            {
                userResultDtos.add(resultDto);
            }
        }
        result=userResultDtos.getLast();

        return  result;
    }

    @Override
    public List<TestResultDto> testsByUser(long userId) {
        List<WorkshopTestResult > results= workshopTestResultRepo.findAll();
        List<TestResultDto> resultDtos = new ArrayList<>();
        List<TestResultDto> userResultDtos = new ArrayList<>();
        TestResultDto result=new TestResultDto();

        if (!results.isEmpty()) {
            resultDtos = results.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        for(TestResultDto resultDto: resultDtos)
        {
            if(resultDto.getRegisteredUser().getId()==userId)
            {
                userResultDtos.add(resultDto);
            }
        }

        return  userResultDtos;
    }

    @Override
    public List<TestResultDto> getAllResultsByWorkshop(long workshopId) {
        List<WorkshopTestResult > results= workshopTestResultRepo.findAll();
        List<TestResultDto> resultDtos = new ArrayList<>();
        List<TestResultDto> userResultDtos = new ArrayList<>();
        TestResultDto result=new TestResultDto();

        if (!results.isEmpty()) {
            resultDtos = results.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        for(TestResultDto resultDto: resultDtos)
        {
            if(resultDto.getWorkshopTest().getWorkshopId()==workshopId)
            {
                userResultDtos.add(resultDto);
            }
        }

        return  userResultDtos;
    }
}


