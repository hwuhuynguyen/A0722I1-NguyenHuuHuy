package com.example.librarymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String clazz;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Card> cardList;

    public Student() {
    }

    public Student(String id, String name, String clazz, Set<Card> cardList) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Set<Card> getCardList() {
        return cardList;
    }

    public void setCardList(Set<Card> cardList) {
        this.cardList = cardList;
    }
}
