/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field.Model;

/**
 * @version 1.0
 * @author DominikFiglak
 */

public class NotPolygonException extends Exception {

    /**
     * Non-parameter constructor
     */
    public NotPolygonException() {
    }
    
     /**
     * bad points exception message
     */
    public NotPolygonException(String message){
        super(message);
    }
}