package com.grupo4.todolist.api.Domain.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.grupo4.todolist.api.Domain.DbConnect;
import com.grupo4.todolist.api.Domain.Entities.Task;

public class TaskDAO {
    private final DbConnect dbConnect;

    public TaskDAO() {
        this.dbConnect = new DbConnect();
    }
    int displayLimit = 100; //Variable in charge of displaying the number of elements, will change later based on the parameters.

    /**
     * reads TaskData data from resultset row
     *
     * @param rs the resultset to read from
     * @return product or null in case of error
     * @throws PersistException in case of database error
     */
    private Task fromResultSet(ResultSet rs){
        Task task;
        try {
            // Retrieve data from the result set
            String id = rs.getString("task_id");
            String name = rs.getString("task_name");
            String colId = rs.getString("column_id");
            // Create a new Task object with the retrieved data
            task = new Task(id, name, colId);

            return task;
        } catch (SQLException ex) {
            //Log de exception and return null

            //throw new PersistException("Sql error", OpResult.DB_SQLERR.getCode());
            System.out.println("Error "+ex);
            return null;
        }
    }

    public List<Task> getTasks(){
        List<Task> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to get all existing tasks
            String query = "select * from task";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            //Fetch data
            while (rs.next()) {
                Task task = fromResultSet(rs);
                if (task != null) {
                    result.add(task);
                }
            }
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
    }
    public List<Task> getTasksByColumnId(String columnId){
        List<Task> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to get all existing tasks
            String query = "select * from task where column_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, columnId);
            ResultSet rs = ps.executeQuery();
            //Fetch data
            while (rs.next()) {
                Task task = fromResultSet(rs);
                if (task != null) {
                    result.add(task);
                }
            }
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
    }

	public int insert(Task task) {
        //we start with the result = -1 because this gives us more information
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to insert a new task into the task table with placeholders for task_id, task_name, and column_id
            String query = "insert into task(task_id, task_name, column_id) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            //set parameters for the prepared statement
            ps.setString(1, task.getTaskId());
            ps.setString(2, task.getTaskName());
            ps.setString(3, task.getSourceColumn());
            //excuse the update and get results
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
	}
    public int edit(String id, String newName) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to edit a task
            System.out.println("AYUDA"+ newName);
            String query = "update task set task_name=? where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            // Set parameters for the prepared statement
            ps.setString(1, newName);
            ps.setString(2, id);
            // Execute the update and get the result
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
	}
    public int delete(String id) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to delete a task
            String query = "delete from task where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
	}
    public int move(Task task) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            // SQL query to move a task
            String query = "update task set column_id=? where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, task.getSourceColumn());
            ps.setString(2, task.getTaskId());
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
            //log de exception
        }
        return result;
	}
}
