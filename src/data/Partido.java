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
    private Equipo [] equipos2;
    private int [] marcador;
    private int [] marcadoresParcialesA;
    private int [] marcadoresParcialesB;
    String stats; 
    Torneo t1;

    public Partido(String equipoA, String equipoB, Torneo t1) {
        equipos= new String [2];
        equipos[0]=equipoA ;
        equipos[1]= equipoB;
        this.equipos = equipos;
        marcador = new int [2];
        marcadoresParcialesA = new int [4];
        marcadoresParcialesB = new int [4];
        marcador[0]=0;
        marcador[1]=0;
        this.t1=t1;
    }
     public Partido(Equipo equipoA, Equipo equipoB) {
        equipos= new String [2];
        equipos2= new Equipo [2];
        equipos[0]=equipoA.getNombre() ;
        equipos[1]= equipoB.getNombre();
        this.equipos = equipos;
        marcador = new int [2];
        marcadoresParcialesA = new int [4];
        marcadoresParcialesB = new int [4];
        marcador[0]=0;
        marcador[1]=0;
        equipos2[0]=equipoA;
        equipos2[1]=equipoB;
        
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

    public void setMarcadorParcialA(int marcador, int cuarto) {
        this.marcadoresParcialesA[cuarto-1]= marcador;  
    }
    public void setMarcadorParcialB(int marcador, int cuarto) {
        this.marcadoresParcialesB[cuarto-1]= marcador;
       
    }
    public int getMarcadorParcialA(int cuarto) {
        return this.marcadoresParcialesA[cuarto-1];
    }
    public int getMarcadorParcialB(int cuarto) {
        return this.marcadoresParcialesB[cuarto-1];
    }
    public void setStats(){
        this.stats=this.toString();
    }
    public void asignarStats(String stats){
        this.stats=stats;
    }
    public String getStats(){
        return this.stats;
    }
    @Override
    public String toString() {
        return this.obtenerEquipoA().toString() + "\n"+this.obtenerEquipoB().toString();
    }
     
    public String getEquipoA(){
        return equipos[0];
    }
    public String getEquipoB(){
        return equipos[1];
    }
    public int getMarcadorEquipoA(){
        return marcador[0];
    }
    public int getMarcadorEquipoB(){
        return marcador[1];
    }
    public Equipo obtenerEquipoA(){
        try {
            return t1.getEquipos().get(equipos[0]);
        } catch (NullPointerException e) {
            return equipos2[0];
        }
        
        
    }
    public Equipo obtenerEquipoB(){
       try {
            return t1.getEquipos().get(equipos[1]);
        } catch (NullPointerException e) {
            return equipos2[1];
        }
        
    }
    
    public String toOutput(){
        return "Partido,"+this.equipos[0]+","+this.equipos[1]+","+this.marcador[0]+","+this.marcador[1]+","+this.toString()+",";
    }
    
}
