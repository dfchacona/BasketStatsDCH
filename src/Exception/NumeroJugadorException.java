/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author dieguischa
 */
public class NumeroJugadorException extends Exception {

    public NumeroJugadorException(String message) {
        super("El numero es demasiado largo");
    }
     
}
