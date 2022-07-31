package com.example.spring_swagger.api;

import com.example.spring_swagger.domain.Greeting;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Api(tags = "Greeting")
public class GreetingController {
    private final static String template = "Hello, %s!";
    private final AtomicLong conunter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return Greeting.of(conunter.incrementAndGet(), String.format(template,name));
    }

    @PostMapping("/greeting")
    public String resistGreeting(@RequestParam(value = "word", defaultValue = "World") String word){
        return word;
    }


}
