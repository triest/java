import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


/*
Get Atomic Time from Internet Clock – This program will get the true atomic time from an atomic time clock on the Internet.
 There are various clocks across the world. Do a search for a list of them.
*/
public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

      //  System.out.println("\nTesting 2 - Send Http POST request");
     //  http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://nist.time.gov/actualtime.cgi?lzbc=siqm9b";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // response- время в миллисикундах с 01.01.1970
         String newstring=response.toString();
        //обрезаем строку
        String newstring1=newstring.substring(17, 33);
             System.out.println("S: "+newstring1);
             Long long1;
             long1=Long.valueOf(newstring1);
             System.out.println(long1);
        Date date=new Date(long1);
       System.out.println("Date: "+new Date(long1/1000));
    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "http://www.google.com/";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String newstring=response.toString();
       String newstring1=newstring.substring(15, 33);
       System.out.println("S: "+newstring1);
        //print result
        System.out.println(response.toString());

    }

}