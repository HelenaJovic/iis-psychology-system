package com.example.IIS.service;

import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface WorkshopService {
    WorkShopDto createWorkshop(WorkShopDto workShopDto);

    List<WorkShopDto> getAllWorkshopsByPsychologistId(long id);
    List<WorkShopDto> getAll();

    PsychologistDto getPsycho(long id);

    WorkShopDto getWorkshopById(long id);

    List<WorkShopDto> workshopsByUser(long id);

    List<WorkShopDto> pastWorkshopsByUser(long id);

    List<WorkShopDto> futureWorkshopsByUser(long id);

    WorkShopDto manageWorkshop(WorkShopDto workShopDto,long id);



}
