package com.company;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by triest on 06.03.2017.
 */
public class Console {
    String[] s=new String[10];


    //функция запроса комманды
    public void ascCommand(){
        System.out.println ("Input command:");

        final Scanner in = new Scanner(System.in);
        String s1=in.nextLine ();
        //  String[] s=new String[10];
        s=s1.split(" ");
        System.out.println (Arrays.toString (s));
        // заносим комманду в in
    }

}
