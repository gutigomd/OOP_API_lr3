package com.example.coworking.controller;

import com.example.coworking.model.Reservation;
import com.example.coworking.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository resRepo;

    // Конструктор вручную вместо Lombok
    public ReservationController(ReservationRepository resRepo) {
        this.resRepo = resRepo;
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation r) {
        r.setStatus("ACTIVE");
        return resRepo.save(r);
    }

    @GetMapping("/active")
    public List<Reservation> getActive() {
        return resRepo.findByStatus("ACTIVE");
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        Reservation r = resRepo.findById(id).orElseThrow();
        r.setStatus("CANCELLED");
        resRepo.save(r);
    }
}