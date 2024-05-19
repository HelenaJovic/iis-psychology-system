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
public class TestResultDto {

    private Long id;


    private Long neededPoints;

    private Date dateFilled;

    private WorkshopTest workshopTest;

    private RegisteredUser registeredUser;

}
