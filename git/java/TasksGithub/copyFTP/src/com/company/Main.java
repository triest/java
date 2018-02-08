package com.company;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.SocketException;
import java.io.Console;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main fpclient=new Main ();
        Console console=new Console ();
        console.ascCommand ();

        try {
            System.out.println ();
            FTPClient client = new FTPClient ();
            String hostname="127.0.0.1";
            client.connect (hostname);
            FTPfunction ftPfunction=new FTPfunction ();
            //check connect to FTP
            boolean login1 = client.login ("user1", "7225");
            boolean answer=client.sendNoOp ();
            if(answer==true) {
                if (login1 != false) {
                    //   System.out.println("Remote system is " + client.getSystemName());
                    String[] ftpFile = client.listNames ();
                    //     System.out.println("file:  " + Arrays.asList(ftpFile));
                    System.out.println ();
                    client.changeWorkingDirectory ("RSE");
                    boolean rez = ftPfunction.downloadFile(client, "sw2.txt");
                    //конец скачки
                    //   boolean rez1 = fpclient.uploadFile (client, "E:/Dropbox/file111.txt");
                } else {
                    System.out.println ("Fals connect");
                }
                //закрываем соединение
                client.disconnect ();
            }
            else {System.out.println ("Fals connect");}
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
