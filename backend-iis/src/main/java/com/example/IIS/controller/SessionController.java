package com.example.IIS.controller;

import com.example.IIS.dto.QuestionDTO;
import com.example.IIS.dto.SessionDTO;
import com.example.IIS.dto.SessionReportDTO;
import com.example.IIS.dto.TimeSlotDTO;
import com.example.IIS.service.SessionService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
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
    @GetMapping("/pdf/{documentationId}")
    public ResponseEntity<byte[]> getSessionReport(@PathVariable Long documentationId) {
        SessionReportDTO report = sessionService.generateReport(documentationId);
        try {
            byte[] pdfBytes = savePdfReport(report);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "session_report.pdf");
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (IOException | DocumentException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private byte[] savePdfReport(SessionReportDTO report) throws IOException, DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);
        document.open();

        Font companyFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
        Paragraph companyInfo = new Paragraph("Equilibria\nDimitrija Tucovića 1, Novi Sad, Srbija\n", companyFont);
        companyInfo.setAlignment(Element.ALIGN_LEFT);
        document.add(companyInfo);

        document.add(new Paragraph("\n"));

        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.DARK_GRAY);
        Paragraph title = new Paragraph("Izveštaj individualne sesije", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("\n"));

        Font dateTimeFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
        PdfPTable dateTimeTable = new PdfPTable(2);
        dateTimeTable.setWidthPercentage(100);
        dateTimeTable.setSpacingBefore(10f);
        dateTimeTable.setSpacingAfter(10f);
        dateTimeTable.addCell(getCell("Datum: " + report.getDate(), PdfPCell.ALIGN_LEFT, dateTimeFont));
        dateTimeTable.addCell(getCell("Vreme: " + report.getStartTime() + " - " + report.getEndTime(), PdfPCell.ALIGN_RIGHT, dateTimeFont));
        document.add(dateTimeTable);

        document.add(new Chunk(new LineSeparator()));

        document.add(new Paragraph("\n"));

        Font contentFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        table.addCell(getCell("Korisnik: " + report.getFirstName() + " " + report.getLastName(), PdfPCell.ALIGN_LEFT, contentFont));
        table.addCell(getCell("Cilj sesije: " + report.getGoal(), PdfPCell.ALIGN_LEFT, contentFont));
        table.addCell(getCell("Sažetak teme: " + report.getSessionTopic(), PdfPCell.ALIGN_LEFT, contentFont));
        table.addCell(getCell("Emocionalne reakcije: " + report.getEmotionalReactions(), PdfPCell.ALIGN_LEFT, contentFont));
        table.addCell(getCell("Plan: " + report.getPlan(), PdfPCell.ALIGN_LEFT, contentFont));

        document.add(table);

        document.close();
        return baos.toByteArray();
    }


    private PdfPCell getCell(String text, int alignment, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

}
