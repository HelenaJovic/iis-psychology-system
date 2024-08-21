package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.MessageDto;
import com.example.IIS.dto.ReportDto;
import com.example.IIS.dto.StudentInternshipDto;
import com.example.IIS.repository.MessagesRepo;
import com.example.IIS.repository.StudentInternshipRepo;
import com.example.IIS.service.StudentInternshipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentInternshipServiceImpl implements StudentInternshipService {

    @Autowired
    private StudentInternshipRepo studentInternshipRepo;

    @Autowired
    private MessagesRepo messagesRepo;

    @Autowired
    private ModelMapper mapper;

    private StudentInternshipDto mapToDTO(StudentInternship studentInternship){
        StudentInternshipDto dto = mapper.map(studentInternship, StudentInternshipDto.class);
        return dto;
    }

    private ReportDto mapToReportDto(StudentInternship studentInternship){
        ReportDto dto = mapper.map(studentInternship, ReportDto.class);
        return dto;
    }

    private StudentInternship mapToEntity(StudentInternshipDto dto){
        StudentInternship studentInternship = mapper.map(dto, StudentInternship.class);
        return studentInternship;
    }


    @Override
    public void create(List<StudentTest> studentTests) {
        for (StudentTest studentTest : studentTests) {
            StudentInternship studentInternship = new StudentInternship();
            studentInternship.setInternship(studentTest.getInternshipTest().getInternship());
            studentInternship.setStudent(studentTest.getStudent());
            studentInternship.setEndDate(LocalDate.now().plusMonths(1));
            studentInternshipRepo.save(studentInternship);
        }
    }

    @Override
    public StudentInternshipDto GetByStudent(long id) {
        StudentInternship studentInternship = studentInternshipRepo.getStudentInternshipByStudent_Id(id);
        if(studentInternship != null){
            return mapToDTO(studentInternship);
        }
        return null;
    }

    @Override
    public StudentInternshipDto GetByPsychologist(long id) {
        StudentInternship studentInternship = studentInternshipRepo.getById(1L);
        if (studentInternship != null){
            return mapToDTO(studentInternship);
        }
        return null;
    }

    @Override
    public StudentInternshipDto GetByPsychologist2(long id) {
        StudentInternship studentInternship = studentInternshipRepo.findById(2L).orElse(null);
        if (studentInternship != null){
            return mapToDTO(studentInternship);
        }
        return null;
    }


    @Override
    public List<StudentInternshipDto> GetALLByPsychologist(long id) {
        List<StudentInternship> studentInternships = studentInternshipRepo.getStudentInternshipsByPsychologist_Id(id);
        List<StudentInternshipDto> dtos = new ArrayList<>();
        if (studentInternships != null){
            for (StudentInternship studentInternship:studentInternships) {
                dtos.add(mapToDTO(studentInternship));
            }
            return  dtos;
        }
        return null;
    }

    @Override
    public ReportDto GetFinishedInternshipByStudentId(long id) {
        StudentInternship studentInternship = studentInternshipRepo.getStudentInternshipByStudent_Id(id);
        if(studentInternship != null && studentInternship.getEndDate().isBefore(LocalDate.now())){
            return mapToReportDto(studentInternship);
        }
        return  null;
    }

    @Override
    public void updateInternship(String comment, long id) {
        StudentInternship studentInternship = studentInternshipRepo.findById(id).orElse(null);

        if (studentInternship != null){
            Set<String> comments = studentInternship.getComments();
            if (comments == null) {
                comments = new HashSet<>();
                studentInternship.setComments(comments);
            }
            comments.add(comment);

            studentInternshipRepo.save(studentInternship);
        }
    }

    @Override
    public List<MessageDto> getMessagesById(long studentInternshipId) {
        List<Message> messages = messagesRepo.getMessagesByStudentInternship_Id(studentInternshipId);
        List<MessageDto> dtos = new ArrayList<>();
        for (Message message: messages) {
            MessageDto dto =  mapper.map(message, MessageDto.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Integer getStudentUnreadMessages(long studentId, long studentInternshipId) {
        List<MessageDto> dtos = getMessagesById(studentInternshipId);
        Integer numOfUnreadMessages = 0;
        for (MessageDto dto:dtos) {
            if(!dto.isRead() && dto.getStudentId()==studentId && dto.getSender().equals("psychologist")){
                numOfUnreadMessages ++;
            }
        }
        return  numOfUnreadMessages;
    }

    @Override
    public Integer getPsychologistUnreadMessages(long psychologistId, long studentInternshipId) {
        List<MessageDto> dtos = getMessagesById(studentInternshipId);

        Integer numOfUnreadMessages = 0;
        for (MessageDto dto:dtos) {
            if(!dto.isRead() && dto.getPsychologistId()==psychologistId && dto.getSender().equals("student")){
                numOfUnreadMessages ++;
            }
        }
        return  numOfUnreadMessages;
    }

    @Override
    public void createMessage(MessageDto messageDto) {
        Message message = mapper.map(messageDto, Message.class);
        messagesRepo.save(message);
    }

    @Override
    public void readMessage(MessageDto messageDto) {
        Message message = messagesRepo.findById(messageDto.getId()).orElse(null);
        message.setRead(true);
        messagesRepo.save(message);
    }
}
