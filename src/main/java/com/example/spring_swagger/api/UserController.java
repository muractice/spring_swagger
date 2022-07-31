package com.example.spring_swagger.api;

import com.example.spring_swagger.domain.User;
import com.example.spring_swagger.domain.UserList;
import com.example.spring_swagger.domain.UserRepository;
import io.swagger.annotations.Api;
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
    public PostUserResponse postUser(String name, String address){
        logger.info("Called postUser");

        long userId = userRepository.allocate();
        logger.info("allocate():{}",userId);

        User user = User.of(userId,name,address);

        userRepository.register(user);
        return PostUserResponse.of( user);
    }

}
