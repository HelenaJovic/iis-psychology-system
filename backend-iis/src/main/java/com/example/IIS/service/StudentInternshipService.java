package com.example.IIS.service;

import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.MessageDto;
import com.example.IIS.dto.ReportDto;
import com.example.IIS.dto.StudentInternshipDto;

import java.util.List;

public interface StudentInternshipService {
    void create(List<StudentTest> bestStudents);

    StudentInternshipDto GetByStudent(long id);

    StudentInternshipDto GetByPsychologist(long id);
    StudentInternshipDto GetByPsychologist2(long id);

    List<StudentInternshipDto> GetALLByPsychologist(long id);

    ReportDto GetFinishedInternshipByStudentId(long id);

    void updateInternship(String comment, long id);

    List<MessageDto> getMessagesById(long studentInternshipId);

    Integer getStudentUnreadMessages(long studentId, long studentInternshipId);

    Integer getPsychologistUnreadMessages(long psychologistId, long studentInternshipId);

    void createMessage(MessageDto messageDto);

    void readMessage(MessageDto messageDto);
}
