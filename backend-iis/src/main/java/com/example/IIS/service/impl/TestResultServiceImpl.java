package com.example.IIS.service.impl;

import com.example.IIS.domain.WorkshopTestResult;
import com.example.IIS.dto.TestResultDto;
import com.example.IIS.repository.WokrshopTestResultRepo;
import com.example.IIS.repository.WorkshopTestQRepo;
import com.example.IIS.service.TestResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestResultServiceImpl implements TestResultService {
    @Autowired
    private WokrshopTestResultRepo workshopTestResultRepo;


    @Autowired
    private ModelMapper mapper;

    private TestResultDto mapToDTO(WorkshopTestResult workshopTestResult){
        TestResultDto testResultDto = mapper.map(workshopTestResult, TestResultDto.class);
        return testResultDto;
    }

    // convert DTO to entity
    private WorkshopTestResult mapToEntity(TestResultDto testResultDto){
        WorkshopTestResult workshopTestResult = mapper.map(testResultDto, WorkshopTestResult.class);
        return workshopTestResult;
    }
}
