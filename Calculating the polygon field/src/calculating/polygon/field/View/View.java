/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field.View;

import calculating.polygon.field.Model.Vector2;
import java.util.List;

/**
 * Class to display user information on the output
 * @author Dominik Figlak
 * @version 1.1
 */
public class View {

    /**
     * Displays information about the error during parse
     * @param argument
     */
    public void floatParseError(RuntimeException argument){
        System.out.println("RuntimeExceptionException: " + argument.getMessage());
    }
    
    /**
     * Displays message about exit
     */
    public void messageBeforeExit(){
        System.out.println("Aplication will close");
    }
    
    /**
     * Displays information with wrong numbers at the input
     */
    public void badNumberInInput(){
        System.out.println("The number could not be entered correctly, try again");
    }
    
    /**
     * Displays information about the waiting number at the entrance
     */
    public void starGetVerticesFromInput(){
        System.out.print("Enter number of vertices: ");
    }
    
    /**
     * Displays information about the waiting float at the entrance
     */
    @Deprecated
    public void toGetFloat(){
        System.out.print("Enter a float: ");
    }
    
    /**
    * Displays information about the waiting float x at the entrance
    */
    public void toGetXFloat(){
        System.out.print("Enter a x float: ");
    }
     
    /**
    * Displays information about the waiting float y at the entrance
    */
    public void toGetYFloat(){
        System.out.print("Enter a y float: ");
    }
    
    /**
     * Displays all vertices
     * @param vertices
     */
    public void printVertices(List<Vector2> vertices){
          for(Vector2 point : vertices){
              System.out.print("x: " + point.X() + " ");
              System.out.print("y: " + point.Y() + "\n");
          }
    }
}

