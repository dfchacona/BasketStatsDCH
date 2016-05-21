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
    private Equipo [] equipos; 
    private int [] marcador;

    public Partido(Equipo equipoA, Equipo equipoB) {
        equipos= new Equipo [2];
        equipos[0]=equipoA;
        equipos[1]=equipoB;
        this.equipos = equipos;
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
        return "Partido{" + "equipos=" + Arrays.toString(equipos) + '}';
    }
     
     
   
   
}
