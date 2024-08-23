package com.example.ticketmanager.repository;

import com.example.ticketmanager.model.Bus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Optional<Bus> findByBusNumber(String busNumber);

    @Query("SELECT b FROM Bus b JOIN b.route r LEFT JOIN b.tickets t ON t.bus.id = b.id AND t.date = :date WHERE r.startLocation = :from AND r.destinationLocation = :to GROUP BY b.id HAVING b.capacity - COUNT(t.id) > 0")
    List<Bus> findBusesByRouteAndSeats(@Param("from") String from, @Param("to") String to, @Param("date") LocalDate date);    

    @Query("SELECT DISTINCT b FROM Bus b JOIN b.route r LEFT JOIN b.tickets t ON t.date = :date WHERE r.startLocation = :from AND r.destinationLocation = :to")
    List<Bus> findBusesByRouteAndDate(@Param("from") String from, @Param("to") String to, @Param("date") LocalDate date);    
}