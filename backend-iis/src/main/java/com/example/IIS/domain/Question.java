package com.example.IIS.domain;

import com.example.IIS.domain.enums.questionCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private questionCategory category;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "psychologist_id")
    private Psychologist psychologist;

    private boolean isVisible;

    @OneToMany(mappedBy = "question", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<Answer>();





}
