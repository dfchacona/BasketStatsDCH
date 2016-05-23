/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.NumeroJugadorException;
import java.awt.*;

/**
 * Clase jugador perteneciente a la clase Equipo
 * @author Diego Fernando Chacon 
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
    /**
     * Constructor que permite cargar un jugador apartir de un archivo de texto
     * @param rutaFoto Ruta de una imagen del jugador
     * @param puntosTot Numero de puntos conseguidos en el torneo
     * @param asistenciasTot Numero de asistencias repartidas en el torneo 
     * @param rebotesTot Numero de rebotes conseguidos en el torneo
     * @param rebotesDefensivosTot Numero de rebotes defensivos conseguidos en el torneo
     * @param rebotesOfensivosTot Numero de rebotes ofensivos conseguidos durante el torneo
     * @param taponesTot Numero de tapones conseguidos durante el torneo
     * @param robosTot Numero de robos logrados durante el torneo
     * @param faltasTot Numero de faltas cometidas durante el torneo
     * @param intentosDobleTot Numero total de intentos al aro durante el torneo
     * @param intentosTripleTot Numero total de intentos de 3 puntos a lo largo del torneo
     * @param intentosLibreTot Numero de intentos desde la linea de libres a lo largo del torneo
     * @param doblesConvertidosTot Numero total de canastas convertidas a lo largo del torneo
     * @param triplesConvertidosTot Numero total de tripes convertidos a lo largo del torneo
     * @param libresConvertidosTot Numero total de tiros libres encestados a lo largo del torneo
     * @param nombre Nombre del jugador
     * @param apellido Apellido del jugador
     * @param numero Numero de la camiseta del jugador
     * @param partidosJugados Numero de partidos jugados por el jugador
     */
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
/**
 * Metodo que reinicia todas las estadisticas de un jugador para un partido nuevo
 */
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
    /**
     * Metodo que permite crear la plantilla de un jugador
     * @param nombre Nombre del jugador
     * @param apellido Apellido del jugador
     * @param numero Numero en la camiseta del jugador
     * @param rutaFoto Ruta de una imagen del jugador
     * @throws NumeroJugadorException Excepcion lanzada cuando el numero es demasiado grande
     */
    public Jugador(String nombre, String apellido, int numero, String rutaFoto) throws NumeroJugadorException {
        this.nombre = nombre;
        this.apellido = apellido;
        if(numero>99){
            throw new NumeroJugadorException ("Numero Invalido");
        }
        this.numero = numero;
        this.rutaFoto= rutaFoto; 
    }
    
    
   /**
    * Metodo ejecutado cuando un jugador falla un tiro al aro
    */
    public void fallar2(){
        this.intentosDoble++;
    }
    /**
    * Metodo ejecutado cuando un jugador falla un tiro libre
    */
    public void fallarLibre(){
        this.intentosLibre++;
    }
    /**
    * Metodo ejecutado cuando un jugador falla un triple
    */
    public void fallar3(){
        this.intentosDoble++;
        this.intentosTriple++;
    /**
    * Metodo ejecutado cuando un jugador anota un tiro al aro
    */
    }
    public void anotar2(){
        this.puntos+=2;
        this.intentosDoble++;
        this.doblesConvertidos++;
    }
    /**
    * Metodo ejecutado cuando un jugador anota un tiro libre
    */
    public void anotarLibre(){
        this.puntos+=1;
        this.intentosLibre++;
        this.libresConvertidos++;
    }
    /**
    * Metodo ejecutado cuando un jugador anota un triple
    */
    public void anotar3(){
        this.puntos+=3;
        this.intentosDoble++;
        this.intentosTriple++;
        this.doblesConvertidos++;
        this.triplesConvertidos++;
    }
    /**
    * Metodo ejecutado cuando un jugador consigue una asistencia
    */
    public void asistir(){
        this.asistencias++;
    }
    /**
    * Metodo ejecutado cuando un jugador consigue un rebote defensivo
    */
     public void rebotarDefensivo(){
        this.rebotesDefensivos++;
    }
     /**
    * Metodo ejecutado cuando un jugador consigue un rebote ofensivo
    */
    public void rebotarOfensivo(){
        this.rebotesOfensivos++;
    }
     /**
    * Metodo ejecutado cuando un jugador consigue un tapon
    */
      public void taponar(){
        this.tapones++;
    }
     /**
    * Metodo ejecutado cuando un jugador consigue un robo
    */   
       public void robar(){
        this.robos++;
    }
     /**
    * Metodo ejecutado cuando un jugador comete una falta
    */   
       public void cometerfalta(){
           
       this.faltas++;
    }
    /**
     * Metodo ejecutado cuando un jugador juega un partido
     */   
       public void jugarPartido(){
          this.partidosJugados++;
       }
    /**
     * Metodo que retorna la cantidad de puntos en el partido 
     * @return puntos 
     */   
    public int getPuntos() {
        return puntos;
    }
    /**
     * Metodo que retorna la cantidad de asistencias en el partido 
     * @return asistencias
     */   
    public int getAsistencias() {
        return asistencias;
    }
    /**
     * Metodo que retorna la cantidad de rebotes en el partido 
     * @return rebotes totales
     */   
    public int getRebotes() {
        return this.rebotesOfensivos+this.rebotesDefensivos;
    }
    /**
     * Metodo que retorna la cantidad de rebotes defensivos en el partido 
     * @return Rebotes defensivos
     */   
    public int getRebotesDefensivos() {
        return this.rebotesDefensivos;
    }
    /**
     * Metodo que retorna la cantidad de rebotes ofensivos en el partido 
     * @return Rebotes ofensivos
     */   
    public int getRebotesOfensivos() {
        return rebotesOfensivos;
    }
    /**
     * Metodo que retorna la cantidad de Tapones en el partido 
     * @return tapones
     */   
    public int getTapones() {
        return tapones;
    }
    /**
     * Metodo que retorna la cantidad de robos en el partido 
     * @return robos 
     */   
    public int getRobos() {
        return robos;
    }
    /**
     * Metodo que retorna la cantidad de faltas en el partido 
     * @return faltas
     */   
    public int getFaltas() {
        return faltas;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de campo en el partido 
     * @return intentos de campo
     */   
    public int getIntentosDoble() {
        return intentosDoble;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de triple en el partido 
     * @return Intentos de triple
     */   
    public int getIntentosTriple() {
        return intentosTriple;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de triple en el partido 
     * @return Intentos de libre
     */   
    public int getIntentosLibre() {
        return intentosLibre;
    }
    /**
     * Metodo que retorna la cantidad de dobles convertidos en el partido 
     * @return Dobles convertidos
     */   
    public int getDoblesConvertidos() {
        return doblesConvertidos;
    }
    /**
     * Metodo que retorna la cantidad de triples convertidos en el partido 
     * @return Triples convertidos
     */   
    public int getTriplesConvertidos() {
        return triplesConvertidos;
    }
    /**
     * Metodo que retorna la cantidad de libres convertidos en el partido 
     * @return Libres convertidos
     */   
    public int getLibresConvertidos() {
        return libresConvertidos;
    }
    /**
     * Metodo que retorna el nombre del jugador
     * @return Nombre
     */   
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que retorna el apellido del jugador
     * @return Apellido
     */  
    public String getApellido() {
        return apellido;
    }
    /**
     * Metodo que retorna el numero de la camiseta del jugador
     * @return Numero de camiseta
     */  
    public int getNumero() {
        return numero;
    }
    /**
     * Metodo que retorna el numero de partidos jugados por el jugador
     * @return Partidos ganados
     */  
    public int getPartidosJugados() {
        return partidosJugados;
    }
    /**
     * Metodo que retorna el porcentaje de tiros de campo de un partido del jugador
     * @return Porcentaje de tiros de campo
     */  
    public double getPorcentajeTC() {
        
        try {
            porcentajeTC=this.doblesConvertidos*100/this.intentosDoble;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTC;
    }
    /**
     * Metodo que retorna el porcentaje de tiros de tres de un partido del jugador
     * @return Porcentaje de tiros de tres
     */ 
    public double getPorcentajeTriples() {
        try {
            porcentajeTriples=this.triplesConvertidos*100/this.intentosTriple;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTriples;
    }
    /**
     * Metodo que retorna el porcentaje de tiros libres de un partido del jugador
     * @return Porcentaje de tiros libres
     */ 
    public double getPorcentajeTL() {
       try {
            porcentajeTL=this.libresConvertidos*100/this.intentosLibre;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTL;
    }
    /**
     * Metodo que retorna una cadena que exhibe la cantidad de intentos, conversiones
     * y el porcentaje de tiros de campo de un jugador en un partido
     * @return Porcentaje de tiros de campo
     */ 
    public String getTC(){
    return this.doblesConvertidos+"/"+this.intentosDoble+"---"+this.getPorcentajeTC()+"%";
    }
    /**
     * Metodo que retorna una cadena que exhibe la cantidad de intentos, conversiones
     * y el porcentaje de tiros de tres de un jugador en un partido
     * @return Porcentaje de tiros de tres
     */ 
    public String get3TC(){
    return this.triplesConvertidos+"/"+this.intentosTriple+"---"+this.getPorcentajeTriples()+"%";
    }
    /**
     * Metodo que retorna una cadena que exhibe la cantidad de intentos, conversiones
     * y el porcentaje de tiros libres de un jugador en un partido
     * @return Porcentaje de tiros libres
     */ 
    public String getTL(){
    return this.libresConvertidos+"/"+this.intentosLibre+"---"+this.getPorcentajeTL()+"%";
    }
    /**
     * Metodo que permite obtener la ruta de la foto de un jugador
     * @return Ruta de foto
     */ 
    public String getRutaFoto() {
        return rutaFoto;
    }
    /**
     * Metodo que retorna la cantidad de puntos en el partido 
     * @return puntos 
     */
    public int getPuntosTot() {
        return puntosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de puntos convertidos en un partido
     * @param puntosTot puntos sumados a la cantidad de puntos que llevaba el jugador 
     */
    public void setPuntosTot(int puntosTot) {
        this.puntosTot+=puntosTot;
    }
    /**
     * Metodo que retorna la cantidad de puntos en el torneo
     * @return asistencias
     */
    public int getAsistenciasTot() {
        return asistenciasTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de asistencias repartidas en un partido
     * @param asistenciasTot asistencias que seran sumadas al total
     */
    public void setAsistenciasTot(int asistenciasTot) {
        this.asistenciasTot+=asistenciasTot;
    }
    /**
     * Metodo que retorna la cantidad de asistencias en el torneo
     * @return rebotes totales 
     */
    public int getRebotesTot() {
        return rebotesTot;
    }
    /**
     *  Metodo que permite sumarle al jugador la cantidad de Rebotes conseguidos en un partido
     * @param rebotesTot rebotes que seran sumados al total
     */
    public void setRebotesTot(int rebotesTot) {
        this.rebotesTot+=rebotesDefensivosTot+ rebotesOfensivosTot;
    }
    /**
     * Metodo que retorna la cantidad de rebotes defensivos en el torneo 
     * @return rebotes defensivos
     */
    public int getRebotesDefensivosTot() {
        return rebotesDefensivosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de Rebotes defensivos conseguidos en un partido
     * @param rebotesDefensivosTot rebotes que seran sumados al total 
     */
    public void setRebotesDefensivosTot(int rebotesDefensivosTot) {
        this.rebotesDefensivosTot+=rebotesDefensivosTot;
    }
    /**
     * Metodo que retorna la cantidad de rebotes ofensivos en el torneo 
     * @return rebotes ofensivos
     */
    public int getRebotesOfensivosTot() {
        return rebotesOfensivosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de Rebotes ofensivos conseguidos en un partido
     * @param rebotesOfensivosTot rebotes que seran sumados al total 
     */
    public void setRebotesOfensivosTot(int rebotesOfensivosTot) {
        this.rebotesOfensivosTot+=rebotesOfensivosTot;
    }
    /**
     * Metodo que retorna la cantidad de tapones en el torneo 
     * @return tapones 
     */
    public int getTaponesTot() {
        return taponesTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de tapones conseguidos en un partido
     * @param taponesTot tapones que seran sumados al total 
     */
    public void setTaponesTot(int taponesTot) {
        this.taponesTot+=taponesTot;
    }
    /**
     * Metodo que retorna la cantidad de robos en el torneo 
     * @return robos
     */
    public int getRobosTot() {
        return robosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de robos conseguidos en un partido
     * @param robosTot robos que seran sumados al total 
     */
    public void setRobosTot(int robosTot) {
        this.robosTot+=robosTot;
    }
    /**
     * Metodo que retorna la cantidad de faltas en el torneo 
     * @return faltas robos que seran sumados al total 
     */
    public int getFaltasTot() {
        return faltasTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de faltas cometidas en un partido
     * @param faltasTot faltas que seran sumados al total 
     */
    public void setFaltasTot(int faltasTot) {
        this.faltasTot+=faltasTot;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de doble en el torneo 
     * @return intentos doble totales
     */
    public int getIntentosDobleTot() {
        return intentosDobleTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de intentos de doble en un partido
     * @param intentosDobleTot intentos de doble que seran sumados al total
     */
    public void setIntentosDobleTot(int intentosDobleTot) {
        this.intentosDobleTot+=intentosDobleTot;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de triple en el torneo 
     * @return intentos triple totales
     */
    public int getIntentosTripleTot() {
        return intentosTripleTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de intentos de triples en un partido
     * @param intentosTripleTot intentos de triple que seran sumados al total
     */
    public void setIntentosTripleTot(int intentosTripleTot) {
        this.intentosTripleTot+=intentosTripleTot;
    }
    /**
     * Metodo que retorna la cantidad de Intentos de libre en el torneo 
     * @return intentos totales de libre
     */
    public int getIntentosLibreTot() {
        return intentosLibreTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de intentos de libre en un partido
     * @param intentosLibreTot intentos de libre que seran sumados al total
     */
    public void setIntentosLibreTot(int intentosLibreTot) {
        this.intentosLibreTot+=intentosLibreTot;
    }
    /**
     * Metodo que retorna la cantidad de dobles convertidos en el torneo
     * @return dobles convertidos totales
     */
    public int getDoblesConvertidosTot() {
        return doblesConvertidosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de dobles convertidos en un partido
     * @param doblesConvertidosTot dobles convertidos que seran sumados al total
     */
    public void setDoblesConvertidosTot(int doblesConvertidosTot) {
        this.doblesConvertidosTot+=doblesConvertidosTot;
    }
    /**
     * Metodo que retorna la cantidad de triples convertidos en el torneo
     * @return triples convertidos totales
     */
    public int getTriplesConvertidosTot() {
        return triplesConvertidosTot;
    }
    /**
     *  Metodo que permite sumarle al jugador la cantidad de triples convertidos en un partido
     * @param triplesConvertidosTot triples convertidos que seran sumados al total
     */
    public void setTriplesConvertidosTot(int triplesConvertidosTot) {
        this.triplesConvertidosTot+=triplesConvertidosTot;
    }
    /**
     * Metodo que retorna la cantidad de libres convertidos en el torneo
     * @return libres convertidos totales
     */
    public int getLibresConvertidosTot() {
        return libresConvertidosTot;
    }
    /**
     * Metodo que permite sumarle al jugador la cantidad de libres convertidos en un partido
     * @param libresConvertidosTot libres convertidos que seran sumados al total
     */
    public void setLibresConvertidosTot(int libresConvertidosTot) {
        this.libresConvertidosTot+=libresConvertidosTot;
    }
    /**
     * Metodo que retorna el porcentaje de tiros de campo en el torneo
     * @return porcentaje de tiros de campo
     */
        public double getPorcentajeTCTot() {
        
        try {
            porcentajeTC=this.doblesConvertidosTot*100/this.intentosDobleTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTC;
    }
    /**
     * Metodo que retorna el porcentaje de tiros de tres en el torneo
     * @return porcentaje de tiros de tres
     */
    public double getPorcentajeTriplesTot() {
        try {
            porcentajeTriples=this.triplesConvertidosTot*100/this.intentosTripleTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTriples;
    }
     /**
     * Metodo que retorna el porcentaje de tiros de libres en el torneo
     * @return porcentaje de tiros de tres
     */
    public double getPorcentajeTLTot() {
       try {
            porcentajeTL=this.libresConvertidosTot*100/this.intentosLibreTot;
        } catch(Exception ArithmeticException){
            return 0;
        }
        return porcentajeTL;
    }
    /**
     * Metodo que retorna una cadena de caracteres que involucran el total de tiros intentados, 
     * convertidos y el porcentaje de tiros de campo
     * @return cadena con informacion de tiros de campo
     */
    public String getTCTot(){
    return this.doblesConvertidosTot+"/"+this.intentosDobleTot+"---"+this.getPorcentajeTCTot()+"%";
    }
    /**
     * Metodo que retorna una cadena de caracteres que involucran el total de tiros intentados, 
     * convertidos y el porcentaje de tiros de tres
     * @return cadena con informacion de tiros de tres
     */
    public String get3TCTot(){
    return this.triplesConvertidosTot+"/"+this.intentosTripleTot+"---"+this.getPorcentajeTriplesTot()+"%";
    }
    /**
     * Metodo que retorna una cadena de caracteres que involucran el total de tiros intentados, 
     * convertidos y el porcentaje de tiros libres
     * @return cadena con informacion de tiros libres
     */
    public String getTLTot(){
    return this.libresConvertidosTot+"/"+this.intentosLibreTot+"---"+this.getPorcentajeTLTot()+"%";
    }
    /**
     * Metodo que retorna una cadena con toda la informacion de un jugador en un partido
     * @return cadena del jugador
     */
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
    /**
     * Metodo que retorna una cadena de texto que sera guardada en un archivo de texto
     * @return cadena para ser guardada
     */
    public String toOutput(){
        return ""+nombre+","+apellido+","+numero+","+rutaFoto+","+puntosTot+","+asistenciasTot+","+this.getRebotesTot()+","+rebotesOfensivosTot+","+taponesTot+","+robosTot+","+faltasTot+","+doblesConvertidosTot+","+intentosDobleTot+","
                +triplesConvertidosTot+","+intentosTripleTot+","+libresConvertidosTot+","+intentosLibreTot+","+partidosJugados+",";
    }
    /**
     * Metodo que retorna el promedio de puntos por partido del jugador
     * @return Puntos por partido
     */
    public double getPPG(){
        try {
            return this.puntosTot/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    /**
     * Metodo que retorna el promedio de asistencias por partido del jugador
     * @return Aasistencias por partido
     */
    public double getAPG(){
        try {
            return this.asistenciasTot/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    /**
     * Metodo que retorna el promedio de rebotes por partido del jugador
     * @return Rebotes por partido
     */
    public double getRPG(){
        try {
            return this.rebotesTot/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    /**
     * Metodo que retorna el promedio de robos por partido del jugador
     * @return Robos por partido
     */
    public double getRoPG(){
        try {
            return this.robosTot/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    /**
     * Metodo que retorna el promedio de tapas por partido del jugador
     * @return Tapas por partido
     */
    public double getTPG(){
        try {
            return this.taponesTot/this.partidosJugados;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
