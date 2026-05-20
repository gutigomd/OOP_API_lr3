package com.example.library.dto;

public class AuthorDto {
    private Long id;
    private String name;

    // Конструкторы
    public AuthorDto() {}

    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и Сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}