package com.example.IIS.repository;

import com.example.IIS.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.psychologist.id = :psychologistId AND s.date = :date")
    List<Session> findByPsychologistIdAndDate(@Param("psychologistId") long psychologistId, @Param("date") LocalDate date);
}
