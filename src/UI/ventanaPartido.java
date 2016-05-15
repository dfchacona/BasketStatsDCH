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
import javax.swing.*;
/**
 *
 * @author dieguischa
 */
public class ventanaPartido extends JFrame implements ActionListener, Runnable{
    JFrame frame= new JFrame();
    public ventanaPartido(){
        
    }
    public JPanel construyePanelChoice(){
	JPanel panelChoice= new JPanel(); 
        
        Choice a = new Choice();
	 a.addItem("Todo el equipo");
	 for(int x=0; x<=4 ; x++){
			a.addItem(""+x);
			
		}
     

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
    public JPanel panelJugadores(){
        
        JPanel panelM= new JPanel(new GridLayout(4, 1));
        for (int i = 1; i <=4; i++) {
            JPanel panel= new JPanel(new BorderLayout());
            ImageIcon im= new ImageIcon("folder.png");
            JLabel label= new JLabel(im);
            JButton boton= new JButton(""+i);
            panel.add(label, BorderLayout.CENTER);
            panel.add(boton,BorderLayout.SOUTH);
            panelM.add(panel);
        }
        return panelM; 
    }
    public JPanel panelStats(){
         JPanel panelStA= new JPanel(new GridLayout(10,2));
	 JLabel marca1 = new JLabel("Puntos"); 
	 JLabel marca2 = new JLabel("Tiros de Campo"); 
	 JLabel marca3 = new JLabel("Tiros de Campo 3");
	 JLabel marca10= new JLabel("Tiros Libres");
	 JLabel marca11= new JLabel("Asistencias");
	 JLabel marca4 = new JLabel("Rebotes defensivos");
	 JLabel marca5 = new JLabel("Rebotes ofensivos"); 
	 JLabel marca6 = new JLabel("Tapones"); 
	 JLabel marca7 = new JLabel("Robos");
	 JLabel marca8 = new JLabel("Perdidas");
	 JLabel marca9 = new JLabel("Faltas");
	
	
	JTextField Pts= new JTextField("0");
	   panelStA.add(marca1);
	   panelStA.add(Pts);
	   Pts.setEditable(false);
	 JTextField FG= new JTextField("0/0---0%");
	    panelStA.add(marca2);
	    panelStA.add(FG);
	    FG.setEditable(false);
	  JTextField TresFG= new JTextField("0/0---0%");
	    panelStA.add(marca3);
	    panelStA.add(TresFG);
	    TresFG.setEditable(false);
	   JTextField TL= new JTextField("0/0---0%");
	    panelStA.add(marca10);
	    panelStA.add(TL);
	    TL.setEditable(false);
	   JTextField Ast= new JTextField("0");
	    panelStA.add(marca11);
	    panelStA.add(Ast);
	   Ast.setEditable(false);
    JTextField Re= new JTextField("0");
		panelStA.add(marca4);
		Re.setEditable(false);
		 panelStA.add(Re);
     JTextField ReO= new JTextField("0");
	     panelStA.add(marca5);
	     panelStA.add(ReO);
	     ReO.setEditable(false);
     JTextField Ta= new JTextField("0");
		panelStA.add(marca6);
		 panelStA.add(Ta);
		Ta.setEditable(false);
	 JTextField Ro=new JTextField("0");
	    panelStA.add(marca7);
	    panelStA.add(Ro);
	  Ro.setEditable(false);
	
	  JTextField Flt=new JTextField("0");
	    panelStA.add(marca9);
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
        panelNorth.add(construyePanelChoice());
        panelNorth.add(construyePanelChoice());
        JPanel panelCentral= new JPanel( new GridLayout(1,2));
        panelCentral.add(panelStats());
        panelCentral.add(panelStats());
        frame.setLayout(new BorderLayout());
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(panelJugadores(), BorderLayout.WEST);
        frame.add(panelJugadores(), BorderLayout.EAST);
        frame.add(PanelOpciones(), BorderLayout.SOUTH);
        frame.setSize(850, 460);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
