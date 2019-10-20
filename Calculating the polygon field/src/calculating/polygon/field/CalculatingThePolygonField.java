package calculating.polygon.field;

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
       Controller controller = new Controller();
       View view = new View();
       float[] vertices;
       
       if(!controller.areArguments(args)){
           vertices = controller.getArguments(view);
       }
       else{
           vertices = controller.parseArguments(args, view);
       }

       controller.calculatePolygonField(vertices);
       view.printVertices(vertices);
    }
}
