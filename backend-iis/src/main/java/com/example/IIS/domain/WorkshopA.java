package com.example.IIS.domain;

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
@Entity
@Table(name = "workshop_tests_a")
public class WorkshopA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;


    private boolean isTrue;

    @ElementCollection
    @CollectionTable(name = "answers_images", joinColumns = @JoinColumn(name = "workshopa_id"))
    @Column(name = "image")
    private List<String> images;

    @JoinColumn(name = "question_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private WorkshopQ workshopQ;
}
