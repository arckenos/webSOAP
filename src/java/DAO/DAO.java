/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Arcke
 * @param <T>
 */
public abstract class DAO <T>{
    
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String CONEXION = "jdbc:mysql://localhost:3306/escuela";
    
    protected Connection generarConexion() throws ClassNotFoundException, SQLException { 
            Class.forName(DRIVER);     
            return DriverManager.getConnection(CONEXION,USER,PASSWORD);
        
    }
    
    public abstract ArrayList<T> consultar();

    public abstract T consultar(int id);
    
    public abstract void insertar(T entidad);
    
    public abstract void actualizar(T entidad);
    
    public abstract void eliminar(T entidad);
       
}