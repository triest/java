import sun.plugin2.message.Message;

import javax.mail.Session;
import javax.mail.Store;
import java.io.IOException;

/**
 * Created by triest on 21.03.2017.
 */
public class Main {
    Session session = Session.getDefaultInstance(props, null);
    Store store = session.getStore(provider);
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
    }
catch (IOException e){
        e.printStackTrace();
}
