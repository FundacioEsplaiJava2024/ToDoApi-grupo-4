package com.grupo4.todolist.api.Domain.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.grupo4.todolist.api.Domain.DbConnect;
import com.grupo4.todolist.api.Domain.Entities.Column;

public class ColumnDAO {

    private final DbConnect dbConnect;

    public ColumnDAO() {
        this.dbConnect = new DbConnect();
    }
        private Column fromResultSet(ResultSet rs){
        Column column;
        try {
            // Retrieve data from the result set
            String id = rs.getString("column_id");
            String name = rs.getString("column_name");
            String project_id = rs.getString("project_id");
            // Create a new column object with the retrieved data
            column = new Column(id, name, project_id);

            return column;
        } catch (SQLException ex) {
            //Log de exception and return null

            //throw new PersistException("Sql error", OpResult.DB_SQLERR.getCode());
            System.out.println("Error "+ex);
            return null;
        }
    }

        public List<Column> getColumnsByProjectId(String columnId){
        List<Column> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to get all existing Columns
            String query = "select * from column where project_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, columnId);
            ResultSet rs = ps.executeQuery();
            //Fetch data
            while (rs.next()) {
                Column column = fromResultSet(rs);
                if (column != null) {
                    result.add(column);
                }
            }
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting columns", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
    }
}
