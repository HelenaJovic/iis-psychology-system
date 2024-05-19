package com.example.IIS.domain;

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
@Table(name = "registered_user")
public class RegisteredUser extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isStudent;

    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkshopTestResult> testResults = new HashSet<WorkshopTestResult>();


    @ManyToMany
    @JoinTable(
            name = "user_workshop",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "workshop_id")
    )
    private Set<Workshop> workshops = new HashSet<Workshop>();


    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FilledInTest> filledInTests = new HashSet<FilledInTest>();
}
