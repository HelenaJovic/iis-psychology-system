package com.example.IIS.repository;

import com.example.IIS.domain.Message;
import com.example.IIS.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagesRepo  extends JpaRepository<Message, Long> {
    List<Message> getMessagesByStudentInternship_Id(Long id);
}

