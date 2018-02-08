/**
 * Created by triest on 25.03.2017.
 */

import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * Created by triest on 25.03.2017.
 */

public class Main {


    public static void main(String args[]) throws IOException {
        JSONObject object = new JSONObject();
        WeatherHttpClient weatherHttpClient=new WeatherHttpClient();
        String res=weatherHttpClient.getWeatherData("Petrozavadsk");
        Gson g = new Gson();
        JSONObject jsonObj = new JSONObject(jsonString.toString());
        System.out.print(res);
        JSONArray myjsonarray = myjson.toJSONArray(string_containing_json_above);
    }


}