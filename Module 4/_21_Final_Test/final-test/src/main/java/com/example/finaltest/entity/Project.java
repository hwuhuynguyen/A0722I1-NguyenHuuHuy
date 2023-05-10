package com.example.finaltest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Table(name = "project")
public class Project {
    @Id
    private String id;

    @NotBlank(message = "Vui long nhap ten du an!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Min(value = 30000000, message = "Kinh phi toi thieu phai la 30.000.000 VND")
    private long budget;

    @NotBlank(message = "Vui long nhap mo ta")
    private String description;

    @Min(value = 1, message = "Thoi gian dang ky gioi thieu phai lon hon hoac bang 1")
    @Max(value = 12, message = "Thoi gian dang ky gioi thieu phai nho hon hoac bang 12")
    private int month;

    @NotNull(message = "Vui long nhap ngay dang ky")
    private Date registerDate;

    private long cost;

    public Project() {
    }

    public Project(String id, String name, Company company, long budget, String description, int month, Date registerDate, long cost) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.budget = budget;
        this.description = description;
        this.month = month;
        this.registerDate = registerDate;
        this.cost = cost;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", budget=" + budget +
                ", description='" + description + '\'' +
                ", month=" + month +
                ", registerDate=" + registerDate +
                ", cost=" + cost +
                '}';
    }
}
