package com.example.demo.model;

import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private int stock;

    public Book(String title, String description, int stock) {
        this.title = title;
        this.description = description;
        this.stock = stock;
    }

    public Book() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "This book is titled '" + title + "' with ID: " + id + ". Description: " + description + ". Currently, there are " + stock + " copies in stock.";
    }
}