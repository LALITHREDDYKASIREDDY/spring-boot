package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class DemoController {


    DemoService s=new DemoService();
     
    @GetMapping("/")
    public ArrayList<User>  getMethodName() {
        return s.userlist();
    }
    
    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("dsaf");
        return s.login(user.getName(),user.getPassword());
    }
}
