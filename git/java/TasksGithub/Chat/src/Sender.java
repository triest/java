/**
 * Created by triest on 30.03.2017.
 */
import java.net.*;

import java.io.*;
import java.util.Scanner;

class Sender{

    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private int port;

    Sender(String host, int port){

        this.host = host;

        this.port = port;

    }

    public void sendMessage(String mes){

        try{

            byte[] data = mes.getBytes();

            InetAddress addr = InetAddress.getByName(host);

            DatagramPacket pack = new DatagramPacket(data, data.length, addr, port);

            DatagramSocket ds = new DatagramSocket();

            ds.send(pack);

            ds.close();

        }catch(IOException e){

            System.err.println(e);

        }

    }

    public void askMessage() {
        System.out.print (">");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        sendMessage(s1);
        //  ftpFunction.setHostname (s1);

    }

    static SomeThing someThing;
    public static void main(String[] args) {
        someThing=new SomeThing();
        someThing.start();
        Sender sndr = new Sender("localhost", 1050);
        String[] st = {"d", "ds"};
        while (true){
        sndr.askMessage();}
    }
}