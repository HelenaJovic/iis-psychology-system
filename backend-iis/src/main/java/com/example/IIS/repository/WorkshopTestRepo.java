package com.example.IIS.repository;

import com.example.IIS.domain.Workshop;
import com.example.IIS.domain.WorkshopTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopTestRepo extends JpaRepository<WorkshopTest, Long> {
}
