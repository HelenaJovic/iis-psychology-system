package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestCreationRequest {
    private WorkshopTestDto workshopTestDto;
    private List<WorkshopQDto> listOfQuestionDtos;
    private List<WorkshopADto> listOfAnswerDtos;
}
