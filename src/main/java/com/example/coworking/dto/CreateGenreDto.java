package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateGenreDto {
    @NotBlank(message = "Название жанра не может быть пустым")
    @Size(min = 3, max = 50, message = "Название жанра должно быть от 3 до 50 символов")
    private String name;

    // Геттеры и Сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}