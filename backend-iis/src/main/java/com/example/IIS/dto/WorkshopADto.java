package com.example.IIS.dto;

import com.example.IIS.domain.WorkshopQ;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopADto {
    private Long id;

    private String text;

    private boolean isTrue;


    private List<String> images;

    private long workshopQId;
}
