package com.example.IIS.service;

import com.example.IIS.dto.WorkshopADto;
import com.example.IIS.dto.WorkshopQDto;

import java.util.List;

public interface TestAService {
    WorkshopADto createAnswer(WorkshopADto workshopADto);
    List<WorkshopADto> getAllAnswersByTestId(long id);

}
