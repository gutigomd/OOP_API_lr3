package com.example.library.dto;

public class BookDto {
    private Long id;
    private String title;
    private String authorName;
    private String genreName;

    // Конструкторы
    public BookDto() {}

    public BookDto(Long id, String title, String authorName, String genreName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.genreName = genreName;
    }

    // Геттеры и Сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getGenreName() { return genreName; }
    public void setGenreName(String genreName) { this.genreName = genreName; }
}