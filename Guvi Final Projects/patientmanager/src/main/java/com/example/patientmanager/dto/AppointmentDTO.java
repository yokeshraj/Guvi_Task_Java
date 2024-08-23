// AppointmentDTO.java
package com.example.patientmanager.dto;

public class AppointmentDTO {
    private Long id;
    private String time; // Formatted time
    private String doctorName;

    // Default constructor
    public AppointmentDTO() {
    }

    // Parameterized constructor
    public AppointmentDTO(Long id, String time, String doctorName) {
        this.id = id;
        this.time = time;
        this.doctorName = doctorName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}