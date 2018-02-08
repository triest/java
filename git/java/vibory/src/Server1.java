/**
 * Created by triest on 15.06.2017.
 */

import java.io.*;
import java.net.*;

public class Server1 {

        int port = 6789;
        Server1 server ;

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


// declare a server socket and a client socket for the server

    ServerSocket echoServer = null;
    Socket clientSocket = null;


    public Server1( int port ) {
        this.port = port;
        //server = new Server1( port );
        this.startServer();

    }

    public void stopServer() {
        System.out.println( "Server cleaning up." );
        System.exit(0);
    }

    public void startServer() {
        // Try to open a server socket on the given port
        // Note that we can't choose a port less than 1024 if we are not
        // privileged users (root)

        try {
            echoServer = new ServerSocket(port);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        System.out.println( "Waiting for connections. Only one connection is allowed." );

        // Create a socket object from the ServerSocket to listen and accept connections.
        // Use Server1Connection to process the connection.

        while ( true ) {
            try {
                clientSocket = echoServer.accept();
                Server1Connection oneconnection = new Server1Connection(this);
                oneconnection.run();
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

class Server1Connection {
    BufferedReader is;
    PrintStream os;
    Socket clientSocket;
    Server1 server;

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public Server1Connection(Server1 server) {
       // this.clientSocket =;
        this.server = server;
        System.out.println( "Connection established with: " + clientSocket );
        try {
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run() {
        String line;
        try {
            boolean serverStop = false;
            Integer n = null;
            while (true) {
                line = is.readLine();
                System.out.println( "Received " + line );
                if (line==null){continue;}
                 n = Integer.parseInt(line);
                if ( n == -1 ) {
                    serverStop = true;
                    break;
                }
                if ( n == 0 ) break;
                os.println("" + n );
            }
                System.out.println(n);
            System.out.println( "Connection closed." );
        //    is.close();
          //  os.close();
          //  clientSocket.close();

            if ( serverStop ) server.stopServer();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}