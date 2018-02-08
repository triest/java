/**
 * Created by triest on 25.03.2017.
 */
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by triest on 25.03.2017.
 */
public class WeatherHttpClient {

    public Float getTempOfDay() {
        return TempOfDay;
    }

    public Float getMaxTempOfDay() {
        return maxTempOfDay;
    }

    public void setMaxTempOfDay(Float maxTempOfDay) {
        this.maxTempOfDay = maxTempOfDay;
    }

    public Float getMinTempOfDay() {
        return minTempOfDay;

    }

    public void setMinTempOfDay(Float minTempOfDay) {
        this.minTempOfDay = minTempOfDay;
    }

    public void setTempOfDay(Float tempOfDay) {
        TempOfDay = tempOfDay;
    }

    Float TempOfDay;
    Float minTempOfDay;
    Float maxTempOfDay;
    String Precipitation;
    String[] DataArray;

    public String getPrecipitation() {
        return Precipitation;
    }

    public void setPrecipitation(String precipitation) {
        Precipitation = precipitation;
    }

    //
    //json API request
    private static String BASE_URL = "http://samples.openweathermap.org/data/2.5/weather?q=Petrozavodsk&appid=b1b15e88fa797225412429c1c50c122a1";
    private static String IMG_URL = "http://openweathermap.org/img/w/";

    public String getWeatherData(String location) {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            //    con = (HttpURLConnection) ( new URL(BASE_URL/* + location*/)).openConnection();
            con = (HttpURLConnection) (new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=" + location + "&appid=3ac1f68b653ffbf72a5f782420062771")).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line + "rn");

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }

    public String[] getDataArray() {
        return DataArray;
    }

    public void setDataArray(String[] dataArray) {
        DataArray = dataArray;
    }

    public byte[] getImage(String code) {
        HttpURLConnection con = null;

        InputStream is = null;
        try {
            con = (HttpURLConnection) (new URL(IMG_URL + code)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while (is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }

//тут будем обрезать ненужное
    public void CutDataFromArray(String[] dataArray){
        String tempString=DataArray[10];
      //  System.out.println(tempString);
        String result = tempString.replaceAll("[^0-9.]", "");
        setTempOfDay(Float.valueOf(result));
        tempString=DataArray[11];
        setMinTempOfDay(Float.valueOf(tempString.replaceAll("[^0-9.]", "")));
        tempString=DataArray[12];
        setMaxTempOfDay(Float.valueOf(tempString.replaceAll("[^0-9.]","")));
        tempString=DataArray[20]; //тут у нас "description:"
        tempString=tempString.replaceAll("\"description\":\"","");
         tempString=tempString.replaceAll("\"","");
        this.setPrecipitation(tempString);

            System.out.println(getPrecipitation());
    }


    public void ShovAll(){
     //   String[] arr=res.split(",");
        //    System.out.print(Arrays.asList(arr));

        //this.CutDataFromArray(arr);
        System.out.println("Max temp "+this.getMaxTempOfDay());
        System.out.println("Min temp "+this.getMinTempOfDay());
        System.out.println("Avg "+this.getTempOfDay());
        System.out.println("Precipitation "+this.getPrecipitation());
    }
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */


}