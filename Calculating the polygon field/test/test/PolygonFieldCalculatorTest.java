/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import calculating.polygon.field.PolygonFieldCalculator;
import org.junit.*;
import calculating.polygon.field.Vector2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */
public class PolygonFieldCalculatorTest {
    
    private PolygonFieldCalculator calculator;
    
    @Before
    public void suite(){
        calculator = new PolygonFieldCalculator();
    }
    
    @Test
    public void testCalculateDistance(){
        List<Vector2> testList = new ArrayList<Vector2>();
        
        testList.add(new Vector2((float)3.5, (float)5.6));
        testList.add(new Vector2((float)-3.5, (float)0));
        testList.add(new Vector2((float)3.5, (float)5.6));
        testList.add(new Vector2((float)0, (float)0));
        testList.add(new Vector2((float)-3.53232, (float)1.6));
        
        for(Vector2 point : testList){
            for(Vector2 point1 : testList){
             System.out.println(calculator.calculateDistance(point1, point));
            }
        }
        
    }
}
