package com.example.Student_Management_API.dtos;

public class UserRequestDTO {

    private Long enrollmentNumber;
    private String name;
    private Long contactNumber;
    private String department;
    private String email;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long enrollmentNumber, String name, Long contactNumber, String department, String email) {
        this.enrollmentNumber = enrollmentNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.department = department;
        this.email = email;
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
        private Long enrollmentNumber;
        private String name;
        private Long contactNumber;
        private String department;
        private String email;

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

        public UserRequestDTO build() {
            return new UserRequestDTO(enrollmentNumber, name, contactNumber, department, email);
        }
    }
}
