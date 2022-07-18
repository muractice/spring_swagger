package com.example.study_record.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String address;

    private User(String name, String address){
        this.name = name;
        this.address = address;
    }

    public static User of(String name, String adress) {
        return new User(name,adress);
    }
}
