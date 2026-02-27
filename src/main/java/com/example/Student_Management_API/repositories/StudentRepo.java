package com.example.Student_Management_API.repositories;

import com.example.Student_Management_API.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
    public Student findByEnrollmentNumber(Long enrollmentNumber);
}
