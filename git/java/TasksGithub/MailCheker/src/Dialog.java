import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by triest on 22.03.2017.
 */
public class Dialog {
    //показывает меню дирректории
    public void ShowFolderMenu(Commands commands,Mail mail) throws IOException, MessagingException {
        System.out.println("1.RerfeshFolder");
        System.out.println("2.Open litter");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        //  String[] s=new String[10];
       String[] s = s1.split (" ");
        //    System.out.println (Arrays.toString (s));
        // заносим комманду в in
        commands.applyCommand (s,mail,this);
    }

    //показывает меню письма
    public void ShowLetterMenu(Commands commands,Mail mail){
        System.out.println("1.Close letter");
        System.out.println("2.Retry on letter");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        //  String[] s=new String[10];
        String[] s = s1.split (" ");
        //    System.out.println (Arrays.toString (s));
        // заносим комманду в in
        try {
            commands.applyCommand (s,mail,this);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //проверяет где находяться, и выводит соотвествующие команжы и содержимое дирректории
    public void CheckPosition(Mail mail,Commands commands) throws IOException, MessagingException {
        System.out.println("Check position is run "+mail.getPosition());
        System.out.println("Check folder "+mail.getFolder());
        if(mail.getPosition().equals("folder")){
            ShowFolderMenu(commands,mail);
        }
        if(mail.getPosition().equals("letter")){
            ShowLetterMenu(commands,mail);
        }
    }

   // спрашиваем номер письма
    public int AskLetterNumber(){
        System.out.println("Enter letter number:");
        final Scanner in=new Scanner(System.in);
        int num1 = in.nextInt();
               return num1-1;

    }

}
