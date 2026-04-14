package com.example.coworking.repository;

import com.example.coworking.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    List<Workspace> findByBuildingId(Long buildingId);
    List<Workspace> findByNameContainingIgnoreCase(String query);
}