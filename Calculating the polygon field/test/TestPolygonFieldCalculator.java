
import calculating.polygon.field.Model.PolygonFieldCalculator;
import calculating.polygon.field.Model.Vector2;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Dominik Figlak
 * @version 1.0
 */
public class TestPolygonFieldCalculator {
    
    private final PolygonFieldCalculator polygonFieldCalculator = new PolygonFieldCalculator();
    
     /**
     * test claculateDistance method from PolygonFieldCalculator class
     */
    @Test
    public void testCalculateDistance(){
        List<Vector2> testList = new ArrayList<>();
        testList.add(new Vector2(0.0f, 1.0f));
        testList.add(new Vector2(-1.0f, 1.0f));
        testList.add(new Vector2(-10.0f, 1.0f));
        testList.add(new Vector2(0.0f, 1.5f));
        testList.add(new Vector2(20.0f, 1.0f));
        testList.add(new Vector2(10.0f, 111.5f));

        System.out.println("Calculate Distance test 1, distance: " 
            + polygonFieldCalculator.calculateDistance(testList.get(0), testList.get(1)));
        System.out.println("Calculate Distance test 2, distance: " 
            + polygonFieldCalculator.calculateDistance(testList.get(0), testList.get(1),testList.get(2)));
        System.out.println("Calculate Distance test 3, distance: " 
            + polygonFieldCalculator.calculateDistance(testList.get(0), testList.get(1),testList.get(2),testList.get(3)));
        System.out.println("Calculate Distance test 4, distance: " 
            + polygonFieldCalculator.calculateDistance(
            testList.get(0), testList.get(1),testList.get(2),testList.get(3),testList.get(4)));
        System.out.println("Calculate Distance test 5, distance: " 
            + polygonFieldCalculator.calculateDistance(
                    testList.get(0), testList.get(1), testList.get(2),testList.get(3),testList.get(4),testList.get(5),testList.get(0)));
        System.out.println("Calculate Distance test 6, distance: " 
            + polygonFieldCalculator.calculateDistance(testList.get(0), testList.get(5)));
    }
}
