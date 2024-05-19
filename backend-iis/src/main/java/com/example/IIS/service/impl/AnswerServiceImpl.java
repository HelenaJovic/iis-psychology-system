package com.example.IIS.service.impl;

import com.example.IIS.domain.Answer;
import com.example.IIS.domain.FilledInTest;
import com.example.IIS.domain.Question;
import com.example.IIS.dto.AnswerDTO;
import com.example.IIS.dto.FilledInTestDTO;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.repository.AnswerRepository;
import com.example.IIS.repository.FilledInTestRepository;
import com.example.IIS.repository.QuestionRepository;
import com.example.IIS.service.AnswerService;
import com.example.IIS.service.FilledInTestService;
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
    private FilledInTestService filledInTestService;

    @Autowired
    private ModelMapper mapper;


    @Override
    public AnswerDTO createAnswer(AnswerDTO answerDTO) {

       Answer answer = new Answer();
       answer.setPoints(answerDTO.getPoints());
       answer.setQuestion(questionRepository.findById(answerDTO.getQuestionId()).get());

       answer.setFilledInTest(filledInTestService.getByIdEntity(answerDTO.getFilledInTestId()));
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

    @Override
    public List<Answer> getByTestId(Long id) {
        List<Answer> allAnswers = answerRepository.findAll();

        List<Answer> answersWithTestId = new ArrayList<>();

        for (Answer answer : allAnswers) {
            if (answer.getFilledInTest().getId().equals(id)) {
                answersWithTestId.add(answer);
            }
        }

        return answersWithTestId;

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

    private FilledInTest mapToEntity(FilledInTestDTO filledInTestDTO){
        FilledInTest filledInTest = mapper.map(filledInTestDTO, FilledInTest.class);
        return filledInTest;
    }
}
