/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Servicios.servicios;
import dao.dao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import data.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author dieguischa
 */
public class CrearEquipo extends JFrame implements ActionListener, Runnable, ItemListener{
    Equipo e1; 
    creacionTorneo crear; 
    int numeroTextF;
    dao dao= new dao();
    JFileChooser file=new JFileChooser();
    JTextField nombreT= new JTextField();
    JLabel nombreTorneo= new JLabel("Nombre Equipo:");
    JFrame frame= new JFrame();
    JPanel opciones= new JPanel(new FlowLayout());
    Choice a = new Choice();
    JPanel jugadores= new JPanel(new BorderLayout());
    JButton continuar= new JButton("Aceptar");
    HashMap <Integer, JTextField> textfields= new HashMap();
    JButton atras= new JButton("Cancelar");
    Icon icono= new ImageIcon("folder.png");
    Icon iconoB= new ImageIcon("add-page.png");
    servicios serv= new servicios();
    
    public CrearEquipo(creacionTorneo crear, int num){
       this.crear=crear;
       this.numeroTextF= num;
       this.run();
       
    }
    
     public JPanel numeroJugadores(){
        JPanel numequipos= new JPanel(new FlowLayout());
        JLabel equipos= new JLabel("Numero de jugadores");
        
	 
	       for (int i = 5; i <= 10; i++) {
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
           JLabel equipo= new JLabel("Jugador "+i);
          
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
        jugadores.add(nombre,BorderLayout.NORTH);
        jugadores.add(labels, BorderLayout.WEST);
        jugadores.add(textF, BorderLayout.CENTER);
        jugadores.add(botones, BorderLayout.EAST);
        
        return jugadores;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i <= 10; i++) {
            if(e.getActionCommand().equals("b"+i)){
             file.showOpenDialog(frame);
             textfields.get(i).setText(""+file.getSelectedFile());
             
        }
        }
        for (int i = 1; i <= 10; i++) {
            if(e.getActionCommand().equals("c"+i)){
             crearJugador crearJugador= new crearJugador(this, i);  
            
             
             
             
        }
        }
        if (e.getActionCommand().equals("Cancelar")){
            frame.dispose();
        }
        if (e.getActionCommand().equals("Aceptar")){
            Equipo e1= new Equipo(nombreT.getText());
            for (JTextField t1 : textfields.values()) {
                try {
                    serv.crearJugador(e1, dao.cargarJugador(t1.getText()));
                    serv.guardarEquipo(e1);
                    String nombreArchivo=nombreT.getText()+".txt";
                    String ret= nombreArchivo.replaceAll(" ","");
                    crear.setRuta(ret, this.numeroTextF);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CrearEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            frame.dispose();
{
                
            }
            
        }
    }

    @Override
    public void run() {
        
        continuar.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(numeroJugadores(), BorderLayout.NORTH);
        frame.setSize(500, 250);
       
        opciones.add(atras);
        opciones.add(continuar);
        continuar.addActionListener(this);
        atras.addActionListener(this);
        frame.add(opciones, BorderLayout.SOUTH);
        frame.add(espaciosEquipos(5), BorderLayout.CENTER);
        frame.setVisible(true);
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 5; i <= 10; i++) {
            if (a.getSelectedItem().equals(""+i)){
            jugadores.removeAll();
            jugadores.repaint();
            frame.add(espaciosEquipos(i),BorderLayout.CENTER);
            frame.setSize(500,i*50);
            frame.setVisible(true);
            
        }
        }
    }
    public void setRuta(String ruta, int numero){
        textfields.get(numero).setText(ruta);
    }
}


