package com.example.spring_school.controller;

import com.example.spring_school.dto.ProjectDto;
import com.example.spring_school.entity.Project;
import com.example.spring_school.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "getMyProject")
    public List<Project> MyProjectGetController(Model model){

        List<Project> projects = projectRepository.findById("");

        return projects;
    }

    @GetMapping(value = "saveProjectList")
    public HashMap<String, String> saveProject(@RequestParam Map<String, Object> getiden){

        getiden.get("");

        ProjectDto projectDto = new ProjectDto();

        Project project = Project.createProject(projectDto);

        projectRepository.save(project);

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;
    }

    @GetMapping(value = "projectList3")
    public String getProjectByLanguage(Model model){

        String language = "";

        projectRepository.findByLanguageContaining(language);

        return "";
    }

}
