package com.example.demo;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements DemoRepository{
    @Autowired
    private DemoJpaRepository d;
    public ArrayList<User> userlist(){
        List<User> a=d.findAll();
        return new ArrayList<>(a);

    }
   public String login(String user,String password){
        User u=d.findById(user).get();
        if(u.getPassword()==password)
        {
            return "logged in";
        }
    
    return "wrong details";
   }
}
