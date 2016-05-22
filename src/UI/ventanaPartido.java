/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exception.JugadorExpulsadoException;
import Servicios.servicios;
import data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ventanaPartido extends JFrame implements ItemListener,ActionListener, Runnable{
    JFrame frame= new JFrame();
    Equipo e1; 
    Equipo e2;
    JLabel marca1;
    JLabel marca2;
    JLabel marca3;
    JLabel marca4;
    JLabel marca5;
    JLabel marca6;
    JLabel marca7;
    JLabel marca9;
    JLabel marca10;
    JLabel marca11;
    HashMap <String, JTextField> textfields;
    HashMap <String, Choice> choice; 
    servicios serv= new servicios();
    public ventanaPartido(Equipo e1, Equipo e2){
        this.e1 = e1;
        this.e2 = e2;
        this.textfields=new <String, JTextField>  HashMap();
        this.choice= new <String, Choice> HashMap();
    }
    
    public JPanel construyePanelChoice(Equipo e1){
	JPanel panelChoice= new JPanel(); 
        
        Choice a = new Choice();
        a.setName(""+e1.getNombre());
	 a.addItem(e1.getNombre());
	 for(Jugador j1: e1.getJugadores().values()){
			a.addItem(""+j1.getNumero());
			
		}
               choice.put(e1.getNombre(), a);
     a.addItemListener(this);
     panelChoice.add(a);
     return panelChoice;
}
public JPanel PanelOpciones(){
	    JPanel panelSouth = new JPanel(new FlowLayout());
		JButton botonFinQ=new JButton ("Fin del Cuarto");
		botonFinQ.setActionCommand("finQ");
	    botonFinQ.addActionListener(this);
	    JButton botonMarcadorF=new JButton ("Marcador Final");  
            botonMarcadorF.setActionCommand("marcadorf");
	    botonMarcadorF.addActionListener(this);
	    panelSouth.add(botonFinQ);
	    panelSouth.add(botonMarcadorF);
		JButton botonSalir=new JButton ("Salir");
		botonSalir.setActionCommand("salir");
	    botonSalir.addActionListener(this);
	    panelSouth.add(botonSalir);

	return panelSouth;
	}
    public JPanel panelJugadores(Equipo e1){
        
        JPanel panelM= new JPanel(new GridLayout(e1.getJugadores().size(), 1));
        for (Jugador j1: e1.getJugadores().values()) {
            JPanel panel= new JPanel(new BorderLayout());
            ImageIcon im;
            System.out.println(j1.getRutaFoto());
            if(j1.getRutaFoto().equals("")){
               im= new ImageIcon("desconocido.png");  
            }else{
               im= new ImageIcon(j1.getRutaFoto());
            }
            JLabel foto= new JLabel(im);
            JButton boton= new JButton(""+j1.getNumero());
            boton.setActionCommand(e1.getNombre()+j1.getNumero());
            boton.addActionListener(this);
            JLabel nombre= new JLabel(""+j1.getApellido());
            panel.add(nombre, BorderLayout.NORTH);
            panel.add(foto, BorderLayout.CENTER);
            panel.add(boton,BorderLayout.SOUTH);
            panelM.add(panel);
        }
        return panelM; 
    }
    public JPanel panelStats(Equipo e1){
         JPanel panelStA= new JPanel(new GridLayout(10,2));
	 marca1 = new JLabel("Puntos"); 
	 marca2 = new JLabel("Tiros de Campo"); 
	 marca3 = new JLabel("Tiros de Campo 3");
	 marca10= new JLabel("Tiros Libres");
	 marca11= new JLabel("Asistencias");
	 marca4 = new JLabel("Rebotes defensivos");
	 marca5 = new JLabel("Rebotes ofensivos"); 
	 marca6 = new JLabel("Tapones"); 
	 marca7 = new JLabel("Robos");
	 
	 marca9 = new JLabel("Faltas");
	
	
        JTextField Pts = new JTextField("0");
	   panelStA.add(marca1);
	   panelStA.add(Pts);
	   Pts.setEditable(false);
           textfields.put(e1.getNombre()+"Pts", Pts);
	 JTextField FG= new JTextField("0/0---0.0%");
	    panelStA.add(marca2);
	    panelStA.add(FG);
	    FG.setEditable(false);
            textfields.put(e1.getNombre()+"FG", FG);
	 JTextField TresFG= new JTextField("0/0---0.0%");
	    panelStA.add(marca3);
	    panelStA.add(TresFG);
	    TresFG.setEditable(false);
            textfields.put(e1.getNombre()+"3FG", TresFG);
	  JTextField TL= new JTextField("0/0---0.0%");
	    panelStA.add(marca10);
	    panelStA.add(TL);
	    TL.setEditable(false);
            textfields.put(e1.getNombre()+"TL", TL);
	   JTextField Ast= new JTextField("0.0");
	    panelStA.add(marca11);
	    panelStA.add(Ast);
            textfields.put(e1.getNombre()+"Ast", Ast);
	     Ast.setEditable(false);
           JTextField Re= new JTextField("0");
		panelStA.add(marca4);
		Re.setEditable(false);
		 panelStA.add(Re);
                 textfields.put(e1.getNombre()+"Re", Re);
           JTextField ReO= new JTextField("0");
	     panelStA.add(marca5);
	     panelStA.add(ReO);
	     ReO.setEditable(false);
             textfields.put(e1.getNombre()+"ReO", ReO);
             JTextField Ta= new JTextField("0");
		panelStA.add(marca6);
		 panelStA.add(Ta);
                 textfields.put(e1.getNombre()+"Ta", Ta);
		Ta.setEditable(false);
	    JTextField Ro=new JTextField("0");
	    panelStA.add(marca7);
	    panelStA.add(Ro);
	    Ro.setEditable(false);
            textfields.put(e1.getNombre()+"Ro", Ro);
	   JTextField Flt=new JTextField("0");
	    panelStA.add(marca9);
            textfields.put(e1.getNombre()+"Flt", Flt);
	    panelStA.add(Flt);
	  Flt.setEditable(false);
	  Pts.setBackground(Color.WHITE);
	  FG.setBackground(Color.WHITE);
	  Re.setBackground(Color.WHITE);
	  ReO.setBackground(Color.WHITE);
	  Ta.setBackground(Color.WHITE);
	  Ro.setBackground(Color.WHITE);
	  Flt.setBackground(Color.WHITE);
	  TresFG.setBackground(Color.WHITE);
	  TL.setBackground(Color.WHITE);
	  Ast.setBackground(Color.WHITE);

        return panelStA; 
    }
    
    
    @Override
    public void run() {
        JPanel panelNorth= new JPanel( new GridLayout(1,2));
        panelNorth.add(construyePanelChoice(this.e1));
        panelNorth.add(construyePanelChoice(this.e2));
        JPanel panelCentral= new JPanel( new GridLayout(1,2));
        panelCentral.add(panelStats(e1));
        panelCentral.add(panelStats(e2));
        frame.setLayout(new BorderLayout());
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(panelJugadores(this.e1), BorderLayout.WEST);
        frame.add(panelJugadores(this.e2), BorderLayout.EAST);
        frame.add(PanelOpciones(), BorderLayout.SOUTH);
        frame.setSize(850, 460);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(Jugador j1: e1.getJugadores().values()){
            if (e.getActionCommand().equals(e1.getNombre()+j1.getNumero())){
                Runnable AccionJugador=null;
                try {
                    AccionJugador = new AccionJugador(j1, this);
                } catch (JugadorExpulsadoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                try {
                    AccionJugador.run();
                } catch (NullPointerException ex) {
                    break;
                }
                
                
            }
            
        }
        for(Jugador j1: e2.getJugadores().values()){
            if (e.getActionCommand().equals(e2.getNombre()+j1.getNumero())){
                Runnable AccionJugador=null;
                try {
                    AccionJugador = new AccionJugador(j1, this);
                } catch (JugadorExpulsadoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                try {
                    AccionJugador.run();
                } catch (NullPointerException ex) {
                    break;
                }
                
                
            }
            
        }
        if(e.getActionCommand().equals("marcadorf")){
            for(Jugador j1: e1.getJugadores().values()){
                j1.setPuntosTot(j1.getPuntos());
                j1.setAsistenciasTot(j1.getAsistencias());
                j1.setIntentosDobleTot(j1.getIntentosDoble());
                j1.setIntentosTripleTot(j1.getIntentosTriple());
                j1.setDoblesConvertidosTot(j1.getDoblesConvertidos());
                j1.setTriplesConvertidosTot(j1.getTriplesConvertidos());
                j1.setIntentosLibreTot(j1.getIntentosLibre());
                j1.setLibresConvertidosTot(j1.getLibresConvertidos());
                j1.setRebotesDefensivosTot(j1.getRebotesDefensivos());
                j1.setRebotesOfensivosTot(j1.getRebotesOfensivos());
                j1.setTaponesTot(j1.getTapones());
                j1.setRobosTot(j1.getRobos());
                j1.setFaltasTot(j1.getFaltas());
                try {
                    serv.guardarJugador(j1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ventanaPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                j1.clear();
            }
            for(Jugador j1: e2.getJugadores().values()){
                j1.setPuntosTot(j1.getPuntos());
                j1.setAsistenciasTot(j1.getAsistencias());
                j1.setIntentosDobleTot(j1.getIntentosDoble());
                j1.setIntentosTripleTot(j1.getIntentosTriple());
                j1.setDoblesConvertidosTot(j1.getDoblesConvertidos());
                j1.setTriplesConvertidosTot(j1.getTriplesConvertidos());
                j1.setIntentosLibreTot(j1.getIntentosLibre());
                j1.setLibresConvertidosTot(j1.getLibresConvertidos());
                j1.setRebotesDefensivosTot(j1.getRebotesDefensivos());
                j1.setRebotesOfensivosTot(j1.getRebotesOfensivos());
                j1.setTaponesTot(j1.getTapones());
                j1.setRobosTot(j1.getRobos());
                j1.setFaltasTot(j1.getFaltas());
                try {
                    serv.guardarJugador(j1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ventanaPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                j1.clear();
            }
        }
        
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
       for(Choice a: choice.values()){
           for(Jugador j1: e1.getJugadores().values()){
               if(a.getSelectedItem().equals(""+j1.getNumero())&&a.getName().equals(e1.getNombre())){
                textfields.get(e1.getNombre()+"Pts").setText(""+j1.getPuntos());
                textfields.get(e1.getNombre()+"FG").setText(""+j1.getTC());
                textfields.get(e1.getNombre()+"3FG").setText(""+j1.get3TC());
                textfields.get(e1.getNombre()+"TL").setText(""+j1.getTL());
                textfields.get(e1.getNombre()+"Ast").setText(""+j1.getAsistencias());
                textfields.get(e1.getNombre()+"Re").setText(""+j1.getRebotesDefensivos());
                textfields.get(e1.getNombre()+"ReO").setText(""+j1.getRebotesOfensivos());
                textfields.get(e1.getNombre()+"Ta").setText(""+j1.getTapones());
                textfields.get(e1.getNombre()+"Ro").setText(""+j1.getRobos());
                textfields.get(e1.getNombre()+"Flt").setText(""+j1.getFaltas());
                 switch (j1.getFaltas()){
                    case 3:
                    textfields.get(e1.getNombre()+"Flt").setBackground(Color.yellow);
                    break;
                    case 4:
                    textfields.get(e1.getNombre()+"Flt").setBackground(Color.orange);
                    break;
                    case 5:
                    textfields.get(e1.getNombre()+"Flt").setBackground(Color.red);
                    break;
                    default:
                        break;
                }
               }
           }
           for(Jugador j1: e2.getJugadores().values()){
               if(a.getSelectedItem().equals(""+j1.getNumero())&&a.getName().equals(e2.getNombre())){
                
                textfields.get(e2.getNombre()+"Pts").setText(""+j1.getPuntos());
                textfields.get(e2.getNombre()+"FG").setText(""+j1.getTC());
                textfields.get(e2.getNombre()+"3FG").setText(""+j1.get3TC());
                textfields.get(e2.getNombre()+"TL").setText(""+j1.getTL());
                textfields.get(e2.getNombre()+"Ast").setText(""+j1.getAsistencias());
                textfields.get(e2.getNombre()+"Re").setText(""+j1.getRebotesDefensivos());
                textfields.get(e2.getNombre()+"ReO").setText(""+j1.getRebotesOfensivos());
                textfields.get(e2.getNombre()+"Ta").setText(""+j1.getTapones());
                textfields.get(e2.getNombre()+"Ro").setText(""+j1.getRobos());
                textfields.get(e2.getNombre()+"Flt").setText(""+j1.getFaltas());
                switch (j1.getFaltas()){
                    case 3:
                    textfields.get(e2.getNombre()+"Flt").setBackground(Color.yellow);
                    break;
                    case 4:
                    textfields.get(e2.getNombre()+"Flt").setBackground(Color.orange);
                    break;
                    case 5:
                    textfields.get(e2.getNombre()+"Flt").setBackground(Color.red);
                    break;
                    default:
                        break;
                }
               }
           }
           if(a.getSelectedItem().equals(e2.getNombre())){
                textfields.get(e2.getNombre()+"Pts").setText(""+e2.getPuntos());
                textfields.get(e2.getNombre()+"FG").setText(""+e2.getTC());
                textfields.get(e2.getNombre()+"3FG").setText(""+e2.get3TC());
                textfields.get(e2.getNombre()+"TL").setText(""+e2.getTL());
                textfields.get(e2.getNombre()+"Ast").setText(""+e2.getAsistencias());
                textfields.get(e2.getNombre()+"Re").setText(""+e2.getRebotesD());
                textfields.get(e2.getNombre()+"ReO").setText(""+e2.getRebotesO());
                textfields.get(e2.getNombre()+"Ta").setText(""+e2.getTapones());
                textfields.get(e2.getNombre()+"Ro").setText(""+e2.getRobos());
                textfields.get(e2.getNombre()+"Flt").setText(""+e2.getFaltas());
               }
           if(a.getSelectedItem().equals(e1.getNombre())){
                textfields.get(e1.getNombre()+"Pts").setText(""+e1.getPuntos());
                textfields.get(e1.getNombre()+"FG").setText(""+e1.getTC());
                textfields.get(e1.getNombre()+"3FG").setText(""+e1.get3TC());
                textfields.get(e1.getNombre()+"TL").setText(""+e1.getTL());
                textfields.get(e1.getNombre()+"Ast").setText(""+e1.getAsistencias());
                textfields.get(e1.getNombre()+"Re").setText(""+e1.getRebotesD());
                textfields.get(e1.getNombre()+"ReO").setText(""+e1.getRebotesO());
                textfields.get(e1.getNombre()+"Ta").setText(""+e1.getTapones());
                textfields.get(e1.getNombre()+"Ro").setText(""+e1.getRobos());
                textfields.get(e1.getNombre()+"Flt").setText(""+e1.getFaltas());
               }
       }
    }

}
