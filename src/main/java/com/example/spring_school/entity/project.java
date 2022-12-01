package com.example.spring_school.entity;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.dto.ProjectDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long piId;

    private String id;

    @Column(nullable = false)
    private String pjName;

    private String pjShortInfo;

    private String pjLongInfo;

    private String pjLink;

    public static Project createProject(ProjectDto projectDto, PasswordEncoder passwordEncoder){
        Project project = new Project();
        project.setPjName(projectDto.getPjName());
        project.setPjShortInfo(projectDto.getPjShortInfo());
        project.setPjLongInfo(projectDto.getPjLongInfo());
        project.setPjLink(projectDto.getPjLink());

        return project;
    }

}
