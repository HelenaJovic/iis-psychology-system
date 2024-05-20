package com.example.IIS.service;

import com.example.IIS.dto.GroupSessionDTO;
import com.example.IIS.dto.TimeSlotDTO;

import java.time.LocalDate;
import java.util.List;

public interface GroupSessionService {

    GroupSessionDTO create(GroupSessionDTO groupSessionDTO);

   List<GroupSessionDTO> getAll();

   GroupSessionDTO reserveSession(GroupSessionDTO groupSessionDTO,Long registeredUserId);
}
