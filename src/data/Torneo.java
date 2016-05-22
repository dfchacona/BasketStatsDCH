/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 *
 * @author dieguischa
 */
public class Torneo {
    private String nombre; 
    private HashMap <String, Equipo> equipos; 
    private ArrayList <Partido> partidos;
    private int numEquipos; 

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new <String, Equipo>  HashMap();
        this.partidos= new <Partido> ArrayList();
        this.setPartidos();
        
    }
     
    public void anadirEquipo(Equipo e){
        equipos.put(e.getNombre(), e);
        this.numEquipos++;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", equipos=" + equipos + '}';
    }

    public HashMap<String, Equipo> getEquipos() {
        return equipos;
    }
    public String toOutput(){
        String output = ""+nombre+",";
        for(Equipo e1: equipos.values()){
            output=output+"Equipo,"+e1.getNombre()+",";
        }
        for(Partido p1: partidos){
            output=output+p1.toOutput();
        }
        return output;
    }   

    public String getNombre() {
        return nombre;
    }
    public void setPartidos(){
        HashMap <String,Equipo> copia=new <String, Equipo>  HashMap();
        copia=(HashMap<String, Equipo>) equipos.clone();
        for (int i = 1; i <= this.numEquipos; i++) {
            for (Equipo e1: equipos.values()){
                copia.remove(e1.getNombre());
                for (Equipo e2: copia.values()){
                    Partido p1= new Partido(e1.getNombre(), e2.getNombre(), this);
                    partidos.add(p1);    
                }
                
        }
        }
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    public void anadirPartido(Partido p1){
        partidos.add(p1);
    }
}
