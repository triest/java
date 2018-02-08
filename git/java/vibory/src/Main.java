import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by triest on 26.05.2017.
 */



//Этот проверка системы выборов
    /*
    public static void main(String[] args) {
            VoitingSystem voitingSystem=new VoitingSystem();
            String[] arg={"d","ew"};
          Voiting voiting=new Voiting();
            voiting.setTitle("Vibor 2018");
            voiting.addCandidate2("Putin");
            voiting.addCandidate2("Medvedev");
           System.out.println("Putin index "+voiting.GetIndexByCandidateName("Medvedev"));
            voiting.AddVoiceByName("Putin");

      //     System.out.println(voiting.getCandidateByIndex(0).getVoices());

            System.out.println(voiting.getCandudate("Medvedev"));

          for (Candidate candidate: voiting.getCandidates()){
               System.out.println(candidate.getName());
               System.out.println(candidate.getVoices());
            }
    }
        */
/*
    public static void main(String[] args) throws IOException {
       // Server server=new Server(); //создаем сервер
      //  server.waitingClientConnect();//ждес соединения клиента
       // server.waitingmessage();
        Server1 server1=new Server1(6789);
        server1.startServer();
        Server1Connection server1Connection=new Server1Connection(server1);
        server1Connection.setClientSocket(server1.getClientSocket());

    }*/

public class Main {


    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + 4444 + ", " + e);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: " + 4444 + ", " + e);
            System.exit(1);
        }

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(
                    new BufferedOutputStream(clientSocket.getOutputStream(), 1024), false);
            KKState kks = new KKState();
            String inputLine, outputLine;

            outputLine = kks.processInput(null);
            pw.println(outputLine);
            pw.flush();

            while ((inputLine = br.readLine()) != null) {
                outputLine = kks.processInput(inputLine);
                pw.println(outputLine);
                pw.flush();
                if (outputLine.equals("Bye."))
                    break;
            }
            pw.close();
            br.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;
        // ServerSocket welcomeSocket = new ServerSocket (6789);
        Run run=new Run();
        KKState2 kkState2=new KKState2();
        //   Socket connectionSocket = welcomeSocket.
        //          accept();
        /*BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());*/
    /*    ServerSocket welcomeSocket = new ServerSocket (6789);
        while (true) {
           // Server server=new Server();


          /*  Socket connectionSocket = welcomeSocket.
                    accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine(); capitalizedSentence =
                    clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
*/

/*
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket (6789);
        Socket connectionSocket = welcomeSocket.
                accept();
        BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        WorkVitchUser workVitchUser=new WorkVitchUser();
        VoitingSystem voitingSystem=new VoitingSystem();
        while (true) {



            String toClient;
            clientSentence=inFromClient.readLine();
            System.out.println("From client "+clientSentence);
            if(clientSentence.equalsIgnoreCase("Authorization")){//если мы получили запрос на авторизацию,
                    toClient="Authorization_is_allowed"; //отправляем разрешение на авторизацию
                System.out.println("Ansvet to client "+toClient);
                    outToClient.writeBytes(toClient);
                    clientSentence=inFromClient.readLine();//получили имя и пароль
                   String[] NameAndPass=workVitchUser.devideNamePassword(clientSentence);
                    voitingSystem.findUser2(NameAndPass[0],NameAndPass[1]);
                // тут будем разделять имя и пароль


            }
        }
    }
    */


