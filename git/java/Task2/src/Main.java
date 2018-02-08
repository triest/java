import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by triest on 17.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] commands;
        List<String> lines = new ArrayList<String>();
        Integer count=0;
        try {
        FileInputStream fstream = new FileInputStream("E:\\Dropbox\\Java\\Task2\\src\\test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
            while ((strLine = br.readLine()) != null) {
              //  System.out.println(strLine);
                lines.add(strLine);
                count++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        commands=lines.toArray(new String[0]);
        System.out.println(Arrays.toString(new String[]{commands[0]}));

    }
}
