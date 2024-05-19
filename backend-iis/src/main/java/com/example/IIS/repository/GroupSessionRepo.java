package com.example.IIS.repository;

import com.example.IIS.domain.GroupSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface GroupSessionRepo extends JpaRepository<GroupSession, Long> {
}
