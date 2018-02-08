package sample;

/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 26/08/13
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
public class Student extends Percon {
    public int bal;
    int Stipend;
      int baz=500;
    public  Student(){

        SetBal();
    }

   public void SetBal(){
       boolean correct=true;
       do {
           System.out.println("Введите средний бал:");
           bal=sc.nextInt();
           if (sc.hasNextInt()&& bal>0 && bal<=5){correct=true;}
           else{System.out.println("Введено некоректное число");
               correct=false;
           }
       }while (correct==false);
   }
    public int GetBal(){
        return bal;
    }

    public void SetStipend(){
        if (bal>=4){Stipend=bal*baz;}
         else{};

    }

    public int GetRate(){

        return Stipend;
    }



}
