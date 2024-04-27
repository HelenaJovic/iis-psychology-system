package com.example.IIS.dto;

import com.example.IIS.domain.Question;
import com.example.IIS.domain.enums.questionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    private String text;

    private questionCategory category;

    private boolean isVisible;

    private Long psychologistId;


}
