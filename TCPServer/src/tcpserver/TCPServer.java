package tcpserver;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.io.*;
/**
 * @author Dominik Figlak
 * @version 1.0
 */
public class TCPServer implements Closeable {
    private int PORT; 
    private ServerSocket serverSocket ;
    private Socket socket ;
    private PrintWriter output;
    private BufferedReader input;
    private Model model;
 /**
 * Reads the properties from a file "properties.xml"
 */   
private void readProperties(){ 
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("properties.xml")) {
            properties.loadFromXML(in);
            PORT = (Integer.parseInt(properties.getProperty("port")));
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
}
/**
 * The method responsible for setting streams.
 * @throws IOException
 */
public void setStreams() throws IOException{
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
}
/**
 * 
 * @throws IOException checks the correctness of reading and writing
 * 
 */
public TCPServer() throws IOException{
        try{ 
            this.readProperties();
            model = new Model();
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server on");
            socket=serverSocket.accept();
            System.out.println("Communicate with client accepted");
            this.setStreams();
            String str="";
            while(!str.equals("over"))  //server loop
            {  
                str = input.readLine();
                if(str.equals("HELP") || str.toUpperCase().equals("HELP")){
                   output.println( "'HowCommunicate' - show how add data for,"
                           +"'CalculateMethod' - , print name of method use server to calculate"+
                       "'over' - close server");
                }
                else if(str.equals("HowCommunicate")){
                    output.println(ListOperations.showCalculateMethod());
                }
                else if(str.equals("CalculateMethod")){
                    output.println(ListOperations.showHowCommunicate());
                }
                else if(str.equals("over")){ 
                     output.println("OVER");
                }
                else{
                output.println(model.parseArguments(str, output));
                }  
                this.setStreams();
           }
           System.out.print("Server closed.\n");
           socket.close();  
           serverSocket.close();  
    } 
       catch(IOException | NullPointerException e) {
            System.err.println("Server closed.\n");
    }  
       }
    /**
     * Creating server object.
     * @param args not used 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException  {
        TCPServer tcpserver= new TCPServer(); 
    }
    
     /**
     * Close server.
     * @throws IOException 
     */
       @Override
    public void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
    } 
}
