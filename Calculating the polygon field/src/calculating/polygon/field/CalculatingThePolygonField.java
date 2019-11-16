package calculating.polygon.field;

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
       Model controller = new Model();
       View view = new View();
       List<Vector2> vertices;
       
       if(!controller.areArguments(args)){
           vertices = controller.getArguments(view);
       }
       else{
           vertices = controller.parseVectorArguments(args, view);
       }

       controller.calculatePolygonField(vertices);
       view.printVertices(vertices);
    }
}
