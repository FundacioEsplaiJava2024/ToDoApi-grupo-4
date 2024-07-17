package com.grupo4.todolist.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_ID;

    private String user_name;

    private String user_password;

    private String user_email;

    public User() {}

    public User(long user_ID, String user_name, String user_password, String user_email) {
        this.user_ID =  user_ID;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public String getName() {
        return user_name;
    }
    public long getID() {
        return user_ID;
    }
    public String getPassword() {
        return user_password;
    }
    public String getEmail() {
        return user_email;
    }
    
    public void setName(String user_name) {
        this.user_name = user_name;
    }    
    public void setID(long user_ID) {
        this.user_ID = user_ID;
    }    
    public void setPassword(String user_password) {
        this.user_password = user_password;
    }    
    public void setEmail(String user_email) {
        this.user_email = user_email;
    }
}
