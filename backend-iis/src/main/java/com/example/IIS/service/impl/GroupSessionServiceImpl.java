package com.example.IIS.service.impl;

import com.example.IIS.domain.GroupSession;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Session;
import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.TimeSlotDTO;
import com.example.IIS.repository.GroupSessionRepo;
import com.example.IIS.repository.SessionRepo;
import com.example.IIS.service.GroupSessionService;
import com.example.IIS.service.PsychologistService;
import com.example.IIS.service.RegisteredUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupSessionServiceImpl implements GroupSessionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GroupSessionRepo groupSessionRepo;

    @Autowired
    private PsychologistService psychologistService;

    @Autowired
    private RegisteredUserService registeredUserService;


    private GroupSession mapToEntity(GroupSessionDTO groupSessionDTO){
        GroupSession groupSession = mapper.map(groupSessionDTO, GroupSession.class);
        return groupSession;
    }

    private GroupSessionDTO mapToDTO(GroupSession groupSession){
        GroupSessionDTO groupSessionDTO= mapper.map(groupSession, GroupSessionDTO.class);
        // Custom user id mapping
        List<Long> registeredUserIds = new ArrayList<>();
        for (var user:groupSession.getRegisteredUsers()) {
            registeredUserIds.add(user.getId());
        }
        groupSessionDTO.setRegisteredUserIds(registeredUserIds);

        return groupSessionDTO;
    }

    @Override
    public GroupSessionDTO create(GroupSessionDTO groupSessionDTO) {

        Psychologist psychologist = psychologistService.getById(groupSessionDTO.getPsychologistId());

        List<RegisteredUser> registeredUsers = registeredUserService.findAllById(groupSessionDTO.getRegisteredUserIds());
        GroupSession groupSession = mapToEntity(groupSessionDTO);
        groupSession.setRegisteredUsers(registeredUsers);
        groupSession.setPsychologist(psychologist);
        GroupSession savedGroupSession = groupSessionRepo.save(groupSession);
        return mapToDTO(savedGroupSession);
    }

    @Override
    public List<GroupSessionDTO> getAll() {
        List<GroupSession> groupSessions = groupSessionRepo.findAll();
        List<GroupSessionDTO> dtos = new ArrayList<>();

        for(GroupSession gs: groupSessions){
            dtos.add(mapToDTO(gs));
        }

        return dtos;
    }

    @Override
    public GroupSessionDTO reserveSession(GroupSessionDTO groupSessionDTO, Long registeredUserId) {
        GroupSession groupSession = groupSessionRepo.findById(groupSessionDTO.getId()).get();
        System.out.println("AAAAAAAAAAAAAAAAAAAA");
        System.out.println(groupSession);
        List<RegisteredUser> users = new ArrayList<>();
        users.add(registeredUserService.getByIdEntity(registeredUserId));
        groupSession.setRegisteredUsers(users);
        return mapToDTO(groupSessionRepo.save(groupSession));
    }


}
