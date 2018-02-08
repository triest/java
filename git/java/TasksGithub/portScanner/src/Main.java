import java.io.IOException;
import java.net.Socket;

/**
 * Created by triest on 11.03.2017.
 */

public class Main {
    int minPort;
    
    public static void main(String[] args) {
        String remote = "192.168.0.1";
        int minPort = 0;
        int maxPort;
        PortScanner portScanner=new PortScanner();
        portScanner.askIP();
        portScanner.askMinPort();
        portScanner.askMaxPort();
        minPort=portScanner.getMinPort();
        maxPort=portScanner.getMaxPort();

        if(minPort>maxPort){
            int temp=minPort;
            minPort=maxPort;
            maxPort=temp;
        }
        System.out.println("Scannenig is begins");
        do {
            try {
                Socket s = new Socket(remote,minPort);
                System.out.println("Server is listening on port " + minPort+ " of " + remote);
                s.close();

            } catch (IOException ex) {
            //    System.out.println("Server is not listening on port " + i+ " of " + remote);
            }
            minPort++;
            if(minPort%100==0){System.out.println("Lestens "+minPort );}
        } while(minPort <= maxPort);
        System.out.println();
    }
}
