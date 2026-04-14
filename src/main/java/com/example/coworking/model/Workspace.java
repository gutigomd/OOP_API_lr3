package com.example.coworking.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer floor;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToMany
    @JoinTable(name = "workspace_to_types",
            joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<WorkspaceType> types;

    public Workspace() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Set<WorkspaceType> getTypes() { return types; }
    public void setTypes(Set<WorkspaceType> types) { this.types = types; }
}