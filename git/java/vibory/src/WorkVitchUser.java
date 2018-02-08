import java.util.Scanner;

/**
 * Created by triest on 26.05.2017.
 */
public class WorkVitchUser {

    // создаем нового пользователя
    public void creatUser(VoitingSystem voitingSystem){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String name=in.nextLine();
        System.out.println("Введите имя логин");
        String login=in.nextLine();
        System.out.println("Введите пароль");
        String password=in.nextLine();
        voitingSystem.addUser(name,login,password);
    }


     //интерфейс работы пользователя
    public void UserEnter(){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя логин");
        String login=in.nextLine();
        System.out.println("Введите пароль");
        String password=in.nextLine();
    }

    public String[] devideNamePassword(String passwordname){
        String[] parts=passwordname.split("&");
        return parts;
    }


}
