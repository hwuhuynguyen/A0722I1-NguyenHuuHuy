package com.example.finaltest.service.project;

import com.example.finaltest.entity.Project;
import com.example.finaltest.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void removeById(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Iterable<Project> searchByRegisterDateAndProjectName(Date startedDate, Date endDate, String name) {
        return projectRepository.searchByRegisterDateAndProjectName(startedDate, endDate, name);
    }
}
