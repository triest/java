import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by triest on 08.04.2017.
 */
public class Client2 {
    public static void main(String[] args){
        try {
            Socket s=new Socket("127.0.0.1",1201);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String msgin="";
            String msgout="";
            while (!msgin.equals("end")){
                msgout=br.readLine();
                dout.writeUTF(msgout);
                msgin=din.readUTF();
                System.out.println(msgin);
            }

        }catch (Exception e){

        }
    }
}
