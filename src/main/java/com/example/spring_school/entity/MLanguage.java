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
public class MLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mId;

    private long Id;

    private String mLnaguage;

}
