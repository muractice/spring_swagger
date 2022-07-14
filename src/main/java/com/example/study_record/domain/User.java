package com.example.study_record.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String adress;

    private User(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

    public static User of(String name, String adress) {
        return new User(name,adress);
    }
}
