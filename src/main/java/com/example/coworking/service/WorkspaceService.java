package com.example.coworking.service;

import com.example.coworking.model.Workspace;
import com.example.coworking.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    // Конструктор вместо @RequiredArgsConstructor
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<Workspace> findByName(String query) {
        return workspaceRepository.findByNameContainingIgnoreCase(query);
    }

    public List<Workspace> getAll() {
        return workspaceRepository.findAll();
    }
}