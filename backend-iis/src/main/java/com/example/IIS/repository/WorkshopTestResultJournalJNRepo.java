package com.example.IIS.repository;

import com.example.IIS.domain.WorkshopTest;
import com.example.IIS.domain.WorkshopTestResultJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopTestResultJournalJNRepo extends JpaRepository<WorkshopTestResultJournal, Long> {
}
