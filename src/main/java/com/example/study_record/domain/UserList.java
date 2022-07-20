package com.example.study_record.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserList {
//    @Getter
    private final List<User> users;

    private UserList(){
        this.users = new ArrayList<>();
    }

    private UserList(List<User> users){
        this.users = users;
    }

    public static UserList get(){
        return new UserList();
    }

    public static UserList of(List<User> users){
        return new UserList(users);
    }
    public UserList add(User user){
        List<User> tmpUsers = new ArrayList<>(users);
        tmpUsers.add(user);
        return new UserList(tmpUsers);
    }

    public List<User> getUsers(){
        return Collections.unmodifiableList(users);
    }
}
