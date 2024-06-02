package com.example.IIS.dto;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.WorkshopTest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopTestResultJournalJNDto {


    private Long id;

    private Long achievedPoints;
    private Long average_score;
    private Long pass_rate;

    private Long attempt_count;
    private boolean isPassed;

    private Date dateFilled;

    private Date changeDate;

    private String operationType;

    private WorkshopTestDto workshopTest;

    private RegisteredUserDto registeredUser;
}
