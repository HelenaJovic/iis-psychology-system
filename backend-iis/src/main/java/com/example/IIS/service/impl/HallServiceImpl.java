package com.example.IIS.service.impl;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.repository.HallRepo;
import com.example.IIS.service.HallService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    HallRepo hallRepo;

    @Autowired
    private ModelMapper mapper;

    private HallDto mapToDTO(Hall hall){
        HallDto hallDto = mapper.map(hall, HallDto.class);
        return hallDto;
    }

    // convert DTO to entity
    private Hall mapToEntity(HallDto hallDto){
        Hall hall = mapper.map(hallDto, Hall.class);
        return hall;
    }

    @Override
    public List<HallDto> getAllHalls() {
        List<Hall> halls=hallRepo.findAll();
        HallDto hallDto=new HallDto();
        List<HallDto> hallsDto =new ArrayList<HallDto>();

        for (Hall hall : halls) {
            hallDto=mapToDTO(hall);
            hallsDto.add(hallDto);

        }
        return hallsDto;
    }
}