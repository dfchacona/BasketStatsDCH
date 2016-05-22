/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dao.dao;
import data.Equipo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dieguischa
 */
public class partidoAmistoso implements ActionListener, Runnable{
    JFrame frame= new JFrame(); 
    JFileChooser file=new JFileChooser();
    Icon icono= new ImageIcon("folder.png");
    Icon iconoB= new ImageIcon("add-page.png");
    JButton continuar= new JButton("Continuar");
    JButton atras= new JButton("Atras");
    JPanel jugadores= new JPanel(new BorderLayout());
    dao dao= new dao();
     HashMap <Integer, JTextField> textfields= new HashMap();
    public JPanel espaciosEquipos(){
         JPanel nombre= new JPanel(new GridLayout(1,2));
        JPanel labels= new JPanel(new GridLayout(2,1));
        JPanel textF= new JPanel(new GridLayout(2,1));
        JPanel botones= new JPanel(new GridLayout(2,2));
        
       
        for (int i = 1; i <= 2; i++) {
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
             CrearEquipo crearEquipo= new CrearEquipo(this, i);
                          
        }
    }
        if(e.getActionCommand().equals("Atras")){
            frame.dispose();
            Runnable VentanaInicio= new VentanaInicio();
            VentanaInicio.run();
        }
    if(e.getActionCommand().equals("Continuar")){
        Equipo e1=null;  
        Equipo e2=null;
        try {
                e1= dao.cargarEquipo(textfields.get(1).getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(partidoAmistoso.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                e2= dao.cargarEquipo(textfields.get(2).getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(partidoAmistoso.class.getName()).log(Level.SEVERE, null, ex);
            }
            Runnable ventanaPartido= new ventanaPartido(e1, e2);
            ventanaPartido.run();
            
    }    
    }
    
    @Override
    public void run() {
        
        continuar.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 250);
        JPanel opciones= new JPanel(new FlowLayout());
        opciones.add(atras);
        opciones.add(continuar);
        atras.addActionListener(this);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(opciones, BorderLayout.SOUTH);
        frame.add(espaciosEquipos(), BorderLayout.CENTER);
        frame.setVisible(true);
        
    }
        public void setRuta(String ruta, int numero){
        textfields.get(numero).setText(ruta);
    }
}
