package com.example.Student_Management_API.services.impl;

import com.example.Student_Management_API.entities.Student;
import com.example.Student_Management_API.repositories.StudentRepo;
import com.example.Student_Management_API.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSeviceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentSeviceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        Student saved = studentRepo.save(student);
        return saved;
    }

    @Override
    public Student updateStudent(Student student, Long enrollmentNumber) {
        Student student1;
        try {
            student1=studentRepo.findByEnrollmentNumber(enrollmentNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setContactNumber(student.getContactNumber());
        student1.setDepartment(student.getDepartment());
        Student updated = studentRepo.save(student1);
        return updated;
    }

    @Override
    public String deleteStudent(Long enrollmentNumber) {
        Student deleted = studentRepo.findByEnrollmentNumber(enrollmentNumber);
        String message = "Deleted student with enrollment number " + enrollmentNumber;
        studentRepo.delete(deleted);
        return message;
    }

    @Override
    public Student getStudent(Long enrollmentNumber) {
        Student student = studentRepo.findByEnrollmentNumber(enrollmentNumber);
        return student;
    }
}
