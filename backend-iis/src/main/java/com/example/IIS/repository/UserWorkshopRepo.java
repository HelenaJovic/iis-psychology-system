package com.example.IIS.repository;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.UserWorkshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWorkshopRepo extends JpaRepository<UserWorkshop, Long> {
}
