package com.example.IIS.service;

import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.TimeSlotDTO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface SessionService {

    SessionDTO create(SessionDTO sessionDTO);

    List<TimeSlotDTO> generateFreeTimeSlots(long psychologistId, LocalDate date);

    HashMap<Integer, Integer> getTakenTimeSlots(long psychologistId, LocalDate date);
}
