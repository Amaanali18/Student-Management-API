package com.example.Student_Management_API.services;

import com.example.Student_Management_API.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();
    public Student createStudent(Student student);
    public Student updateStudent(Student student,Long enrollmentNumber);
    public String deleteStudent(Long enrollmentNumber);
    public Student getStudent(Long enrollmentNumber);
}
