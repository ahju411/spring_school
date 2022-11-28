package com.example.spring_school.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long piId;

    private String key;

    @Column(nullable = false)
    private String pjName;

    private String pjShortInfo;

    private String pjLongInfo;

    private String pjLink;

}
