/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.NumeroJugadorException;
import java.util.*;

/**
 * @author Diego Fernando Chacon
 * @since 10/05/16
 * @version 1.9
 * Clase que crea objetos de tipo torneo 
 */
public class Torneo {
    private String nombre; 
    private HashMap <String, Equipo> equipos; 
    private HashMap <String,Partido> partidos;
    private int numEquipos; 

/**
 * Metodo constructor de la clase torneo 
 * @param nombre Nombre del torneo 
 */
    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new <String, Equipo>  HashMap();
        this.partidos= new <String,Partido> HashMap();
        this.setPartidos();       
    }
/**
 * Metodo para añadir un torneo
 * @param e equipo que se vinculara al torneo
 */     
    public void anadirEquipo(Equipo e){
        equipos.put(e.getNombre(), e);
        this.numEquipos++;
    }
/**
 * Metodo para añadir un torneo
 * @return Devuelve el torneo en forma de cadena de caracteres
 */  
    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", equipos=" + equipos + '}';
    }
/**
 * Metodo que retorna la lista de equipos del torneo
 * @return Lista de equipos
 */
    public HashMap<String, Equipo> getEquipos() {
        return equipos;
    }
/**
 * Metodo que retorna la cadena de caracteres que se guarda en un archivo de texto
 * @return Devuelve la cadena que se va a guardar
 */    
    public String toOutput(){
        String output = ""+nombre+",";
        for(Equipo e1: equipos.values()){
            output=output+"Equipo,"+e1.getNombre()+",";
        }
        for(Partido p1: partidos.values()){
            output=output+p1.toOutput();
        }
        return output;
    }   
/**
 * Metodo para obtener el nombre del torneo 
 * @return Devuelve el nombre del torneo
 */
    public String getNombre() {
        return nombre;
    }
    public void setPartidos(){
        HashMap <String,Equipo> copia=new <String, Equipo>  HashMap();
        copia=(HashMap<String, Equipo>) equipos.clone();
        for (int i = 1; i <= this.numEquipos; i++) {
            for (Equipo e1: equipos.values()){
                copia.remove(e1.getNombre());
                for (Equipo e2: copia.values()){
                    Partido p1= new Partido(e1.getNombre(), e2.getNombre(), this);
                    partidos.put(e1.getNombre()+e2.getNombre(),p1);    
                }
                
        }
        }
    }
/**
 * Metodo para obtener la lista de partidos del torneo
 * @return Devuelve la lista de los partidos
 */ 
    public HashMap<String,Partido> getPartidos() {
        return partidos;
    }
/**
 * Metodo para añadir un partido al HashMap de partidos del torneo
 * @param p1 Partido que sera añadido
 * @param e1 Nombre del primer equipo
 * @param e2 Nombre del segundo equipo
 */    
    public void anadirPartido(Partido p1, String e1, String e2){
        partidos.put(e1+e2,p1);
    }
/**
 * Metodo que permite obtener el jugador que mas puntos ha anotado a lo largo del torneo
 * @return Jugador lider en puntos
 * @throws NumeroJugadorException excepcion generada cuando el numero del jugador es invalido
 */
    public Jugador getLiderPuntos() throws NumeroJugadorException{
        Jugador liderPuntos= new Jugador("Dummy", "Dummy", 0, null);
        liderPuntos.setPuntosTot(0);
        for(Equipo e1: this.equipos.values()){
            for(Jugador j1: e1.getJugadores().values()){
                if (j1.getPPG()>liderPuntos.getPPG()){
                    liderPuntos=j1; 
                }
            }
        }
        return liderPuntos; 
    }
/**
 * Metodo que permite obtener el equipo que mas puntos ha anotado a lo largo del torneo
 * @return Jugador lider en puntos
 */
    public Equipo getLiderEquipoPuntos() {
        Equipo liderPuntos= new Equipo("Dummy");
        for(Equipo e1: this.equipos.values()){
                if (e1.getPPG()>liderPuntos.getPPG()){
                liderPuntos=e1; 
            }
        }
        return liderPuntos; 
    }    
/**
 * Metodo que permite obtener el jugador que mas asistencias ha repartido a lo largo del torneo
 * @return Jugador lider en asistencias
 * @throws NumeroJugadorException excepcion generada cuando el numero del jugador es invalido
 */
    public Jugador getLiderAsistencias() throws NumeroJugadorException{
        Jugador liderPuntos= new Jugador("Dummy", "Dummy", 0, null);
        liderPuntos.setAsistenciasTot(0);
        for(Equipo e1: this.equipos.values()){
            for(Jugador j1: e1.getJugadores().values()){
                if (j1.getAsistenciasTot()>liderPuntos.getAsistenciasTot()){
                    liderPuntos=j1; 
                }
            }
        }
        return liderPuntos; 
    }
/**
 * Metodo que permite obtener el equipo que mas puntos ha anotado a lo largo del torneo
 * @return Jugador lider en puntos
 */
    public Equipo getLiderEquipoAsistencias() {
            double PuntosLider=0;
            Equipo ret = null;
        for(Equipo e1: this.equipos.values()){
                if (e1.getAPG()>PuntosLider){
                   ret = e1;
                PuntosLider=e1.getAsistenciasTot();
            }
        }
        return ret; 
    }        
/**
 * Metodo que permite obtener el jugador con mejor porcentaje de conversion a lo largo del torneo
 * @return Jugador lider en porcentaje de tiros de campo
 * @throws NumeroJugadorException excepcion generada cuando el numero del jugador es invalido
 */    
    public Jugador getLiderFG() throws NumeroJugadorException{
        Jugador liderPuntos= new Jugador("Dummy", "Dummy", 0, null);
        liderPuntos.setDoblesConvertidosTot(0);
        liderPuntos.setIntentosDobleTot(0);
        for(Equipo e1: this.equipos.values()){
            for(Jugador j1: e1.getJugadores().values()){
                if (j1.getPorcentajeTCTot()>liderPuntos.getPorcentajeTCTot()){
                    liderPuntos=j1; 
                }
            }
        }
        return liderPuntos; 
    }
/**
 * Metodo que permite obtener el equipo con mejor porcentaje de 
 * tiros de campo a lo largo del torneo
 * @return Jugador lider en puntos
 *
 */
    public Equipo getLiderEquipoFG() {
        Equipo liderPuntos= new Equipo("Dummy");
        for(Equipo e1: this.equipos.values()){
                if (e1.getPorcentajeTCTot()>liderPuntos.getPorcentajeTCTot()){
                liderPuntos=e1; 
            }
        }
        return liderPuntos; 
    }  
/**
 * Metodo que permite obtener el jugador con mejor porcentaje de conversion de triples a lo largo del torneo
 * @return Jugador lider en porcentaje de tiros de campo
 * @throws NumeroJugadorException excepcion generada cuando el numero del jugador es invalido
 */    
    public Jugador getLider3FG() throws NumeroJugadorException{
        Jugador liderPuntos= new Jugador("Dummy", "Dummy", 0, null);
        liderPuntos.setDoblesConvertidosTot(0);
        liderPuntos.setIntentosDobleTot(0);
        for(Equipo e1: this.equipos.values()){
            for(Jugador j1: e1.getJugadores().values()){
                if (j1.getPorcentajeTriplesTot()>liderPuntos.getPorcentajeTriplesTot()){
                    liderPuntos=j1; 
                }
            }
        }
        return liderPuntos; 
    }    
    /**
 * Metodo que permite obtener el equipo con mejor porcentaje de 
 * conversion de triples a lo largo del torneo
 * @return Jugador lider en puntos
 * 
 */
    public Equipo getLiderEquipo3FG(){
        Equipo liderPuntos= new Equipo("Dummy");
        for(Equipo e1: this.equipos.values()){
                if (e1.getPorcentaje3TCTot()>liderPuntos.getPorcentaje3TCTot()){
                liderPuntos=e1; 
            }
        }
        return liderPuntos; 
    } 
}
 

