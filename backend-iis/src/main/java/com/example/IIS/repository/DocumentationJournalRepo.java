package com.example.IIS.repository;

import com.example.IIS.domain.DocumentationJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationJournalRepo extends JpaRepository<DocumentationJournal, Long> {
}
