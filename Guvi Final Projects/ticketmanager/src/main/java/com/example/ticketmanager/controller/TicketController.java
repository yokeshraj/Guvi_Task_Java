package com.example.ticketmanager.controller;

import com.example.ticketmanager.dto.TicketDTO;
import com.example.ticketmanager.model.TicketStatus;
import com.example.ticketmanager.model.PaymentStatus;
import com.example.ticketmanager.model.User;
import com.example.ticketmanager.model.Bus;
import com.example.ticketmanager.service.TicketService;
import com.example.ticketmanager.service.UserService;
import com.example.ticketmanager.service.BusService;
import com.example.ticketmanager.service.PaymentMethodService;
import com.example.ticketmanager.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ticketmanager.dto.UserDTO;
import com.example.ticketmanager.model.PaymentMethod;


import java.util.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private BusService busService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<?> createTicket(@RequestHeader("Authorization") String authorizationHeader, 
                                        @RequestBody TicketDTO ticketDTO) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            ticketDTO.setUser(new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()));
            ticketDTO.setTicketStatus(TicketStatus.BOOKED);
            ticketDTO.setPaymentStatus(PaymentStatus.PENDING);
            Optional<Bus> busOptional = busService.findBusByNumber(ticketDTO.getBusNumber());
            if (busOptional.isPresent()) {
                ticketDTO.setBusNumber(busOptional.get().getBusNumber());
            } else {
                return new ResponseEntity<>("Bus not found", HttpStatus.BAD_REQUEST);
            }
            if (ticketDTO.getPaymentMethod() != null) {
                Optional<PaymentMethod> paymentMethodOptional = paymentMethodService.findPaymentMethodById(ticketDTO.getPaymentMethod().getId());
                if (!paymentMethodOptional.isPresent()) {
                    return new ResponseEntity<>("Payment method not found", HttpStatus.BAD_REQUEST);
                }
            }
            if (ticketDTO.getDate() == null) {
                return new ResponseEntity<>("Date is required", HttpStatus.BAD_REQUEST);
            }
            List<TicketDTO> savedTicketsDTO = ticketService.saveTicket(ticketDTO);
            return new ResponseEntity<>(savedTicketsDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@RequestHeader("Authorization") String authorizationHeader, 
                                       @PathVariable Long id) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            Optional<TicketDTO> ticketOptional = ticketService.getTicketById(id);
            if (ticketOptional.isPresent() && ticketOptional.get().getUser().getEmail().equals(email)) {
                return new ResponseEntity<>(ticketOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateTicketStatus(@RequestHeader("Authorization") String authorizationHeader, 
                                                @PathVariable Long id,
                                                @RequestParam(required = false) TicketStatus ticketStatus,
                                                @RequestParam(required = false) PaymentStatus paymentStatus) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            Optional<TicketDTO> ticketOptional = ticketService.getTicketById(id);
            if (ticketOptional.isPresent() && ticketOptional.get().getUser().getEmail().equals(email)) {
                TicketDTO ticketDTO = ticketOptional.get();

                if (ticketStatus != null) {
                    ticketDTO.setTicketStatus(ticketStatus);
                }

                if (paymentStatus != null) {
                    ticketDTO.setPaymentStatus(paymentStatus);
                }

                List<TicketDTO> updatedTicketsDTO = ticketService.saveTicket(ticketDTO);
                return new ResponseEntity<>(updatedTicketsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user-tickets")
    public ResponseEntity<?> getAllTicketsByUser(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            List<TicketDTO> tickets = ticketService.getTicketsByUserEmail(userOptional.get().getEmail());
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}