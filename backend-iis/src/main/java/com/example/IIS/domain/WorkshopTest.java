package com.example.IIS.domain;

import com.example.IIS.domain.enums.WorkshopCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshop_tests")
public class WorkshopTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long neededPoints;


    @JoinColumn(name = "workshop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Workshop workshop;

    @OneToMany(mappedBy = "workshopTest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkshopQ> testQuestions = new HashSet<WorkshopQ>();

    @OneToMany(mappedBy = "workshopTest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkshopTestResult> testResults = new HashSet<WorkshopTestResult>();
}
