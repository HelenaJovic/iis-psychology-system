package com.example.IIS.service.impl;

import com.example.IIS.domain.Session;
import com.example.IIS.domain.SessionDocumentation;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.SessionDocumentationDTO;
import com.example.IIS.repository.SessionDocumentationRepo;
import com.example.IIS.service.IndividualSessionService;
import com.example.IIS.service.SessionDocumentationService;
import com.example.IIS.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionDocumentationServiceImpl implements SessionDocumentationService {
    @Autowired
    private SessionDocumentationRepo sessionDocumentationRepo;

    @Autowired
    private IndividualSessionService individualSessionService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SessionDocumentationDTO create(SessionDocumentationDTO documentationDTO) {
        SessionDocumentation sessionDocumentation = new SessionDocumentation();
        sessionDocumentation.setIndividualSessions(individualSessionService.getById(documentationDTO.getIndividualSessionId()));
        sessionDocumentation.setPlan(documentationDTO.getPlan());
        sessionDocumentation.setEmotionalReactions(documentationDTO.getEmotionalReactions());
        sessionDocumentation.setTopicSummary(documentationDTO.getTopicSummary());
        SessionDocumentation savedDocumentation = sessionDocumentationRepo.save(sessionDocumentation);
        return mapToDTO(savedDocumentation);
    }

    @Override
    public List<SessionDocumentationDTO> getAll() {

        List<SessionDocumentation>  documentations = sessionDocumentationRepo.findAll();
        List<SessionDocumentationDTO> dtos = new ArrayList<>();

        for(SessionDocumentation s: documentations){
            dtos.add(mapToDTO(s));
        }
       return dtos;
    }

    @Override
    public SessionDocumentation getById(Long id) {
        return sessionDocumentationRepo.findById(id).get();
    }

    @Override
    public SessionDocumentationDTO delete(Long id) {
        SessionDocumentation documentation = sessionDocumentationRepo.findById(id).get();
        sessionDocumentationRepo.delete(documentation);
        return mapToDTO(documentation);
    }

    @Override
    public SessionDocumentationDTO update(SessionDocumentationDTO documentationDTO, Long id) {
        SessionDocumentation documentation = sessionDocumentationRepo.findById(id).get();
        documentation.setTopicSummary(documentationDTO.getTopicSummary());
        documentation.setEmotionalReactions(documentationDTO.getEmotionalReactions());
        documentation.setPlan(documentationDTO.getPlan());
        documentation.setIndividualSessions(individualSessionService.getById(documentationDTO.getIndividualSessionId()));
        sessionDocumentationRepo.save(documentation);

        return mapToDTO(documentation);
    }


    private SessionDocumentation mapToEntity(SessionDocumentationDTO sessionDocumentationDTO){
        SessionDocumentation sessionDocumentation = mapper.map(sessionDocumentationDTO, SessionDocumentation.class);
        return sessionDocumentation;
    }

    private SessionDocumentationDTO mapToDTO(SessionDocumentation sessionDocumentation){
        SessionDocumentationDTO sessionDocumentationDTO= mapper.map(sessionDocumentation, SessionDocumentationDTO.class);
        return sessionDocumentationDTO;
    }
}
