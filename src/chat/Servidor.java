/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;


import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import DAO.Manipular_Datos;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Servidor extends Conexion {
    public static Lista ObjLista;
    private Manipular_Datos MD;
    
    public Servidor() throws IOException {
        super("Servidor");
    }
    
    public void Actualizar_Chat(Proceso p1){
        MD=new Manipular_Datos();
        ArrayList<String> Mensajes=MD.BajarMensajes();
        for(String i:Mensajes){
            p1.enviarMensa(i);
        }
        
    }
    
     public void Inicio_Servidor() throws IOException{
         int contador=1;
         ObjLista= new Lista();
         while(true){
            System.out.println("Esperando Clientes");
            cs=ss.accept();
            System.out.println("Llego el cliente numero:"+ contador);
            Proceso p1= new Proceso(cs);
            Actualizar_Chat(p1);
            ObjLista.anadir(p1);
            ObjLista.mostrar();
            p1.start();
            contador++;
         }
         
    }
     public static void main (String [ ] args) throws IOException {
        Servidor s1= new Servidor();
        s1.Inicio_Servidor();
       
    
    }
    
    
}
