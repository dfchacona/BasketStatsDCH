/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import dao.dao;
import java.io.*;
import java.io.PrintStream;
import data.*;
import java.util.Scanner;
import Exception.*;
/**
 *
 * @author dieguischa
 */
public class servicios {
    dao dao= new dao();
    public Torneo cargarTorneo(String archivo) throws FileNotFoundException{
        
        Torneo t1= dao.cargarTorneo(archivo);
        return t1;
    }
    public Equipo cargarEquipo() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del equipo");
        String nombreE=scanner.next();
        Equipo e1= dao.cargarEquipo(nombreE+".txt");
        return e1;
    }
    
    
    
    public Equipo crearEquipo(Torneo t1, Equipo e1) throws FileNotFoundException, NumeroJugadorException{
        
        t1.anadirEquipo(e1);    
        PrintStream fout = new PrintStream(new File(e1.getNombre()+".txt"));
        fout.println(e1.toOutput());  
       
        return e1;
    }
    public void crearJugador(Equipo e1, Jugador j1) throws FileNotFoundException, NumeroJugadorException{
        
        e1.anadirJugador(j1);
        PrintStream fout = new PrintStream(new File(e1.getNombre()+".txt"));
        fout.println(e1.toOutput());  
    }
    public Torneo crearTorneo() throws FileNotFoundException, NumeroJugadorException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del torneo");
        String nombreT= scanner.next();
        Torneo t1= new Torneo(nombreT);
        PrintStream fout = new PrintStream(new File(nombreT+".txt"));
        fout.println(t1.toOutput());  
        return t1;
    }
    
    public void guardarPartido(Partido p1) throws FileNotFoundException{
        String nombreArchivo=p1.getEquipoA()+p1.getEquipoB()+".txt";
        String ret= nombreArchivo.replaceAll(" ","");
        PrintStream fout = new PrintStream(new File(ret));
        fout.println(p1.toOutput());  
        
    }
    
    public void guardarTorneo(Torneo t1) throws FileNotFoundException{
        String nombreArchivo=t1.getNombre()+".txt";
        String ret= nombreArchivo.replaceAll(" ","");
        PrintStream fout = new PrintStream(new File(ret));
        fout.println(t1.toOutput());  
        
    }
    public void guardarEquipo(Equipo e1) throws FileNotFoundException{
        String nombreArchivo=e1.getNombre()+".txt";
        String ret= nombreArchivo.replaceAll(" ","");
        PrintStream fout = new PrintStream(new File(e1.getNombre()+".txt"));
        fout.println(e1.toOutput());  
        
    }
    public void guardarJugador(Jugador j1) throws FileNotFoundException{
        String nombreArchivo=j1.getNombre()+j1.getApellido()+".txt";
        String ret= nombreArchivo.replaceAll(" ","");
        PrintStream fout = new PrintStream(new File(ret));
        fout.println(j1.toOutput());  
        
    }
}
