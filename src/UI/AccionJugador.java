/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import data.*;
import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import Exception.*;

/**
 *
 * @author dieguischa
 */
public class AccionJugador extends JFrame implements ActionListener,Runnable{
    JButton Anotar2;
    JButton Fallar2;
    JButton Anotar3;
    JButton Fallar3;
    JButton Anotar1; 
    JButton Fallar1; 
    JButton Asistencia; 
    JButton Rebote;
    JButton ReboteOfensivo;
    JButton Tapon; 
    JButton Robo; 
    JButton Falta;
    JButton cancelar;
    ArrayList <JButton> botones; 
    Jugador j1;
    ventanaPartido padre; 
    JFrame frame;

    public AccionJugador(Jugador j1, ventanaPartido padre) throws JugadorExpulsadoException{
        this.j1 = j1;
        if (this.j1.getFaltas()==5){
            throw new JugadorExpulsadoException("Jugador Expulsado");
        }
        
        botones= new <JButton> ArrayList(); 
        this.padre=padre;
        cancelar= new JButton("Cancelar");
        cancelar.addActionListener(this);
    }
    public JPanel panelBotones(){
        JPanel panelM= new JPanel(new GridLayout(6,2));
        Anotar2= new JButton ("Tiro de 2 anotado");
        botones.add(Anotar2);
        Fallar2= new JButton ("Tiro de 2 fallado");
        botones.add(Fallar2);
        Anotar3= new JButton ("Tiro de 3 anotado");
        botones.add(Anotar3);
        Fallar3= new JButton ("Tiro de 3 fallado");
        botones.add(Fallar3);
        Anotar1= new JButton ("Tiro Libre anotado");
        botones.add(Anotar1);
        Fallar1= new JButton ("Tiro Libre fallado"); 
        botones.add(Fallar1);
        Asistencia= new JButton ("Asistencia");
        botones.add(Asistencia);
        Rebote= new JButton ("Rebote defensivo");
        botones.add(Rebote);
        ReboteOfensivo=new JButton ("Rebote ofensivo");
        botones.add(ReboteOfensivo);
        Tapon= new JButton ("Tapon"); 
        botones.add(Tapon);
        Robo= new JButton ("Robo");
        botones.add(Robo);
        Falta= new JButton ("Falta");
        botones.add(Falta);
        for(JButton boton: botones){
            panelM.add(boton);
            boton.addActionListener(this);
        }
        return panelM;
    }
    public void run() {
        
        frame= new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(panelBotones(), BorderLayout.NORTH);
        frame.setSize(300, 300);
        frame.add(cancelar, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ItemEvent ie = null;
        if(e.getActionCommand().equals("Tiro de 2 anotado")){
            frame.dispose();
            j1.anotar2();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
            
        }
        if(e.getActionCommand().equals("Tiro de 2 fallado")){
            frame.dispose();
            j1.fallar2();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Tiro de 3 anotado")){
            frame.dispose();
            j1.anotar3();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Tiro de 3 fallado")){
            frame.dispose();
            j1.fallar3();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Tiro Libre anotado")){
            frame.dispose();
            j1.anotarLibre();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Tiro Libre Fallado")){
            frame.dispose();
            j1.fallarLibre();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Asistencia")){
            frame.dispose();
            j1.asistir();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Rebote ofensivo")){
            frame.dispose();
            j1.rebotarOfensivo();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Rebote defensivo")){
            frame.dispose();
            j1.rebotarDefensivo();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Tapon")){
            frame.dispose();
            j1.taponar();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Robo")){
            frame.dispose();
            j1.robar();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Falta")){
            frame.dispose();
            j1.cometerfalta();
            padre.itemStateChanged(ie);
            System.out.println(j1.toString());
        }
        if(e.getActionCommand().equals("Cancelar")){
            frame.dispose();
        }
    }

   
}
