package com.example.IIS.service.impl;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.UserWorkshop;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.UserWorkshopDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.UserWorkshopRepo;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.UserWorkshopService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserWorkshopImpl implements UserWorkshopService {

    @Autowired
    private UserWorkshopRepo workshopRepo;


    @Autowired
    private ModelMapper mapper;

    private UserWorkshopDto mapToDTO(UserWorkshop workshop){
        UserWorkshopDto workShopDto = mapper.map(workshop, UserWorkshopDto.class);
        return workShopDto;
    }

    // convert DTO to entity
    private UserWorkshop mapToEntity(UserWorkshopDto workshopDto){
        UserWorkshop workshop = mapper.map(workshopDto, UserWorkshop.class);
        return workshop;
    }

    @Override
    @Transactional
    public void addUserToWorkshop(long workshopId, long userId) {
        UserWorkshop userWorkshop = new UserWorkshop();
        userWorkshop.setWorkshopId(workshopId);
        userWorkshop.setUserId(userId);

        workshopRepo.save(userWorkshop);
    }

    @Override
    public List<UserWorkshopDto> getAll() {
        List<UserWorkshop> workshops = workshopRepo.findAll();
        List<UserWorkshopDto> userWorkshopDtos = new ArrayList<>();

        if (!workshops.isEmpty()) {
            userWorkshopDtos = workshops.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        return userWorkshopDtos;
    }



}
