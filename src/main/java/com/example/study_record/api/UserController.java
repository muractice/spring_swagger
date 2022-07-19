package com.example.study_record.api;

import com.example.study_record.domain.User;
import com.example.study_record.domain.UserList;
import com.example.study_record.domain.UserRepository;
import io.swagger.annotations.Api;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Api(tags = "User")
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public UserList getUsers(){
        logger.info("Called getUsers");
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public PostUserResponse getUser(@PathVariable Long id){
        return PostUserResponse.of(userRepository.findById(id) );
    }

    @PostMapping("/user")
    public PostUserResponse postUser(){
        User user = User.of("四郎","福岡");
        userRepository.register(user);
        return PostUserResponse.of( user);
    }

}
