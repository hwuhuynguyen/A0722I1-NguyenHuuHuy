package com.example.librarymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private boolean status;
    @NotNull(message = "Vui long nhap ngay muon sach")
    private Date startedDate;
    @NotNull(message = "Vui long nhap ngay tra sach")
    private Date endDate;

    public Card() {
    }

    public Card(String id, Book book, Student student, boolean status, Date startedDate, Date endDate) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.startedDate = startedDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", student=" + student +
                ", status=" + status +
                ", startedDate=" + startedDate +
                ", endDate=" + endDate +
                '}';
    }
}
