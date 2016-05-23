/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;

/**
 * 
 * @author Diego Fernando Chacon 
 * Clase que crea objetos de tipo partido
 */
public class Partido {
    private String [] equipos; 
    private Equipo [] equipos2;
    private int [] marcador;
    private int [] marcadoresParcialesA;
    private int [] marcadoresParcialesB;
    String stats; 
    Torneo t1;
/**
 * Constructor que permite crear un equipo asociado a un torneo
 * @param equipoA nombre del primer equipo
 * @param equipoB nombre del segundo equipo
 * @param t1 torneo al cual pertece el partido
 */
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
/**
 * Constructor que permite crear un partido independiente de un torneo, es 
 * decir un partido amistoso
 * @param equipoA Equipo 1
 * @param equipoB Equipo 2
 */    
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
/**
 * Metodo que retorna el vector marcador
 * @return Marcador del partido
 */     
    public int[] getMarcador() {
        return marcador;
    }
/**
 * Metodo que permite asignarle el marcador a un partido
 * @param marcadorA Marcador del equipo 1
 * @param marcadorB Marcador del equipo 2
 */
    public void setMarcador(int marcadorA, int marcadorB) {
        marcador = new int [2];
        marcador[0]= marcadorA;
        marcador[1]= marcadorB;
        this.marcador = marcador;
    }
/**
 * Metodo que permite asignar el marcador de un solo cuarto al equipo 1
 * @param marcador Marcador 
 * @param cuarto Cuarto correspondiente
 */
    public void setMarcadorParcialA(int marcador, int cuarto) {
        this.marcadoresParcialesA[cuarto-1]= marcador;  
    }
/**
 * Metodo que permite asignar el marcador de un solo cuarto al equipo 2
 * @param marcador Marcador 
 * @param cuarto Cuarto correspondiente
 */    
    public void setMarcadorParcialB(int marcador, int cuarto) {
        this.marcadoresParcialesB[cuarto-1]= marcador;       
    }
/**
 * Metodo que permite obtener el marcador de un solo cuarto del equipo 1
 * @param cuarto Cuarto correspondiente
 * @return Marcador del cuarto
 */    
    public int getMarcadorParcialA(int cuarto) {
        return this.marcadoresParcialesA[cuarto-1];
    }
/**
 * Metodo que permite obtener el marcador de un solo cuarto del equipo 2
 * @param cuarto Cuarto correspondiente
 * @return Marcador del cuarto
 */     
    public int getMarcadorParcialB(int cuarto) {
        return this.marcadoresParcialesB[cuarto-1];
    }
/**
 * Metodo que permite determinar cual sera la cadena de caracteres
 * asignada a la variable stats.
 */
    public void setStats(){
        this.stats=this.toString();
    }
/**
 * Metodo que permite asignar un valor a la variable stats
 * @param stats Valor que se le quiere asignar
 */
    public void asignarStats(String stats){
        this.stats=stats;
    }
/**
 * Metodo que permite obtener el valor de Stats
 * @return stats
 */    
    public String getStats(){
        return this.stats;
    }
/**
 * Metodo que retorna la representacion en cadena de caracteres
 * del partido en cuestion 
 * @return Cadena de caracteres del partido
 */    
    @Override
    public String toString() {
        return this.obtenerEquipoA().toString() + "\n"+this.obtenerEquipoB().toString();
    }
 /**
  * Metodo que permite obtener el equipo numero 1
  * @return Equipo numero 1
  */    
    public String getEquipoA(){
        return equipos[0];
    }
/**
  * Metodo que permite obtener el equipo numero 2
  * @return Equipo numero 2
  */       
    public String getEquipoB(){
        return equipos[1];
    }
 /**
  * Metodo que permite obtener el marcador del equipo numero 1
  * @return marcador del equipo numero 1
  */      
    public int getMarcadorEquipoA(){
        return marcador[0];
    }
 /**
  * Metodo que permite obtener el marcador del equipo numero 2
  * @return marcador del equipo numero 2
  */     
    public int getMarcadorEquipoB(){
        return marcador[1];
    }
/**
 * Metodo que permite obtener el objeto Equipo #1 asociado a este partido
 * @return Equipo 1
 */    
    public Equipo obtenerEquipoA(){
        try {
            return t1.getEquipos().get(equipos[0]);
        } catch (NullPointerException e) {
            return equipos2[0];
        }
        
/**
 * Metodo que permite obtener el objeto Equipo #2 asociado a este partido
 * @return Equipo 2
 */            
    }
    public Equipo obtenerEquipoB(){
       try {
            return t1.getEquipos().get(equipos[1]);
        } catch (NullPointerException e) {
            return equipos2[1];
        }
        
    }
 /**
  * Metodo que convierte la clase partido en la cadena de caracteres que sera almacenada en 
  * una cadena de texto
  * @return Cadena de texto almacenada 
  */   
    public String toOutput(){
        return "Partido,"+this.equipos[0]+","+this.equipos[1]+","+this.marcador[0]+","+this.marcador[1]+","+this.toString()+",";
    }
    
}
