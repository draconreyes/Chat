/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import chat.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Manipular_Datos {

    public Manipular_Datos() {
        
    }
    
    public void SubirMensajes(String Mensaje){
        ConexionMysql conec = new ConexionMysql();
        conec.conectar();
        System.out.println(conec.getMensaje());
        String sql = "insert into mensajes(Contenido) VALUES(?)";
        ResultSet rs = null; // recibe el resultado de la consulta
        PreparedStatement ps = null;// prepara la consulta
        try {
            ps = conec.getConexion().prepareStatement(sql);
            ps.setString(1, Mensaje);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    public ArrayList<String> BajarMensajes(){
        ArrayList<String> Lista_Mensajes= new ArrayList<>();
        ConexionMysql conec = new ConexionMysql();
        conec.conectar();
        System.out.println(conec.getMensaje());
        String sql = "SELECT mensajes.Contenido FROM mensajes";
        ResultSet rs = null; // recibe el resultado de la consulta
        PreparedStatement ps = null;// prepara la consulta
        try {
            ps = conec.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String men = rs.getString(1);
                Lista_Mensajes.add(men);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Manipular_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return Lista_Mensajes;
    }
    
    
}
