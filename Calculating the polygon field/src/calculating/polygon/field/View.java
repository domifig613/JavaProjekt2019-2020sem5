/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field;

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
    public void toGetFloat(){
        System.out.print("Enter a float: ");
    }
    
    /**
     *
     * @param vertices
     */
    public void printVertices(float[] vertices){
          for (int i = 0; i < vertices.length; i++) {
             System.out.print(vertices[i] + "\n");
        }
    }
}

