/**
 * Created by triest on 12.03.2017.
 */
/*
Mail Checker (POP3 / IMAP) – The user enters various account information include web server and IP,
 protocol type (POP3 or IMAP) and the application will check for email on several accounts at a given interval.*/

import java.util.Properties;

//POP3

public class Main {


    public static void main(String[] args) throws Exception {
        Properties props = new Properties();



        Mail mail=new Mail();
        Commands commands=new Commands();
        //   Folder inbox = store.getFolder("INBOX");
            mail.setPosition("folder");
            mail.setFolder("INBOX");
        //  inbox = store.getFolder("INBOX");
   //     mail.GetMessage(host,username,password,store,"INBOX");
   //    mail.displayInboxMessages();
    //    mail.ShowOpenFolder(host,username,password,store,"INBPX");
   //!!     mail.ShowOpenFolder(mail.getHost(),mail.getUsername(),mail.getPassword(),mail.getStore(),"INBOX");
     //   mail.displayMessage(host, username,password,store,"INBOX",1);

        Dialog dialog=new Dialog();
        while (true){
            dialog.CheckPosition(mail,commands);
        }
            /*
            try {
                store.connect(host, username, password);
                Folder inbox = store.getFolder("INBOX");
                if (inbox == null) {
                    System.out.println("No INBOX");
                    System.exit(1);
                }
                inbox.open(Folder.READ_ONLY);
                Message[] messages = inbox.getMessages();
                for (int i = 0; i < messages.length; i++) {
                    System.out.println("Message " + (i + 1));
                    messages[i].writeTo(System.out);
                }
                inbox.close(false);
                store.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

    }
}


