package com.example.IIS.repository;

import com.example.IIS.domain.FeedbackWorkshop;
import com.example.IIS.domain.FilledInTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackWorkshopRepo extends JpaRepository<FeedbackWorkshop, Long> {
    List<FeedbackWorkshop> findAllByWorkshopId(Long id);
}
