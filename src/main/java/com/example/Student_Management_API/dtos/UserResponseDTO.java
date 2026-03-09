package com.example.Student_Management_API.dtos;

public class UserResponseDTO {

    private Long id;
    private Long enrollmentNumber;
    private String name;
    private Long contactNumber;
    private String department;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, Long enrollmentNumber, String name, Long contactNumber, String department, String email) {
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long enrollmentNumber;
        private String name;
        private Long contactNumber;
        private String department;
        private String email;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder enrollmentNumber(Long e) {
            this.enrollmentNumber = e;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder contactNumber(Long c) {
            this.contactNumber = c;
            return this;
        }

        public Builder department(String d) {
            this.department = d;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserResponseDTO build() {
            return new UserResponseDTO(id, enrollmentNumber, name, contactNumber, department, email);
        }
    }
}
