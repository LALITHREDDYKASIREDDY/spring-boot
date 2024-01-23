package com.example.demo;

import java.util.ArrayList;

public interface DemoRepository {
  String login(String user,String password);
   ArrayList<User> userlist(); 
} 