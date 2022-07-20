package com.example.study_record.datasource;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<User> userRowMapper = (rs, i) -> {
        long id = rs.getInt("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        return User.of(id,name,address);
    };

    @Override
    public UserList findAll() {
        String sql = "SELECT * FROM users ";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        List<User> userList = jdbcTemplate.query(sql,sqlParameterSource,userRowMapper);

        return UserList.of(userList);
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users ";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        return User.of(id,"太郎","東京");
    }

    @Override
    public long allocate() {
        String sql = "VALUES NEXT VALUE FOR user_id_seq";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        long result = jdbcTemplate.queryForObject(sql,sqlParameterSource,Long.class);
        return result;
    }

    @Override
    public void register(User user) {
    }

}
