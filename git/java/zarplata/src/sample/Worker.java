package sample;

/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 26/08/13
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class Worker extends Percon {
    int rate;

    public  Worker(){
        super.SetName();
        super.SetAge();
        SetRate();
    }



    public void SetRate(){
       System.out.println("Введите ставку:");
         age=sc.nextInt();
    }

    public int GetRate(){
        return rate;
    }

}
