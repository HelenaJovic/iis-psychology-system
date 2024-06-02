package com.example.IIS.dto;

import com.example.IIS.domain.StudentInternship;
import com.example.IIS.domain.enums.StudentInternshipPriority;
import com.example.IIS.domain.enums.StudentInternshipStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JournalingTasksDto {
    private Long id;

    private String operationType;

    private String title;

    private String description;

    private String status;

    private String priority;

    private Long numOfTasksWithSameStatus;

    private Long numOfTasksWithSamePriority;

    private Date dateFilled;
}
