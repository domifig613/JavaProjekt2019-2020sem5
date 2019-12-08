package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
/**
 * The class communicate with server.
 * @author Dominik Figlak
 * @version 1.0
 */
public class Client  {
    private Socket clientSocket; 
    private PrintWriter output;
    private BufferedReader input;
    private int PORT;
    private InetAddress hostAddress;

    /**
     * Constructor 
     * @throws IOException
     */
public Client() throws IOException {
        this.readProperties();
        try{ 
            this.setStreams();
            System.out.println("Connected.");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str="",str2; 
            while(!str.equals("over")){  //communictaion in terminal 
                str=br.readLine();
                output.println(str);
                str2 = input.readLine();
                System.out.println("Server says: "+str2);  
                this.setStreams();
            }
            clientSocket.close(); 
       }
       catch(IOException e ){
           System.err.print("Error!");
       }
}
/**
 * The method responsible for setting streams.
 */
private void setStreams(){
     try { output = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    clientSocket.getOutputStream())), true);
            input = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
        }  catch (IOException e) {
            System.out.println("Can't connect with server!");
        }
     catch (NullPointerException f){
         System.out.println("Can't connect with server!");
     }
}
/**
 * A method that reads the properties from a file "properties.xml"
 */
private void readProperties (){ 
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("properties.xml")) {
            properties.loadFromXML(in);
            PORT = (Integer.parseInt(properties.getProperty("port")));
            hostAddress = InetAddress.getByName(properties.getProperty("adresServer"));
            this.clientSocket = new Socket (hostAddress,PORT);
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
/**
* The main method
* @param args
* @throws IOException
*/
public static void main(String[] args) throws IOException {
    Client tcpclient = new Client(); 
    }
}