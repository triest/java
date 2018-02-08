/**
 * Created by triest on 08.04.2017.
 */
import java.net.Socket;
public class Client2 {
    public static void main(String[] args)
    {
        try {
            Socket sock = new Socket("localhost",445);
            SendThread sendThread = new SendThread(sock);
            Thread thread = new Thread(sendThread);thread.start();
            RecieveThread recieveThread = new RecieveThread(sock);
            Thread thread2 =new Thread(recieveThread);thread2.start();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
}
