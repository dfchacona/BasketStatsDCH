/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;

/**
 *
 * @author dieguischa
 */
public class Partido {
    private String [] equipos; 
    private int [] marcador;
    Torneo t1;

    public Partido(String equipoA, String equipoB, Torneo t1) {
        equipos= new String [2];
        equipos[0]=equipoA ;
        equipos[1]= equipoB;
        this.equipos = equipos;
        marcador = new int [2];
        marcador[0]=0;
        marcador[1]=0;
        this.t1=t1;
    }
    
    public int[] getMarcador() {
        return marcador;
    }

    public void setMarcador(int marcadorA, int marcadorB) {
        marcador = new int [2];
        marcador[0]= marcadorA;
        marcador[1]= marcadorB;
        this.marcador = marcador;
    }

    @Override
    public String toString() {
        return "Partido{" + "equipos=" + this.getEquipoA() + this.getEquipoB()+ '}';
    }
     
    public String getEquipoA(){
        return equipos[0];
    }
    public String getEquipoB(){
        return equipos[1];
    }
    public Equipo obtenerEquipoA(){
        return t1.getEquipos().get(equipos[0]);
        
    }
    public Equipo obtenerEquipoB(){
        return t1.getEquipos().get(equipos[1]);
        
    }
    public String toOutput(){
        return "Partido,"+this.equipos[0]+","+this.equipos[1]+","+this.marcador[0]+","+this.marcador[1]+",";
    }
}
