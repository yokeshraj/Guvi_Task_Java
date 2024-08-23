package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.Bus;
import com.example.ticketmanager.model.Route;
import com.example.ticketmanager.service.BusService;
import com.example.ticketmanager.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ticketmanager.dto.BusSearchResponseDTO;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private RouteService routeService;

    // Create a new bus
    @PostMapping("/create")
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus, @RequestParam Long routeId) {
        Optional<Route> route = routeService.getRouteById(routeId);

        if (route.isPresent()) {
            bus.setRoute(route.get());
            Bus newBus = busService.saveBus(bus);
            return new ResponseEntity<>(newBus, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all buses
    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    // Update an existing bus
    @PutMapping("/update/{id}")
    public ResponseEntity<Bus> updateBus(
            @PathVariable Long id,
            @RequestBody Bus busDetails,
            @RequestParam Long routeId) {
        Optional<Bus> existingBus = busService.getBusById(id);
        Optional<Route> route = routeService.getRouteById(routeId);

        if (existingBus.isPresent() && route.isPresent()) {
            Bus bus = existingBus.get();
            bus.setBusNumber(busDetails.getBusNumber());
            bus.setCapacity(busDetails.getCapacity());
            bus.setRoute(route.get());
            bus.setTiming(busDetails.getTiming());
            Bus updatedBus = busService.saveBus(bus);
            return new ResponseEntity<>(updatedBus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a bus
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable Long id) {
        Optional<Bus> bus = busService.getBusById(id);

        if (bus.isPresent()) {
            busService.deleteBus(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<BusSearchResponseDTO>> searchBuses(
            @RequestParam String from,
            @RequestParam String to) {
        List<Bus> buses = busService.findBusesByRouteAndSeats(from, to, null);
    
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        List<BusSearchResponseDTO> response = buses.stream()
            .map(bus -> {
                BusSearchResponseDTO dto = new BusSearchResponseDTO();
                dto.setId(bus.getId());
                dto.setBusNumber(bus.getBusNumber());
                dto.setCapacity(bus.getCapacity());
    
                LocalTime time = bus.getTiming();
                String formattedTime = time.format(timeFormatter);
                dto.setTiming(formattedTime);
    
                BusSearchResponseDTO.RouteDTO routeDTO = new BusSearchResponseDTO.RouteDTO();
                routeDTO.setFrom(bus.getRoute().getStartLocation());
                routeDTO.setTo(bus.getRoute().getDestinationLocation());
                dto.setRoute(routeDTO);
    
                int bookedSeats = (int) bus.getTickets().stream()
                    .count();
                dto.setBookedSeats(bookedSeats);
    
                int availableSeats = bus.getCapacity() - bookedSeats;
                dto.setAvailableSeats(availableSeats);
    
                return dto;
            })
            .filter(dto -> dto != null)
            .collect(Collectors.toList());
    
        return new ResponseEntity<>(response, HttpStatus.OK);
    }    
}