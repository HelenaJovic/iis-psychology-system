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
@Table(name = "filledInTest")
public class FilledInTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date finishedDate;

    private boolean isFinished;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "registeredUser_id")
    private RegisteredUser registeredUser;

    @OneToMany(mappedBy = "filledInTest", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<Answer>();



}
