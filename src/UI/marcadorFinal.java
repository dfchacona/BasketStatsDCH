/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import data.Partido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dieguischa
 */


public class marcadorFinal extends JFrame {
	JPanel panelA;
        Partido p1;
        JFrame frame= new JFrame();
public marcadorFinal(Partido p1){
        this.p1= p1;
	frame.setTitle("Marcador Final");
	frame.setSize(400,150);
	frame.setResizable(true);
	frame.setLocationRelativeTo(null);
	frame.setLayout(new BorderLayout());
	frame.add(PuntuacionEquipo());
	frame.setVisible(true);
	
	
}
public JPanel PuntuacionEquipo(){
        panelA = new JPanel(new FlowLayout (FlowLayout.CENTER));
	JPanel EquipoA= new JPanel (new GridLayout(0,7));
	String equipoA= p1.getEquipoA();
	JLabel NombreEquipo= new JLabel(""+equipoA);
	Font f = new Font( "Arial",Font.BOLD,22 );
	NombreEquipo.setFont(f);
	 
	JLabel Margen= new JLabel("");
	JLabel Q1= new JLabel("1Q");
	JLabel Q2= new JLabel("2Q");
	JLabel Q3= new JLabel("3Q");
	JLabel Q4= new JLabel("4Q");
	JLabel OT= new JLabel("OT");
	JLabel total= new JLabel ("Total");
	JLabel PTS1QA= new JLabel(""+p1.getMarcadorParcialA(1));
	JLabel PTS2QA= new JLabel(""+p1.getMarcadorParcialA(2));
	JLabel PTS3QA= new JLabel(""+p1.getMarcadorParcialA(3));
	JLabel PTS4QA= new JLabel(""+p1.getMarcadorParcialA(4));
	JLabel PTSOTA= new JLabel("-");
	
	JLabel PTSTotalA= new JLabel(""+p1.getMarcadorEquipoA());
	JLabel NombreEquipoB= new JLabel(p1.getEquipoB());
	NombreEquipoB.setFont(f);
	JLabel PTS1QB= new JLabel(""+p1.getMarcadorParcialB(1));
	JLabel PTS2QB= new JLabel(""+p1.getMarcadorParcialB(2));
	JLabel PTS3QB= new JLabel(""+p1.getMarcadorParcialB(3));
	JLabel PTS4QB= new JLabel(""+p1.getMarcadorParcialB(4));
	JLabel PTSOTB= new JLabel("-");
	
	JLabel PTSTotalB= new JLabel(""+p1.getMarcadorEquipoB());
	EquipoA.add(Margen);
	EquipoA.add(Q1);
	EquipoA.add(Q2);
	EquipoA.add(Q3);
	EquipoA.add(Q4);
	EquipoA.add(OT);
	EquipoA.add(total);
	EquipoA.add(NombreEquipo);
	EquipoA.add(PTS1QA);
	EquipoA.add(PTS2QA);
	EquipoA.add(PTS3QA);
	EquipoA.add(PTS4QA);
	EquipoA.add(PTSOTA);
	EquipoA.add(PTSTotalA);
	EquipoA.add(NombreEquipoB);
	EquipoA.add(PTS1QB);
	EquipoA.add(PTS2QB);
	EquipoA.add(PTS3QB);
	EquipoA.add(PTS4QB);
	EquipoA.add(PTSOTB);
	EquipoA.add(PTSTotalB);
	panelA.add(EquipoA);
        return panelA;
}  
}
