package com.example.IIS.repository;

import com.example.IIS.domain.IndividualSessions;
import com.example.IIS.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualSessionRepo extends JpaRepository<IndividualSessions, Long> {

    List<IndividualSessions> findByPsychologist(Psychologist psychologist);
}
