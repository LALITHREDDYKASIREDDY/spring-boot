package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
@Column(name="name")
  private String name;
  @Column(name="password")
  private String password;
  public User(){

  }
  public User(String name,String password){
    this.name=name;
    this.password=password;
  }

  public String getName(){
    return name;
  }
  public String getPassword(){
    return password;
  }

  public void setName(String name){
    this.name=name;
  }

  public void setPassword(String password){
    this.password=password;
  }

}
