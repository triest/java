import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by triest on 02.07.2017.
 */
public class KKState2 {

    // / переменные состояния
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;
    User user;
    private int state = WAITING;
    private int currentJoke = 0;
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    VoitingSystem voitingSystem;
    Voiting voiting;

    public KKState2() {
       voitingSystem =new VoitingSystem();
       voiting=new Voiting();
    }

    String processInput(String theInput) {
        String theOutput = null;

            //если мы ждали, то отправляем ответ об авторизации
        if(state==WAITING){
            theOutput="Authorization";
        }

/*
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: " + 4444 + ", " + e);
            System.exit(1);
        }
*/

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(
                    new BufferedOutputStream(clientSocket.getOutputStream(), 1024), false);
            KKState kks = new KKState();
            String inputLine, outputLine;
        }
         catch (IOException e){
            e.printStackTrace();
         }


            return theOutput;
    }

    //функция читает
    // сначала отправляем имя и пароль. Затем того, за которого голосуем
    public void ReadCommand(String command){
            if(command.contains("&")){ //если пришла стока с разделителем, то считаем, что это имя и пароль
                    //
                String []parts=command.split("&"); //разделяем имя и пароль
               if (voitingSystem.findUser2(parts[0],parts[1])!=null){
                        user=voitingSystem.findUser2(parts[0],parts[1]); // присваиваем пользователя
               }else {
                   System.out.println("User not found");
               }
            }
            // если команда содержит голосование
        if(command.contains("voiting")){

                if( voitingSystem.findUser2(user.getLogin(),user.getPassword()).isVoited()==false){
            String []parts=command.split("&"); //разделияем
            voiting.AddVoiceByName(parts[1]);
            voitingSystem.findUser2(user.getLogin(),user.getPassword()).setVoited(true);}
                else {
                    System.out.println("User alredy voited");
                }
        }
    }
}
