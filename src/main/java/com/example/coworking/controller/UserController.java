package com.example.coworking.controller;

import com.example.coworking.model.User;
import com.example.coworking.model.Reservation;
import com.example.coworking.repository.UserRepository;
import com.example.coworking.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepo;
    private final ReservationRepository resRepo;

    // Конструктор вручную
    public UserController(UserRepository userRepo, ReservationRepository resRepo) {
        this.userRepo = userRepo;
        this.resRepo = resRepo;
    }

    @PostMapping
    public User create(@RequestBody User u) {
        return userRepo.save(u);
    }

    @GetMapping("/{id}/reservations")
    public List<Reservation> getReservations(@PathVariable Long id) {
        return resRepo.findByUserId(id);
    }
}