package com.example.IIS.service;

import com.example.IIS.dto.FeedbackWorkshopDto;
import com.example.IIS.dto.FilledInTestDTO;
import com.example.IIS.dto.WorkshopEvaluationDto;

import java.util.List;

public interface FeedbackWorkshopService {
    FeedbackWorkshopDto createFeedback(FeedbackWorkshopDto feedbackWorkshopDto);
    WorkshopEvaluationDto getEvaluationByWorkshop(long workshopId);
    double getGradeByFemales(long workshopId);
     double getGradeByMale(long workshopId) ;
     List<FeedbackWorkshopDto> getAllByWorkshopId(Long workshopId) ;
    double getFinalGrade(long workshopId);
    double getTotalContentGrade(long workshopId);
    double getTotalOrganizationGrade(long workshopId);
    double getTotalPriceGrade(long workshopId);
    double getTotalPsychologistGrade(long workshopId);
    int getNumberOfRecommended(long workshopId);
}
