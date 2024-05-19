package com.example.IIS.service.impl;

import com.example.IIS.domain.GroupSession;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Session;
import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.repository.GroupSessionRepo;
import com.example.IIS.repository.SessionRepo;
import com.example.IIS.service.GroupSessionService;
import com.example.IIS.service.PsychologistService;
import com.example.IIS.service.RegisteredUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
