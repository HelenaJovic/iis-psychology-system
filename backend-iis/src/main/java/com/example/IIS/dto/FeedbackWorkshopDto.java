package com.example.IIS.dto;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Workshop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackWorkshopDto {

    private Long id;

    private Long contentGrade;
    private Long psychologistGrade;

    private double finalGrade;

    private Long organizationGrade;
    private Long priceGrade;


    private boolean recommended;


    private String comment;
    private long registeredUserId;


    private long workshopId;
}
