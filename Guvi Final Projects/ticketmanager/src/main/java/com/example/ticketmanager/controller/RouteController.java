package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.Route;
import com.example.ticketmanager.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    // Create a new route
    @PostMapping("/create")
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route newRoute = routeService.saveRoute(route);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

    // Get all routes
    @GetMapping("/all")
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    // Update an existing route
    @PutMapping("/update/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route routeDetails) {
        Optional<Route> existingRoute = routeService.getRouteById(id);

        if (existingRoute.isPresent()) {
            Route route = existingRoute.get();
            route.setStartLocation(routeDetails.getStartLocation());
            route.setDestinationLocation(routeDetails.getDestinationLocation());
            Route updatedRoute = routeService.saveRoute(route);
            return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a route
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable Long id) {
        Optional<Route> route = routeService.getRouteById(id);

        if (route.isPresent()) {
            routeService.deleteRoute(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}