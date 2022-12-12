package com.example.spring_school.config;

public class LanguageProcess {

    public void languageAddProcess(String existLanguage, String addLanguage){
        if(existLanguage.contains(addLanguage)){
        }else {
            existLanguage = existLanguage + "," + addLanguage;
        }
    }

    public void languageremoveProcess(String existLanguage, String removeLanguage){
        if (existLanguage.contains(removeLanguage)){
            existLanguage.replace(String.valueOf(removeLanguage),"");
        }
    }

}
