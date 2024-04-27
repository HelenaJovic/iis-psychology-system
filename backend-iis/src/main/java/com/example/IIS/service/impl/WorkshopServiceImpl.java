package com.example.IIS.service.impl;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.UserWorkshopDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.HallService;
import com.example.IIS.service.RegisteredUserService;
import com.example.IIS.service.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkshopServiceImpl implements WorkshopService {
    @Autowired
    private WorkshopRepo workshopRepo;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HallService hallService;

    @Autowired
    private RegisteredUserService registeredUserService;


    @Override
    public WorkShopDto createWorkshop(WorkShopDto workShopDto) {

        Workshop workshop = mapToEntity(workShopDto);
        Workshop newWorkshop = workshopRepo.save(workshop);

        WorkShopDto WorkshopResponse = mapToDTO(newWorkshop);
        return WorkshopResponse;


    }

    @Override
    public List<WorkShopDto> getAllWorkshopsByPsychologistId(long id) {

        List<Workshop> workshops = workshopRepo.getAllWorkshopsByPsychologistId(id);
        List<WorkShopDto> workShopDtos = new ArrayList<>();

        if (!workshops.isEmpty()) {
            workShopDtos = workshops.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        return workShopDtos;
    }

// convert DTO to entity
private RegisteredUser mapToEntity(RegisteredUserDto registeredUserDto){
    RegisteredUser registeredUser = mapper.map(registeredUserDto, RegisteredUser.class);
    return registeredUser;
}

//    @Transactional
//    @Override
//    public WorkShopDto userAdded(WorkShopDto workShopDto, long id, long user_id) {
//        Workshop workshop = workshopRepo.findById(id).get();
//
//        RegisteredUser registeredUser = mapToEntity(registeredUserService.getById(user_id));
//
//        workshop.getUsers().add(registeredUser);
//        registeredUser.getWorkshops().add(workshop);
//
//        workshop = workshopRepo.saveAndFlush(workshop);
//        registeredUserService
//
//        return mapToDTO(workshop);
//    }




private RegisteredUserDto mapToDTO(RegisteredUser registeredUser){
    RegisteredUserDto registeredUserDto = mapper.map(registeredUser, RegisteredUserDto.class);
    return registeredUserDto;
}

//    @Override
//    public List<RegisteredUserDto> getAllUsersByWorkshop(long id) {
//        Workshop workshop=workshopRepo.findById(id).get();
//        List<RegisteredUser> allUsers=workshop.getUsers();
//
//        RegisteredUserDto registeredUserDto=new RegisteredUserDto();
//        for(RegisteredUser registeredUser:allUsers)
//        {
//            registeredUserDto=mapToDTO(registeredUser);
//            allUsersDtos.add(registeredUserDto);
//        }
//
//        return  allUsersDtos;
//
//    }


private WorkShopDto mapToDTO(Workshop workshop){
    WorkShopDto workShopDto = mapper.map(workshop, WorkShopDto.class);
    return workShopDto;
}

// convert DTO to entity
private Workshop mapToEntity(WorkShopDto workshopDto){
    Workshop workshop = mapper.map(workshopDto, Workshop.class);
    return workshop;
}}

