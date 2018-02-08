import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by triest on 26.06.2017.
 */
public class KnockKnock {

    private ServerSocket serverSocket;
    private Socket clientSocket;

    public KnockKnock() {
        // создаем сокет сервера
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 4444");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: " + 4444 + ", " + e);
            System.exit(1);
        }


        try {
            //создаем поток ввода и вывода

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(
                    new BufferedOutputStream(clientSocket.getOutputStream(), 1024), false);
            KKState kks = new KKState();
            String inputLine, outputLine;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
