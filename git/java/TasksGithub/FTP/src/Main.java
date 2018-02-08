import java.io.IOException;

public class Main {

public static void main(String[] args) throws IOException {
   WhoIS whoIS=new WhoIS ();
   Console console=new Console ();
   while (true) {
       console.askHostname (whoIS);
       whoIS.answerWhoIS ();
       //   FileWriter writer=new FileWriter ("E:\\Dropbox\\WhoIs.txt",false);
       // whoIS.WriteToFile (writer,whoIS.getInfo ());
       whoIS.write ("E:\\Dropbox\\WhoIs.txt", whoIS.getInfo ());
   }
}


}
