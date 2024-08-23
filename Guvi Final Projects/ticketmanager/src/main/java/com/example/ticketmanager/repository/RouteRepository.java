package com.example.ticketmanager.repository;

import com.example.ticketmanager.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}