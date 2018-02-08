import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;

/**
 * Created by triest on 19.02.2017.
 */

public class Qverty {


    public static void main(String args[]) throws IOException {
        URL url = new URL("http://paralay.iboards.ru/index.php?");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("sid=1165585fc68e11cdd70aa67600450992");
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while (true) {
            if (!((line = reader.readLine()) != null)) break;
            System.out.println(line);
        }
        writer.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
