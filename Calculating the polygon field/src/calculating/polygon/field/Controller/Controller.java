/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating.polygon.field.Controller;

import calculating.polygon.field.Model.Vector2;
import calculating.polygon.field.View.View;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Class collects data from the user
 * @author Dominik Figlak
 * @version 1.1
 */
public class Controller {
    
    /**
     * Take points from user
     * @param view
     * @return vertices
     */
    public List<Vector2> getArguments(View view){
        List<Vector2> vertices = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        view.starGetVerticesFromInput();

        int count = getIntFromInput(input, view);
        float x=0f, y=0f;
        for(int i=0; i< count; i++){
            
            view.toGetXFloat();
            
            if(input.toString().length() == 0)
            {
                break;
            }
            
            try {
                x = input.nextFloat();
            }
            catch (InputMismatchException ime) {
                view.badNumberInInput();
                input.next(); // Flush the buffer from all data
                i--;
                continue;
            }
            
             view.toGetYFloat();
            
            if(input.toString().length() == 0)
            {
                break;
            }
            
            try {
                y = input.nextFloat();
            }
            catch (InputMismatchException ime) {
                view.badNumberInInput();
                input.next(); // Flush the buffer from all data
                i--;
                continue;
            }
            Vector2 point = new Vector2(x,y);
            vertices.add(point);
        }
        return vertices;
    }
    
    /**
     * Parse arguments from input
     * @param arguments
     * @param view
     * @return vertices
     */
    public List<Vector2> parseArguments(String[] arguments, View view){
        List<Vector2> vertices = new ArrayList<>();
        for(int index = 0; index < arguments.length; index+=2){
            try{
                Float x = Float.parseFloat(arguments[index].trim());
                Float y = Float.parseFloat(arguments[index+1].trim());
                Vector2 point = new Vector2(x,y);
                vertices.add(point);
            }
            catch (RuntimeException argument){
                view.floatParseError(argument);
                view.messageBeforeExit();
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

