/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dieguischa
 */
public class ventanaEstadisticas extends JFrame implements ActionListener, Runnable{
    JFrame frame; 
    JTextArea area;
    JScrollPane campoTexto; 
    String texto;
    JButton boton;
    
    ventanaEstadisticas(String texto){
        frame= new JFrame();
        this.texto=texto;
        frame.setLayout(new BorderLayout());
        area = new JTextArea(5, 20);
        area.setText(texto);
        boton= new JButton("OK");
        campoTexto= new JScrollPane(area);
        boton.addActionListener(this);
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OK")){
            frame.dispose();
        }
    }

    @Override
    public void run() {
        frame.add(campoTexto, BorderLayout.CENTER);
        frame.add(boton, BorderLayout.SOUTH);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    
}
