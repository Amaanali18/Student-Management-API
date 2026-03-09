package com.example.Student_Management_API.controllers;

import com.example.Student_Management_API.dtos.UserRequestDTO;
import com.example.Student_Management_API.dtos.UserResponseDTO;
import com.example.Student_Management_API.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MainController {

    private final StudentService service;

    public MainController(StudentService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<String> loadingBackend() {
        return new ResponseEntity<>("Backend is Connected", HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserResponseDTO>> getAllStudents() {
        List<UserResponseDTO> data = service.getAllStudents();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("{enrollmentNumber}")
    public ResponseEntity<UserResponseDTO> getStudent(@PathVariable Long enrollmentNumber) {
        UserResponseDTO data = service.getStudent(enrollmentNumber);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<UserResponseDTO> createStudent(@RequestBody UserRequestDTO student) {
        UserResponseDTO saved = service.createStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("{enrollmentNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long enrollmentNumber) {
        String deleted = service.deleteStudent(enrollmentNumber);
        return new ResponseEntity<>(deleted, HttpStatus.ACCEPTED);
    }

    @PutMapping("{enrollmentNumber}")
    public ResponseEntity<UserResponseDTO> updateStudent(
            @PathVariable Long enrollmentNumber,
            @RequestBody UserRequestDTO student) {
        UserResponseDTO updated = service.updateStudent(student, enrollmentNumber);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
