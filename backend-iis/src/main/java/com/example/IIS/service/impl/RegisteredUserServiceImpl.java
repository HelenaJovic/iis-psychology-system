package com.example.IIS.service.impl;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.dto.*;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.repository.RegisteredUserRepo;
import com.example.IIS.service.RegisteredUserService;
import com.example.IIS.service.UserWorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {

    @Autowired
    private RegisteredUserRepo registeredUserRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserWorkshopService userWorkshopService;



    private RegisteredUserDto mapToDTO(RegisteredUser registeredUser){
        RegisteredUserDto registeredUserDto = mapper.map(registeredUser, RegisteredUserDto.class);
        return registeredUserDto;
    }

    // convert DTO to entity
    private RegisteredUser mapToEntity(RegisteredUserDto registeredUserDto){
        RegisteredUser registeredUser = mapper.map(registeredUserDto, RegisteredUser.class);
        return registeredUser;
    }

    @Override
    public RegisteredUserDto createReg(RegisteredUserDto registerDTO) {
        RegisteredUser registeredUser=mapToEntity(registerDTO);
        RegisteredUser newRegisteredUser=registeredUserRepo.save(registeredUser);

        RegisteredUserDto registeredUserDto=mapToDTO(newRegisteredUser);
        return registeredUserDto;

    }

    @Override
    public List<RegisteredUserDto> getAllUsers() {
        List<RegisteredUser> users=registeredUserRepo.findAll();
        RegisteredUserDto registeredUserDto=new RegisteredUserDto();
        List<RegisteredUserDto> registeredUserDtos =new ArrayList<RegisteredUserDto>();

        for (RegisteredUser registeredUser : users) {
            registeredUserDto=mapToDTO(registeredUser);
            registeredUserDtos.add(registeredUserDto);

        }
        return registeredUserDtos;
    }

    @Override
    public RegisteredUserDto getById(long id) {
        RegisteredUser registeredUser= registeredUserRepo.findById(id).get();
        return mapToDTO(registeredUser);
    }

    @Override
    public List<RegisteredUserDto> getUsersByWorkshopId(long id) {
        List<RegisteredUserDto> users = new ArrayList<>();
        List<UserWorkshopDto> list = userWorkshopService.getAll();

        for (UserWorkshopDto workshop : list) {
            if (workshop.getWorkshopId().equals(id)) {
                RegisteredUserDto registeredUserDto = getById(workshop.getUserId());
                users.add(registeredUserDto);
            }
        }

        return users;
    }
}
