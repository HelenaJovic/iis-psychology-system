package com.example.IIS.service.impl;

import com.example.IIS.domain.RegisteredUser;
import com.example.IIS.domain.Task;
import com.example.IIS.domain.enums.StudentInternshipPriority;
import com.example.IIS.domain.enums.StudentInternshipStatus;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.TaskDto;
import com.example.IIS.repository.StudentInternshipRepo;
import com.example.IIS.repository.TaskRepo;
import com.example.IIS.service.StudentInternshipService;
import com.example.IIS.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StudentInternshipRepo studentInternshipRepo;

    private Task mapToEntity(TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(StudentInternshipStatus.STUCK);
        task.setPriority(mapPriority(taskDto));
        task.setStudentInternship(studentInternshipRepo.findById(taskDto.getStudentInternshipId()).orElse(null));
        return task;
    }

    private StudentInternshipPriority mapPriority(TaskDto taskDto) {
        String priority = taskDto.getPriority().toUpperCase();
        if (priority.equals(StudentInternshipPriority.LOW.toString())){
            return StudentInternshipPriority.LOW;
        }
        else if (priority.equals(StudentInternshipPriority.MEDIUM.toString())){
            return StudentInternshipPriority.MEDIUM;
        }
        else if (priority.equals(StudentInternshipPriority.HIGH.toString())){
            return StudentInternshipPriority.HIGH;
        }
        return null;
    }

    private StudentInternshipStatus mapStatus(TaskDto taskDto) {
        String status = taskDto.getStatus().toUpperCase();
        if (status.equals(StudentInternshipStatus.IN_PROGRESS.toString())) {
            return StudentInternshipStatus.IN_PROGRESS;
        } else if (status.equals(StudentInternshipStatus.DONE.toString())) {
            return StudentInternshipStatus.DONE;
        } else if (status.equals(StudentInternshipStatus.NOT_REVIEWED.toString())) {
            return StudentInternshipStatus.NOT_REVIEWED;
        } else if (status.equals(StudentInternshipStatus.STUCK.toString())) {
            return StudentInternshipStatus.STUCK;
        }
        return null;
    }


    @Override
    public void createTask(TaskDto taskDto) {
        taskRepo.save(mapToEntity(taskDto));
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Task task = taskRepo.findById(taskDto.getId()).orElse(null);
        task.setStatus(mapStatus(taskDto));
        if (task != null){
            taskRepo.save(task);
        }
    }
}
