package com.example.IIS.repository;

import com.example.IIS.domain.JournalingTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JournalTasksRepo extends JpaRepository<JournalingTasks, Long> {
    @Query("SELECT j FROM JournalingTasks j ORDER BY j.dateFilled DESC LIMIT 1")
    JournalingTasks findLatestTask();
}
