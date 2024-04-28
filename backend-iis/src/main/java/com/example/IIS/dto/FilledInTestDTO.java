package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilledInTestDTO {

    private Date finishedDate;

    private Long registeredUserId;

    private boolean isFinished;
}
