package com.example.study_record.domain;

public interface UserRepository {
    public UserList findAll();
    public User findById(Long id);
}
