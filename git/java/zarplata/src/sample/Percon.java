package sample;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 26/08/13
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */

public class Percon {
    Scanner sc = new Scanner(System.in);

    public String name;
    public int age;
    public boolean correct;


    //констуктор
    public void Percon(){
        SetName();
        SetAge();
    }


   public void GetName(){
        System.out.println("Name:"+name);
    }
    public void SetName(){
      System.out.println("Введите имя:");
       name=sc.next();
    }

    public void SetAge(){
        boolean correct=true;

        System.out.println("Введите возраст:");
        age=sc.nextInt();
    }

    public void GetAge(){
       System.out.println("Возраст: "+age);
    }


}
