package com.grupo4.todolist.api.Domain.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo4.todolist.api.Domain.DbConnect;
import com.grupo4.todolist.api.Domain.Entities.Task;
import com.grupo4.todolist.api.Domain.Entities.User;

public class UserDAO {
    private final DbConnect dbConnect;

    public UserDAO() {
        this.dbConnect = new DbConnect();
    }
    private User fromResultSet(ResultSet rs){
        User user;
        try {
            // Retrieve data from the result set
            Long id = rs.getLong("user_ID");
            String name = rs.getString("user_name");
            String pwd = rs.getString("user_password");
            // Create a new Task object with the retrieved data
            user = new User(id ,name, pwd);

            return user;
        } catch (SQLException ex) {
            //Log de exception and return null

            //throw new PersistException("Sql error", OpResult.DB_SQLERR.getCode());
            System.out.println("Error "+ex);
            return null;
        }
    }

    public int insert(String username, String password) {
        int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to insert a new task into the task table with placeholders for task_id, task_name, and column_id
            String query = "insert into user(user_name, user_password) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            //set parameters for the prepared statement
            ps.setString(1, username);
            ps.setString(2, password);
            //excuse the update and get results
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
    }

    public User getUser(String username, String password) {
        User u = null;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to get all existing tasks
            String query = "select * from user where user_name=? AND user_password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            //Fetch data
            while (rs.next()) {
                u = fromResultSet(rs);
            }
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return u;
    }
    
}
