package com.example.IIS.repository;

import com.example.IIS.domain.WorkshopQ;
import com.example.IIS.domain.WorkshopTestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WokrshopTestResultRepo extends JpaRepository<WorkshopTestResult, Long> {
}
