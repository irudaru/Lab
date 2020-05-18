import java.net.*;
import java.io.*;

public class Server {
    public static int count = 0;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server has started work");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Server has connected with Client #" + ++count);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );

            Collection collection = Collection.startFromSave(args);

        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally{
            System.out.print("Server has finished work");
        }
    }
}
