/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dominik Figlak
 * @version 1.1
 */
public class Model {
    
    
     /**
     * Checks for arguments
     * @param arguments
     * @return
     */
    public boolean areArguments(String[] arguments){
        return arguments.length > 0;
    }
    
    /**
     * Calculate polygon field
     * @param vertices
     * @throws NotPolygonException
     * @return vertices
     */
    public float calculatePolygonField(List<Vector2> vertices) throws NotPolygonException{

       if(vertices.size() < 3){
           throw new NotPolygonException("polygon should has more than 2 vertices");  
       }

       PolygonFieldCalculator calculator = new PolygonFieldCalculator();
       return calculator.calculateDistance(vertices.get(0), vertices.get(1), vertices.get(2));
    }
    
     /**
     * Parse arguments from input
     * @return vertices
     * @param argumentsString
     * @param output
     */
    public List<Vector2> parseArguments(String argumentsString, PrintWriter output){
        String[] arguments = argumentsString.split(" ");
        List<Vector2> vertices = new ArrayList<>();
        
        for(int index = 0; index < arguments.length; index+=2){
            try{
                Float x = Float.parseFloat(arguments[index].trim());
                Float y = Float.parseFloat(arguments[index+1].trim());
                Vector2 point = new Vector2(x,y);
                boolean add = vertices.add(point);
            }
            catch (RuntimeException argument){
                output.println("Bad format");
            }
        }
         output.println("Good format");
        return vertices;
    }
}