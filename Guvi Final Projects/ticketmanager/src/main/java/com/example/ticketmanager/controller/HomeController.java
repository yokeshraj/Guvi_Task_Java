package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.HomeResponse;
import com.example.ticketmanager.model.User;
import com.example.ticketmanager.security.JwtUtil;
import com.example.ticketmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ResponseEntity<?> homePage(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        if (jwtUtil.isTokenExpired(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            String welcomeMessage = "Welcome, " + user.get().getFirstName();
            HomeResponse response = new HomeResponse(welcomeMessage);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}