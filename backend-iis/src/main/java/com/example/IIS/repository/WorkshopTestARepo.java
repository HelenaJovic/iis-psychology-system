package com.example.IIS.repository;

import com.example.IIS.domain.WorkshopA;
import com.example.IIS.domain.WorkshopQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopTestARepo extends JpaRepository<WorkshopA, Long> {
}
