package com.example.IIS.service.impl;

import com.example.IIS.domain.GroupSession;
import com.example.IIS.domain.IndividualSessions;
import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.IndividualSessionDTO;
import com.example.IIS.repository.GroupSessionRepo;
import com.example.IIS.repository.IndividualSessionRepo;
import com.example.IIS.service.IndividualSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualSessionServiceImpl implements IndividualSessionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IndividualSessionRepo individualSessionRepo;

    private IndividualSessions mapToEntity(IndividualSessionDTO individualSessionDTO){
       IndividualSessions individualSession = mapper.map(individualSessionDTO, IndividualSessions.class);
        return individualSession;
    }

    private IndividualSessionDTO mapToDTO(IndividualSessions individualSession){
        IndividualSessionDTO individualSessionDTO= mapper.map(individualSession, IndividualSessionDTO.class);
        return individualSessionDTO;
    }

    @Override
    public IndividualSessionDTO create(IndividualSessionDTO individualSessionDTO) {
        IndividualSessions individualSession = mapToEntity(individualSessionDTO);
        IndividualSessions savedIndividualSession = individualSessionRepo.save(individualSession);
        return mapToDTO(savedIndividualSession);
    }
}
