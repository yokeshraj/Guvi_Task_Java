package com.example.ticketmanager.repository;

import com.example.ticketmanager.model.Ticket;
import com.example.ticketmanager.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByTicketStatus(TicketStatus ticketStatus);
    List<Ticket> findByUserIdAndTicketStatus(Long userId, TicketStatus ticketStatus);
    List<Ticket> findByTicketNumber(String ticketNumber);
    List<Ticket> findByUserEmail(String email);
}