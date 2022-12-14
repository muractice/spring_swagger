package com.example.spring_swagger.api;

import com.example.spring_swagger.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PostUserResponse {
    @Getter
    private final User user;

    public static PostUserResponse of(User user){
        return new PostUserResponse(user);
    }
}
