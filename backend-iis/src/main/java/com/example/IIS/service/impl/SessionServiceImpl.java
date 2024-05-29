package com.example.IIS.service.impl;

import com.example.IIS.domain.Question;
import com.example.IIS.domain.Session;
import com.example.IIS.domain.SessionDocumentation;
import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.SessionReportDTO;
import com.example.IIS.dto.TimeSlotDTO;
import com.example.IIS.repository.SessionRepo;
import com.example.IIS.service.SessionDocumentationService;
import com.example.IIS.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private SessionDocumentationService sessionDocumentationService;

    @Override
    public SessionDTO create(SessionDTO sessionDTO) {
        Session session = mapToEntity(sessionDTO);
        Session savedSession = sessionRepo.save(session);
        return mapToDTO(savedSession);
    }

    @Override
    public List<TimeSlotDTO> generateFreeTimeSlots(long psychologistId, LocalDate date) {
        var takenSlotsMap = getTakenTimeSlots(psychologistId, date);
        List<TimeSlotDTO> freeTimeSlots = new ArrayList<>();

        for (int i = 8; i <= 14; i += 2) {
            if (!takenSlotsMap.containsKey(i)) {
                freeTimeSlots.add(new TimeSlotDTO(LocalTime.of(i, 0), LocalTime.of(i + 2, 0)));
            }
        }

        return freeTimeSlots;
    }

    @Override
    public HashMap<Integer, Integer> getTakenTimeSlots(long psychologistId, LocalDate date) {
        List<Session> sessions = sessionRepo.findByPsychologistIdAndDate(psychologistId, date);
        HashMap<Integer, Integer> takenSlotsMap = new HashMap<>();

        for(Session s:sessions){
            takenSlotsMap.put(s.getStartTime().getHour(), s.getEndTime().getHour());
        }

        return takenSlotsMap;
    }

    @Override
    public SessionReportDTO generateReport(long sessionDocumentId) {

        SessionDocumentation sessionDocumentation = sessionDocumentationService.getById(sessionDocumentId);

        SessionReportDTO report = new SessionReportDTO();

        report.setSessionTopic(sessionDocumentation.getTopicSummary());
        report.setPlan(sessionDocumentation.getPlan());
        report.setEmotionalReactions(sessionDocumentation.getEmotionalReactions());
        report.setGoal(sessionDocumentation.getIndividualSessions().getSessionGoal());
        report.setDate(sessionDocumentation.getIndividualSessions().getDate());
        report.setStartTime(sessionDocumentation.getIndividualSessions().getStartTime());
        report.setEndTime(sessionDocumentation.getIndividualSessions().getEndTime());
        report.setFirstName(sessionDocumentation.getIndividualSessions().getRegisteredUser().getName());
        report.setLastName(sessionDocumentation.getIndividualSessions().getRegisteredUser().getLastName());

        return report;
    }

    private Session mapToEntity(SessionDTO sessionDTO){
        Session session = mapper.map(sessionDTO, Session.class);
        return session;
    }

    private SessionDTO mapToDTO(Session session){
        SessionDTO sessionDTO= mapper.map(session, SessionDTO.class);
        return sessionDTO;
    }
}
