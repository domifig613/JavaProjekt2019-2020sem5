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
public class Model {
    
    /**
     * @param arguments
     * @return
     */
    public boolean areArguments(String[] arguments){
        return arguments.length > 0;
    }
    
    /**
     *
     * @param view
     * @return
     */
    public List<Vector2> getArguments(View view){
        List<Vector2> vertices;
        Scanner input = new Scanner(System.in);
        view.starGetVerticesFromInput();

        int count = getIntFromInput(input, view);
        
        vertices = new ArrayList<Vector2>();
        
        for(int i=0; i < count; i++){
            
            
            if(input.toString().length() == 0)
            {
                break;
            }
            
            try {
                view.toGetX();
                Float vertexX = new Float(input.nextFloat());
                view.toGetY();
                Float vertexY = new Float(input.nextFloat());
                vertices.add(new Vector2(vertexX, vertexY));
            }
            catch (InputMismatchException ime) {
                view.badNumberInInput();
                input.next(); // Flush the buffer from all data
                i--;
            }
        }
        return vertices;
    }
    
    /**
     *
     * @param arguments
     * @param view
     * @return
     */
    @Deprecated
    public List<Float> parseArguments(String[] arguments, View view){
        List<Float> vertices = new ArrayList<Float>();
        for(int index = 0; index < arguments.length; index++){
            try{
                vertices.add(Float.parseFloat(arguments[index].trim()));
            }
            catch (NumberFormatException argument){
                view.floatParseError(argument);
                view.messageBeforeExit();
                System.exit(0);
            }
        }
        return vertices;
    }
    
    /**
     *
     * @param vertices
     */
    public void calculatePolygonField(List<Vector2> vertices){
        try{
            if(vertices.size() < 3){
                throw new NotPolygonException("polygon should has more than 2 vertices");  
            }
        }
        catch(NotPolygonException ex){
           System.err.println(ex.getMessage());
           System.exit(0);
       }
    }
    
    public List<Vector2> parseVectorArguments(String[] arguments, View view){
        List<Vector2> vertices = new ArrayList<Vector2>();
        if(arguments.length % 2 != 0)
        {
            view.messageOddNumbersOfVertices();
            view.messageBeforeExit();
            System.exit(0);
        }
        for(int index = 0; index < arguments.length; index +=2){
            try{
                Float x = Float.parseFloat(arguments[index].trim());
                Float y = Float.parseFloat(arguments[index+1].trim());
                vertices.add(new Vector2(x,y));
            }
            catch (NumberFormatException argument){
                view.floatParseError(argument);
                view.messageBeforeExit();
                System.exit(0);
            }
        }
        return vertices;
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