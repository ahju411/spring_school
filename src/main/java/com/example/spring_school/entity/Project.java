package com.example.spring_school.entity;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.dto.ProjectDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

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

    @Column(nullable = false)
    private String pjName;

    private String pjShortInfo;

    private String pjLongInfo;

    private String pjLink;

    private String language;

    public static Project createProject(ProjectDto projectDto, PasswordEncoder passwordEncoder){
        Project project = new Project();
        project.setPjName(projectDto.getPjName());
        project.setPjShortInfo(projectDto.getPjShortInfo());
        project.setPjLongInfo(projectDto.getPjLongInfo());
        project.setPjLink(projectDto.getPjLink());

        return project;
    }

}
