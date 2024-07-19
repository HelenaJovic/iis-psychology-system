package com.example.IIS.service;

import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopTestDto;

import java.util.List;

public interface WorkshopTestService {
    WorkshopTestDto createTest(WorkshopTestDto workshopTestDto);

    WorkshopTestDto getTest(long id);

    List<WorkshopTestDto> getAll();

    WorkshopTestDto getWorkshopTestByWorkshopId(long workshopId);

}
