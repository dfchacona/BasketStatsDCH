/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exception.NumeroJugadorException;
import java.util.*;

/**
 *
 * @author dieguischa
 */
public class Torneo {
    private String nombre; 
    private HashMap <String, Equipo> equipos; 
    private HashMap <String,Partido> partidos;
    private int numEquipos; 

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new <String, Equipo>  HashMap();
        this.partidos= new <String,Partido> HashMap();
        this.setPartidos();
        
    }
     
    public void anadirEquipo(Equipo e){
        equipos.put(e.getNombre(), e);
        this.numEquipos++;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", equipos=" + equipos + '}';
    }

    public HashMap<String, Equipo> getEquipos() {
        return equipos;
    }
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

    public HashMap<String,Partido> getPartidos() {
        return partidos;
    }
    public void anadirPartido(Partido p1, String e1, String e2){
        partidos.put(e1+e2,p1);
    }
    public void guardarPartido(Partido p1, String e1, String e2){
        partidos.replace(e1+e2,p1);
    }
    public Jugador getLiderPuntos() throws NumeroJugadorException{
        Jugador liderPuntos= new Jugador("Dummy", "Dummy", 0, null);
        liderPuntos.setPuntosTot(0);
        for(Equipo e1: this.equipos.values()){
            for(Jugador j1: e1.getJugadores().values()){
                if (j1.getPuntosTot()>liderPuntos.getPuntosTot()){
                    liderPuntos=j1; 
                }
            }
        }
        return liderPuntos; 
    }
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
}
