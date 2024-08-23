package com.example.ticketmanager.service;

import com.example.ticketmanager.dto.BusSearchResponseDTO;
import com.example.ticketmanager.model.Bus;
import com.example.ticketmanager.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    public List<Bus> findBusesByRouteAndSeats(String from, String to, String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return busRepository.findBusesByRouteAndSeats(from, to, localDate);
    }
    
    public ResponseEntity<List<BusSearchResponseDTO>> searchBuses(String from, String to, String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    
        List<Bus> buses = busRepository.findBusesByRouteAndDate(from, to, localDate);
    
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
                    .filter(ticket -> ticket.getDate().equals(localDate))
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

    public Optional<Bus> findBusByNumber(String busNumber) {
        return busRepository.findByBusNumber(busNumber);
    }
}