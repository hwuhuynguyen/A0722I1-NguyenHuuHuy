package com.example.finaltest.service.project;

import com.example.finaltest.entity.Project;
import com.example.finaltest.service.IGeneralService;

import java.util.Date;

public interface IProjectService extends IGeneralService<Project> {
    Iterable<Project> searchByRegisterDateAndProjectName(Date startedDate, Date endDate, String name);

}
