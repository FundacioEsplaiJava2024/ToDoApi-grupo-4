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
    private Long userID;

    private String userName;

    private String userPassword;

    public User() {}

    public User(Long userID, String userName, String userPassword) {
        this.userID =  userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }    

    public void setUserID(Long userID) {
        this.userID = userID;
    }    

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }    
}
