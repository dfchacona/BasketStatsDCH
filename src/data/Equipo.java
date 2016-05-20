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
    
    public int getPuntos(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getPuntos();
        }
        return puntos;
    }
    public int getAsistencias(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getAsistencias();
        }
        return puntos;
    }
    public int getRebotesD(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesDefensivos();
        }
        return puntos;
    }
    public int getRebotesO(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesOfensivos();
        }
        return puntos;
    }
    public int getTapones(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getTapones();
        }
        return puntos;
    }
    public int getRobos(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRobos();
        }
        return puntos;
    }
    public int getFaltas(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getFaltas();
        }
        return puntos;
    }
    public String getTC(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosDoble();
            aciertos+=j1.getDoblesConvertidos();
            
        }
        porcentaje=aciertos*100/intentos;
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
     public String get3TC(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosTriple();
            aciertos+=j1.getTriplesConvertidos();
            
        }
        porcentaje=aciertos*100/intentos;
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
      public String getTL(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosLibre();
            aciertos+=j1.getLibresConvertidos();
            
        }
        porcentaje=aciertos*100/intentos;
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
}
