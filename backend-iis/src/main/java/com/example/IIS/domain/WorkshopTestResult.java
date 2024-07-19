package com.example.IIS.domain;

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
@Table(name = "workshop_tests_results")
public class WorkshopTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long neededPoints;

    private Date dateFilled;

    @JoinColumn(name = "test_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private WorkshopTest workshopTest;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private RegisteredUser registeredUser;


}
