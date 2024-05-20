package com.example.IIS.service.impl;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.PsychologistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsychologistServiceImpl implements PsychologistService {
    @Autowired
    private PsychologistRepo psychologistRepo;

    @Autowired
    private ModelMapper mapper;

    private PsychologistDto mapToDTO(Psychologist psychologist){
        PsychologistDto psychologistDto = mapper.map(psychologist, PsychologistDto.class);
        return psychologistDto;
    }

    // convert DTO to entity
    private Psychologist mapToEntity(PsychologistDto psychologistDto){
        Psychologist psychologist = mapper.map(psychologistDto, Psychologist.class);
        return psychologist;
    }


    @Override
    public PsychologistDto createPsych(PsychologistDto psychologistDto) {

        Psychologist psychologist=mapToEntity(psychologistDto);
        Psychologist newPsychologist=psychologistRepo.save(psychologist);


        PsychologistDto PsyhologistResponse = mapToDTO(newPsychologist);
        return PsyhologistResponse;    }

    @Override
    public Psychologist getById(Long id) {
       return psychologistRepo.findById(id).get();
    }

    @Override
    public List<PsychologistDto> getAll() {
        List<Psychologist> psychologists = psychologistRepo.findAll();
        List<PsychologistDto> dtos = new ArrayList<>();

        for(Psychologist p: psychologists){
            dtos.add(mapToDTO(p));
        }

        return dtos;
    }
}
