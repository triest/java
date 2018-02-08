import Exaption.NotConnectedExaption;

import java.util.Scanner;

/**
 * Created by triest on 05.03.2017.
 */
public class Console {
    String[] s = new String[10];
    //функция запроса комманды
    public void askHostname(WhoIS whoIS) {
        System.out.println ("Input Hostname");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
            whoIS.setHostname (s1);
          //  ftpFunction.setHostname (s1);

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



}

