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

    public Torneo(String nombre) {
        this.nombre = nombre;
        HashMap  <String, Equipo> equipos = new HashMap();
        this.equipos= equipos;
    }
     
    public void anadirEquipo(Equipo e){
        equipos.put(e.getNombre(), e);
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
        return output;
    }   

    public String getNombre() {
        return nombre;
    }
     
}
