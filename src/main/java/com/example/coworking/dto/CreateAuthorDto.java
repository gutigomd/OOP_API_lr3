package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuthorDto {
    @NotBlank(message = "Имя автора не может быть пустым")
    @Size(min = 2, max = 100, message = "Имя автора должно быть от 2 до 100 символов")
    private String name;

    // Геттеры и Сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}