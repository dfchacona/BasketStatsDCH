/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exception.NumeroJugadorException;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Servicios.*;
import dao.dao;
import data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author dieguischa
 */
public class creacionTorneo extends JFrame implements ItemListener,ActionListener,Runnable{
    CrearEquipo crear; 
    servicios serv= new servicios();
    dao dao= new dao();
    Torneo t1;
    JTextField nombreT= new JTextField();
    JLabel nombreTorneo= new JLabel("Nombre Torneo");
    JFrame frame= new JFrame();
    JPanel opciones= new JPanel(new FlowLayout());
    Choice a = new Choice();
    JPanel equipos= new JPanel(new BorderLayout());
    JButton continuar= new JButton("Continuar");
    JButton atras= new JButton("Atras");
    Icon icono= new ImageIcon("folder.png");
    Icon iconoB= new ImageIcon("add-page.png");
    HashMap <Integer, JTextField> textfields= new HashMap();
     JFileChooser file=new JFileChooser();
    public creacionTorneo(){
        
        
    }
    
    
    public JPanel numeroEquipos(){
        JPanel numequipos= new JPanel(new FlowLayout());
        JLabel equipos= new JLabel("Numero de equipos");
        
	 
	       for (int i = 2; i <= 10; i++) {
           a.add(""+i);
           a.addItemListener(this);
        }
               
    numequipos.add(equipos);
    numequipos.add(a);
       
    return numequipos;    
    }
    
    public JPanel espaciosEquipos(int numeroEquipos){
        JPanel nombre= new JPanel(new GridLayout(1,2));
        JPanel labels= new JPanel(new GridLayout(numeroEquipos,1));
        JPanel textF= new JPanel(new GridLayout(numeroEquipos,1));
        JPanel botones= new JPanel(new GridLayout(numeroEquipos,2));
       
        for (int i = 1; i <= numeroEquipos; i++) {
            JLabel equipo= new JLabel("Equipo "+i);
          
            JTextField text= new JTextField();
            JButton botonB= new  JButton(icono);
            JButton botonC= new JButton(iconoB);
            text.setName(""+i);
            textfields.put(i, text);
            botonB.addActionListener(this);
            botonB.setActionCommand("b"+i);
            botonC.addActionListener(this);
            botonC.setActionCommand("c"+i);
            Dimension preferredSize= new Dimension(40, 40);
            botonB.setPreferredSize(preferredSize);
            botonC.setPreferredSize(preferredSize);
            labels.add(equipo);
            text.setEditable(false);
            textF.add(text);
            botones.add(botonB);
            botones.add(botonC);
            
        }
        nombre.add(nombreTorneo);
        nombre.add(nombreT);
        equipos.add(nombre,BorderLayout.NORTH);
        equipos.add(labels, BorderLayout.WEST);
        equipos.add(textF, BorderLayout.CENTER);
        equipos.add(botones, BorderLayout.EAST);
        
        return equipos;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Atras")){
            frame.dispose();
            Runnable VentanaInicio= new VentanaInicio();
            VentanaInicio.run();
        }
        for (int i = 1; i <= 10; i++) {
            if(e.getActionCommand().equals("b"+i)){
             file.showOpenDialog(frame);
             textfields.get(i).setText(""+file.getSelectedFile());
             
        }
        }
        for (int i = 1; i <= 10; i++) {
            if(e.getActionCommand().equals("c"+i)){
             CrearEquipo crearEquipo= new CrearEquipo(this, i);
             
         }
        }
        if(e.getActionCommand().equals("Continuar")){
        Torneo t1= new Torneo(nombreT.getText());
            for (JTextField tf : textfields.values()) {
                try {
                    serv.crearEquipo(t1, dao.cargarEquipo(tf.getText()));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CrearEquipo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumeroJugadorException ex) {
                Logger.getLogger(creacionTorneo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            t1.setPartidos();
            try {
                serv.guardarTorneo(t1);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(creacionTorneo.class.getName()).log(Level.SEVERE, null, ex);
            }
         Runnable ventanaTorneo = null;
            try {
                ventanaTorneo = new ventanaTorneo(t1);
            } catch (NumeroJugadorException ex) {
                Logger.getLogger(creacionTorneo.class.getName()).log(Level.SEVERE, null, ex);
            }
         ventanaTorneo.run();
         frame.dispose();
        } 
        System.out.println(e.getActionCommand());
    }

    @Override
    public void run() {
        
        continuar.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(numeroEquipos(), BorderLayout.NORTH);
        frame.setSize(500, 175);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        opciones.add(atras);
        opciones.add(continuar);
        
        atras.addActionListener(this);
        frame.add(opciones, BorderLayout.SOUTH);
        frame.add(espaciosEquipos(2), BorderLayout.CENTER);
        frame.setVisible(true);
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        for (int i = 2; i <= 10; i++) {
            if (a.getSelectedItem().equals(""+i)){
            equipos.removeAll();
            equipos.repaint();
            frame.add(espaciosEquipos(i),BorderLayout.CENTER);
            frame.setSize(500,i*93);
            frame.setVisible(true);
            
        }
        }
        
        
    }

     public void setRuta(String ruta, int numero){
        textfields.get(numero).setText(ruta);
    }
    
}
