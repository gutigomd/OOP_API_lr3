package com.example.coworking.controller;

import com.example.coworking.model.WorkspaceType;
import com.example.coworking.repository.WorkspaceTypeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/workspace-types") // Вот этот адрес искал Postman
public class WorkspaceTypeController {

    private final WorkspaceTypeRepository typeRepo;

    public WorkspaceTypeController(WorkspaceTypeRepository typeRepo) {
        this.typeRepo = typeRepo;
    }

    @PostMapping
    public WorkspaceType create(@RequestBody WorkspaceType type) {
        return typeRepo.save(type);
    }

    @GetMapping
    public List<WorkspaceType> getAll() {
        return typeRepo.findAll();
    }
}