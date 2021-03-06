/**
 * Created by triest on 27.06.2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class KnockKnockClient {
    public static void main(String[] args) {
        Socket kkSocket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            kkSocket = new Socket("127.0.0.1", 4444);
            pw = new PrintWriter(kkSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: taranis");
        }

        if (kkSocket != null && pw != null && br != null) {
            try {
                StringBuffer buf = new StringBuffer(50);
                int c;
                String fromServer;

                while ((fromServer = br.readLine()) != null) {
                    System.out.println("Server: " + fromServer);
                    if (fromServer.equals("Bye."))
                        break;
                    while ((c = System.in.read()) != '\n') {
                        buf.append((char)c);
                    }
                    System.out.println("Client: " + buf);
                    pw.println(buf.toString());
                    pw.flush();
                    buf.setLength(0);
                }

                pw.close();
                br.close();
                kkSocket.close();
            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }
}