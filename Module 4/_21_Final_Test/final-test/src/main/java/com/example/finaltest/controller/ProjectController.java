package com.example.finaltest.controller;

import com.example.finaltest.entity.Company;
import com.example.finaltest.entity.Project;
import com.example.finaltest.service.company.ICompanyService;
import com.example.finaltest.service.project.IProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private IProjectService projectService;
    @Autowired
    private ICompanyService companyService;

    //    @GetMapping("/list")
//    public String displayProjectList(Model model) {
//        List<Project> projectList = (List<Project>) projectService.findAll();
//        model.addAttribute("projectList", projectList);
//        return "/project/list";
//    }
    @GetMapping("/list")
    public String search(@RequestParam("startedDate") Optional<String> startedDate,
                         @RequestParam("endDate") Optional<String> endDate,
                         @RequestParam("name") Optional<String> name, Model model) {
        List<Project> projectList;
        String startedDateSearch, endDateSearch, nameSearch;
        startedDateSearch = (startedDate.isEmpty()) ? "" : startedDate.get();
        endDateSearch = (endDate.isEmpty()) ? "" : endDate.get();
        if (!startedDateSearch.equals("") && !endDateSearch.equals("")) {
            nameSearch = (name.isEmpty()) ? "" : name.get();
            Date start = Date.valueOf(startedDateSearch);
            Date end = Date.valueOf(endDateSearch);
            System.err.println(start);
            System.err.println(end);
            projectList = (List<Project>) projectService.searchByRegisterDateAndProjectName(start, end, nameSearch);
        } else {
            projectList = (List<Project>) projectService.findAll();
        }
        System.err.println("size: " + projectList.size());
        model.addAttribute("projectList", projectList);
        return "/project/list";
    }

    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        List<Company> companyList = (List<Company>) companyService.findAll();
        Project project = new Project();
        project.setId(autoGenerateMotelId());
        project.setRegisterDate(Date.valueOf(LocalDate.now()));
        model.addAttribute("project", project);
        model.addAttribute("companyList", companyList);
        return "/project/register";
    }

    @PostMapping("/register")
    public String registerProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult, Model model) {
        System.err.println(project);
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getErrorCount());
            System.err.println(bindingResult.getAllErrors());
            List<Company> companyList = (List<Company>) companyService.findAll();
            model.addAttribute("companyList", companyList);
            return "/project/register";
        }
        System.err.println("done");
        System.err.println("cost: " + calculateProjectCost(project.getBudget(), project.getMonth()));
        long cost = calculateProjectCost(project.getBudget(), project.getMonth());
        project.setCost(cost);
        projectService.save(project);
        return "redirect:/project/list";
    }

    @GetMapping("/detail/{id}")
    public String displayProjectInformation(@PathVariable("id") String id, Model model) {
        Project project = projectService.findById(id).isPresent() ? projectService.findById(id).get() : null;
        System.err.println(project);
        if (project != null) {
            model.addAttribute("project", project);
            return "/project/detail";
        }
        return "error";
    }


    private String autoGenerateMotelId() {
        List<Project> projectList = (List<Project>) projectService.findAll();
        if (projectList.size() == 0) return "DA-0001";
        String lastId = projectList.get(projectList.size() - 1).getId();
        String[] split = lastId.split("-");
        int number = Integer.parseInt(split[1]) + 1;
        return (number < 10) ? ("DA-000" + number) : ("DA-00" + number);
    }

    private long calculateProjectCost(long budget, int month) {
        long cost;
        if (budget < 100000000) {
            cost = budget * month / 100;
        } else if (budget < 500000000) {
            cost = budget * month * 2 / 100;
        } else {
            cost = budget * month * 3 / 100;
        }
        return cost;
    }
}
