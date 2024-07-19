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
            String id = rs.getString("task_id");
            String name = rs.getString("task_name");
            String colId = rs.getString("column_id");
            task = new Task(id, name, colId);

            return task;
        } catch (SQLException ex) {
            //throw new PersistException("Sql error", OpResult.DB_SQLERR.getCode());
            System.out.println("Error "+ex);
            return null;
        }
    }

    public List<Task> getTasks(){
        List<Task> result = new ArrayList<>();
        try (Connection conn = dbConnect.getConnection()) {
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
        }
        return result;
    }

	public int insert(Task task) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "insert into task(task_id, task_name, column_id) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, task.getTaskId());
            ps.setString(2, task.getTaskName());
            ps.setString(3, task.getSourceColumn());
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
        }
        return result;
	}
    public int edit(Task task) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "update task set task_name=? where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getTaskId());
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
        }
        return result;
	}
    public int delete(Task task) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "delete from task where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, task.getTaskId());
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
        }
        return result;
	}
    public int move(Task task) {
		int result = -1;
        try (Connection conn = dbConnect.getConnection()) {
            String query = "update task set column_id=? where task_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, task.getSourceColumn());
            ps.setString(2, task.getTaskId());
           
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            //throw new PersistException("Sql error selecting tasks", OpResult.DB_SELERR.getCode());
            System.out.println("Error "+ex);
        }
        return result;
	}
}
