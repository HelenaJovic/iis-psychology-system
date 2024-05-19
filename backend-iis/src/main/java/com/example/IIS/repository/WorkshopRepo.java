package com.example.IIS.repository;

import com.example.IIS.domain.Comment;
import com.example.IIS.domain.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopRepo extends JpaRepository<Workshop, Long> {

    List<Workshop> getAllWorkshopsByPsychologistId(long id);

}
