/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.*;

/**
 *
 * @author dieguischa
 */
public class Jugador {
    private String rutaFoto;
    private int puntos; 
    private int asistencias; 
    private int rebotes;
    private int rebotesDefensivos;
    private int rebotesOfensivos;
    private int tapones; 
    private int robos; 
    private int faltas; 
    private int intentosDoble; 
    private int intentosTriple; 
    private int intentosLibre; 
    private int doblesConvertidos; 
    private int triplesConvertidos; 
    private int libresConvertidos; 
    private String nombre; 
    private String apellido; 
    private int numero; 
    private int partidosJugados; 
    private double porcentajeTC;
    private double porcentajeTriples;
    private double porcentajeTL;

    public Jugador(String rutaFoto, int puntos, int asistencias, int rebotes, int rebotesOfensivos, int tapones, int robos, int faltas, int intentosDoble, int intentosTriple, int intentosLibre, int doblesConvertidos, int triplesConvertidos, int libresConvertidos, String nombre, String apellido, int numero) {
        this.rutaFoto = rutaFoto;
        this.puntos = puntos;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.rebotesOfensivos = rebotesOfensivos;
        this.tapones = tapones;
        this.robos = robos;
        this.faltas = faltas;
        this.intentosDoble = intentosDoble;
        this.intentosTriple = intentosTriple;
        this.intentosLibre = intentosLibre;
        this.doblesConvertidos = doblesConvertidos;
        this.triplesConvertidos = triplesConvertidos;
        this.libresConvertidos = libresConvertidos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

    public Jugador(String nombre, String apellido, int numero, String rutaFoto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.rutaFoto= rutaFoto; 
    }
    
    
    public void anotar(int puntos){
        this.puntos=+puntos;
    }
    public void fallar2(){
        this.intentosDoble++;
    }
    public void fallarLibre(){
        this.intentosLibre++;
    }
    public void fallar3(){
        this.intentosDoble++;
        this.intentosTriple++;
    }
    public void anotar2(){
        anotar(2);
        this.intentosDoble++;
        this.doblesConvertidos++;
    }
    public void anotarLibre(){
        anotar(1);
        this.intentosLibre++;
        this.libresConvertidos++;
    }
    public void anotar3(){
        anotar(3);
        this.intentosDoble++;
        this.intentosTriple++;
        this.doblesConvertidos++;
        this.triplesConvertidos++;
    }
    public void anotar(){
        this.puntos=+puntos;
    }
    public void asistir(){
        this.asistencias++;
    }
     public void rebotar(){
        this.rebotes++;
    }
    public void rebotarOfensivo(){
        this.rebotesOfensivos++;
    }
      public void taponar(){
        this.tapones++;
    }
       public void robar(){
        this.robos++;
    }
       public void cometerfalta(){
       this.faltas++;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getRebotes() {
        return rebotes;
    }

    public int getRebotesDefensivos() {
        return this.rebotes-this.rebotesOfensivos;
    }

    public int getRebotesOfensivos() {
        return rebotesOfensivos;
    }

    public int getTapones() {
        return tapones;
    }

    public int getRobos() {
        return robos;
    }

    public int getFaltas() {
        return faltas;
    }

    public int getIntentosDoble() {
        return intentosDoble;
    }

    public int getIntentosTriple() {
        return intentosTriple;
    }

    public int getIntentosLibre() {
        return intentosLibre;
    }

    public int getDoblesConvertidos() {
        return doblesConvertidos;
    }

    public int getTriplesConvertidos() {
        return triplesConvertidos;
    }

    public int getLibresConvertidos() {
        return libresConvertidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumero() {
        return numero;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public double getPorcentajeTC() {
        
        try {
            porcentajeTC=this.doblesConvertidos*100/this.intentosDoble;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTC;
    }

    public double getPorcentajeTriples() {
        try {
            porcentajeTriples=this.triplesConvertidos*100/this.intentosTriple;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTriples;
    }

    public double getPorcentajeTL() {
       try {
            porcentajeTL=this.libresConvertidos*100/this.intentosLibre;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTL;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre +" "+apellido+ 
               "\nNumero: " + numero+
               "\nPuntos=" + puntos + 
               "\nAsistencias=" + asistencias + 
               "\nRebotes Defensivos=" + this.getRebotesDefensivos() + 
               "\nRebotes Ofensivos=" + rebotesOfensivos +
               "\nTapones=" + tapones +
               "\nRobos=" + robos + 
               "\nFaltas=" + faltas + 
               "\nTiros de campo=" + doblesConvertidos + "/" + intentosDoble + 
               "\nTiros de 3=" + triplesConvertidos + "/" + intentosTriple + 
               "\nTirosLibres=" + libresConvertidos+ "/" + intentosLibre + 
               "\nPorcentaje TC=" + this.getPorcentajeTC()+ "%"+ 
               "\nPorcentaje Triples=" + this.getPorcentajeTriples() + "%"+ 
               "\nPorcentaje TL=" + this.getPorcentajeTL() + "%\n";
    }
    public String toOutput(){
        return ""+nombre+","+apellido+","+numero+","+rutaFoto+","+puntos+","+asistencias+","+rebotes+","+rebotesOfensivos+","+tapones+","+robos+","+faltas+","+doblesConvertidos+","+intentosDoble+","
                +triplesConvertidos+","+intentosTriple+","+libresConvertidos+","+intentosLibre+",";
    }
}
