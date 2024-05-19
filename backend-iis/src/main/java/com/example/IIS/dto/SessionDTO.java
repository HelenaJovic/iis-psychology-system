package com.example.IIS.dto;

import com.example.IIS.domain.enums.SessionType;
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
public class SessionDTO {


    private Long id;
    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Long psychologistId;
}
