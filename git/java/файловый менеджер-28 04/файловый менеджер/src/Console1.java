import java.io.IOException;
import java.util.Scanner;

/**
 * Created by triest on 05.03.2017.
 */

public class Console1 {
    String[] s = new String[10];
    Manager manager;


    //функция запроса комманды
    public void ascCommand(Manager manager,DAO dao) throws IOException {
        System.out.println ("Input command:");

        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        manager.CommandCheker(s1,dao);
      // manager.CommandCheker();
        //    System.out.println (Arrays.toString (s));
        // заносим комманду в in

    }

}

