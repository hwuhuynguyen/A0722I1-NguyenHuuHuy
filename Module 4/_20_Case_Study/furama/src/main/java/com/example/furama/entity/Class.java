package com.example.furama.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Class {
    @Id
    private String classCode;
    private String className;

    @JsonBackReference
    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Class() {
    }

    public Class(String classCode, String className, Set<Student> students) {
        this.classCode = classCode;
        this.className = className;
        this.students = students;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "classCode='" + classCode + '\'' +
                ", className='" + className + '\'' +
                ", students=" + students +
                '}';
    }
}
