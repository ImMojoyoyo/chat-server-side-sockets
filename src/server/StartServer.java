package server;

import java.net.*;
import java.io.*;



public class StartServer {
    public static void main(String[] args){
        int port = 3000;
        int order = 1;

        try{
            ServerSocket server = new ServerSocket(port);

            while(true){
                System.out.println("Waiting for a new connection...");

                Socket con = server.accept();
                (new ProcessConection(con, order)).start();
                order++;
            }
        }
        catch (UnknownHostException e){
           System.out.println("This host doesn't exist");
        } catch (IOException e) {
            System.out.println("Err with some data...");
        }
    }
}
