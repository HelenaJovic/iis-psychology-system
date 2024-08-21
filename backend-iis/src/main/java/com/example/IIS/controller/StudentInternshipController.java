package com.example.IIS.controller;

import com.example.IIS.dto.*;
import com.example.IIS.service.StudentInternshipService;
import com.example.IIS.service.StudentTestService;
import com.example.IIS.service.TaskService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/student-internships")
public class StudentInternshipController {

    @Autowired
    private StudentInternshipService _studentInternshipService;

    @Autowired
    private TaskService _taskService;

    @GetMapping("/by-student/{id}")
    public ResponseEntity<StudentInternshipDto> getByStudent(@PathVariable(name = "id") long id){
        StudentInternshipDto dto = _studentInternshipService.GetByStudent(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-psychologist/{id}")
    public ResponseEntity<StudentInternshipDto> getByPsychologist(@PathVariable(name = "id") long id){
        StudentInternshipDto dto = _studentInternshipService.GetByPsychologist(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-psychologist2/{id}")
    public ResponseEntity<StudentInternshipDto> getByPsychologist2(@PathVariable(name = "id") long id){
        StudentInternshipDto dto = _studentInternshipService.GetByPsychologist2(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all-by-psychologist/{id}")
    public ResponseEntity<List<StudentInternshipDto>> getAllByPsychologist(@PathVariable(name = "id") long id){
        List<StudentInternshipDto> dto = _studentInternshipService.GetALLByPsychologist(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping
    @PermitAll
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto){
        _taskService.createTask(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping
    @PermitAll
    public ResponseEntity<Void> updateTask(@RequestBody TaskDto taskDto){
        _taskService.updateTask(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value ="/update-internship/{id}", consumes = "text/plain")
    @PermitAll
    public ResponseEntity<Void> updateInternship(@RequestBody String comment, @PathVariable(name="id") long id){
        _studentInternshipService.updateInternship(comment, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/finishedInternship/{id}")
    public ResponseEntity<ReportDto> getFinishedInternshipByStudentId(@PathVariable(name="id") long id){
        ReportDto report= _studentInternshipService.GetFinishedInternshipByStudentId(id);
        if(report != null){
            return new ResponseEntity<>(report, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            File dir = new File("uploads/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(serverFile)) {
                fos.write(bytes);
            }

            String fileDownloadUri = "/uploads/" + file.getOriginalFilename();
            return ResponseEntity.ok(fileDownloadUri);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/messages/{studentInternshipId}")
    public ResponseEntity<List<MessageDto>> getMessagesByStudentInternshipId(@PathVariable(name = "studentInternshipId") long studentInternshipId){
        List<MessageDto> messages = _studentInternshipService.getMessagesById(studentInternshipId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/num-unread-messages-student/{studentInternshipId}/{studentId}")
    public ResponseEntity<Integer> getStudentUnreadMessages(@PathVariable(name = "studentId") long studentId, @PathVariable(name = "studentInternshipId") long studentInternshipId){
        Integer messages = _studentInternshipService.getStudentUnreadMessages(studentId, studentInternshipId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/num-unread-messages-psychologist/{studentInternshipId}/{psychologistId}")
    public ResponseEntity<Integer> getPsychologistUnreadMessages(@PathVariable(name = "psychologistId") long psychologistId, @PathVariable(name = "studentInternshipId") long studentInternshipId){
        Integer messages = _studentInternshipService.getPsychologistUnreadMessages(psychologistId, studentInternshipId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping ("/messages")
    public ResponseEntity<Void> createMessage(@RequestBody MessageDto messageDto){
        _studentInternshipService.createMessage(messageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/messages/read")
    public ResponseEntity<Void> readMessage(@RequestBody MessageDto messageDto){
        _studentInternshipService.readMessage(messageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
