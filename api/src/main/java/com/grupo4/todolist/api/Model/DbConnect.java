package com.grupo4.todolist.api.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DbConnect {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String PROTOCOL = "jdbc:mysql:";
    public static final String HOST = "127.0.0.1";
    public static final String BD_NAME = "test";
    public static final String USER = "";
    public static final String PASSWORD = "";
    public static String BD_URL;
    
    public static void loadDriver() {
        try {
            //getConnectionProperties(); añadir esta linea en caso de que leamos más adelante los parametros desde fichero.
            Class.forName(DRIVER);
            BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            //throw new PersistException("Driver not found", OpResult.DB_DRIVER.getCode());
        }
    }
    
    /**
     * gets and returns a connection to database
     * @return connection
     * @throws PersistException in case of connetion error
     */
    public Connection getConnection(){
        BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            //throw new PersistException("Error connecting to database", OpResult.DB_NOCONN.getCode());
        }
        return conn;
    }
}