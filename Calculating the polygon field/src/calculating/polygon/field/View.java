/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field;

import java.util.List;

/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */
public class View {

    /**
     *
     * @param argument
     */
    public void floatParseError(NumberFormatException argument){
        System.out.println("NumberFormatException: " + argument.getMessage());
    }
    
    /**
     *
     */
    public void messageBeforeExit(){
        System.out.println("Aplication will close");
    }
    
    public void messageOddNumbersOfVertices(){
        System.out.println("program params must be even values");
    }
    
    /**
     *
     */
    public void badNumberInInput(){
        System.out.println("The number could not be entered correctly, try again");
    }
    
    /**
     *
     */
    public void starGetVerticesFromInput(){
        System.out.print("Enter number of vertices: ");
    }
    
    /**
     *
     */
    @Deprecated
    public void toGetFloat(){
        System.out.print("Enter a float: ");
    }
    
     public void toGetX(){
        System.out.print("Enter a float x: ");
    }
     
      public void toGetY(){
        System.out.print("Enter a float y: ");
    }
    /**
     *
     * @param vertices
     */
    public void printVertices(List<Vector2> vertices){
        for (Vector2 vertex : vertices){
            System.out.print("x: "+ vertex.X() + " y: " + vertex.Y() + "\n");
        }
    }
}

