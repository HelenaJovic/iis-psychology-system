package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name="psychologist_id")
    Psychologist psychologist;

    @ManyToOne
    @JoinColumn(name="student_internship_id")
    StudentInternship studentInternship;

    private String content;

    private boolean isRead;

    private String sender;
}
