package com.example.IIS.controller;

import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.SessionReportDTO;
import com.example.IIS.dto.TimeSlotDTO;
import com.example.IIS.service.SessionService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PreAuthorize("hasAnyRole('ROLE_REGISTERED_USER', 'ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@Valid @RequestBody SessionDTO sessionDTO){
        return new ResponseEntity<>(sessionService.create(sessionDTO), HttpStatus.CREATED);
    }


    @PreAuthorize("hasAnyRole('ROLE_REGISTERED_USER', 'ROLE_PSYCHOLOG')")
    @GetMapping("/{psychologistId}/{date}")
    public ResponseEntity<List<TimeSlotDTO>>  generateFreeSlots(@PathVariable Long psychologistId, @PathVariable LocalDate date){
        return new ResponseEntity<>(sessionService.generateFreeTimeSlots(psychologistId,date), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @GetMapping("/sessions/pdf/{documentationId}")
    public ResponseEntity<String> getSessionReport(@PathVariable Long documentationId){
        SessionReportDTO report = sessionService.generateReport(documentationId);
        try{
            String filePath = savePdfReport(report);
            return new ResponseEntity<>(filePath, HttpStatus.OK);
        }   catch (IOException | DocumentException e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    private String savePdfReport(SessionReportDTO report) throws IOException, DocumentException {
        Document document = new Document();
        String fileName = "session_report_" +  ".pdf";
        String filePath = "C:\\Users\\Hp\\Downloads\\" + fileName;


        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
        Paragraph title = new Paragraph("Equilibria", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        document.add(new Paragraph("\n"));


            document.add(new Paragraph("Date: " + report.getDate()));
            document.add(new Paragraph("Start Time: " + report.getStartTime()));
            document.add(new Paragraph("End Time: " + report.getEndTime()));
            document.add(new Paragraph("User: " + report.getFirstName() + " " + report.getLastName()));
            document.add(new Paragraph("Session goal: " + report.getGoal()));
            document.add(new Paragraph("Topic summary: " + report.getSessionTopic()));
            document.add(new Paragraph("Emotional reactions: " + report.getEmotionalReactions()));
            document.add(new Paragraph("Plan: " + report.getPlan()));


        document.close();
        return filePath;
    }

}
