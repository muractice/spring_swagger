package com.example.study_record.datasource;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

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
        String sql = "SELECT 1";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        long result = jdbcTemplate.queryForObject(sql,sqlParameterSource,Long.class);
        return result;
    }

    @Override
    public void register(User user) {
    }

}
