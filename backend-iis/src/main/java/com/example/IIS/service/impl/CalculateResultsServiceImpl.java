package com.example.IIS.service.impl;

import com.example.IIS.domain.Answer;
import com.example.IIS.domain.FilledInTest;
import com.example.IIS.domain.Question;
import com.example.IIS.domain.enums.questionCategory;
import com.example.IIS.dto.FilledInTestDTO;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.TestResultsDTO;
import com.example.IIS.service.AnswerService;
import com.example.IIS.service.CalculateResultsService;
import com.example.IIS.service.FilledInTestService;
import com.example.IIS.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateResultsServiceImpl implements CalculateResultsService {

    @Autowired
    private FilledInTestService filledInTestService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Override
    public TestResultsDTO calculate(long userId) {
       List<FilledInTestDTO> tests= filledInTestService.getByUserId(Long.valueOf(3));
        List<Answer> answers = new ArrayList<Answer>();

        double OpennesReal =0;

        int OpennesCount = 0;

         double ConscietiousnessReal =0 ;

         int ConscietiousnessCount =0;

         double ExtraversionReal = 0;

         int ExtraversionCount = 0;

         double AgreeablenessReal = 0;

         int AgreeablenessCount =0;

         double NeuroticismReal = 0;

         int NeuroticismCount =0;


       for(FilledInTestDTO filledInTestDTO: tests){
            answers = answerService.getByTestId(filledInTestDTO.getId());

       }

       for(Answer answer: answers){
           QuestionDTO question = questionService.getById(answer.getQuestion().getId());

           if(question.getCategory()== questionCategory.Openness){

               OpennesReal += answer.getPoints();
               OpennesCount +=1;
           }
           else if(question.getCategory()== questionCategory.Extraversion){
               ExtraversionReal += answer.getPoints();
               ExtraversionCount +=1;
           }
           else if(question.getCategory()== questionCategory.Agreeableness){
               AgreeablenessReal += answer.getPoints();
               AgreeablenessCount +=1;
           }

           else if(question.getCategory()==questionCategory.Neuroticism){
               NeuroticismReal += answer.getPoints();
               NeuroticismCount += 1;
           }

           else {
               ConscietiousnessReal += answer.getPoints();
               ConscietiousnessCount += 1;
           }
       }

       System.out.println(ConscietiousnessCount);

       return new TestResultsDTO(OpennesReal/(OpennesCount*5), ConscietiousnessReal/(ConscietiousnessCount*5), ExtraversionReal/(ExtraversionCount*5), AgreeablenessReal/(AgreeablenessCount*5), NeuroticismReal/(NeuroticismCount*5) );

    }
}
