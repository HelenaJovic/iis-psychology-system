package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopEvaluationDto {
    private String workshopName;
    private int femaleParticipation;
    private int maleParticipation;
    private double finalGrade;
    private int totalNumberOfFeedback;
    private int totalNumberOfParticipants;
    private double gradeByFemale;
    private double gradeByMale;
    private double totalContentGrade;
    private double totalPsychologicalGrade;
    private double totalOrgGrade;
    private double totalPriceGrade;
    private int numberRecommended;
    private int numberNotRecommended;
}
