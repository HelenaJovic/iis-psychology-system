package com.example.IIS.service.impl;

import com.example.IIS.domain.Answer;
import com.example.IIS.domain.FilledInTest;
import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.FilledInTestDTO;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.repository.FilledInTestRepository;
import com.example.IIS.repository.RegisteredUserRepo;
import com.example.IIS.service.FilledInTestService;
import com.example.IIS.service.RegisteredUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilledInTestServiceImpl implements FilledInTestService {

    @Autowired
    private FilledInTestRepository filledInTestRepository;

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private ModelMapper mapper;


    @Override
    public FilledInTestDTO createTest(FilledInTestDTO filledInTestDTO) {
       FilledInTest filledInTest = new FilledInTest();
       filledInTest.setFinishedDate(filledInTestDTO.getFinishedDate());
       filledInTest.setFinished(filledInTestDTO.isFinished());
       filledInTest.setRegisteredUser(MapToEntity(registeredUserService.getById(filledInTestDTO.getRegisteredUserId())));
       FilledInTest savedTest = filledInTestRepository.save(filledInTest);
       return mapToDTO(savedTest);
    }

    @Override
    public FilledInTestDTO getById(Long id) {
        FilledInTest filledInTest = filledInTestRepository.findById(id).get();
        return mapToDTO(filledInTest);
    }

    @Override
    public FilledInTest getByIdEntity(Long id) {
        return filledInTestRepository.findById(id).get();


    }

    @Override
    public List<FilledInTestDTO> getByUserId(Long id) {
        RegisteredUser registeredUser = MapToEntity(registeredUserService.getById(id));
       List<FilledInTest> filledInTests = filledInTestRepository.findFilledInTestByRegisteredUser(registeredUser);

       List<FilledInTestDTO> dtos = new ArrayList<FilledInTestDTO>();

        for (FilledInTest filledInTest : filledInTests) {
            dtos.add(mapToDTO(filledInTest));
        }

        return dtos;

    }

    @Override
    public FilledInTestDTO finishTest(Long id) {
        FilledInTest filledInTest = filledInTestRepository.findById(id).get();
        filledInTest.setFinished(true);
        FilledInTest savedTest = filledInTestRepository.save(filledInTest);
        return mapToDTO(savedTest);
    }


    private FilledInTest mapToEntity(FilledInTestDTO filledInTestDTO){
        FilledInTest filledInTest = mapper.map(filledInTestDTO, FilledInTest.class);
        return filledInTest;
    }

    private FilledInTestDTO mapToDTO(FilledInTest filledInTest){
        FilledInTestDTO filledInTestDTO= mapper.map(filledInTest, FilledInTestDTO.class);
        return filledInTestDTO;
    }

    private RegisteredUser MapToEntity(RegisteredUserDto registeredUserDto){
        RegisteredUser registeredUser = mapper.map(registeredUserDto, RegisteredUser.class);
        return registeredUser;
    }
}
