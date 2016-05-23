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
import java.awt.BorderLayout;
import java.awt.Choice;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dieguischa
 */
public class ventanaTorneo implements Runnable, ActionListener, ListSelectionListener, ItemListener{
    dao dao;
    servicios serv;
    Torneo torneo;
    JTabbedPane tabs; 
    JFrame frame; 
    JPanel panelPartidos;
    JPanel panelClasificacion;
    HashMap <String, JButton> botones;
    HashMap <String, JTextField> textfields;
    Choice a; 
    JLabel foto;
    ImageIcon im;
    ImageIcon imBotonJ;
    JLabel nombreLider;
    JLabel estadisticaLider;
    JList lista;
    Jugador j1;
    JPanel panelLideres;
    Equipo e1;
    public ventanaTorneo(Torneo torneo) throws NumeroJugadorException{
       dao= new dao();
       serv= new servicios();
       this.torneo=torneo; 
       tabs = new JTabbedPane();
       frame= new JFrame();
       botones= new <String, JButton> HashMap();
       textfields=  new <String, JTextField> HashMap();
       a= new Choice();
       a.addItem("Jugadores");
       a.addItem("Equipos");
       j1=torneo.getLiderPuntos();
            if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
            }else{
               im= new ImageIcon(j1.getRutaFoto());
            }
        foto= new JLabel(im);
        estadisticaLider= new JLabel(j1.getPPG()+"PPG");
        nombreLider= new JLabel(j1.getNombre()+" "+j1.getApellido());
        imBotonJ= new ImageIcon("Play.png");
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
            JButton jugar= new JButton (imBotonJ);
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
            JLabel PorcentajeEquipo= new JLabel("0.0"); 
            try{
            double porcentajeEquipo=e1.getPartidosGanados()*100/e1.getPartidosJugados();  
            PorcentajeEquipo.setText(""+porcentajeEquipo);
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
        JPanel panelM= new JPanel(new BorderLayout());
        panelM.add(a, BorderLayout.NORTH);
        a.addItemListener(this);
        lista = new JList();
        
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION ); 
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement("Puntos");
        modelo.addElement("Asistencias");
        modelo.addElement("Porcentaje TC");
        modelo.addElement("Porcentaje 3TC");
        modelo.addElement("Porcentaje TL");
        modelo.addElement("Rebotes");
        modelo.addElement("Tapones");
        modelo.addElement("Robos");
        lista.setModel(modelo);
        lista.addListSelectionListener(this);
        JScrollPane scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 120,220, 80);
        scrollLista.setViewportView(lista);
        panelM.add(scrollLista, BorderLayout.WEST);
        JPanel panelLideres = new JPanel(new FlowLayout());
        panelLideres.add(foto); 
        panelLideres.add(nombreLider);
        panelLideres.add(estadisticaLider);
        panelM.add(panelLideres, BorderLayout.CENTER);
        
        
        return panelM;
    }
    @Override
    public void run(){
        tabs.addTab("Partidos", panelPartidosT());  
        tabs.addTab("Clasificación", panelClasificacionT());
        try {
            panelLideres= panelLideresT();
        } catch (NumeroJugadorException ex) {
            Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabs.addTab("Lideres", panelLideres);
        
        frame.add(tabs);
        
        frame.setSize(570,64*torneo.getEquipos().size());
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

     public void actualizar(){
        tabs.removeAll();
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
    public void valueChanged(ListSelectionEvent e) {
       if(a.getSelectedItem().equals("Jugadores")){
       if(lista.getSelectedIndex()==0){
           try {
               j1=torneo.getLiderPuntos();
           } catch (NumeroJugadorException ex) {
               Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
           }
               nombreLider.setText(j1.getNombre()+" "+j1.getApellido());
               estadisticaLider.setText(j1.getPPG()+" PPG");
               if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
                }else{
               im= new ImageIcon(j1.getRutaFoto());
               }
               foto.setIcon(im);
               panelLideres.repaint();
           
       }    
        if(lista.getSelectedIndex()==1){
           try {
               j1=torneo.getLiderAsistencias();
           } catch (NumeroJugadorException ex) {
               Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
           }
               nombreLider.setText(j1.getNombre()+" "+j1.getApellido());
               estadisticaLider.setText(j1.getAPG()+" APG");
               if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
                }else{
               im= new ImageIcon(j1.getRutaFoto());
               }
               foto.setIcon(im);
               panelLideres.repaint();
           
       } 
       if(lista.getSelectedIndex()==2){
           try {
               j1=torneo.getLiderFG();
           } catch (NumeroJugadorException ex) {
               Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
           }
               nombreLider.setText(j1.getNombre()+" "+j1.getApellido());
               estadisticaLider.setText(j1.getPorcentajeTCTot()+"%");
               if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
                }else{
               im= new ImageIcon(j1.getRutaFoto());
               }
               foto.setIcon(im);
               panelLideres.repaint();
           
       }
       if(lista.getSelectedIndex()==3){
           try {
               j1=torneo.getLider3FG();
           } catch (NumeroJugadorException ex) {
               Logger.getLogger(ventanaTorneo.class.getName()).log(Level.SEVERE, null, ex);
           }
               nombreLider.setText(j1.getNombre()+" "+j1.getApellido());
               estadisticaLider.setText(j1.getPorcentajeTriplesTot()+"%");
               if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
                }else{
               im= new ImageIcon(j1.getRutaFoto());
               }
               foto.setIcon(im);
               panelLideres.repaint();
           
       }
       
       }
       if(a.getSelectedItem().equals("Equipos")){
          if(lista.getSelectedIndex()==0){
           
               e1=torneo.getLiderEquipoPuntos();
           
               nombreLider.setText(e1.getNombre());
               estadisticaLider.setText(e1.getPPG()+" PPG");
               im= new ImageIcon("equipo.png");  
               foto.setIcon(im);
               panelLideres.repaint();
               
           
       }    
          if(lista.getSelectedIndex()==1){
           
               e1=torneo.getLiderEquipoAsistencias();
           
               nombreLider.setText(e1.getNombre());
               estadisticaLider.setText(e1.getAPG()+" APG");
               im= new ImageIcon("equipo.png");  
               foto.setIcon(im);
               panelLideres.repaint();
               
           
       } 
           if(lista.getSelectedIndex()==2){
           
                e1=torneo.getLiderEquipoFG();
           
               nombreLider.setText(e1.getNombre());
               estadisticaLider.setText(e1.getPorcentajeTCTot()+" %");
               im= new ImageIcon("equipo.png");  
               foto.setIcon(im);
               panelLideres.repaint();
               
           
       } 
           if(lista.getSelectedIndex()==3){
           
                e1=torneo.getLiderEquipo3FG();
           
               nombreLider.setText(e1.getNombre());
               estadisticaLider.setText(e1.getPorcentaje3TCTot()+" %");
               im= new ImageIcon("equipo.png");  
               foto.setIcon(im);
               panelLideres.repaint();
               
           
       } 
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       
    }

    
}
