/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exception.NumeroJugadorException;
import Exception.PartidoNoJugadoException;
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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

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
    JPanel panelClasificacion;
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
            JTextField tfequipoB= new JTextField(""+p1.getMarcadorEquipoB());
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
            frame.setSize(300,500);
        }
        return panelPartidos;
    }
    public JPanel panelClasificacionT(){
        
        panelClasificacion= new JPanel(new GridLayout(torneo.getEquipos().size()+1, 3));
        panelClasificacion.add(new JLabel("Nombre Equipo"));
        panelClasificacion.add(new JLabel("Record Equipo"));
        panelClasificacion.add(new JLabel("Porcentaje de Victorias"));
        for (Equipo e1: torneo.getEquipos().values()) {
            JLabel EquipoA= new JLabel(e1.getNombre());
            JLabel RecordEquipo= new JLabel(e1.getPartidosGanados()+"-"+e1.getPartidosPerdidos());
            JLabel PorcentajeEquipo= new JLabel(".000"); 
            try{
            PorcentajeEquipo.setText(""+e1.getPartidosGanados()/e1.getPartidosJugados());
            }catch(ArithmeticException ex){
               
            }
            
            panelClasificacion.add(EquipoA);
            panelClasificacion.add(RecordEquipo); 
            panelClasificacion.add(PorcentajeEquipo);
        }
        panelClasificacion.setSize(500,500);
        return panelClasificacion;
    }
    public JPanel panelLideresT() throws NumeroJugadorException{
        
        JPanel panelLideres = new JPanel(new GridLayout(3, 2));
        Jugador j1=torneo.getLiderPuntos();
        Jugador j2=torneo.getLiderAsistencias();
        Jugador j3=torneo.getLiderFG();
        panelLideres.add(new JLabel(j1.getNombre()+" "+j1.getApellido()));
        panelLideres.add(new JLabel(""+j1.getPuntosTot()));
        panelLideres.add(new JLabel(j2.getNombre()+" "+j2.getApellido()));
        panelLideres.add(new JLabel(""+j2.getAsistenciasTot()));
        panelLideres.add(new JLabel(j3.getNombre()));
        panelLideres.add(new JLabel(""+j3.getTCTot()+"%"));
        
        
        return panelLideres;
    }
    public void run(){
        tabs.addTab("Partidos", panelPartidosT());  
        tabs.addTab("Clasificación", panelClasificacionT());
        try {
            tabs.addTab("Lideres", panelLideresT());
        } catch (NumeroJugadorException ex) {
            Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.add(tabs);
        
        frame.setSize(300,300);
        frame.setVisible(true);
       
          
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Equipo e1 : torneo.getEquipos().values()) {
            for(Equipo e2 : torneo.getEquipos().values()){
                if(e.getActionCommand().equals(e1.getNombre()+e2.getNombre()+"jugar")) {
                    Runnable ventanaPartido = new ventanaPartido(e1, e2, torneo, this);
                    ventanaPartido.run();
                }
                 if(e.getActionCommand().equals(e1.getNombre()+e2.getNombre()+"stats")) {  
                    try {
                        Partido p1=dao.cargarPartido(e1.getNombre(),e2.getNombre(),torneo);
                        if(p1.getStats() == null){
                            throw (new PartidoNoJugadoException("El partido aun no ha sido jugado"));
                        }    
                        Runnable ventanaEstadisticas= new ventanaEstadisticas(p1.getStats());
                        ventanaEstadisticas.run();
                        
                    } catch (FileNotFoundException ex) {
                       
                    } catch (PartidoNoJugadoException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                } 
            }
        }
          if (tabs.getSelectedIndex()==0){
              frame.setSize(500,500);
          }
                
          if(tabs.getSelectedIndex()==1){
                 frame.setSize(300,300);
          }
              
    }


}
