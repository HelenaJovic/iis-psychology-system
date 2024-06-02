package com.example.IIS.service.impl;

import com.example.IIS.domain.Workshop;
import com.example.IIS.domain.WorkshopTestResultJournal;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.dto.WorkshopTestResultJournalJNDto;
import com.example.IIS.repository.WorkshopTestResultJournalJNRepo;
import com.example.IIS.service.WorkshopJournalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopJournalServiceImpl implements WorkshopJournalService {

    @Autowired
    WorkshopTestResultJournalJNRepo workshopTestResultJournalJNRepo;

    @Autowired
    ModelMapper mapper;

    private WorkshopTestResultJournalJNDto mapToDTO(WorkshopTestResultJournal workshop){
        WorkshopTestResultJournalJNDto workShopDto = mapper.map(workshop, WorkshopTestResultJournalJNDto.class);
        return workShopDto;
    }

    // convert DTO to entity
    private WorkshopTestResultJournal mapToEntity(WorkshopTestResultJournalJNDto workshopDto){
        WorkshopTestResultJournal workshop = mapper.map(workshopDto, WorkshopTestResultJournal.class);
        return workshop;
    }
    @Override
    public WorkshopTestResultJournalJNDto getById(long id) {
        return mapToDTO(workshopTestResultJournalJNRepo.findAll().getLast());
    }
}
