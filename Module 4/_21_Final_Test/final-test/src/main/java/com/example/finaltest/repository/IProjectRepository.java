package com.example.finaltest.repository;

import com.example.finaltest.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IProjectRepository extends JpaRepository<Project, String> {
    @Query("select p from Project p where lower(p.name) like lower(concat('%', :name, '%')) and (p.registerDate between :startedDate and :endDate) ")
    Iterable<Project> searchByRegisterDateAndProjectName(Date startedDate, Date endDate, String name);
}
