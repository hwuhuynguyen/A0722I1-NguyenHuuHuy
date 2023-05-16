package com.example.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String author;
    private String description;
    private int quantity;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Card> cardList;

    public Book() {
    }

    public Book(String id, String name, String author, String description, int quantity, Set<Card> cardList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
        this.cardList = cardList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Card> getCardList() {
        return cardList;
    }

    public void setCardList(Set<Card> cardList) {
        this.cardList = cardList;
    }
}
