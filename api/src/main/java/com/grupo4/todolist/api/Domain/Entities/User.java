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

    public User() {}

    public User(Long user_ID, String user_name, String user_password) {
        this.user_ID =  user_ID;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public String getUserName() {
        return user_name;
    }

    public Long getUserID() {
        return user_ID;
    }

    public String getUserPassword() {
        return user_password;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }    

    public void setUserID(Long user_ID) {
        this.user_ID = user_ID;
    }    

    public void setUserPassword(String user_password) {
        this.user_password = user_password;
    }    
}
