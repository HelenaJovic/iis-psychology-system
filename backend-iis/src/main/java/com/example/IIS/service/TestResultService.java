package com.example.IIS.service;

import com.example.IIS.dto.TestResultDto;
import com.example.IIS.dto.TestResultsDTO;
import com.example.IIS.dto.WorkshopADto;

import java.util.List;

public interface TestResultService {
    public TestResultDto evaluateTest(List<WorkshopADto> answers, long testId, long userId) ;

    public TestResultDto getTestResultByUserId(long userId);

    public List<TestResultDto> testsByUser(long userId);

    public List<TestResultDto> getAllResultsByWorkshop(long workshopId);
}