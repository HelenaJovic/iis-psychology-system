package com.example.IIS.service;

import com.example.IIS.domain.IndividualSessions;
import com.example.IIS.dto.IndividualSessionDTO;

import java.util.List;

public interface IndividualSessionService {

    IndividualSessionDTO create(IndividualSessionDTO individualSessionDTO);

    IndividualSessions getById(Long id);

    List<IndividualSessionDTO> getByPsychologistId(Long id);
}
