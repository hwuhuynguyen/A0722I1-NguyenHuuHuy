package com.example.finaltest.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    private String id;
    private String name;
    private String field;
    private String phoneNumber;
    private String email;
    private String address;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Project> projectList;

    public Company() {
    }

    public Company(String id, String name, String field, String phoneNumber, String email, String address, Set<Project> projectList) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.projectList = projectList;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<Project> projectList) {
        this.projectList = projectList;
    }
}
