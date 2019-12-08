

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import tcpserver.Model;
import tcpserver.NotPolygonException;
import tcpserver.Vector2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Dominik Figlak
 * @version 1.1
 */
public class TestModel {
    
    private final Model model = new Model();
    
     /**
     * test areArguments from model class
     */
    @Test
    public void testAreArguments(){
        String[] arrayTest = new String[2];
        System.out.println("test areArguments, array 2 lenght: " + model.areArguments(arrayTest));
        arrayTest = new String[1];
        System.out.println("test areArguments, array 1 lenght: " + model.areArguments(arrayTest));
        arrayTest = new String[0];
        System.out.println("test areArguments, array 0 lenght: " + model.areArguments(arrayTest));
        arrayTest = new String[3];
        System.out.println("test areArguments, array 3 lenght: " + model.areArguments(arrayTest));
        arrayTest = new String[100];
        System.out.println("test areArguments, array 100 lenght: " + model.areArguments(arrayTest));
    }
    
     /**
     * test calculatePolygonField method from Model class
     */
    @Test
    public void testCalculatePolygonField()throws NotPolygonException{
        
        List<Vector2> testArray = new ArrayList<>();
        try{
        System.out.println("calculate polygon test 0, distance: " 
            + model.calculatePolygonField(testArray));
        }
        catch(NotPolygonException exc){
            System.out.println("calculate polygon test 0 fail");
        }
        testArray.add(new Vector2(3.5f, 0f));
        testArray.add(new Vector2(3.5f, 1f));
         try{
        System.out.println("calculate polygon test 1, distance: " 
            + model.calculatePolygonField(testArray));
        }
        catch(NotPolygonException exc){
            System.out.println("calculate polygon test 1 fail");
        }
        testArray.add(new Vector2(3.5f, 5f));
          try{
        System.out.println("calculate polygon test 2, distance: " 
            + model.calculatePolygonField(testArray));
        }
        catch(NotPolygonException exc){
            System.out.println("calculate polygon test 2 fail");
        }
        testArray.add(new Vector2(0f, 0f));
        testArray.add(new Vector2(-1f, -1f));
          try{
        System.out.println("calculate polygon test 3, distance: " 
            + model.calculatePolygonField(testArray));
        }
        catch(NotPolygonException exc){
            System.out.println("calculate polygon test 3 fail");
        }
        testArray.add(new Vector2(-4f, -4.5f));
         try{
        System.out.println("calculate polygon test 4, distance: " 
            + model.calculatePolygonField(testArray));
        }
        catch(NotPolygonException exc){
            System.out.println("calculate polygon test 4 fail");
        }
    }
    
    
}
