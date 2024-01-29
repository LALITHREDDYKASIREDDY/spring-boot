package com.example.apirouting;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MyController {
    @GetMapping("/")
    public String fun1() {
        return "Home Page";
    }

    @GetMapping("/about")
    public String fun2() {
        return "About Page";
    }
    
}
