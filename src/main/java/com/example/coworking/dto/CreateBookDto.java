package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBookDto {
    @NotBlank(message = "Название книги не может быть пустым")
    @Size(min = 1, max = 255, message = "Название книги слишком длинное или короткое")
    private String title;

    @NotNull(message = "ID автора обязателен")
    private Long authorId;

    @NotNull(message = "ID жанра обязателен")
    private Long genreId;

    // Геттеры и Сеттеры
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }
}