package com.example.IIS.service;

import com.example.IIS.dto.WorkshopQDto;
import com.example.IIS.dto.WorkshopTestDto;

import java.util.List;

public interface TestQService {
    WorkshopQDto createQuestion(WorkshopQDto workshopQDto);
    WorkshopQDto getQuestion(long id);
    List<WorkshopQDto> getAll();
    List<WorkshopQDto> getAllQuestionsByTestId(long id);
}
