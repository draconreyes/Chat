package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscucharServidor extends Thread{
    Socket ss = null;
    InputStream entrada = null;
    DataInputStream entra = null;
    
    public EscucharServidor(Socket so){
        System.out.println("Empezo a escuchar");
        ss = so;
        try{
            entrada = ss.getInputStream();
            entra = new DataInputStream(entrada);
            
        }
        catch(Exception e){
        }
    }
    public void run(){
        while(true){
            try {
                String leido = entra.readUTF();
                System.out.println("Server dijo"+leido);
            } catch (IOException ex) {
                Logger.getLogger(EscucharServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
