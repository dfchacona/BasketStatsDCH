/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import data.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author dieguischa
 */
public class ventanaTorneo implements Runnable{
    Torneo torneo;
    JTabbedPane tabs; 
    JFrame frame; 
    JPanel panelPartidos;
    HashMap <String, JButton> botones;
    public ventanaTorneo(Torneo torneo){
       this.torneo=torneo; 
       tabs = new JTabbedPane();
       frame= new JFrame();
       botones= new <String, JButton> HashMap();
    }
    public JPanel panelPartidosT(){
        
        panelPartidos= new JPanel(new GridLayout(torneo.getPartidos().size()/3,2));
        GridBagConstraints c = new GridBagConstraints();
        for (Partido p1: torneo.getPartidos()) {
            JPanel panelM1A= new JPanel(new FlowLayout());
            JPanel panelM1B= new JPanel(new FlowLayout());
            JPanel panelM2= new JPanel(new GridLayout(2,2));
            JLabel EquipoA= new JLabel(p1.getEquipoA());
            panelM1A.add(EquipoA);
            panelM1A.add(new JTextField("0"));
            JLabel EquipoB= new JLabel(p1.getEquipoB());
            panelM1B.add(new JTextField("0"));
            panelM1B.add(EquipoB);
            JButton jugar= new JButton ("Jugar");
            JButton stats= new JButton ("Estadisticas");
            panelM2.add(panelM1A);
            panelM2.add(panelM1B);
            panelM2.add(jugar);
            panelM2.add(stats);
            panelPartidos.add(panelM2);
            botones.put(p1.getEquipoA()+p1.getEquipoB(), jugar);
            
        }
        return panelPartidos;
    }
    public void run(){
        
        tabs.addTab("Partidos", panelPartidosT());
        
        frame.add(tabs);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
