package com.example.IIS.repository;

import com.example.IIS.domain.SessionDocumentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDocumentationRepo extends JpaRepository<SessionDocumentation, Long> {
}
