import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by triest on 12.06.2017.
 */
public class Client {
    String login;
    String password;

    PrintWriter out;
    BufferedReader inu;
    String fuser,fserver;
    Socket fromserver;
    BufferedReader in;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void UserEnter(){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя логин");
         this.setLogin(in.nextLine());
        System.out.println("Введите пароль");
         password=in.nextLine();
    }


    public void SendLoginAndPasswordToServer(){
        //while (login!=null){
          out.println(login);
            String loginAndPassdord=this.getLogin()+"&"+this.getPassword();
           fserver =loginAndPassdord;

       }

/*
    public void SendTextMessage(String textMessage){
            while (=textMessage!=null){
                out.println(textMessage);
                fserver=textMessage;
           }
    }*/

    public void Connect() throws IOException {

            BufferedReader inFromUser =
                    new BufferedReader(
                            new InputStreamReader(System.in));
           fromserver = new Socket ("127.0.0.1",1234);
            DataOutputStream outToServer =
                    new DataOutputStream(
                            fromserver.getOutputStream());
            BufferedReader inFromServer =
                    new BufferedReader(
                            new InputStreamReader(
                                   fromserver.getInputStream()));
        out = new PrintWriter(fromserver.getOutputStream(),true);
        inu = new BufferedReader(new InputStreamReader(System.in));

    }


    public void sendToServer(String TextTosend) throws IOException {

    //    out = new PrintWriter(fromserver.getOutputStream(),true);
      //  inu = new BufferedReader(new InputStreamReader(System.in));
        out.println(TextTosend);
    }

    public String makeLoginAndPassword(){
        String LoginAndPassword=login+"&"+password;
      return LoginAndPassword;
    }

    //пример клиента
    public void ClientExample(){
        System.out.println("ds");
        System.out.println("Welcome to Client side");

         fromserver = null;

        System.out.println("Connecting to");
        try {
            fromserver = new Socket("127.0.0.1",1234);
            BufferedReader in  = new
                    BufferedReader(new InputStreamReader(fromserver.getInputStream()));
             out = new PrintWriter(fromserver.getOutputStream(),true);
             inu = new BufferedReader(new InputStreamReader(System.in));




            while ((fuser = inu.readLine())!=null) {
                out.println(fuser);
                fserver = in.readLine();
                System.out.println(fserver);
                if (fuser.equalsIgnoreCase("close")) break;
                if (fuser.equalsIgnoreCase("exit")) break;
            }
            System.out.println(inu);
            out.close();
            in.close();
            inu.close();
            fromserver.close();
            System.out.println("Connecting close");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Connecting error");
            System.exit(0);
        }

    }



}
