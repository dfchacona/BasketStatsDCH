/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.NumeroJugadorException;
import java.util.*;

/**
 * Clase equipo pertenceinte a la clase torneo 
 * @author dieguischa
 */
public class Equipo {
    private String nombre; 
    private HashMap <Integer ,Jugador> jugadores; 
    private int partidosJugados; 
    private int partidosGanados; 
    private int partidosPerdidos;
    /**
     * Metodo constructor que permite crear a un equipo
     * @param nombre Nombre del equipo
     */
    public Equipo(String nombre){
        HashMap <Integer, Jugador> jugadores= new HashMap(); 
        this.nombre=nombre;
        this.jugadores=jugadores;
        this.partidosJugados=0;
        this.partidosGanados=0;
    }
    public Equipo() throws NumeroJugadorException{
        Jugador j1= new Jugador("Dummy", "Dummy", 0, "");
        j1.setAsistenciasTot(0);
        jugadores= new <Integer, Jugador> HashMap(); 
        this.anadirJugador(j1);
        this.partidosJugados=0;
    }
    /**
     * Metodo que retorna la lista de jugadores del equipo
     * @return  Lista de jugadores
     */
    public HashMap<Integer, Jugador> getJugadores() {
        return jugadores;
    }
    /**
     * Metodo implementado cuando un equipo gana un partido
     */
    public void ganarPartido() {
       this.partidosGanados++;
    }
    /**
     * Metodo implementado cuando un equipo juega un partido
     */
    public void jugarPartido() {
        this.partidosJugados++;
    }
    /**
     * Metodo que retorna la cantidad de partidos perdidos por un equipo 
     * restando la cantidad de partidos jugados y la de partidos ganados
     * @return Partidos perdidos
     */
    public int getPartidosPerdidos() {
        partidosPerdidos=this.partidosJugados-this.partidosGanados;
        return partidosPerdidos;
    }
    /**
     * Metodo que permite añadir un jugador a la lista de jugadores del equipo
     * @param j Jugador que sera añadido
     */
    public void anadirJugador(Jugador j) {
        this.jugadores.put(j.getNumero(), j);
    }
    /**
     * Metodo que retorna el nombre del equipo 
     * @return Nombre del equipo 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo Para asignarle una cantidad de partidos a la 
     * variable partidos jugados
     * @param partidosJugados valor que sera asignado
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    /**
     * MetMetodo Para asignarle una cantidad de partidos a la 
     * variable partidos ganados
     * @param partidosGanados valor que sera asignado
     */
    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }
    /**
     * Metodo que retorna una cadena que contiene la informacion del equipo 
     * tanto como estadisticas de todo el equipo como la estadisticas individuales
     * de cada uno de sus jugadores
     * @return Cadena de texto con dicha representacion 
     */
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
    /**
     * Metodo que retorna una cadena de texto que sera guardada en un archivo 
     * @return Cadena a ser guardada
     */
    public String toOutput(){
        String output=""+nombre+",";
        output=output+this.partidosJugados+","+this.partidosGanados+",";
        for(Jugador j1: jugadores.values()){
            output=output+"Jugador,"+j1.getNombre()+","+j1.getApellido()+",";
        }
        
        return output;
    }
    /**
     * Metodo que permite obtener la cantidad de puntos totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de puntos
     */
    public int getPuntos(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getPuntos();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de asistencias totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de asistencias
     */
    public int getAsistencias(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getAsistencias();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de rebotes defensivos totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de rebotes defensivos
     */
    public int getRebotesD(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesDefensivos();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de rebotes ofensivos totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de rebotes ofensivos
     */
    public int getRebotesO(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesOfensivos();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de tapones totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de tapones
     */
    public int getTapones(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getTapones();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de robos totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de robos
     */
    public int getRobos(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRobos();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la cantidad de faltas totales del equipo 
     * sumando la de todos sus jugadores
     * @return Cantidad de faltas
     */
    public int getFaltas(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getFaltas();
        }
        return puntos;
    }
    /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de campo del equipo la cantidad de tiros fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores
     * @return Cadena de informacion de los tiros de campo
     */
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
    /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de triple del equipo la cantidad de triples fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores
     * @return Cadena de informacion de los triples
     */
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
     /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de libre del equipo la cantidad de tiros libres fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores
     * @return Cadena de informacion de los tiros libres
     */
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
      /**
     * Metodo que permite obtener la cantidad de puntos totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de puntos
     */
       public int getPuntosTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getPuntosTot();
        }
        return puntos;
    }
    /**
     * Metodo que retorna la cantidad de partidos jugados por el equipo
     * @return Cantidad de partidos jugados
     */   
    public int getPartidosJugados() {
        return partidosJugados;
    }
    /**
     * Metodo que retorna la cantidad de partidos ganados por el equipo
     * @return Cantidad de partidos ganados
     */  
    public int getPartidosGanados() {
        return partidosGanados;
    }
      /**
     * Metodo que permite obtener la cantidad de asistencias totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de puntos
     */   
    public int getAsistenciasTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getAsistenciasTot();
        }
        return puntos;
    }
      /**
     * Metodo que permite obtener la cantidad de reotes defensivos totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de rebotes defensivos
     */
    public int getRebotesDTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesDefensivosTot();
        }
        return puntos;
    }
      /**
     * Metodo que permite obtener la cantidad de rebotes ofensivos totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de rebotes ofensivos
     */
    public int getRebotesOTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRebotesOfensivosTot();
        }
        return puntos;
    }
      /**
     * Metodo que permite obtener la cantidad de tapones totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de tapones
     */
    public int getTaponesTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getTaponesTot();
        }
        return puntos;
    }
      /**
     * Metodo que permite obtener la cantidad de robos totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de tobos
     */
    public int getRobostTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getRobosTot();
        }
        return puntos;
    }
      /**
     * Metodo que permite obtener la cantidad de faltas totales del equipo
     * a lo largo del torneo sumando la de todos sus jugadores
     * @return Cantidad de faltas
     */
    public int getFaltasTot(){
        int puntos=0;
        for(Jugador j1:this.jugadores.values()){
            puntos+=j1.getFaltasTot();
        }
        return puntos;
    }
       /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de campo del equipo la cantidad de tiros de campo fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores a lo largo del torneo
     * @return Cadena de informacion de los tiros campo
     */
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
       /**
     * Metodo que permite obtener el porcentaje de tiros de campo del equipo
     * @return Porcentaje de tiros de campo del equipo
     */
    public double getPorcentajeTCTot(){
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
            return 0;
        }
        return porcentaje;
    }
       /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de triples del equipo la cantidad de triples fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores a lo largo del torneo
     * @return Cadena de informacion de los triples
     */
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
     /**
     * Metodo que permite obtener el porcentaje de triples del equipo
     * @return Porcentaje de tiros de campo del equipo
     */
    public double getPorcentaje3TCTot(){
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
            return 0;
        }
        return porcentaje;
    }
       /**
     * Metodo que permite obtener la una cadena de texto que involucra la cantidad
     * de intentos de libre del equipo la cantidad de tiros libres fallados y el porcentaje
     * correspondiente sumando la de todos sus jugadores a lo largo del torneo
     * @return Cadena de informacion de los tiros libres
     */
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
      /**
     * Metodo que permite obtener el porcentaje de libres del equipo
     * @return Porcentaje de tiros de campo del equipo
     */
    public double getPorcentajeTLTot(){
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
            return 0;
        }
        return porcentaje;
    }
      /**
     * Metodo que retorna el promedio de puntos por partido del equipo
     * @return Puntos por partido
     */
    public double getPPG(){
        try {
            return this.getPuntosTot()/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
      /**
     * Metodo que retorna el promedio de asisitencias por partido del equipo
     * @return Puntos por partido
     */
    public double getAPG(){
        try {
            double APG= (double)this.getAsistenciasTot()/this.partidosJugados;
            return APG;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
      /**
     * Metodo que retorna el promedio de rebotes por partido del equipo
     * @return Puntos por partido
     */
    public double getRPG(){
        try {
            return this.getRebotesDTot()+this.getRebotesOTot()/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
      /**
     * Metodo que retorna el promedio de Robos por partido del equipo
     * @return Puntos por partido
     */
    public double getRoPG(){
        try {
            return this.getRobostTot()/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
      /**
     * Metodo que retorna el promedio de tapas por partido del equipo
     * @return Puntos por partido
     */
    public double getTPG(){
        try {
            return this.getTaponesTot()/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
