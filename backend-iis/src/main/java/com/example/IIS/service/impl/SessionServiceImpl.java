package com.example.IIS.service.impl;

import com.example.IIS.domain.Question;
import com.example.IIS.domain.Session;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.repository.SessionRepo;
import com.example.IIS.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SessionRepo sessionRepo;


    @Override
    public SessionDTO create(SessionDTO sessionDTO) {
        Session session = mapToEntity(sessionDTO);
        Session savedSession = sessionRepo.save(session);
        return mapToDTO(savedSession);
    }

    private Session mapToEntity(SessionDTO sessionDTO){
        Session session = mapper.map(sessionDTO, Session.class);
        return session;
    }

    private SessionDTO mapToDTO(Session session){
        SessionDTO sessionDTO= mapper.map(session, SessionDTO.class);
        return sessionDTO;
    }
}
