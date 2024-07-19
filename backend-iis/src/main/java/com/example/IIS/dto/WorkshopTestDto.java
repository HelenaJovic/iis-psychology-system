package com.example.IIS.dto;

import com.example.IIS.domain.Workshop;
import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.domain.WorkshopTestResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopTestDto {
    private Long id;


    private Long neededPoints;

    private Date dateFilled;


    private Workshop workshop;

    private Set<WorkshopQ> testQuestions = new HashSet<WorkshopQ>();

    private Set<WorkshopTestResult> testResults = new HashSet<WorkshopTestResult>();
}
