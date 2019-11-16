/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field;

import com.sun.org.glassfish.gmbal.Description;

/**
 *
 * @author domin
 */
public class PolygonFieldCalculator implements Distance {
    
     @Description("calculateDistance (implemented from interface) was called")
     public Float calculateDistance(Vector2 firstVertex, Vector2 secoundVertex)
     {
         Float xDistance = firstVertex.X() - secoundVertex.X();
         Float yDistance = firstVertex.Y() - secoundVertex.Y();
         
         return (float)(Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)));
     }
}
