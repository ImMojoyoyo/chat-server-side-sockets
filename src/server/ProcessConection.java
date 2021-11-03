package server;

import java.net.*;
import java.io.*;


public class ProcessConection extends Thread {
    Socket sc;
    int order;

    public ProcessConection(Socket sc, int order){
        this.sc = sc;
        this.order = order;
    }

    public void run(){
        try{
            PrintWriter out = new PrintWriter(sc.getOutputStream());
            BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));

            String name = bf.readLine();

            for(int i = 1; i <= 10; i++){
                out.println("message " + i +
                        "for client" + name +
                        ": number of order is " + order);
                out.flush();
                Thread.sleep(200);
            }
            sc.close();

        }
        catch (IOException e){
            System.out.println("Err with data...");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
