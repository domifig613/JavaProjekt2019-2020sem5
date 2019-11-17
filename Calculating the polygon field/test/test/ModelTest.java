/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.*;
import calculating.polygon.field.Model;
import calculating.polygon.field.Vector2;
import calculating.polygon.field.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */
public class ModelTest {
    
    private Model model;
    private View view;
    
    @Before
    public void setup(){
        model = new Model();
        view = new View();
    }
    
    @Test
    public void testGetArguments(){
        try
        {
            List<Vector2> points = model.getArguments(view);
            System.out.println("list of points from method getArguments : /n");
            for(Vector2 point : points)
            {
                System.out.println(point.X() + " " + point.Y() + "/n");
            }
        }
        catch(Exception exception)
        {
            System.out.println("cannot test getArguments method"); 
        }
    }
    
    @Test
    public void testCalculatePolygonField(){
        List<Vector2> vertices = new ArrayList<Vector2>();
        vertices.add(new Vector2(3.4f, 3.5f));
        vertices.add(new Vector2(3.4f, 3.5f));
        model.calculatePolygonField(vertices);

        vertices.add(new Vector2(3.4f, 3.5f));
        model.calculatePolygonField(vertices);
    }
    
    @Test
    public void testParseVectorArguments(){
         //public List<Vector2> parseVectorArguments(String[] arguments, View view)
         List<String[]> testArrays = new ArrayList<String[]>();
         String[] arrayArguments1 = {"32"};
         testArrays.add(arrayArguments1);
         String[] arrayArguments2 = {"32", "3.35"};
         testArrays.add(arrayArguments2);
         String[] arrayArguments3 = {"32","32", "3.35"};
         testArrays.add(arrayArguments3);
         String[] arrayArguments4 = {"32","32", "3.35","32", "3.35"};
         testArrays.add(arrayArguments4);
         String[] arrayArguments5 = {"0", "0","0", "0","0", "0",};
         testArrays.add(arrayArguments5);
         String[] arrayArguments6 = {"32","0", "0",};
         testArrays.add(arrayArguments6);
         String[] arrayArguments7 = {"32","32","0", "0","32","0", "0"};
         testArrays.add(arrayArguments7);
         String[] arrayArguments8 = {"32", "-5", "-35677", "0,2323"};
         testArrays.add(arrayArguments8);
         
         
         for(String[] array : testArrays){
         try{
               model.parseVectorArguments(array, view);
                 
         }
         catch(Exception exception){
            System.out.println("array with strings");
             for(String string : array){
                System.out.println(string);
            }
             System.out.println("cannot be converted to floats");
         }
        }       
    }
}
