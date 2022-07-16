package com.example.study_record.api;

import com.example.study_record.domain.User;
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
