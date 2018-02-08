import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by triest on 13.03.2017.
 */


public class Mail {

    String host = "pop3.rambler.ru";
    String username = "6ded6";
    String password = "T8CMF3z0bSkD";
    String provider = "pop3";
    String folder = "";

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //показывает, где позиция
    String position;

    Properties props = new Properties();
    //   String provider = "pop3";
    Session session = Session.getDefaultInstance(props, null);
    Store store = session.getStore(provider);
    //  String host;
    // String username ;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    // String password;
    //  String provider;
    javax.mail.Message[] InboxMessages1;

    public Mail() throws NoSuchProviderException {
    }
/*
    public void setInboxMessages(Message[] inboxMessages) {
        this.InboxMessages1 = javax.mail.Folder.inboxMessages;
    }
*/

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }


    //получаем письма, и записываем в массив
    public void GetMessage(String host, String username, String password, Store store, String folder) throws MessagingException, IOException {
        this.setPosition("folder");
        store.connect(host, username, password);
        //   Folder inbox = store.getFolder("INBOX");
        Folder inbox = store.getFolder(folder);
        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1);
        }
        inbox.open(Folder.READ_ONLY);
        javax.mail.Message[] messages = inbox.getMessages();
        InboxMessages1 = inbox.getMessages();

        for (int i = 0; i < messages.length; i++) {
            //     System.out.println("Message " + (i + 1));
            messages[i].writeTo(System.out);
            System.out.println(messages[i].getSubject());

            System.out.println(messages[i].getFolder());
            System.out.println(messages[i].getContent());
            System.out.println(messages[i].getSubject());
        }
        inbox.close(false);
        store.close();
    }

    public void ShowOpenFolder(String host, String username, String password, Store store, String folder) throws MessagingException, IOException {
        this.setFolder(folder);
        this.setPosition("folder");
        store.connect(host, username, password);
        Folder inbox = store.getFolder(folder);
        if (inbox == null) {
            System.out.println("No" + folder);
            System.exit(1);
        }
        System.out.println("inbox " + inbox); // тут ошибка inbox pop3 (?)
        inbox.open(Folder.READ_ONLY);
        javax.mail.Message[] messages = inbox.getMessages();
        //    InboxMessages1=inbox.getMessages();
        System.out.println("Folder " + folder);
        for (int i = 0; i < messages.length; i++) {
            //     System.out.println("Message " + (i + 1));
            //    messages[i].writeTo(System.out);
            System.out.println("Show open folder is run");
            System.out.print(i + 1 + ".");
            System.out.print(" " + messages[i].getFrom().toString());

            System.out.println("From: " + Arrays.toString(messages[i].getFrom()));
            System.out.println("To: " + Arrays.toString(messages[i].getRecipients(javax.mail.Message.RecipientType.TO)));
            System.out.println("Team: " + messages[i].getSubject());
            System.out.println("Date" + messages[i].getSentDate());


            // System.out.println(messages[i].getContent());
            //    System.out.println(messages[i].getSubject());
        }
        inbox.close(false);
        store.close();
    }


    //показать все сообщения в входящих
    public void displayInboxMessages(String host, String username, String password, Store store, String folder, int i) throws IOException, MessagingException {
        preperaFolder(host, username, password, store, folder);
        this.setPosition("folder");
        store.connect(host, username, password);
        //   Folder inbox = store.getFolder("INBOX");
        Folder inbox = store.getFolder(folder);
        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1);
        }
        inbox.open(Folder.READ_ONLY);
        javax.mail.Message[] messages = inbox.getMessages();
        InboxMessages1 = inbox.getMessages();
        //     System.out.println("Message " + (i + 1));
        //    messages[i].writeTo(System.out);
        //    System.out.println(messages[i].getSubject());
        //     System.out.println(messages[t].getFolder());
        //    Address[] address=messages[i].getFrom();
        //     System.out.println("From :"+parseAddresses(messages[i].getRecipients(Message.RecipientType.TO)));
        //   System.out.println("Subject :"+messages[i].getSubject());
        //   System.out.println("Folder "+messages[i].getFolder());
        //  System.out.println("Content "+messages[i].getContent());
        //     System.out.println(messages[i].getContent());
        //   System.out.println(messages[t].getSubject());
        for (int t = 0; t < messages.length; t++) {
            System.out.println("From :" + parseAddresses(messages[t].getRecipients(javax.mail.Message.RecipientType.CC)));
            System.out.println("Subject :" + messages[t].getSubject());
            System.out.println("Date :" + messages[t].getReceivedDate());
        }

        inbox.close(false);
        store.close();
    }


    public void preperaFolder(String host, String username, String password, Store store, String folder) throws MessagingException, IOException {
        store.connect(host, username, password);
        //   this.setPosition("m");
        Folder inbox = store.getFolder(folder);
        if (inbox == null) {
            System.out.println("No" + folder);
            System.exit(1);
        }
        inbox.open(Folder.READ_ONLY);
        //Message[] messages = inbox.getMessages();
        javax.mail.Message[] messages = inbox.getMessages();

        //    InboxMessages1=inbox.getMessages();
        // System.out.println("Folder "+folder);
        for (int i = 0; i < messages.length; i++) {
            //     System.out.println("Message " + (i + 1));
            //    messages[i].writeTo(System.out);

            //System.out.println(" "+messages[i].getFrom().toString());
            //   System.out.println("To "+ Arrays.toString(messages[i].getRecipients(Message.RecipientType.CC)));
            //  System.out.println("To "+ Arrays.toString(messages[i].getRecipients(Message.RecipientType.BCC)));
            //     System.out.println("From: "+Arrays.toString(messages[i].getFrom()));
            //    System.out.println("To: "+ Arrays.toString(messages[i].getRecipients(Message.RecipientType.TO)));
            //   System.out.println("Team: "+messages[i].getSubject());
            //       System.out.println(" "+messages[i].getReceivedDate());

            // System.out.println(messages[i].getContent());
            //    System.out.println(messages[i].getSubject());
        }
        inbox.close(false);
        store.close();
    }

    public void displayMessage(String host, String username, String password, Store store, String folder, int i) throws IOException, MessagingException {


        this.setPosition("letter");
        preperaFolder(host, username, password, store, folder);

        store.connect(host, username, password);
        //   Folder inbox = store.getFolder("INBOX");
        Folder inbox = store.getFolder(folder);
        if (inbox == null) {
            System.out.println("No INBOX");
            System.exit(1);
        }
        inbox.open(Folder.READ_ONLY);
        javax.mail.Message[] messages = inbox.getMessages();

        //проверяем индекс
        if ((i - 1 > messages.length) || (i < 0)) {
            System.out.println("Wrong letter number");
            inbox.close(false);
            store.close();
            this.setPassword("folder");
            return;
        } else {
            InboxMessages1 = inbox.getMessages();
            //     System.out.println("Message " + (i + 1));
            //    messages[i].writeTo(System.out);
            //    System.out.println(messages[i].getSubject());
            //     System.out.println(messages[t].getFolder());
            //    Address[] address=messages[i].getFrom();
            System.out.println("From :" + parseAddresses(messages[i].getRecipients(javax.mail.Message.RecipientType.TO)));
            System.out.println("Subject :" + messages[i].getSubject());
            System.out.println("Folder " + messages[i].getFolder());
            System.out.println("Content " + messages[i].getContent());
            //     System.out.println(messages[i].getContent());
            //   System.out.println(messages[t].getSubject());

            inbox.close(false);
            store.close();
        }
    }


    private String parseAddresses(Address[] address) {
        String listOfAddress = "";
        if ((address == null) || (address.length < 1))
            return null;
        if (!(address[0] instanceof InternetAddress))
            return null;

        for (int i = 0; i < address.length; i++) {
            InternetAddress internetAddress =
                    (InternetAddress) address[0];
            listOfAddress += internetAddress.getAddress();
        }
        return listOfAddress;
    }

    public void sendMessage(String host, String username, String password, Store store, String folder) {
        try {
            store.connect(host, username, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("6ded6@rambler.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("triest21@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage2(){
        String to = "6ded6@rambler.ru";//change accordingly
        String from = "6ded6@rambler.ru";//change accordingly
        String host = "pop3.rambler.ru";//or IP address

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (MessagingException mex) {mex.printStackTrace();
        System.out.println("Error");}
    }

    public void sendMessage3() throws Exception{
        Properties props = new Properties();

        String host = "yourHost.edu";
        String username = "userName";
        String password = "mypassword";
        String provider = "pop3";

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore(provider);
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
    }
}



