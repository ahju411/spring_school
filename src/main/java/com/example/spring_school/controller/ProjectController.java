package com.example.spring_school.controller;

import com.example.spring_school.entity.Project;
import com.example.spring_school.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "projectList")
    public List<Project> ProjectGetController(Model model){

        List<Project> projects = projectRepository.findAll();

        return projects;
    }

    @GetMapping(value = "projectList1")
    public List<Project> MyProjectGetController(Model model){

        List<Project> projects = projectRepository.findById("");

        return projects;
    }

    @GetMapping(value = "projectList2")
    public String saveProject(){

        Project project = new Project();

        projectRepository.save(project);

        return "/";
    }

    @GetMapping(value = "projectList3")
    public String getProjectByLanguage(Model model){

        String language = "";

        projectRepository.findByLanguageContaining(language);

        return "";
    }

}
