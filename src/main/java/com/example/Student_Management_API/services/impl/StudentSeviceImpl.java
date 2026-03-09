package com.example.Student_Management_API.services.impl;

import com.example.Student_Management_API.dtos.UserRequestDTO;
import com.example.Student_Management_API.dtos.UserResponseDTO;
import com.example.Student_Management_API.entities.Student;
import com.example.Student_Management_API.repositories.StudentRepo;
import com.example.Student_Management_API.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentSeviceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentSeviceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // ── Mapping helpers ──────────────────────────────────────────────────────

    private Student toEntity(UserRequestDTO dto) {
        Student student = new Student();
        student.setEnrollmentNumber(dto.getEnrollmentNumber());
        student.setName(dto.getName());
        student.setContactNumber(dto.getContactNumber());
        student.setDepartment(dto.getDepartment());
        student.setEmail(dto.getEmail());
        return student;
    }

    private UserResponseDTO toResponseDTO(Student student) {
        return UserResponseDTO.builder()
                .id(student.getId())
                .enrollmentNumber(student.getEnrollmentNumber())
                .name(student.getName())
                .contactNumber(student.getContactNumber())
                .department(student.getDepartment())
                .email(student.getEmail())
                .build();
    }

    // ── Service methods ───────────────────────────────────────────────────────

    @Override
    public List<UserResponseDTO> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO createStudent(UserRequestDTO userRequestDTO) {
        Student student = toEntity(userRequestDTO);
        Student saved = studentRepo.save(student);
        return toResponseDTO(saved);
    }

    @Override
    public UserResponseDTO updateStudent(UserRequestDTO userRequestDTO, Long enrollmentNumber) {
        Student student;
        try {
            student = studentRepo.findByEnrollmentNumber(enrollmentNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        student.setName(userRequestDTO.getName());
        student.setEmail(userRequestDTO.getEmail());
        student.setContactNumber(userRequestDTO.getContactNumber());
        student.setDepartment(userRequestDTO.getDepartment());
        Student updated = studentRepo.save(student);
        return toResponseDTO(updated);
    }

    @Override
    public String deleteStudent(Long enrollmentNumber) {
        Student deleted = studentRepo.findByEnrollmentNumber(enrollmentNumber);
        studentRepo.delete(deleted);
        return "Deleted student with enrollment number " + enrollmentNumber;
    }

    @Override
    public UserResponseDTO getStudent(Long enrollmentNumber) {
        Student student = studentRepo.findByEnrollmentNumber(enrollmentNumber);
        return toResponseDTO(student);
    }
}
