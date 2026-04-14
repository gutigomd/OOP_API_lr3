package com.example.coworking.controller;

import com.example.coworking.repository.WorkspaceRepository;
import com.example.coworking.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final WorkspaceRepository wsRepo;
    private final UserRepository userRepo;

    public AnalyticsController(WorkspaceRepository wsRepo, UserRepository userRepo) {
        this.wsRepo = wsRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/workspaces/count")
    public long countWs() {
        return wsRepo.count();
    }

    @GetMapping("/users/count")
    public long countUsers() {
        return userRepo.count();
    }
}