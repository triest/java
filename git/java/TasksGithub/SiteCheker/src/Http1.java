import Excaption.HuUnknownHostWxception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by triest on 15.04.2017.
 */
public class Http1 {
    String[] ErroesRespons;
    public int S;


    public String[] getErroesRespons() {
        return ErroesRespons;
    }

    public void setErroesRespons(String[] erroesRespons) {
        ErroesRespons = erroesRespons;
    }

    public void ReadResponseFromFile(String PatchToFile) throws IOException {
        //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path filePath = new File(PatchToFile).toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = Files.readAllLines(filePath, charset);
        String[] stringArray = stringList.toArray(new String[]{});
    }

    //читает файл с ошибками и записывает в массив
    public void readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
    //    System.out.print(Arrays.asList(lines.toArray(new String[lines.size()])));
        ErroesRespons=lines.toArray(new String[lines.size()]);
    }

    //ищим код оибки в элемента
    public void searchIndex(String url) throws IOException {
        int response= 0;
        try {
            response = getHTTPResponseStatusCode(url);
        } catch (HuUnknownHostWxception huUnknownHostWxception) {
            huUnknownHostWxception.printStackTrace();
        }

        String ErrirCode=String.valueOf(response);
        //будем искать код ошибки в строке из массива
        for (int i=0;i<ErroesRespons.length;i++) {
           boolean res=ErroesRespons[i].toLowerCase().contains(ErrirCode.toLowerCase());
           if (res==true){
               // если находим, то выводим описание
               System.out.println(ErroesRespons[i]);
               break;
           }
        }
    }

    public static int getHTTPResponseStatusCode(String u) throws HuUnknownHostWxception {
        URL url = null;
        try {
            url = new URL(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection http = null;
        try {
            http = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return http.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
  }

