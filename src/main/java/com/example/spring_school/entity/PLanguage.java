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
public class PLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pId;

    private long Id;

    private String pLnaguage;

}
