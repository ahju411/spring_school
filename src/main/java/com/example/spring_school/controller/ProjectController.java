package com.example.spring_school.controller;

import com.example.spring_school.dto.ProjectDto;
import com.example.spring_school.entity.Project;
import com.example.spring_school.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    //프로젝트 전체 가져오기
    @PostMapping(value = "projectList")
    public List<Project> ProjectGetController(Model model){
        List<Project> projects = projectRepository.findAll();

        return projects;
    }

    //내 프로젝트 받아오기
    @PostMapping(value = "myProject")
    public List<Project> MyProjectGetController(@RequestParam Map<String, Object> getiden){
        String id = (String) getiden.get("id");
        List<Project> projects = projectRepository.findById(id);

        return projects;
    }

    //프로젝트 받아와서 저장
    @PostMapping(value = "saveProject")
    public HashMap<String, String> saveProject(@RequestParam Map<String, Object> getiden, MultipartHttpServletRequest mtfRequest){

        String pjName = (String) getiden.get("pjName");
        String pjShortInfo = (String) getiden.get("pjShortInfo");
        String pjLongInfo = (String) getiden.get("pjLongInfo");
        String pjLink = (String)  getiden.get("pjLink");
        String language = (String) getiden.get("language");
        String image = (String) getiden.get("image");
        String imageName = (String) getiden.get("imageName");
        String oriImageName = (String) getiden.get("oriImageName");

        ProjectDto projectDto = new ProjectDto();
        projectDto.setPjLink(pjLink);
        projectDto.setPjName(pjName);
        projectDto.setPjShortInfo(pjShortInfo);
        projectDto.setPjLongInfo(pjLongInfo);
        projectDto.setLanguage(language);
        projectDto.setImage(image);
        projectDto.setImageName(imageName);
        projectDto.setOriImageName(oriImageName);
        projectDto.setRegDate(LocalDateTime.now());

        Project project = Project.createProject(projectDto);

        projectRepository.save(project);

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;
    }

    //프로젝트 수정
    @PostMapping(value = "updateProject")
    public HashMap<String, String> updateProject(@RequestParam Map<String, Object> getiden){

        String pjId = (String) getiden.get("pjId");
        String pjName = (String) getiden.get("pjName");
        String pjShortInfo = (String) getiden.get("pjShortInfo");
        String pjLongInfo = (String) getiden.get("pjLongInfo");
        String pjLink = (String)  getiden.get("pjLink");
        String language = (String) getiden.get("language");
        String image = (String) getiden.get("image");
        String imageName = (String) getiden.get("imageName");
        String oriImageName = (String) getiden.get("oriImageName");

        ProjectDto projectDto = new ProjectDto();
        projectDto.setPjLink(pjLink);
        projectDto.setPjName(pjName);
        projectDto.setPjShortInfo(pjShortInfo);
        projectDto.setPjLongInfo(pjLongInfo);
        projectDto.setLanguage(language);
        projectDto.setImage(image);
        projectDto.setImageName(imageName);
        projectDto.setOriImageName(oriImageName);
        projectDto.setRegDate(LocalDateTime.now());

        Project project = Project.createProject(projectDto);

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;
    }

    //프로젝트중에 특정 language가 포함된 프로젝트 가져오기
    @PostMapping(value = "projectByLanguage")
    public List<Project> getProjectByLanguage(@RequestParam Map<String, Object> getiden){

        String language = (String) getiden.get("language");

        List<Project> projects = projectRepository.findByLanguageContaining(language);

        return projects;
    }

    @CrossOrigin
    @PostMapping(value = "deleteProject")
    public String deleteProject(@RequestParam Map<String, Object> getiden){
        String id = (String) getiden.get("id");

        Long iden = Long.valueOf(Integer.parseInt(id));

        projectRepository.deleteById(iden);

        return "삭제가 완료되었습니다.";
    }

}
