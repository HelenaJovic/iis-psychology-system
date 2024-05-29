package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SessionReportDTO {

    private String firstName;

    private String lastName;

    private String goal;

    private String sessionTopic;

    private String emotionalReactions;

    private String plan;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;


}
