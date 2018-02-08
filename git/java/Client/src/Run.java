

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by triest on 18.06.2017.
 */
public class Run {
    String sentence;
    String modifiedSentence;

    void run() throws IOException {
        BufferedReader inFromUser =
                new BufferedReader(
                        new InputStreamReader(System.in));
        Socket clientSocket = new Socket ("127.0.0.1",6789);
        DataOutputStream outToServer =
                new DataOutputStream(
                        clientSocket.getOutputStream());
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        // while (true) {
        outToServer.writeBytes(sentence + "\n");
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        //}
        //     clientSocket.close();
    }
}
