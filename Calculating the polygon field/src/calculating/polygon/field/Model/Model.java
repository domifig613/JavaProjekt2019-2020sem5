/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field.Model;

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
     */
    public float calculatePolygonField(List<Vector2> vertices) throws NotPolygonException{

       if(vertices.size() < 3){
           throw new NotPolygonException("polygon should has more than 2 vertices");  
       }

       PolygonFieldCalculator calculator = new PolygonFieldCalculator();
       return calculator.calculateDistance(vertices.get(0), vertices.get(1), vertices.get(2));
    }
}