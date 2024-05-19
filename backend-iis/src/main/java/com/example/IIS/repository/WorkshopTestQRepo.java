package com.example.IIS.repository;

import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.domain.WorkshopTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopTestQRepo extends JpaRepository<WorkshopQ, Long> {
}
