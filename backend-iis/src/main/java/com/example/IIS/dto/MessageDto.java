package com.example.IIS.dto;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;

    private Long studentId;
    private String studentName;

    private Long psychologistId;
    private String psychologistName;

    private Long studentInternshipId;

    private String content;

    private boolean read;

    private String sender;
}
