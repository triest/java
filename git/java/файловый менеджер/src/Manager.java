import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by triest on 23.04.2017.
 */
/*
1.1.2.	Manager. Написать класс, который будет содержать бизнес-логику вашего приложения (производить различные проверки, перед тем как совершать операции с объектами).*/
public class Manager {

    // функция, которая проверият существование файла (пути), корректность команды, и затем вызывает соответствующию функцию из DAO
    // тут команды с аргументами

   public void CommandCheker(String command,String parametr) {
        DAO dao=new DAO();
        if (command.equals("cd")) {
            System.out.println("Command: "+command);
            System.out.println("Parametr "+parametr);
            dao.changeDir(parametr);
        } else {
            if (command.equals("ls")) {
                dao.ls();
            } else {
                if (command.equals("remove")) {
                    try {
                        dao.deleteFile(parametr);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (command.equals("touch")) {
                        try {
                            dao.creatFile(parametr);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (command.equals("find")) {
                            dao.findFile(parametr);
                        }
                        else {
                            if (command.equals("append")) {
                                dao.appendToFile();
                            }
                            else {
                                System.out.println("Command not found");
                            }
                        }
                    }
                }
            }
        }
    }



    //тут комманды без аргументов

    public void  CommandCheker(String command) throws IOException {
        DAO dao=new DAO();
        if (command.equals("ls")) {
            dao.ls();
        }
        if (command.equals("cd")){
            dao.changeDir2();
        }
        if(command.equals("del")){
            dao.deleteFile();
        }
        if(command.equals("touch")){
            dao.creatFile();
        }
        if(command.equals("find")){
            dao.findFile();
        }
        if(command.equals("append")){
            dao.appendToFile();
        }
    }

    public String AskStringParametr(String value){
        System.out.println("Input "+value+":");
        final Scanner in = new Scanner (System.in);
        String s1 = in.nextLine ();
        return s1;
    }
/*
    public void SplitCommand(String commandString){
        String[] command=commandString.split(" ");
        if (command.length==1){
            try {
                this.CommandCheker(commandString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                this.CommandCheker(commandString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/
}
