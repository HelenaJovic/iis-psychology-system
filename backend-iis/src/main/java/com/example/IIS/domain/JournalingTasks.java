package com.example.IIS.domain;

import com.example.IIS.domain.enums.StudentInternshipPriority;
import com.example.IIS.domain.enums.StudentInternshipStatus;
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
public class JournalingTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String operationType;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private StudentInternshipStatus status;

    @Column
    private StudentInternshipPriority priority;

    @Column
    private Long numOfTasksWithSameStatus;

    @Column
    private Long numOfTasksWithSamePriority;

    @Column
    private Date dateFilled;

    @ManyToOne
    @JoinColumn(name="student_internship_id")
    private StudentInternship studentInternship;

}
