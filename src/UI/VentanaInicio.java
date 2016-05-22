/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import Servicios.servicios;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.BoxLayout.Y_AXIS;

/**
 *
 * @author dieguischa
 */
public class VentanaInicio extends JFrame implements ActionListener, Runnable{
    
    JRadioButton opcionTorneoNuevo= new JRadioButton("Crear Torneo nuevo");
    JRadioButton opcionTorneoExistente= new JRadioButton("Cargar Torneo Existente");
    JRadioButton opcionPartidoAmistoso= new JRadioButton("Partido Amistoso");
    JFrame frame= new JFrame();
    
    Runnable crear= new creacionTorneo();
    Runnable cargar= new cargarTorneo();
    Runnable amistoso= new partidoAmistoso();
    JButton continuar= new JButton("Continuar");
    public VentanaInicio(){
    
    
}
    public  void opcionInicial(JFrame frame){
        
        opcionTorneoExistente.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(opcionTorneoExistente);
        group.add(opcionTorneoNuevo);
        group.add(opcionPartidoAmistoso);
        opcionTorneoExistente.addActionListener(this);
        opcionTorneoNuevo.addActionListener(this);
        opcionPartidoAmistoso.addActionListener(this);
        continuar.addActionListener(this);
        JPanel panel=new JPanel(new GridLayout(0, 1));
        panel.add(opcionTorneoExistente);
        panel.add(opcionTorneoNuevo);
        panel.add(opcionPartidoAmistoso);
        panel.add(continuar);
        frame.add(panel);
        
      
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(opcionTorneoExistente.isSelected()&&e.getActionCommand().equals("Continuar")){
           
              frame.dispose();
              cargar.run();
       }
       if(opcionTorneoNuevo.isSelected()&&e.getActionCommand().equals("Continuar")){
           frame.dispose();
           crear.run();
       }
       if(opcionPartidoAmistoso.isSelected()&&e.getActionCommand().equals("Continuar")){
           frame.dispose();
           amistoso.run();
       }
      }

    @Override
    public void run() {    
    
    frame.setSize(300,200);
    frame.setResizable(false);
    opcionInicial(frame);
    frame.setVisible(true); 
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setLocation(700, 400);
    }
    }

