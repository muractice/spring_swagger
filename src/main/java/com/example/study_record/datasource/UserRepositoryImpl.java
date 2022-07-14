package com.example.study_record.datasource;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(Long id) {
        return User.of("名前","住所");
    }
}
