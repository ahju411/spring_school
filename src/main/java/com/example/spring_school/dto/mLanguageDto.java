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
public class mLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mId;

    private long key;

    private String mLnaguage;

}
