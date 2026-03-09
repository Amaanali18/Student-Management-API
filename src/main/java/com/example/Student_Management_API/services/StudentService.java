package com.example.Student_Management_API.services;

import com.example.Student_Management_API.dtos.UserRequestDTO;
import com.example.Student_Management_API.dtos.UserResponseDTO;

import java.util.List;

public interface StudentService {

    List<UserResponseDTO> getAllStudents();
    UserResponseDTO createStudent(UserRequestDTO student);
    UserResponseDTO updateStudent(UserRequestDTO student, Long enrollmentNumber);
    String deleteStudent(Long enrollmentNumber);
    UserResponseDTO getStudent(Long enrollmentNumber);
}
