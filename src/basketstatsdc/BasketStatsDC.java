/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketstatsdc;
import data.*;
import Servicios.*;
import UI.*;
import dao.*;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintStream;
/**
 *
 * @author dieguischa
 */
public class BasketStatsDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        dao dao= new dao();
       servicios serv= new servicios();
       Runnable VentanaInicio= new VentanaInicio();
       VentanaInicio.run();
       
    }
}    
     
