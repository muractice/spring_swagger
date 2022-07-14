package com.example.study_record.api;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Api(tags = "User")
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Users")
    public UserList getUsers(){
        return UserList.get()
                .add(User.of("太郎","東京"))
                .add(User.of("二郎","名古屋"))
                .add(User.of("三郎","大阪"));
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
//    public User getUser(@RequestParam(value = "input_id") int id){
        return User.of("名前","住所");
    }
}
