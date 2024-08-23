package com.example.ticketmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String token;
    private String message;

    // Add this constructor to match the usage in the UserController
    public LoginResponse(String firstName, String lastName, String email, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
        this.message = null;
    }
}