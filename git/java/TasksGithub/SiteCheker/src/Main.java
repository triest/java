import Excaption.HuUnknownHostWxception;

import javax.mail.MessagingException;
import java.io.IOException;
/*
*

Site Checker with Time Scheduling – An application that attempts to connect to a website
 or server every so many minutes or a given time and check if it is up. If it is down, it
  will notify you by email or by posting a notice on screen.*/
public class Main {
    public static void main(String[] args) throws IOException, MessagingException {
        //  System.out.print(getHTTPResponseStatusCode("http://google.ru"));
        Http1 http1 = new Http1();
        //   http1.ReadResponseFromFile("src/inform.txt");
        http1.readLines("src/inform.txt");
        PeriodicChecker periodicChecker=new PeriodicChecker();
        File file=new File();
        file.readLines("src/sites.txt",periodicChecker);
        //   http1.readLines("src/inform.txt");
      //  http1.searchIndex("http://google.ru");
 //       System.out.print(http1.getHTTPResponseStatusCode("http://google.ru"));
   //     File file=new File();
        try {
            file.writeToFile(String.valueOf(http1.getHTTPResponseStatusCode("http://google.ru")));
        } catch (HuUnknownHostWxception huUnknownHostWxception) {
            huUnknownHostWxception.printStackTrace();
        }
        Thread t=periodicChecker;
        Mail mail=new Mail();
     //   mail.SendMail4();
        t.start();

    }
}