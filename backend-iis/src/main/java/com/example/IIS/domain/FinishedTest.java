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
@Table(name = "finishedTests")
public class FinishedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date finishedDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "registeredUser_id")
    private RegisteredUser registeredUser;

}
