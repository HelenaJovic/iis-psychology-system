package com.example.IIS.service.impl;

import com.example.IIS.domain.JournalingTasks;
import com.example.IIS.dto.JournalingTasksDto;
import com.example.IIS.repository.JournalTasksRepo;
import com.example.IIS.service.JournalTasksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalTasksServiceImpl implements JournalTasksService {

    @Autowired
    JournalTasksRepo journalTasksRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public JournalingTasksDto getLatest() {
        JournalingTasks journalingTask =  journalTasksRepo.findLatestTask();
        return mapper.map(journalingTask,JournalingTasksDto.class);
    }
}
