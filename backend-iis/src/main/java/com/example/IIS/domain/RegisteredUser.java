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



    @ManyToMany
    @JoinTable(
            name = "user_workshop",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "workshop_id")
    )
    private Set<Workshop> workshops = new HashSet<Workshop>();


    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FilledInTest> filledInTests = new HashSet<FilledInTest>();

    @ManyToMany(mappedBy = "registeredUsers")
//    @JoinTable(
//            name = "user_group_session",
//            joinColumns = @JoinColumn(name = "registered_user_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_session_id")
//    )
    private Set<GroupSession> groupSessions = new HashSet<GroupSession>();

    @OneToMany(mappedBy = "registeredUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<IndividualSessions> individualSessions = new HashSet<IndividualSessions>();
}

