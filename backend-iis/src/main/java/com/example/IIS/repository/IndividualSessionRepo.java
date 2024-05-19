package com.example.IIS.repository;

import com.example.IIS.domain.IndividualSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualSessionRepo extends JpaRepository<IndividualSessions, Long> {
}
