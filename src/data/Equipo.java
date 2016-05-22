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
        this.partidosJugados=0;
        this.partidosGanados=0;
    }

    public HashMap<Integer, Jugador> getJugadores() {
        return jugadores;
    }

    public void ganarPartido() {
       this.partidosGanados++;
    }

    public void jugarPartido() {
        this.partidosJugados++;
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

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }
 
    @Override
    public String toString() {
        String ret="Equipo: " + this.getNombre()
                +"\nPuntos Totales: "+ this.getPuntos()
                +"\nAsistencias Totales: "+this.getAsistencias()
                +"\nRebotes Totales: "+(this.getRebotesDTot()+this.getRebotesO())
                +"\nRebotes Ofensivos Totales: "+(this.getRebotesO())
                +"\nRobos Totales: "+(this.getRobos())
                +"\nTapones Totales: "+(this.getTapones())
                +"\nFaltas Totales: "+(this.getFaltas())+"\n";
                
        for(Jugador j1: jugadores.values()){
            ret=ret+j1.toString();
        }
        return ret;
        
    }

    public String toOutput(){
        String output=""+nombre+",";
        output=output+this.partidosJugados+","+this.partidosGanados+",";
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
        try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
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
        try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
       
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
          try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
       public int getPuntosTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getPuntosTot();
        }
        return puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }
       
    public int getAsistenciasTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getAsistenciasTot();
        }
        return puntos;
    }
    public int getRebotesDTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesDefensivosTot();
        }
        return puntos;
    }
    public int getRebotesOTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesOfensivosTot();
        }
        return puntos;
    }
    public int getTaponesTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getTaponesTot();
        }
        return puntos;
    }
    public int getRobostTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRobosTot();
        }
        return puntos;
    }
    public int getFaltasTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getFaltasTot();
        }
        return puntos;
    }
    public String getTCTot(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosDoble();
            aciertos+=j1.getDoblesConvertidos();
            
        }
        try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
     public String get3TCTot(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosTriple();
            aciertos+=j1.getTriplesConvertidos();
            
        }
        try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
       
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
      public String getTLTot(){
        int intentos=0;
        int aciertos=0;
        double porcentaje=0;
        for(Jugador j1:this.jugadores.values()){
            intentos+=j1.getIntentosLibre();
            aciertos+=j1.getLibresConvertidos();
            
        }
          try {
             porcentaje=aciertos*100/intentos;
        } catch(Exception ArithmeticException){
            return "0/0---0.0%";
        }
        return aciertos+"/"+intentos+"---"+porcentaje+"%";
    }
}
