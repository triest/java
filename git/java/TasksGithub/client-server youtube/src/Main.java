import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by triest on 08.04.2017.
 */


public class Main {

    public static void main(String[] args){
        try {
            ServerSocket ss=new ServerSocket(1201);
            Socket s=ss.accept();
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String msgin="";
            String msgout="";

            while (!msgin.equals("end")){
                msgin=din.readUTF();
                System.out.println("Client>"+msgin);
                msgout=br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            s.close();
        }catch (Exception e){
            System.out.print("Ooops");
        }
    }
}
