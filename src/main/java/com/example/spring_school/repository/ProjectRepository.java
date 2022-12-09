package com.example.spring_school.repository;

import com.example.spring_school.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findById(String id);

    List<Project> findByLanguageContaining(String language);

    Project findByLanguage(String language);

}
