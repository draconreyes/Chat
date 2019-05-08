/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import DAO.Manipular_Datos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Proceso extends Thread{
    Socket refC = null;
    DataInputStream entrada = null;
    DataOutputStream salida = null;
    Proceso sig;
    Manipular_Datos B_datos= new Manipular_Datos();
    Lista lis= new Lista();

    
    public void enviarMensa(String m){        
        try{
            salida.writeUTF(m);
        }
        catch(Exception e){
        }
    }
    
    public Proceso(Socket ref){
        refC = ref;
        try{
            entrada = new DataInputStream(refC.getInputStream());
            salida = new DataOutputStream(refC.getOutputStream());
        }
        catch(Exception e){
            
        }
    } 
    
    public void mostrar(){
        try{
            System.out.println(refC.toString());
        }
        catch(Exception e){
        }
    }

    @Override
    public void run() {
            try {
                while(true){
                String leido = entrada.readUTF();
                B_datos.SubirMensajes("El cliente :"+refC.getPort()+" Dijo:"+leido);
                System.out.println("El cliente :"+refC.getPort()+" Dijo:"+leido);
                Servidor.ObjLista.enviarMensa("El cliente :"+refC.getPort()+" Dijo:"+leido);
                }
            } catch (Exception ex) {
                
            }
            
        
    }
    
   
    
}
