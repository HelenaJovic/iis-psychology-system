package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private String studentName;
    private String studentLastName;
    private String psychologistName;
    private String psychologistLastName;
    private int studentInternshipPoints;
    private Set<TaskDto> tasks;
    private String internshipTitle;
    private LocalDate endDate;
}