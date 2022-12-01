package com.example.spring_school.service;

import com.example.spring_school.entity.Project;
import com.example.spring_school.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

}
