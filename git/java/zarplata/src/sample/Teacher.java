package sample;

/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 26/08/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class Teacher extends Worker {
    public int hour;
    public int hourRate;

    public  Teacher(){



        SetHourRate();
        SetHour();
    }


    public void SetHourRate(){

            System.out.println("Введите часовую ставку:");
            hourRate=sc.nextInt();



    }

    public void SetHour(){

            System.out.println("Введите число часов");
            hour=sc.nextInt();


    }

    public int GetHour(){
        return hour;
    }
    public int GetHourRate(){
        return hourRate;
    }
      public int GetRate(){
       return   super.GetRate()+hour*hourRate;
      }

    }


