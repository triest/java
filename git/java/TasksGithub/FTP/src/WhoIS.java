import org.apache.commons.net.WhoisClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;

/**
 * Created by triest on 27.03.2017.
 */
public class WhoIS {
    String hostname;
    StringBuilder info;

    public StringBuilder getInfo() {
        return info;
    }

    public void setInfo(StringBuilder info) {
        this.info = info;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void answerWhoIS(){
        StringBuilder info = new StringBuilder("");
        WhoisClient whois = new WhoisClient();
        try {
            whois.connect(WhoisClient.DEFAULT_HOST);
            String data = whois.query("=" +this.getHostname ());
            info.append(data);
            whois.disconnect();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(info);
        this.setInfo (info);

    }

    public void WriteToFile(FileWriter writer,String text){
        try
        {
            // запись всей строки
         ;
            writer.append (text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println ("ErroR");
            System.out.println(ex.getMessage());
        }
    }

    public static void write(String fileName, StringBuilder text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.println(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
