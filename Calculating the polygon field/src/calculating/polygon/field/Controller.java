/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */
public class Controller {
    
    public boolean areArguments(String[] arguments){
        return arguments.length > 0;
    }
    
    public float[] getArguments(View view){
        float[] vertices;
        Scanner input = new Scanner(System.in);
        view.starGetVerticesFromInput();

        int count = getIntFromInput(input, view);
      
        vertices = new float[count];
        
        for(int i=0; i<vertices.length; i++){
            view.toGetFloat();
            
            if(input.toString().length() == 0)
            {
                break;
            }
            
            try {
                vertices[i] = input.nextFloat();
            }
            catch (InputMismatchException ime) {
                view.badNumberInInput();
                input.next(); // Flush the buffer from all data
                i--;
            }
        }
        return vertices;
    }
    
    public float[] parseArguments(String[] arguments, View view){
        float[] vertices = new float[arguments.length];
        for(int index = 0; index < arguments.length; index++){
            try{
                vertices[index] = Float.parseFloat(arguments[index].trim());
            }
            catch (NumberFormatException argument){
                view.floatParseError(argument);
                view.messageBeforeExit();
                System.exit(0);
            }
        }
        return vertices;
    }
    
    public void calculatePolygonField(float[] vertices){
        try{
            if(vertices.length < 3){
                throw new NotPolygonException("polygon should has more than 2 vertices");  
            }
        }
        catch(NotPolygonException ex){
           System.err.println(ex.getMessage());
           System.exit(0);
       }
    }
    
    private int getIntFromInput(Scanner input, View view){
        int count = 0;

        while(count == 0){
            try {
                count = input.nextInt();
            }
            catch (InputMismatchException ime) {
                view.badNumberInInput();
                input.next();
            }
        }
        return count;
    }
}

class NotPolygonException extends Exception {

    /**
     * Non-parameter constructor
     */
    public NotPolygonException() {
    }
    
    public NotPolygonException(String message){
        super(message);
    }
}