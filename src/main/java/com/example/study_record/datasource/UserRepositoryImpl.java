package com.example.study_record.datasource;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
        String sql = "SELECT * FROM users ORDER BY id";
        SqlParameterSource param = new MapSqlParameterSource();
        List<User> userList = jdbcTemplate.query(sql,param,userRowMapper);

        return UserList.of(userList);
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id",id);
        User result = jdbcTemplate.queryForObject(sql,param,userRowMapper);
        return result;
    }

    @Override
    public long allocate() {
        String sql = "VALUES NEXT VALUE FOR user_id_seq";
        SqlParameterSource param = new MapSqlParameterSource();
        long result = jdbcTemplate.queryForObject(sql,param,Long.class);
        return result;
    }

    @Override
    public void register(User user) {
        String sql = "INSERT INTO users(id,name,address) values(:id,:name,:address)";
//        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", user.getUserId())
                .addValue("name", user.getName())
                .addValue("address", user.getAddress());
        jdbcTemplate.update(sql,param);
    }

}
