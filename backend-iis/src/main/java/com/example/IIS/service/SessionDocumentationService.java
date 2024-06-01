package com.example.IIS.service;

import com.example.IIS.domain.SessionDocumentation;
import com.example.IIS.dto.SessionDocumentationDTO;

import java.util.List;

public interface SessionDocumentationService {

    SessionDocumentationDTO create(SessionDocumentationDTO documentationDTO);

    List<SessionDocumentationDTO> getAll();


    SessionDocumentation getById(Long id);


    SessionDocumentationDTO delete(Long id);

    SessionDocumentationDTO update(SessionDocumentationDTO documentationDTO, Long id);

}
