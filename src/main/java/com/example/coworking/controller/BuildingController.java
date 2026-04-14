package com.example.coworking.controller;

import com.example.coworking.model.Building;
import com.example.coworking.repository.BuildingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingRepository buildingRepo;

    public BuildingController(BuildingRepository buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    @PostMapping
    public Building create(@RequestBody Building b) {
        return buildingRepo.save(b);
    }

    @GetMapping
    public List<Building> getAll() {
        return buildingRepo.findAll();
    }
}