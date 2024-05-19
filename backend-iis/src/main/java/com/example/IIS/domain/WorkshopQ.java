package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshop_tests_q")
public class WorkshopQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Long pointsPerQuestion;

    @ElementCollection
    @CollectionTable(name = "questions_images", joinColumns = @JoinColumn(name = "workshopq_id"))
    @Column(name = "image")
    private List<String> images;

    @JoinColumn(name = "test_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private WorkshopTest workshopTest;

    @OneToMany(mappedBy = "workshopQ", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkshopA> testAnswers = new HashSet<WorkshopA>();
}
