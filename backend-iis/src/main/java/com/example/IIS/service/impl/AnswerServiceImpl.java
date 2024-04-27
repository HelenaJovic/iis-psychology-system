package com.example.IIS.service.impl;

import com.example.IIS.domain.Answer;
import com.example.IIS.domain.Question;
import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.repository.AnswerRepository;
import com.example.IIS.repository.QuestionRepository;
import com.example.IIS.service.AnswerService;
import com.example.IIS.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public AnswerDTO createAnswer(AnswerDTO answerDTO) {
       Answer answer = new Answer();
       answer.setPoints(answerDTO.getPoints());
       answer.setQuestion(questionRepository.findById(answerDTO.getQuestionId()).get());
       answerRepository.save(answer);
       return mapToDTO(answer);
    }

    @Override
    public List<AnswerDTO> getAll() {
        List<Answer> answers = answerRepository.findAll();
        List<AnswerDTO> dtos = new ArrayList<AnswerDTO>();

        for(Answer answer:answers){
            dtos.add(mapToDTO(answer));
        }

        return dtos;
    }


    //getByFinishedTestId

    private Answer mapToEntity(AnswerDTO answerDTO){
        Answer answer = mapper.map(answerDTO, Answer.class);
        return answer;
    }

    private AnswerDTO mapToDTO(Answer answer){
        AnswerDTO answerDTO= mapper.map(answer, AnswerDTO.class);
        return answerDTO;
    }
}
