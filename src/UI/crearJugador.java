/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Servicios.servicios;
import data.Jugador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author dieguischa
 */
public class crearJugador extends JFrame implements Runnable, ActionListener{
    Jugador j1;
    CrearEquipo crear; 
    partidoAmistoso amistoso;
    int numeroTextF;
    JFrame frame= new JFrame();
    JButton continuar= new JButton("Aceptar");
    JButton atras= new JButton("Cancelar");
    JPanel opciones= new JPanel(new FlowLayout());
    Icon icono= new ImageIcon("folder.png");
    JButton botonB= new  JButton(icono);
    JFileChooser rutaF=new JFileChooser();
    JFileChooser rutaJ=new JFileChooser();
    JTextField RutaFotoT= new JTextField ();
    servicios serv= new servicios();
    JTextField nombreT= new JTextField();
    JTextField apellidoT= new JTextField();; 
    JTextField numeroT= new JTextField();;
    public crearJugador(CrearEquipo crear, int num){
       this.crear=crear;
       this.numeroTextF= num;
       this.run();
       
    }
    public crearJugador(partidoAmistoso amistoso, int num){
       this.amistoso=amistoso;
       this.numeroTextF= num;
       this.run();
       
    }
    public JPanel informacion(){
        JLabel nombre=new JLabel("Nombre:");
        JLabel apellido=new JLabel("Apellido:");
        JLabel numero=new JLabel("#:");
        JLabel RutaFoto= new JLabel ("Ruta de Foto");
        JPanel informacion= new JPanel (new GridLayout(4, 2));
        
        informacion.add(nombre);
        informacion.add(nombreT);
        informacion.add(apellido);
        informacion.add(apellidoT);
        informacion.add(numero);
        informacion.add(numeroT);
        informacion.add(RutaFoto);
        informacion.add(RutaFotoT);
        
        
        
        
        return informacion; 
    }
    @Override
    public void run() {
        frame.setLayout(new BorderLayout());
        frame.setSize(400,250);
        
        opciones.add(atras);
        opciones.add(continuar);
        frame.add(informacion(), BorderLayout.CENTER);
        frame.add(opciones, BorderLayout.SOUTH);
        JLabel vacia= new JLabel("");
        JLabel vaciaB= new JLabel("");
        JLabel vaciaC= new JLabel("");
        
        JPanel boton= new JPanel(new GridLayout(4, 1));
        boton.add(vacia);
        boton.add(vaciaB);
        boton.add(vaciaC);
        continuar.addActionListener(this);
        atras.addActionListener(this);
        boton.add(botonB);
        botonB.addActionListener(this);
        botonB.setActionCommand("b");
        frame.add(boton, BorderLayout.EAST);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("Cancelar")){
             
            frame.repaint();
            frame.dispose();
        }
        
            if(e.getActionCommand().equals("b")){
             rutaF.showOpenDialog(frame);
             RutaFotoT.setText(""+rutaF.getSelectedFile());
             
        }
            if(e.getActionCommand().equals("Aceptar")){
                try{
                     Jugador j1= new Jugador(nombreT.getText(), apellidoT.getText(), Integer.parseInt(numeroT.getText()), RutaFotoT.getText());
                     serv.guardarJugador(j1);
                     String nombreArchivo=nombreT.getText()+apellidoT.getText()+".txt";
                     String ret= nombreArchivo.replaceAll(" ","");
                     try{
                     crear.setRuta(ret, this.numeroTextF);
                     }catch(NullPointerException exc){
                         amistoso.setRuta(ret, this.numeroTextF);
                     }
                     frame.dispose();
                     
                }catch (NullPointerException exc){
                     JOptionPane.showMessageDialog(null, "Ingrese los datos completos e intente nuevamente");
                     frame.dispose();
                } catch (FileNotFoundException ex) {
                 
              } catch  (NumberFormatException exc2) {
                 JOptionPane.showMessageDialog(null, "Ingrese los datos completos e intente nuevamente");
                     frame.dispose();
              }        
             
        }
    }
    public String getJugador(){
        return nombreT.getText()+apellidoT.getText();
    }
    
}
