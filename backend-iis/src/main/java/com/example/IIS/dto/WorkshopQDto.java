package com.example.IIS.dto;

import com.example.IIS.domain.WorkshopA;
import com.example.IIS.domain.WorkshopTest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopQDto {


    private Long id;

    private String text;

    private Long pointsPerQuestion;


    private List<String> images;


    private WorkshopTest workshopTest;

    private Set<WorkshopA> testAnswers = new HashSet<WorkshopA>();
}
