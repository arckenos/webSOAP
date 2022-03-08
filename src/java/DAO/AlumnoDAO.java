/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Arcke
 */
public class AlumnoDAO extends DAO<Alumno>{

    @Override
    public ArrayList consultar() {
        ArrayList<Alumno> listAlumnos = new ArrayList<>();
        
        try{
            Connection conexion = generarConexion();
            Statement comando = conexion.createStatement();
            String codigo = "SELECT id nombreCompleto, carrera, semestre FROM alumnos";            
            ResultSet result = comando.executeQuery(codigo);
            
            while(result.next()){
                Integer id = result.getInt("id");
                String nombre = result.getString("nombreCompleto");
                String carrera = result.getString("carrera");
                Integer semestre = result.getInt("semestre");                
                listAlumnos.add(new Alumno(id, nombre, carrera, semestre));                
                
            }
            conexion.close();
            return  listAlumnos;            
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());
           
       }
       return null;
              
        
    }

    @Override
    public Alumno consultar(int id) {
         try{
           Connection conexion = generarConexion();
            Statement comando = conexion.createStatement();
            String codigo = String.format("SELECT id nombreCompleto, carrera, semestre FROM alumnos WHERE id = %d", id);        
            ResultSet result = comando.executeQuery(codigo);
            if(result.next()){
                Integer idx = result.getInt("id");
                String nombre = result.getString("nombreCompleto");
                String carrera = result.getString("carrera");
                Integer semestre = result.getInt("semestre");      
                
                return new Alumno(idx, nombre, carrera, semestre);                
            }            
            conexion.close();
                        
       }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());
           
       }
       return null;
    }

    @Override
    public void insertar(Alumno entidad) {
                 try{
            Connection conexion = generarConexion();
            Statement comando = conexion.createStatement();
            String codigo = String.format("INSERT INTO alumnos (nombreCompleto, carrera, semestre) VALUES ('%s','%s',%d)",
                    entidad.getNombreCompleto(),
                    entidad.getCarrera(),                    
                    entidad.getSemestre());                    
            comando.executeUpdate(codigo);
            conexion.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());
           
       }
    }

    @Override
    public void actualizar(Alumno entidad) {
         try{
            Connection conexion = generarConexion();
            Statement comando = conexion.createStatement();
            String codigo = String.format("UPDATE lugares SET nombreCompleto = '%s', carrera = '%s',semestre = %d WHERE id = %d ",
                    entidad.getNombreCompleto(),
                    entidad.getCarrera(),
                    entidad.getSemestre(),
                    entidad.getId());        
            comando.executeUpdate(codigo);
            conexion.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());           
       }
    }

    @Override
    public void eliminar(Alumno entidad) {
        try{
            Connection conexion = generarConexion();
            Statement comando = conexion.createStatement();
            String codigo = String.format("DELETE FROM alumnos WHERE id = %d",
                    entidad.getId());        
            comando.executeUpdate(codigo);
            conexion.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());
        }
            
    }


 
    
}
