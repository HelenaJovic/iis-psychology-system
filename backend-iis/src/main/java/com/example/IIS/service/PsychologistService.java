package com.example.IIS.service;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.dto.RegisteredUserDto;

import java.util.List;

public interface PsychologistService {
    PsychologistDto createPsych(PsychologistDto psychologistDto);

    Psychologist getById(Long id);

    List<PsychologistDto> getAll();

}
