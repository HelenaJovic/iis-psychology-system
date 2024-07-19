package com.example.IIS.repository;

import com.example.IIS.domain.RegisteredUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {

}
