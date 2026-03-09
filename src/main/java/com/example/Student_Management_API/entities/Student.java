package com.example.Student_Management_API.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long enrollmentNumber;
    private String name;
    private Long contactNumber;
    private String department;
    private String email;

    public Student() {
    }

    public Student(Long id, Long enrollmentNumber, String name, Long contactNumber, String department, String email) {
        this.id = id;
        this.enrollmentNumber = enrollmentNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.department = department;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(Long enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
