package com.example.IIS.repository;

import com.example.IIS.domain.FilledInTest;
import com.example.IIS.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilledInTestRepository extends JpaRepository<FilledInTest, Long> {

    List<FilledInTest> findFilledInTestByRegisteredUser(RegisteredUser registeredUser);
}
