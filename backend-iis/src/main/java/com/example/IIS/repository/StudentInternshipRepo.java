package com.example.IIS.repository;
import com.example.IIS.domain.StudentInternship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentInternshipRepo extends JpaRepository<StudentInternship, Long> {
    StudentInternship getStudentInternshipByStudent_Id(long id);
//    StudentInternship getStudentInternshipByPsychologist_Id(long id);
    List<StudentInternship> getStudentInternshipsByPsychologist_Id(long id);

}