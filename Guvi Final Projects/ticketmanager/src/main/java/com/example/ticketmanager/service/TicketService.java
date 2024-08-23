package com.example.ticketmanager.service;

import com.example.ticketmanager.dto.TicketDTO;
import com.example.ticketmanager.dto.PaymentMethodDTO;
import com.example.ticketmanager.model.*;
import com.example.ticketmanager.repository.TicketRepository;
import com.example.ticketmanager.repository.UserRepository;
import com.example.ticketmanager.repository.BusRepository;
import com.example.ticketmanager.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketmanager.dto.UserDTO;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<TicketDTO> getTicketsByUserEmail(String email) {
        List<Ticket> tickets = ticketRepository.findByUserEmail(email);
        return tickets.stream()
                      .map(this::mapToDTO)
                      .collect(Collectors.toList());
    }

    public List<TicketDTO> saveTicket(TicketDTO ticketDTO) {
        String ticketNumber = generateTicketNumber();
        String[] seats = ticketDTO.getSeatNumbers().split(",\\s*");

        List<Ticket> savedTickets = new ArrayList<>();
        for (String seat : seats) {
            Ticket ticket = new Ticket();
            ticket.setSeatNumbers(seat);
            ticket.setTicketStatus(ticketDTO.getTicketStatus());
            ticket.setPaymentStatus(ticketDTO.getPaymentStatus());
            ticket.setTicketNumber(ticketNumber);

            ticket.setDate(ticketDTO.getDate());

            if (ticketDTO.getUser() != null) {
                Optional<User> userOptional = userRepository.findById(ticketDTO.getUser().getId());
                userOptional.ifPresent(ticket::setUser);
            }

            if (ticketDTO.getBusNumber() != null) {
                Optional<Bus> busOptional = busRepository.findByBusNumber(ticketDTO.getBusNumber());
                busOptional.ifPresent(ticket::setBus);
            }

            if (ticketDTO.getPaymentMethod() != null) {
                Optional<PaymentMethod> paymentMethodOptional = paymentMethodRepository.findById(ticketDTO.getPaymentMethod().getId());
                paymentMethodOptional.ifPresent(ticket::setPaymentMethod);
            }

            Ticket savedTicket = ticketRepository.save(ticket);
            savedTickets.add(savedTicket);
        }

        return savedTickets.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<TicketDTO> getTicketById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.map(this::mapToDTO);
    }

    private TicketDTO mapToDTO(Ticket ticket) {
        UserDTO userDTO = null;
        if (ticket.getUser() != null) {
            userDTO = new UserDTO(
                ticket.getUser().getId(),
                ticket.getUser().getFirstName(),
                ticket.getUser().getLastName(),
                ticket.getUser().getEmail()
            );
        }
    
        PaymentMethodDTO paymentMethodDTO = null;
        if (ticket.getPaymentMethod() != null) {
            paymentMethodDTO = new PaymentMethodDTO(
                ticket.getPaymentMethod().getId(),
                ticket.getPaymentMethod().getCardNumber(),
                ticket.getPaymentMethod().getCardHolderName(),
                ticket.getPaymentMethod().getExpiryDate(),
                ticket.getPaymentMethod().getCardType()
            );
        }
    
        return new TicketDTO(
            ticket.getId(),
            ticket.getBus() != null ? ticket.getBus().getBusNumber() : null,
            ticket.getSeatNumbers(),
            userDTO,
            ticket.getTicketStatus(),
            ticket.getPaymentStatus(),
            paymentMethodDTO,
            ticket.getTicketNumber(),
            ticket.getDate()
        );
    }    

    private String generateTicketNumber() {
        return "TICKET-" + System.currentTimeMillis();
    }

    public List<TicketDTO> getTicketsByTicketNumber(String ticketNumber) {
        List<Ticket> tickets = ticketRepository.findByTicketNumber(ticketNumber);
        return tickets.stream()
                      .map(this::mapToDTO)
                      .collect(Collectors.toList());
    }
}