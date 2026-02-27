package com.example.Student_Management_API.controllers;

import com.example.Student_Management_API.entities.Student;
import com.example.Student_Management_API.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<String> loadingBackend(){
        return new ResponseEntity<>("Backend is Connected",HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> data = service.getAllStudents();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("{enrollmentNumber}")
    public ResponseEntity<Student> getStudent(@PathVariable Long enrollmentNumber) {
        Student data = service.getStudent(enrollmentNumber);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saved = service.createStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @DeleteMapping("{enrollmentNumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long enrollmentNumber){
        String deleted = service.deleteStudent(enrollmentNumber);
        return new ResponseEntity<>(deleted,HttpStatus.ACCEPTED);
    }
    @PutMapping("{enrollmentNumber}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long enrollmentNumber, @RequestBody Student student){
        Student updated = service.updateStudent(student, enrollmentNumber);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
