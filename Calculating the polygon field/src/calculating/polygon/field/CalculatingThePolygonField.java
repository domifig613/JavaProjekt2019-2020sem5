package calculating.polygon.field;

import calculating.polygon.field.Controller.Controller;
import calculating.polygon.field.View.View;
import calculating.polygon.field.Model.Model;
import calculating.polygon.field.Model.NotPolygonException;
import calculating.polygon.field.Model.Vector2;
import java.util.List;

/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */
public class CalculatingThePolygonField {

    /**
     * @param args the command line arguments
     * in args specify positions of consecutive vertices of the polygon
     */
    public static void main(String[] args) {
       Model model = new Model();
       Controller controller = new Controller();
       View view = new View();
       List<Vector2> vertices;
       
       if(!model.areArguments(args)){
           vertices = controller.getArguments(view);
       }
       else{
           vertices = controller.parseArguments(args, view);
       }

       try{
       model.calculatePolygonField(vertices); 
       }
       catch(NotPolygonException ex)
       {}
      
       view.printVertices(vertices);
    }
}
