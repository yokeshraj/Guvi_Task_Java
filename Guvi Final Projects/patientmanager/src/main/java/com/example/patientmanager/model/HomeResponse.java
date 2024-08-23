package com.example.patientmanager.model;

import java.util.List;

public class HomeResponse {

    private String welcomeMessage;
    private List<Medication> medications;
    private List<Appointment> appointments;

    public HomeResponse(String welcomeMessage, List<Medication> medications, List<Appointment> appointments) {
        this.welcomeMessage = welcomeMessage;
        this.medications = medications;
        this.appointments = appointments;
    }

    // Getters and setters

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}