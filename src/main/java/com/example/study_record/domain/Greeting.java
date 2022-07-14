package com.example.study_record.domain;

import lombok.Getter;

public class Greeting {
    @Getter
    private final long id;
    @Getter
    private final String content;

    private Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    public static Greeting of(long id, String content){
        return new Greeting(id,content);
    }
}
