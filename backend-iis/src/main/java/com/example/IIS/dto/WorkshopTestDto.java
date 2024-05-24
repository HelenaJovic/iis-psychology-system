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

    private String name;


    private Long workshopId;

    private Set<WorkshopQDto> testQuestions = new HashSet<WorkshopQDto>();

//    private Set<Wo> testResults = new HashSet<WorkshopTestResult>();
}
