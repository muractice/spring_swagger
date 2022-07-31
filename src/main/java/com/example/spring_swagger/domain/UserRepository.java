package com.example.spring_swagger.domain;

public interface UserRepository {
    public UserList findAll();
    public User findById(Long id);
    public long allocate();
    public void register(User user);
}
