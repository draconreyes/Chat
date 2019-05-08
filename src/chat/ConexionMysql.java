/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Moreno-Diego Peña
 * @version 1.0
 */
public class ConexionMysql {
    private Connection conexion;
    private String Mensaje;

    /**
     *
     * @param conexion
     * @param Mensaje
     */
    public ConexionMysql(Connection conexion, String Mensaje) {
        this.conexion = conexion;
        this.Mensaje = Mensaje;
    }
    
    /**
     *
     */
    public ConexionMysql() {
        this.conexion =null ;
        this.Mensaje = "";
    }

    /**
     *
     * @return
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     *
     * @param conexion
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @return
     */
    public String getMensaje() {
        return Mensaje;
    }

    /**
     *
     * @param Mensaje
     */
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    /**
     *
     */
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ruta="jdbc:mysql://localhost:3307/mensajeria";
            conexion=DriverManager.getConnection(ruta,"root","");
            Mensaje="Conexion con Mysql exitosa...";
        } catch (ClassNotFoundException ex) {
           Mensaje=ex.getMessage();
           
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    /**
     *
     */
    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            conexion.close();
        }catch(Exception ex){}
    }
    
}
