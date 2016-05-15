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
public class Equipo {
    private String nombre; 
    private HashMap <Integer ,Jugador> jugadores; 
    private int partidosJugados; 
    private int partidosGanados; 
    private int partidosPerdidos;
    public Equipo(String nombre){
        HashMap <Integer, Jugador> jugadores= new HashMap(); 
        this.nombre=nombre;
        this.jugadores=jugadores;
    }

    public HashMap<Integer, Jugador> getJugadores() {
        return jugadores;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        partidosPerdidos=this.partidosJugados-this.partidosGanados;
        return partidosPerdidos;
    }

    public void anadirJugador(Jugador j) {
        this.jugadores.put(j.getNumero(), j);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Equipo: " + "Nombre=" + nombre + 
               "\nJugadores:\n" + jugadores + 
               "\nPartidosJugados=" + partidosJugados +
               "\nPartidosGanados=" + partidosGanados + 
               "\nPartidosPerdidos=" + this.getPartidosPerdidos() + '}';
    }

    public String toOutput(){
        String output=""+nombre+",";
        for(Jugador j1: jugadores.values()){
            output=output+"Jugador,"+j1.getNombre()+","+j1.getApellido()+",";
        }
        return output;
    }
    
    
}
