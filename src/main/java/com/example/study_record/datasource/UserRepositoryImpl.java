package com.example.study_record.datasource;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserList findAll() {
        return UserList.get()
                .add(User.of("太郎","東京"))
                .add(User.of("二郎","名古屋"))
                .add(User.of("三郎","大阪"));
    }

    @Override
    public User findById(Long id) {
        return User.of("太郎","東京");
    }

    @Override
    public long allocate() {
        return 0;
    }

    @Override
    public void register(User user) {
    }

    public long allocate(){
        
    }
}
