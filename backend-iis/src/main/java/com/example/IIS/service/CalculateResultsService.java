package com.example.IIS.service;

import com.example.IIS.dto.TestResultsDTO;

public interface CalculateResultsService {

    TestResultsDTO calculate(long userId);
}
