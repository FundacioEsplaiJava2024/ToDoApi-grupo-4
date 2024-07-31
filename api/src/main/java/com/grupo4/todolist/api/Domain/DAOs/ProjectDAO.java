package com.grupo4.todolist.api.Domain.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.grupo4.todolist.api.Domain.DbConnect;
import com.grupo4.todolist.api.Domain.Entities.Project;

public class ProjectDAO {

    private final DbConnect dbConnect;

    public ProjectDAO() {
        this.dbConnect = new DbConnect();
    }
        private Project fromResultSet(ResultSet rs){
        Project project;
        try {
            // Retrieve data from the result set
            String id = rs.getString("project_id");
            String name = rs.getString("project_name");
            Long user_ID = rs.getLong("user_ID");
            // Create a new project object with the retrieved data
            project = new Project(id, name, user_ID);

            return project;
        } catch (SQLException ex) {
            //Log de exception and return null

            //throw new PersistException("Sql error", OpResult.DB_SQLERR.getCode());
            System.out.println("Error "+ex);
            return null;
        }
    }

        public List<Project> getProjectsByUserId(String userId){
        List<Project> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to get all existing Projects
            String query = "select * from project where user_ID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            //Fetch data
            while (rs.next()) {
                Project project = fromResultSet(rs);
                if (project != null) {
                    result.add(project);
                }
            }
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting projects", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
    }
}
