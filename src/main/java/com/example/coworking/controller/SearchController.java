package com.example.coworking.controller;

import com.example.coworking.model.User;
import com.example.coworking.model.Workspace;
import com.example.coworking.repository.UserRepository;
import com.example.coworking.repository.WorkspaceRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final WorkspaceRepository wsRepo;
    private final UserRepository userRepo;

    public SearchController(WorkspaceRepository wsRepo, UserRepository userRepo) {
        this.wsRepo = wsRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/workspaces")
    public List<Workspace> searchWorkspaces(@RequestParam String query) {
        return wsRepo.findByNameContainingIgnoreCase(query);
    }

    @GetMapping("/users")
    public List<User> searchUsers(@RequestParam String query) {
        return userRepo.findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase(query, query);
    }
}