package com.example.ticketmanager.dto;

import com.example.ticketmanager.model.TicketStatus;

import java.time.LocalDate;

import com.example.ticketmanager.model.PaymentStatus;

public class TicketDTO {
    private Long id;
    private String busNumber;
    private String seatNumbers;
    private UserDTO user;
    private TicketStatus ticketStatus;
    private PaymentStatus paymentStatus;
    private PaymentMethodDTO paymentMethod;
    private String ticketNumber;
    private LocalDate date;

    public TicketDTO() {}
    public TicketDTO(Long id, String busNumber, String seatNumbers, UserDTO user, TicketStatus ticketStatus, PaymentStatus paymentStatus, PaymentMethodDTO paymentMethod, String ticketNumber, LocalDate date) {
        this.id = id;
        this.busNumber = busNumber;
        this.seatNumbers = seatNumbers;
        this.user = user;
        this.ticketStatus = ticketStatus;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.ticketNumber = ticketNumber;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}