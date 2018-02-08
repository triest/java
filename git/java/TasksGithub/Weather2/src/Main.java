/**
 * Created by triest on 25.03.2017.
 */

import java.io.IOException;

/**
 * Created by triest on 25.03.2017.
 */

public class Main {



    public static void main(String args[]) throws IOException {
   //     JSONObject object = new JSONObject();
        WeatherHttpClient weatherHttpClient=new WeatherHttpClient();
   String res;

        res = weatherHttpClient.getWeatherData("Petrozavadsk");
                       String[] arr = res.split(",");
                       //    System.out.print(Arrays.asList(arr));
                       weatherHttpClient.CutDataFromArray(weatherHttpClient.getDataArray());
                       System.out.println("Max temp " + weatherHttpClient.getMaxTempOfDay());
                       System.out.println("Min temp " + weatherHttpClient.getMinTempOfDay());
                       System.out.println("Avg " + weatherHttpClient.getTempOfDay());
                       System.out.println("Precipitation " + weatherHttpClient.getPrecipitation());




   }




}