package com.example.IIS.repository;

import com.example.IIS.domain.Comment;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.WorkShopDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkshopRepo extends JpaRepository<Workshop, Long> {

    List<Workshop> getAllWorkshopsByPsychologistId(long id);

    @Query("SELECT w.name FROM Workshop w WHERE w.id = :id")
    String getWorkshopNameById(@Param("id") Long id);

}
