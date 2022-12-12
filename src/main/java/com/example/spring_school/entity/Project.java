package com.example.spring_school.entity;

import com.example.spring_school.dto.ProjectDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pj_id;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "id")
    private String id;

//    @Column(nullable = false)
    private String pjName;

    private String pjShortInfo;

    private String pjLongInfo;

    private String pjLink;

    private String language;

    private String image;

    private String imageName;

    private String oriImageName;

    private LocalDateTime regDate;

    public static Project createProject(ProjectDto projectDto){
        Project project = new Project();
        project.setPjName(projectDto.getPjName());
        project.setPjShortInfo(projectDto.getPjShortInfo());
        project.setPjLongInfo(projectDto.getPjLongInfo());
        project.setPjLink(projectDto.getPjLink());
        project.setLanguage(projectDto.getLanguage());

        return project;
    }

    public void updateProject(ProjectDto projectDto){
        this.pjName = projectDto.getPjName();
        this.pjShortInfo = projectDto.getPjShortInfo();
        this.pjLongInfo = projectDto.getPjLongInfo();
        this.pjLink = projectDto.getPjLink();
        this.language = projectDto.getLanguage();
    }

}
