/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import Control.Controlador;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Cliente extends Conexion {
    EscucharServidor Escucha;
    public Cliente() throws IOException {
        super("Cliente");
        salidaServidor= new DataOutputStream(cs.getOutputStream());
        Escucha= new EscucharServidor(cs);
        Escucha.start();
    }
    public void Enviarmensaje(String mensaje) throws IOException{
        this.salidaServidor.writeUTF(mensaje);
    }
    
    
    public static void main (String [ ] args) throws IOException {
         Controlador c1= new Controlador();
    
    }
    
}
