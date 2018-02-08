/**
 * Created by triest on 19.02.2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class httprequest {
    public static void request() throws IOException{
        URL url = new URL("http://www.java2s.com");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("value=1&anotherValue=1");
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
