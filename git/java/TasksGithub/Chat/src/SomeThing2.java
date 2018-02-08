import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by triest on 02.04.2017.
 */

class SomeThing2            //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    public void run()        //Этот метод будет выполняться в побочном потоке
    {
        System.out.println("Привет из побочного потока!");

        try {
            DatagramSocket ds = new DatagramSocket(1052);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}