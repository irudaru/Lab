import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try{
            Socket clientSocket = new Socket("127.0.0.1", 1234);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );

            System.out.println(reader.readLine());
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Client has finished work");
        }
    }
}
