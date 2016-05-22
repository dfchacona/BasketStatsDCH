/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Servicios.servicios;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author dieguischa
 */
public class cargarTorneo implements Runnable, ActionListener{
    Torneo t1;
    JFrame frame= new JFrame();
    JButton continuar= new JButton("Continuar");
    JButton atras= new JButton("Atras");
    JPanel opciones = new JPanel(new FlowLayout());
    Icon icono= new ImageIcon("folder.png");
    JTextField text= new JTextField();
    JFileChooser file=new JFileChooser();
    servicios serv= new servicios();
    public cargarTorneo(){
        
    }
    
    public JPanel ingresarTorneo(){
        JPanel torneoM= new JPanel(new FlowLayout());
        JPanel torneo= new JPanel(new GridLayout(1,2));
        JLabel nombreTorneo= new JLabel ("Nombre del torneo:");
        JButton browse= new JButton(icono);
        browse.addActionListener(this);
        browse.setActionCommand("browse");
        torneo.add(nombreTorneo);
        torneo.add(text);
        torneoM.add(torneo);
        torneoM.add(browse);
        return torneoM;
    }
    
    
    @Override
    public void run() {
        frame.setSize(300,100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        opciones.add(atras);
        opciones.add(continuar);
        continuar.addActionListener(this);
        atras.addActionListener(this);
        frame.add(ingresarTorneo(), BorderLayout.NORTH);
        frame.add(opciones, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Atras")){
            frame.dispose();
            Runnable VentanaInicio= new VentanaInicio();
            VentanaInicio.run();
        }
        if(e.getActionCommand().equals("browse")){
            file.showOpenDialog(frame);
            text.setText(""+file.getSelectedFile());
            
        }
        if(e.getActionCommand().equals("Continuar")){
            try {
                t1= serv.cargarTorneo(text.getText());
                System.out.println(t1.toString());
            } catch (FileNotFoundException ex) {
                
            }
         Runnable ventanaTorneo= new ventanaTorneo(t1);
         ventanaTorneo.run();
         frame.dispose();
        }
    }
    
}
