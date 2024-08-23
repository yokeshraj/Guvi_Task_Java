package com.example.ticketmanager.controller;

import com.example.ticketmanager.dto.BusSearchResponseDTO;
import com.example.ticketmanager.dto.TicketDTO;
import com.example.ticketmanager.model.PaymentMethod;
import com.example.ticketmanager.model.User;
import com.example.ticketmanager.security.JwtUtil;
import com.example.ticketmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ticketmanager.service.BusService;
import com.example.ticketmanager.service.TicketService;

import jakarta.servlet.http.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BusService busService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        Optional<User> existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            model.addAttribute("error", "User already registered");
            return "register";
        }
        userService.registerUser(user);
        model.addAttribute("success", "Registration successful, please login");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> existingUser = userService.findUserByEmail(email);

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(password)) {
            String token = jwtUtil.generateToken(email);
            session.setAttribute("token", token);
            model.addAttribute("user", existingUser.get());
            System.out.println("Generated Token is " + token);
            return "redirect:/user/home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> user = userService.findUserByEmail(email);
            if (user.isPresent()) {
                model.addAttribute("username", user.get().getFirstName());
                return "home";
            }
        }
        return "redirect:/user/login";
    }

    @GetMapping("/profile")
    public String getUserProfile(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> user = userService.findUserByEmail(email);
            if (user.isPresent()) {
                model.addAttribute("user", user.get());
                System.out.println( " querried User Details " + user);
                return "profile";
            }
        }
        return "redirect:/user/login";
    }

    @PostMapping("/profile/update")
    public String updateUserProfile(HttpSession session,
                                    @RequestParam("token") String token,
                                    @ModelAttribute User user,
                                    Model model) {
        if (jwtUtil.isTokenExpired(token)) {
            return "redirect:/user/login";
        }

        String emailFromToken = jwtUtil.extractUsername(token);
        Optional<User> existingUser = userService.findUserByEmail(emailFromToken);
        if (existingUser.isPresent()) {
            User currentUser = existingUser.get();
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setEmail(user.getEmail());
            userService.updateUser(currentUser);
            model.addAttribute("user", currentUser);
            return "redirect:/user/profile";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/add-payment")
    public String showAddPaymentMethodForm(Model model, HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null || jwtUtil.isTokenExpired(token)) {
            return "redirect:/user/login";
        }
        model.addAttribute("paymentMethod", new PaymentMethod());
        return "add-payment";
    }

    @PostMapping("/add-payment")
    public String addPaymentMethod(HttpSession session, @ModelAttribute PaymentMethod paymentMethod) {
        String token = (String) session.getAttribute("token");
        if (token == null || jwtUtil.isTokenExpired(token)) {
            return "redirect:/user/login";
        }
        
        String email = jwtUtil.extractUsername(token);
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            paymentMethod.setUser(user);
            user.getPaymentMethods().add(paymentMethod);
            userService.updateUser(user);
        }
        return "redirect:/user/profile";
    }

    @GetMapping("/edit-payment/{paymentMethodId}")
    public String showEditPaymentMethodForm(@PathVariable Long paymentMethodId, Model model, HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null || jwtUtil.isTokenExpired(token)) {
            return "redirect:/user/login";
        }

        String email = jwtUtil.extractUsername(token);
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            PaymentMethod paymentMethod = user.getPaymentMethods().stream()
                    .filter(pm -> pm.getId().equals(paymentMethodId))
                    .findFirst()
                    .orElse(null);

            if (paymentMethod != null) {
                model.addAttribute("paymentMethod", paymentMethod);
                return "edit-payment";
            }
        }
        return "redirect:/user/profile";
    }

    @PostMapping("/update-payment")
    public String updatePaymentMethod(HttpSession session, @ModelAttribute PaymentMethod paymentMethod) {
        String token = (String) session.getAttribute("token");
        if (token == null || jwtUtil.isTokenExpired(token)) {
            return "redirect:/user/login";
        }
        String email = jwtUtil.extractUsername(token);
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<PaymentMethod> existingPaymentMethod = user.getPaymentMethods().stream()
                    .filter(pm -> pm.getId().equals(paymentMethod.getId()))
                    .findFirst();
            if (existingPaymentMethod.isPresent()) {
                PaymentMethod pm = existingPaymentMethod.get();
                pm.setCardType(paymentMethod.getCardType());
                pm.setCardNumber(paymentMethod.getCardNumber());
                pm.setCardHolderName(paymentMethod.getCardHolderName());
                pm.setExpiryDate(paymentMethod.getExpiryDate());
                userService.updateUser(user);
            }
        }
        return "redirect:/user/profile";
    }

    @GetMapping("/delete-payment/{id}")
    public String deletePaymentMethod(@PathVariable Long id, HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null || jwtUtil.isTokenExpired(token)) { return "redirect:/user/login";}
        String email = jwtUtil.extractUsername(token);
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            PaymentMethod paymentMethodToDelete = user.getPaymentMethods().stream()
                    .filter(paymentMethod -> paymentMethod.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (paymentMethodToDelete != null) {
                user.getPaymentMethods().remove(paymentMethodToDelete);
                userService.updateUser(user);
            }
        }
        return "redirect:/user/profile";
    }

    @GetMapping("/show-bus")
    public String showAvailableBusPage(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date,
            @RequestParam int adultMale,
            @RequestParam int adultFemale,
            @RequestParam int maleChild,
            @RequestParam int femaleChild,
            HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> user = userService.findUserByEmail(email);
            if (user.isPresent()) {
                model.addAttribute("username", user.get().getFirstName());
                int totalPassengers = adultMale + adultFemale + maleChild + femaleChild;
                model.addAttribute("totalPassengers", totalPassengers);

                ResponseEntity<List<BusSearchResponseDTO>> response = busService.searchBuses(from, to, date);
                List<BusSearchResponseDTO> buses = response.getBody();
                model.addAttribute("buses", buses);
                model.addAttribute("from", from);
                model.addAttribute("to", to);
                model.addAttribute("date", date);

                return "show-bus";
            }
        }
        return "redirect:/user/login";
    }

    @GetMapping("/book-ticket/{busNumber}/{date}")
    public String bookTicket(
            @PathVariable String busNumber,
            @PathVariable String date,
            HttpSession session,
            Model model) {
        String token = (String) session.getAttribute("token");

        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> user = userService.findUserByEmail(email);

            if (user.isPresent()) {
                model.addAttribute("busNumber", busNumber);
                model.addAttribute("bookingDate", date);
                model.addAttribute("paymentMethods", user.get().getPaymentMethods());
                return "seating";
            }
        }
        return "redirect:/user/login";
    }

    @GetMapping("/book-confirm")
    public String showConfirmedBookTicket(
            @RequestParam("ticketNumber") String ticketNumber,
            HttpSession session,
            Model model) {
        String token = (String) session.getAttribute("token");

        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> user = userService.findUserByEmail(email);

            if (user.isPresent()) {
                List<TicketDTO> tickets = ticketService.getTicketsByTicketNumber(ticketNumber);
                Map<String, List<TicketDTO>> groupedTickets = tickets.stream()
                        .collect(Collectors.groupingBy(TicketDTO::getTicketNumber));

                model.addAttribute("groupedTickets", groupedTickets);
                model.addAttribute("user", user.get());

                return "show-ticket";
            }
        }
        return "redirect:/user/login";
    }

    @GetMapping("/booking-history")
    public String showBookingHistoryPage(HttpSession session, Model model) {
        String token = (String) session.getAttribute("token");
        if (token != null && jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractUsername(token);
            Optional<User> userOptional = userService.findUserByEmail(email);
            
            if (userOptional.isPresent()) {
                List<TicketDTO> tickets = ticketService.getTicketsByUserEmail(email);
                Map<String, List<TicketDTO>> groupedTickets = tickets.stream()
                    .collect(Collectors.groupingBy(TicketDTO::getTicketNumber));
                model.addAttribute("groupedTickets", groupedTickets);
                return "bookinghistory";
            } else {
                return "redirect:/user/login";
            }
        }
        return "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}