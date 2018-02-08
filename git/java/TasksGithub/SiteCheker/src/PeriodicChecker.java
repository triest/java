import Excaption.HuUnknownHostWxception;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by triest on 17.04.2017.
 */
public class PeriodicChecker extends Thread {
    static Http1 http1;
    static File file;
    public String[] SiteList;
    static Mail mail;
    public void setSiteList(String[] siteList) {
        SiteList = siteList;
    }

    public PeriodicChecker() throws IOException {
   //    file=new File("E://Dropbox//Java//TasksGithub//SiteCheker//src//SiteHistory.txt");
        file=new File();

    }

    public String[] getSiteList() {
        return SiteList;
    }

    @Override
    public void run()
    {

        while(true) {
            System.out.println("Thread is doing something");
            try {
            //    for(int i=0;i<SiteList.length;i++) {
                for (String site:this.SiteList){
                  //  String site = SiteList[i];
                    int tempResponse = 0;
                    try {
                        tempResponse = http1.getHTTPResponseStatusCode(site);
                    } catch (HuUnknownHostWxception huUnknownHostWxception) {
                        huUnknownHostWxception.printStackTrace();
                    }

                    System.out.println(tempResponse);
                    //тут ндо добавить текущее время и затем записать в файл
                    // строка, которую будем записывать
                    Date curTime = new Date();
                    DateFormat dtfrm = DateFormat.getDateInstance();
                    String dateTime = dtfrm.format(curTime);
                    Date date = new Date(System.currentTimeMillis());
                    Date data1=  new Date();
                    SimpleDateFormat format1=new SimpleDateFormat("dd.MM.yyyy hh:mm");
               //     String toWriteToFile = site + ":date:" + date.getYear() + " " + " " + date.getHours() + ":" + date.getMinutes() + ":Response:" + tempResponse;
                    String toWriteToFile=format1.format(data1)+" "+site+" "+":Resource:"+tempResponse;
                    System.out.println(toWriteToFile);
                    file.writeToFile(toWriteToFile);
                    // ассоциаивный массив, шдре храниться количество неправильных ответов
                    if (tempResponse!=200){
                                               int count=file.map.get(site);
                                               count++;
                                               file.map.put(site,count);
                    }
                  int count=0;
                    if (file.map.get(site)!=null) {
                        count = file.map.get(site);
                        if (count > 20) {
                            String letter = site + "  " + date.getYear() + " " + " " + date.getHours() + ":" + date.getMinutes() + ":Response:" + tempResponse;
                            mail.SendMail4(site, tempResponse);
                            int count2 = file.map.get(site);
                            count2 = 0;
                            file.map.put(site, count2);
                        }
                        //тут будем отправлять
                    }
                }
            } catch (IOException e) {
                System.out.println("!!");
                e.printStackTrace();
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}