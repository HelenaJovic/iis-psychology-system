package com.example.IIS.service.impl;

import com.example.IIS.domain.Question;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.QuestionRepository;
import com.example.IIS.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
       Question question = mapToEntity(questionDTO);
       Question savedQuestion =  questionRepository.save(question);
       return mapToDTO(savedQuestion);
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<QuestionDTO> dtos = new ArrayList<QuestionDTO>();
        List<Question> questions = questionRepository.findAll();
        for(Question question: questions){
            dtos.add(mapToDTO(question));
        }

        return dtos;
    }

    @Override
    public QuestionDTO changeVisibility(long id) {
        Question question = questionRepository.findById(id).get();

        question.setVisible(false);
        Question newQuestion = questionRepository.save(question);
        return mapToDTO(newQuestion);

    }

    @Override
    public QuestionDTO update(QuestionDTO questionDTO, Long id) {
        Question question = questionRepository.findById(id).get();

        question.setText(questionDTO.getText());
        question.setCategory(questionDTO.getCategory());
        question.setVisible(question.isVisible());

        return mapToDTO(questionRepository.save(question));
    }

    @Override
    public QuestionDTO getById(Long id) {
        Question question = questionRepository.findById(id).get();
        return mapToDTO(question);
    }


    private Question mapToEntity(QuestionDTO questionDTO){
        Question question = mapper.map(questionDTO, Question.class);
        return question;
    }

    private QuestionDTO mapToDTO(Question question){
        QuestionDTO questionDTO = mapper.map(question, QuestionDTO.class);
        return questionDTO;
    }
}
