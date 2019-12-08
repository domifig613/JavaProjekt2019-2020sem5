/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field.Model;

/**
 * @author Dominik Figlak
 * @version 1.1
 */
public class Vector2 {

    private final Float x;
    private final Float y;
    
      /**
     * @return x
     */
    public Float X(){
        return x;
    }
    
    /**
     * @return y
     */
    public Float Y()
    {
        return y;
    }
    
    /**
     * Create new Point
     * @param x
     * @param y
     */
    public Vector2(Float x, Float y){
        this.x = x;
        this.y = y;
    }
}
