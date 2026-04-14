package com.example.coworking.controller;

import com.example.coworking.model.Workspace;
import com.example.coworking.model.WorkspaceType;
import com.example.coworking.repository.WorkspaceRepository;
import com.example.coworking.repository.WorkspaceTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceRepository wsRepo;
    private final WorkspaceTypeRepository typeRepo;

    // Вручную созданный конструктор для внедрения зависимостей (DI)
    public WorkspaceController(WorkspaceRepository wsRepo, WorkspaceTypeRepository typeRepo) {
        this.wsRepo = wsRepo;
        this.typeRepo = typeRepo;
    }

    @PostMapping
    public Workspace create(@RequestBody Workspace w) {
        return wsRepo.save(w);
    }

    @GetMapping
    public List<Workspace> getAll() {
        return wsRepo.findAll();
    }

    @GetMapping("/{id}")
    public Workspace getById(@PathVariable Long id) {
        return wsRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Workspace update(@PathVariable Long id, @RequestBody Workspace details) {
        Workspace ws = wsRepo.findById(id).orElseThrow();
        ws.setName(details.getName());
        ws.setFloor(details.getFloor());
        ws.setCapacity(details.getCapacity());
        return wsRepo.save(ws);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wsRepo.deleteById(id);
    }

    @GetMapping("/building/{buildingId}")
    public List<Workspace> getByBuilding(@PathVariable Long buildingId) {
        return wsRepo.findByBuildingId(buildingId);
    }

    @PostMapping("/{id}/types/{typeId}")
    public Workspace addType(@PathVariable Long id, @PathVariable Long typeId) {
        Workspace ws = wsRepo.findById(id).orElseThrow();
        WorkspaceType wt = typeRepo.findById(typeId).orElseThrow();
        ws.getTypes().add(wt);
        return wsRepo.save(ws);
    }

    @DeleteMapping("/{id}/types/{typeId}")
    public Workspace removeType(@PathVariable Long id, @PathVariable Long typeId) {
        Workspace ws = wsRepo.findById(id).orElseThrow();
        WorkspaceType wt = typeRepo.findById(typeId).orElseThrow();
        ws.getTypes().remove(wt);
        return wsRepo.save(ws);
    }
}