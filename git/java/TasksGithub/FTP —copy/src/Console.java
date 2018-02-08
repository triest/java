import Exaption.NotConnectedExaption;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by triest on 05.03.2017.
 */
public class Console {
    String[] s = new String[10];


    //функция запроса комманды
    public void ascCommand(Commands commands,FTPClient client,FTPfunction ftPfunction,Console console) throws IOException {
        System.out.println ("Input command:");

        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        //  String[] s=new String[10];
        s = s1.split (" ");
        //    System.out.println (Arrays.toString (s));
        // заносим комманду в in
        try {
            commands.applyCommand (s,client,ftPfunction,console);
        } catch (NotConnectedExaption notConnectedExaption) {
            notConnectedExaption.printStackTrace ();
        }
    }

    public void askHostname(FTPfunction ftpFunction) {
        System.out.println ("Input Hostname");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        try {
            ftpFunction.setHostname (s1);
        } catch (NotConnectedExaption notConnectedExaption) {
            notConnectedExaption.printStackTrace ();
        }
    }

    public void askUsername(FTPfunction ftpFunction) {
        System.out.println ("Input Username");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        try {
            ftpFunction.setUsername (s1);
        } catch (NotConnectedExaption notConnectedExaption) {
            notConnectedExaption.printStackTrace ();
        }
    }

    public void askPasswort(FTPfunction ftpFunction) {
        System.out.println ("Input Password");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        try {
            ftpFunction.setPassword (s1);
        } catch (NotConnectedExaption notConnectedExaption) {
            notConnectedExaption.printStackTrace ();
        }
    }


    public String AskFileNameDownload( FTPClient client) {
        System.out.println ("Input File name:");
        final Scanner in = new Scanner (System.in);
        String filename = in.nextLine ();
       return filename;
    }

    public String AskDirectoryeNameDownload(FTPClient client) {
        final Scanner in2 = new Scanner (System.in);
        System.out.println ("Input directoty");
        String Directory=in2.nextLine ();
       return Directory;
    }




}

