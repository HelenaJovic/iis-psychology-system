package com.example.IIS.service;

import com.example.IIS.domain.Answer;
import com.example.IIS.dto.AnswerDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnswerService {

    AnswerDTO createAnswer(AnswerDTO answerDTO);

    List<AnswerDTO> getAll();

    List<Answer> getByTestId(Long id);
}
