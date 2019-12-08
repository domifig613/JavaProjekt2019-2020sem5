/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 * @version 1.0
 * @author Dominik Figlak
 */
public class PolygonFieldCalculator {
    
     /**
     * calculate distance between vertices
     * @param firstVertex
     * @param secoundVertex
     * @param otherVertices
     * @return distance
     */
     public Float calculateDistance(Vector2 firstVertex, Vector2 secoundVertex, Vector2...otherVertices){
         Float xDistance = firstVertex.X() - secoundVertex.X();
         Float yDistance = firstVertex.Y() - secoundVertex.Y();
         
         float distance = (float)(Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)));
         
         if(otherVertices.length > 0){
            xDistance = secoundVertex.X() - otherVertices[0].X();
            yDistance = secoundVertex.Y() - otherVertices[0].Y();
            
            distance += (float)(Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)));
            
            for(int i=1; i<otherVertices.length; i++){
                xDistance = otherVertices[i-1].X() - otherVertices[i].X();
                yDistance = otherVertices[i-1].Y() - otherVertices[i].Y();
                distance += (float)(Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)));
            }  
         }
         return distance;
     }
}
