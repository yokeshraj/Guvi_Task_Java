package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.PaymentMethod;
import com.example.ticketmanager.model.User;
import com.example.ticketmanager.security.JwtUtil;
import com.example.ticketmanager.service.PaymentMethodService;
import com.example.ticketmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/add")
    public ResponseEntity<?> addPaymentMethod(@RequestHeader("Authorization") String authorizationHeader,
                                            @RequestBody PaymentMethod paymentMethod) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            paymentMethod.setUser(user.get());
            PaymentMethod savedPaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod);
            // Add the payment method to the user's list
            user.get().getPaymentMethods().add(savedPaymentMethod);
            userService.updateUser(user.get());
            return new ResponseEntity<>(savedPaymentMethod, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all payment methods for the logged-in user
    @GetMapping("/all")
    public ResponseEntity<?> getAllPaymentMethods(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            List<PaymentMethod> paymentMethods = paymentMethodService.getPaymentMethodsByUserId(user.get().getId());
            return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update an existing payment method
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePaymentMethod(@RequestHeader("Authorization") String authorizationHeader,
                                                 @PathVariable Long id,
                                                 @RequestBody PaymentMethod updatedPaymentMethod) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            Optional<PaymentMethod> existingPaymentMethod = paymentMethodService.getPaymentMethodById(id);
            if (existingPaymentMethod.isPresent() && existingPaymentMethod.get().getUser().equals(user.get())) {
                PaymentMethod paymentMethod = existingPaymentMethod.get();
                paymentMethod.setCardNumber(updatedPaymentMethod.getCardNumber());
                paymentMethod.setCardHolderName(updatedPaymentMethod.getCardHolderName());
                paymentMethod.setExpiryDate(updatedPaymentMethod.getExpiryDate());
                paymentMethod.setCardType(updatedPaymentMethod.getCardType());

                PaymentMethod savedPaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod);
                return new ResponseEntity<>(savedPaymentMethod, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a payment method
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaymentMethod(@RequestHeader("Authorization") String authorizationHeader,
                                                 @PathVariable Long id) {
        String token = authorizationHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Optional<User> user = userService.findUserByEmail(email);
        if (user.isPresent()) {
            Optional<PaymentMethod> paymentMethod = paymentMethodService.getPaymentMethodById(id);
            if (paymentMethod.isPresent() && paymentMethod.get().getUser().equals(user.get())) {
                paymentMethodService.deletePaymentMethod(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}