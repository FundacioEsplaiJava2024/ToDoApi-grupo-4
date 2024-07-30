package com.grupo4.todolist.api.Domain.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.grupo4.todolist.api.Domain.DbConnect;
import com.grupo4.todolist.api.Domain.Entities.User;

public class UserDAO {
    private final DbConnect dbConnect;

    public UserDAO() {
        this.dbConnect = new DbConnect();
    }
    
    private User fromResultSet(ResultSet rs) {
        try {
            // Create a new User object with the retrieved data
            Long id = rs.getLong("user_ID");
            String name = rs.getString("user_name");
            String pwd = rs.getString("user_password");
            User user = new User(id, name, pwd);
            System.out.println("ioio " + user);
            return user;
        } catch (SQLException ex) {
            // Log de exception and return null
            System.out.println("Error " + ex);
            return null;
        }
    }

    public int insert(String username, String password) {
        int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "insert into user(user_name, user_password) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return result;
    }

    public long getUser(String username, String password) {
        long userID = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "select user_ID from user where user_name=? AND user_password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) { // Verificar si hay una fila antes de intentar procesarla
                userID = rs.getLong("user_ID");
            }
            System.out.println("eoeoe " + userID);
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return userID;
    }
}
