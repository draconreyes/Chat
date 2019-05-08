/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.Vista;
import chat.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Controlador implements ActionListener{
    private Vista Ventana;
    private Cliente c1;

    public Controlador() throws IOException {
        this.Ventana = new Vista();
        this.c1 = new Cliente();
        this.Ventana.getBoton_Enviar().addActionListener(this);
        this.Ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Ventana.getBoton_Enviar()){
            String Mensaje=Ventana.getTexArea().getText();
            Ventana.getTexArea().setText("");
            try {
                c1.Enviarmensaje(Mensaje);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
