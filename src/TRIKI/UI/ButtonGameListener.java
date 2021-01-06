/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRIKI.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author paul
 */
public class ButtonGameListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Vamos a mostrar el contenido del evento");
        System.out.println("Mostrar el valor del boton que disparo el evento");
        JButton btn = (JButton) e.getSource();
        System.out.println("button Name: " + btn.getName() + " text: "+ btn.getText() );
        
    }
    
}
