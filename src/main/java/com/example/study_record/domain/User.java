package com.example.study_record.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private final long userId;
    private final String name;
    private final String address;

    private User(long userId,String name, String address){
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public static User of(long userId,String name, String address) {
        return new User(userId,name,address);
    }
}
