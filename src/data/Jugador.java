/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.NumeroJugadorException;
import java.awt.*;

/**
 *
 * @author dieguischa
 */
public class Jugador {
    private String rutaFoto;
    private int puntos=0; 
    private int asistencias=0; 
    private int rebotes=0;
    private int rebotesDefensivos=0;
    private int rebotesOfensivos=0;
    private int tapones=0; 
    private int robos=0; 
    private int faltas=0; 
    private int intentosDoble=0; 
    private int intentosTriple=0; 
    private int intentosLibre=0; 
    private int doblesConvertidos=0; 
    private int triplesConvertidos=0; 
    private int libresConvertidos=0;
    private int puntosTot; 
    private int asistenciasTot; 
    private int rebotesTot;
    private int rebotesDefensivosTot;
    private int rebotesOfensivosTot;
    private int taponesTot; 
    private int robosTot; 
    private int faltasTot; 
    private int intentosDobleTot; 
    private int intentosTripleTot; 
    private int intentosLibreTot; 
    private int doblesConvertidosTot; 
    private int triplesConvertidosTot; 
    private int libresConvertidosTot;
    private String nombre; 
    private String apellido; 
    private int numero; 
    private int partidosJugados; 
    private double porcentajeTC;
    private double porcentajeTriples;
    private double porcentajeTL;
    private double porcentajeTCTot;
    private double porcentajeTriplesTot;
    private double porcentajeTLTot;

    public Jugador(String rutaFoto, int puntosTot, int asistenciasTot, int rebotesTot, int rebotesDefensivosTot, int rebotesOfensivosTot, int taponesTot, int robosTot, int faltasTot, int intentosDobleTot, int intentosTripleTot, int intentosLibreTot, int doblesConvertidosTot, int triplesConvertidosTot, int libresConvertidosTot, String nombre, String apellido, int numero, int partidosJugados) {
        this.rutaFoto = rutaFoto;
        this.puntosTot = puntosTot;
        this.asistenciasTot = asistenciasTot;
        this.rebotesTot = rebotesTot;
        this.rebotesDefensivosTot = rebotesDefensivosTot;
        this.rebotesOfensivosTot = rebotesOfensivosTot;
        this.taponesTot = taponesTot;
        this.robosTot = robosTot;
        this.faltasTot = faltasTot;
        this.intentosDobleTot = intentosDobleTot;
        this.intentosTripleTot = intentosTripleTot;
        this.intentosLibreTot = intentosLibreTot;
        this.doblesConvertidosTot = doblesConvertidosTot;
        this.triplesConvertidosTot = triplesConvertidosTot;
        this.libresConvertidosTot = libresConvertidosTot;
        this.nombre = nombre;
        this.apellido = apellido;
        
        this.numero = numero;
        this.partidosJugados = partidosJugados;
    }

    public Jugador(String rutaFoto, int puntos, int asistencias, int rebotes, int rebotesOfensivos, int tapones, int robos, int faltas, int intentosDoble, int intentosTriple, int intentosLibre, int doblesConvertidos, int triplesConvertidos, int libresConvertidos, String nombre, String apellido, int numero)  {
        this.rutaFoto = rutaFoto;
        this.puntos = puntos;
        this.asistencias = asistencias;
        this.rebotesDefensivos = rebotes-rebotesOfensivos;
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
    public void clear(){
    this.puntos=0; 
    this.asistencias=0; 
    this.rebotes=0;
    this.rebotesDefensivos=0;
    this.rebotesOfensivos=0;
    this.tapones=0; 
    this.robos=0; 
    this.faltas=0; 
    this.intentosDoble=0; 
    this.intentosTriple=0; 
    this.intentosLibre=0; 
    this.doblesConvertidos=0; 
    this.triplesConvertidos=0; 
    this.libresConvertidos=0;
    }
    public Jugador(String nombre, String apellido, int numero, String rutaFoto) throws NumeroJugadorException {
        this.nombre = nombre;
        this.apellido = apellido;
        if(numero>99){
            throw new NumeroJugadorException ("Numero Invalido");
        }
        this.numero = numero;
        this.rutaFoto= rutaFoto; 
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
        this.puntos+=2;
        this.intentosDoble++;
        this.doblesConvertidos++;
    }
    public void anotarLibre(){
        this.puntos+=1;
        this.intentosLibre++;
        this.libresConvertidos++;
    }
    public void anotar3(){
        this.puntos+=3;
        this.intentosDoble++;
        this.intentosTriple++;
        this.doblesConvertidos++;
        this.triplesConvertidos++;
    }
  
    public void asistir(){
        this.asistencias++;
    }
     public void rebotarDefensivo(){
        this.rebotesDefensivos++;
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
        return this.rebotesOfensivos+this.rebotesDefensivos;
    }

    public int getRebotesDefensivos() {
        return this.rebotesDefensivos;
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
    public String getTC(){
    return this.doblesConvertidos+"/"+this.intentosDoble+"---"+this.getPorcentajeTC()+"%";
    }
    public String get3TC(){
    return this.triplesConvertidos+"/"+this.intentosTriple+"---"+this.getPorcentajeTriples()+"%";
    }
    public String getTL(){
    return this.libresConvertidos+"/"+this.intentosLibre+"---"+this.getPorcentajeTL()+"%";
    }
    public String getRutaFoto() {
        return rutaFoto;
    }

    public int getPuntosTot() {
        return puntosTot;
    }

    public void setPuntosTot(int puntosTot) {
        this.puntosTot+=puntosTot;
    }

    public int getAsistenciasTot() {
        return asistenciasTot;
    }

    public void setAsistenciasTot(int asistenciasTot) {
        this.asistenciasTot+=asistenciasTot;
    }

    public int getRebotesTot() {
        return rebotesTot;
    }

    public void setRebotesTot(int rebotesTot) {
        this.rebotesTot+=rebotesDefensivosTot+ rebotesOfensivosTot;
    }

    public int getRebotesDefensivosTot() {
        return rebotesDefensivosTot;
    }

    public void setRebotesDefensivosTot(int rebotesDefensivosTot) {
        this.rebotesDefensivosTot+=rebotesDefensivosTot;
    }

    public int getRebotesOfensivosTot() {
        return rebotesOfensivosTot;
    }

    public void setRebotesOfensivosTot(int rebotesOfensivosTot) {
        this.rebotesOfensivosTot+=rebotesOfensivosTot;
    }

    public int getTaponesTot() {
        return taponesTot;
    }

    public void setTaponesTot(int taponesTot) {
        this.taponesTot+=taponesTot;
    }

    public int getRobosTot() {
        return robosTot;
    }

    public void setRobosTot(int robosTot) {
        this.robosTot+=robosTot;
    }

    public int getFaltasTot() {
        return faltasTot;
    }

    public void setFaltasTot(int faltasTot) {
        this.faltasTot+=faltasTot;
    }

    public int getIntentosDobleTot() {
        return intentosDobleTot;
    }

    public void setIntentosDobleTot(int intentosDobleTot) {
        this.intentosDobleTot+=intentosDobleTot;
    }

    public int getIntentosTripleTot() {
        return intentosTripleTot;
    }

    public void setIntentosTripleTot(int intentosTripleTot) {
        this.intentosTripleTot+=intentosTripleTot;
    }

    public int getIntentosLibreTot() {
        return intentosLibreTot;
    }

    public void setIntentosLibreTot(int intentosLibreTot) {
        this.intentosLibreTot+=intentosLibreTot;
    }

    public int getDoblesConvertidosTot() {
        return doblesConvertidosTot;
    }

    public void setDoblesConvertidosTot(int doblesConvertidosTot) {
        this.doblesConvertidosTot+=doblesConvertidosTot;
    }

    public int getTriplesConvertidosTot() {
        return triplesConvertidosTot;
    }

    public void setTriplesConvertidosTot(int triplesConvertidosTot) {
        this.triplesConvertidosTot+=triplesConvertidosTot;
    }

    public int getLibresConvertidosTot() {
        return libresConvertidosTot;
    }

    public void setLibresConvertidosTot(int libresConvertidosTot) {
        this.libresConvertidosTot+=libresConvertidosTot;
    }
        public double getPorcentajeTCTot() {
        
        try {
            porcentajeTC=this.doblesConvertidosTot*100/this.intentosDobleTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTC;
    }

    public double getPorcentajeTriplesTot() {
        try {
            porcentajeTriples=this.triplesConvertidosTot*100/this.intentosTripleTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTriples;
    }

    public double getPorcentajeTLTot() {
       try {
            porcentajeTL=this.libresConvertidosTot*100/this.intentosLibreTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTL;
    }
    public String getTCTot(){
    return this.doblesConvertidosTot+"/"+this.intentosDobleTot+"---"+this.getPorcentajeTCTot()+"%";
    }
    
    public String get3TCTot(){
    return this.triplesConvertidosTot+"/"+this.intentosTripleTot+"---"+this.getPorcentajeTriplesTot()+"%";
    }
    public String getTLTot(){
    return this.libresConvertidosTot+"/"+this.intentosLibreTot+"---"+this.getPorcentajeTLTot()+"%";
    }
    @Override
    public String toString() {
        return "\nNombre: " + nombre +" "+apellido+ 
               "\nNumero: " + numero+
               "\nPuntos=" + puntos + 
               "\nAsistencias=" + asistencias + 
               "\nRebotes Defensivos=" + rebotesDefensivos+ 
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
        return ""+nombre+","+apellido+","+numero+","+rutaFoto+","+puntosTot+","+asistenciasTot+","+this.getRebotesTot()+","+rebotesOfensivosTot+","+taponesTot+","+robosTot+","+faltasTot+","+doblesConvertidosTot+","+intentosDobleTot+","
                +triplesConvertidosTot+","+intentosTripleTot+","+libresConvertidosTot+","+intentosLibreTot+","+partidosJugados+",";
    }
}
