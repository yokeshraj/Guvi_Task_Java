package com.example.patientmanager.controller;

import com.example.patientmanager.dto.AppointmentDTO;
import com.example.patientmanager.model.Appointment;
// import com.example.patientmanager.model.HomeResponse;
// import com.example.patientmanager.model.LoginResponse;
import com.example.patientmanager.model.Medication;
// import com.example.patientmanager.model.RegisterResponse;
import com.example.patientmanager.model.User;
import com.example.patientmanager.security.JwtUtil;
import com.example.patientmanager.service.MedicationService;
import com.example.patientmanager.service.AppointmentService;
import com.example.patientmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import jakarta.servlet.http.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private JwtUtil jwtUtil;
    
    // Web Handlers //

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password,HttpSession session ,Model model) {
        Optional<User> existingUser = userService.findUserByEmail(email);

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(password)) {
            String token = jwtUtil.generateToken(email);
            model.addAttribute("token", token);
            System.out.println("Token Generated is " + token);
            session.setAttribute("token", token);
            model.addAttribute("user", existingUser.get());
            return "home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> existingUser = userService.findUserByEmail(email);

        if (existingUser.isPresent()) {
            model.addAttribute("error", "User already registered with us");
            return "register";
        }

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        userService.registerUser(newUser);
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");

        if (token == null || jwtUtil.isTokenExpired(token)) {
            return "login";
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> user = userService.findUserByEmail(email);

        if (user.isPresent()) {
            Long userId = user.get().getId();
            List<Medication> medications = medicationService.getMedicationsByUserId(userId);
            List<Appointment> appointments = appointmentService.getAppointmentsByUserId(userId);
            // Define the DateTimeFormatter for your desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            // Map the appointments to DTOs with formatted date
            List<AppointmentDTO> appointmentDTOs = appointments.stream()
                .map(app -> new AppointmentDTO(
                    app.getId(),
                    app.getDateTime().format(formatter),
                    app.getDoctorName()
                ))
                .collect(Collectors.toList());
            model.addAttribute("user", user.get());
            model.addAttribute("medications", medications);
            model.addAttribute("appointments", appointmentDTOs);
            return "home";
        } else {
            return "login";
        }
    }

    @GetMapping("/medications/add")
    public String showAddMedicationPage() {
        return "add-medication";
    }

    @PostMapping("/medications/add")
    public String addMedication(
            @RequestParam String name,
            @RequestParam String dosage,
            @RequestParam String frequency,
            @RequestParam String token,
            Model model) {

        if (jwtUtil.isTokenExpired(token)) {
            return "login"; 
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> user = userService.findUserByEmail(email);

        if (user.isPresent()) {
            Medication medication = new Medication();
            medication.setName(name);
            medication.setDosage(dosage);
            medication.setFrequency(frequency);
            medication.setUserId(user.get().getId());
            medicationService.saveMedication(medication);
            return "redirect:/api/users/home";
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }

    @GetMapping("/appointments/add")
    public String showAddAppointmentPage() {
        return "add-appointment";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String doctorName,
            @RequestParam String token,
            Model model) {

        if (jwtUtil.isTokenExpired(token)) {
            return "login"; 
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> user = userService.findUserByEmail(email);

        if (user.isPresent()) {
            LocalDate appointmentDate = LocalDate.parse(date);
            LocalTime appointmentTime = LocalTime.parse(time);
            LocalDateTime dateTime = LocalDateTime.of(appointmentDate, appointmentTime);

            Appointment appointment = new Appointment();
            appointment.setDateTime(dateTime);
            appointment.setDoctorName(doctorName);
            appointment.setUserId(user.get().getId());
            appointmentService.saveAppointment(appointment);
            return "redirect:/api/users/home";
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }

    @PostMapping("/medications/update/{id}")
    public String updateMedication(
            @PathVariable("id") Long id,
            @RequestParam String name,
            @RequestParam String dosage,
            @RequestParam String frequency,
            @RequestParam String token,
            Model model) {

        if (jwtUtil.isTokenExpired(token)) {
            return "login"; 
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> user = userService.findUserByEmail(email);

        if (user.isPresent()) {
            Optional<Medication> existingMedication = medicationService.findById(id);
            if (existingMedication.isPresent()) {
                Medication medication = existingMedication.get();
                medication.setName(name);
                medication.setDosage(dosage);
                medication.setFrequency(frequency);
                medicationService.saveMedication(medication);
                return "redirect:/api/users/home";
            } else {
                model.addAttribute("error", "Medication not found");
                return "redirect:/api/users/home";
            }
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }

    @GetMapping("/medications/edit/{id}")
    public String editMedication(@PathVariable("id") Long id, Model model) {
        Optional<Medication> medication = medicationService.findById(id);
        if (medication.isPresent()) {
            model.addAttribute("medication", medication.get());
            return "edit-medication";
        }
        return "redirect:/home";
    }

    @GetMapping("/medications/delete/{id}")
    public String deleteMedication(@PathVariable("id") Long id) {
        medicationService.deleteMedication(id);
        return "redirect:/api/users/home";
    }

    @GetMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/api/users/home";
    }

}