package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedbacksWorkshop")
public class FeedbackWorkshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contentGrade;
    private Long psychologistGrade;


    private Long organizationGrade;
    private Long priceGrade;


    private boolean recommended;

    private String comment;

    private double finalGrade;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private RegisteredUser registeredUser;

    @JoinColumn(name = "workshop_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Workshop workshop;
}
