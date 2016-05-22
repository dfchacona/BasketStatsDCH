/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Servicios.servicios;
import dao.dao;
import data.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author dieguischa
 */
public class ventanaTorneo implements Runnable, ActionListener{
    dao dao;
    servicios serv;
    Torneo torneo;
    JTabbedPane tabs; 
    JFrame frame; 
    JPanel panelPartidos;
    HashMap <String, JButton> botones;
    HashMap <String, JTextField> textfields;
    public ventanaTorneo(Torneo torneo){
       dao= new dao();
       serv= new servicios();
       this.torneo=torneo; 
       tabs = new JTabbedPane();
       frame= new JFrame();
       botones= new <String, JButton> HashMap();
       textfields=  new <String, JTextField> HashMap();
    }
    public JPanel panelPartidosT(){
        
        panelPartidos= new JPanel(new GridLayout(torneo.getPartidos().size()/3,2));
        for (Partido p1: torneo.getPartidos().values()) {
            JPanel panelM1A= new JPanel(new FlowLayout());
            JPanel panelM1B= new JPanel(new FlowLayout());
            JPanel panelM2= new JPanel(new GridLayout(2,2));
            JLabel EquipoA= new JLabel(p1.getEquipoA());
            JTextField tfequipoA= new JTextField(""+p1.getMarcadorEquipoA());
            JTextField tfequipoB= new JTextField(""+p1.getMarcadorEquipoA());
            panelM1A.add(EquipoA);
            panelM1A.add(tfequipoA);
            JLabel EquipoB= new JLabel(p1.getEquipoB());
            panelM1B.add(tfequipoB);
            panelM1B.add(EquipoB);
            JButton jugar= new JButton ("Jugar");
            jugar.addActionListener(this);
            jugar.setActionCommand(p1.getEquipoA()+p1.getEquipoB()+"jugar");
            JButton stats= new JButton ("Estadisticas");
            stats.setActionCommand(p1.getEquipoA()+p1.getEquipoB()+"stats");
            stats.addActionListener(this);
            panelM2.add(panelM1A);
            panelM2.add(panelM1B);
            panelM2.add(jugar);
            panelM2.add(stats);
            panelPartidos.add(panelM2);
            botones.put(p1.getEquipoA()+p1.getEquipoB(), jugar);
            textfields.put(p1.getEquipoA()+p1.getEquipoB(), tfequipoA);
            textfields.put(p1.getEquipoB()+p1.getEquipoA(), tfequipoB);
            
        }
        return panelPartidos;
    }
    public void run(){
        tabs.addTab("Partidos", panelPartidosT());  
        frame.add(tabs);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Equipo e1 : torneo.getEquipos().values()) {
            for(Equipo e2 : torneo.getEquipos().values()){
                if(e.getActionCommand().equals(e1.getNombre()+e2.getNombre()+"jugar")) {
                    Runnable ventanaPartido = new ventanaPartido(e1, e2, torneo);
                    ventanaPartido.run();
                }
                 if(e.getActionCommand().equals(e1.getNombre()+e2.getNombre()+"stats")) {  
                    try {
                        Partido p1=dao.cargarPartido(e1.getNombre(),e2.getNombre(),torneo);
                        System.out.println(p1.getStats());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
        }
    }
}
