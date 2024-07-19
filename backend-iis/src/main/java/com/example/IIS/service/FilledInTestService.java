package com.example.IIS.service;

import com.example.IIS.domain.FilledInTest;
import com.example.IIS.dto.FilledInTestDTO;

import java.util.List;

public interface FilledInTestService {

    FilledInTestDTO createTest(FilledInTestDTO filledInTestDTO);

    FilledInTestDTO getById(Long id);

    FilledInTest getByIdEntity(Long id);

    List<FilledInTestDTO> getByUserId(Long id);

    FilledInTestDTO finishTest(Long id);

    List<FilledInTestDTO> getAllFinished();
}
