/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
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
   
    public ventanaPartido(Equipo e1, Equipo e2){
        this.e1 = e1;
        this.e2 = e2;
        this.textfields=new <String, JTextField>  HashMap();
        this.choice= new <String, Choice> HashMap();
    }
    
    public JPanel construyePanelChoice(Equipo e1){
	JPanel panelChoice= new JPanel(); 
        
        Choice a = new Choice();
	 a.addItem("Todo el equipo");
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
            ImageIcon im= new ImageIcon("folder.png");
            System.out.println(j1.getRutaFoto());
            if(j1.getRutaFoto().equals("")){
            
               im= new ImageIcon("folder.png");  
            }else{
               im= new ImageIcon(j1.getRutaFoto());
            }
            JLabel foto= new JLabel(im);
            JButton boton= new JButton(""+j1.getNumero());
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
	 JTextField FG= new JTextField("0/0---0%");
	    panelStA.add(marca2);
	    panelStA.add(FG);
	    FG.setEditable(false);
            textfields.put(e1.getNombre()+"FG", FG);
	 JTextField TresFG= new JTextField("0/0---0%");
	    panelStA.add(marca3);
	    panelStA.add(TresFG);
	    TresFG.setEditable(false);
            textfields.put(e1.getNombre()+"3FG", TresFG);
	  JTextField TL= new JTextField("0/0---0%");
	    panelStA.add(marca10);
	    panelStA.add(TL);
	    TL.setEditable(false);
            textfields.put(e1.getNombre()+"TL", TL);
	   JTextField Ast= new JTextField("0");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
       for(Choice a: choice.values()){
           for(Jugador j1: e1.getJugadores().values()){
               if(a.getSelectedItem().equals(""+j1.getNumero())){
                textfields.get(e1.getNombre()+"Pts").setText("3"+j1.getPuntos());
               }
           }
           for(Jugador j1: e2.getJugadores().values()){
               if(a.getSelectedItem().equals(""+j1.getNumero())){
                textfields.get(e2.getNombre()+"Pts").setText("3"+j1.getPuntos());
               }
           }
       }
    }

}
