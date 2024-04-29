package com.example.IIS.service;

import com.example.IIS.domain.Question;
import com.example.IIS.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

   QuestionDTO createQuestion(QuestionDTO questionDTO);

   List<QuestionDTO> getAll();

   QuestionDTO changeVisibility(long id);

   QuestionDTO update(QuestionDTO questionDTO, Long id);

   QuestionDTO getById(Long id);


}
