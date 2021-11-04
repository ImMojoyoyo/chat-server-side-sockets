package client;

import java.net.*;
import java.io.*;

public class StartClient {
    public  static void main(String[] args){
        int port = 3000;
        String message = null;
        try{
            Socket connection = new Socket("localhost", port);
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

            BufferedReader keyword = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert your name");

            out.println(keyword.readLine());
            out.flush();


            BufferedReader _readSocket = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((message = _readSocket.readLine()) != null){
                System.out.println("Message recived " + message);
            }

            connection.close();
        }
        catch (UnknownHostException e){
            System.out.println("This host doesn't exist");
        }
        catch (IOException e){
            System.out.println("We have a error with E/S");
        }
    }
}
