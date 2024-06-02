package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshop_tests_results_JN")
public class WorkshopTestResultJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long achievedPoints;

    private boolean isPassed;

    private Long attempt_count;
    private Long average_score;
    private Long pass_rate;

    private Long previous_achieved_points;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFilled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;

    private String operationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private WorkshopTest workshopTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private RegisteredUser registeredUser;
}
