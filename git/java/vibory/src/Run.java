import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by triest on 18.06.2017.
 */
public class Run {
    String clientSentence;
    String capitalizedSentence;

    public void run(ServerSocket welcomeSocket) throws IOException {
        Socket connectionSocket = welcomeSocket.
                accept();
        BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        clientSentence = inFromClient.readLine();
        System.out.println(clientSentence);
        capitalizedSentence =
                clientSentence.toUpperCase() + '\n';
        outToClient.writeBytes(capitalizedSentence);
    }
}
