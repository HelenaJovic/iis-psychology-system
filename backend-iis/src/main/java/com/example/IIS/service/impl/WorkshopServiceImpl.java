package com.example.IIS.service.impl;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.*;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
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

    @Autowired
    private PsychologistService psychologistService;

    @Autowired
    private UserWorkshopService userWorkshopService;

    @Override
    public WorkShopDto createWorkshop(WorkShopDto workShopDto) {

        Workshop workshop = mapToEntity(workShopDto);
        Workshop newWorkshop = workshopRepo.save(workshop);

        if(workShopDto.getHallId()!=null) {
            HallDto hall = hallService.findById(workShopDto.getHallId());
            hall.setIsFree(false);
            hallService.saveHall(hall);
        }

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

    @Override
    public List<WorkShopDto> getAll() {
        List<Workshop> workshops=workshopRepo.findAll();
        WorkShopDto workShopDto=new WorkShopDto();
        List<WorkShopDto> workShopDtos =new ArrayList<WorkShopDto>();

        for (Workshop workshop : workshops) {
            workShopDto=mapToDTO(workshop);
            workShopDtos.add(workShopDto);

        }
        return workShopDtos;
    }
    private PsychologistDto mapToDTO(Psychologist psychologist){
        PsychologistDto psychologistDto = mapper.map(psychologist, PsychologistDto.class);
        return psychologistDto;
    }

    @Override
    public PsychologistDto getPsycho(long id) {
        Workshop workshop=workshopRepo.findById(id).get();
        Psychologist psychologist=workshop.getPsychologist();
        return mapToDTO(psychologist);
    }

    @Override
    public WorkShopDto getWorkshopById(long id) {
        return mapToDTO(workshopRepo.findById(id).get());
    }

    @Override
    public List<WorkShopDto> workshopsByUser(long id) {
        List<UserWorkshopDto> filteredUsersOnWorkshop = userWorkshopService.getAll()
                .stream()
                .filter(u -> u.getUserId().equals(id) && !u.isCanceled())
                .collect(Collectors.toList());


        Map<Long, WorkShopDto> workshopMap = getAll().stream()
                .collect(Collectors.toMap(WorkShopDto::getId, Function.identity()));

        List<WorkShopDto> workshopsByUser = filteredUsersOnWorkshop.stream()
                .map(u -> workshopMap.get(u.getWorkshopId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return workshopsByUser;
    }

    @Override
    public List<WorkShopDto> pastWorkshopsByUser(long id) {
        List<WorkShopDto> workShopDtosByUser = workshopsByUser(id);
        List<WorkShopDto> pastWorkshops = new ArrayList<>();

        LocalDate today = LocalDate.now();

        for (WorkShopDto workshop : workShopDtosByUser) {
            LocalDate workshopDate = workshop.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (workshopDate.isBefore(today)) {
                pastWorkshops.add(workshop);
            }
        }

        return pastWorkshops;
    }

    @Override
    public List<WorkShopDto> futureWorkshopsByUser(long id) {
        List<WorkShopDto> workShopDtosByUser = workshopsByUser(id);
        List<WorkShopDto> futureWorkshops = new ArrayList<>();

        LocalDate today = LocalDate.now();

        for (WorkShopDto workshop : workShopDtosByUser) {
            LocalDate workshopDate = workshop.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (workshopDate.isAfter(today)) {
                futureWorkshops.add(workshop);
            }
        }

        return futureWorkshops;
    }

    @Override
    public WorkShopDto manageWorkshop(WorkShopDto workShopDto,long id) {
        Workshop workshop=workshopRepo.findById(id).get();
        workshop.setDate(workShopDto.getDate());
        workshop.setDescription(workShopDto.getDescription());
        workshop.setEndTime(workShopDto.getEndTime());
        workshop.setName(workShopDto.getName());
        workshop.setImages(workShopDto.getImages());
        workshop.setPrice(workShopDto.getPrice());

        return mapToDTO(workshopRepo.save(workshop));
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

