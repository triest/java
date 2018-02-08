
import java.net.*;
import java.io.*;
public class HttpListener {
    HttpListener(int portNumber)
    {
        try
        {
            ServerSocket entrance = new ServerSocket(portNumber);
            Socket s = new Socket();
// entrance.setSoTimeout(2000);
// s.setSoTimeout(100);
// System.out.println(s.getSoTimeout());
            s = entrance.accept();
            InputStream inputData = s.getInputStream();

            String msg = new String();
            int a = 0;
            while ( (a = inputData.read()) != -1  )
            {
                byte i = (byte) a;
                String st = new Character((char)i).toString();
                msg += st;
            }
            System.out.println(msg+"\n of length "+msg.length());
// System.out.print(outputData.);
            inputData.close();
            s.close();
            entrance.close();
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }
    }
}