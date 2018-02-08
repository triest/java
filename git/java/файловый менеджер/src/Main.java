import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by triest on 22.04.2017.
 */
/*
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("ds");
        File[] roots = File.listRoots();
        System.out.println(Arrays.asList(roots));

        String dirPath = "E:\\";
        File file = new File(dirPath);
        //      File[] files = file.listFiles();
        //   System.out.println( Arrays.asList(files));
        //   dirPath="E:\\Документы";
        DAO dao = new DAO();
        System.out.println("Current "+dao.getCurrentDir());
        dao.setCurrentDir("E:"+File.separator);
        System.out.println(dao.getCurrentDir());
        dao.setCurrentDir("E:"+File.separator+"Download");
        System.out.println(dao.getCurrentDir());
        //   System.out.println( Arrays.asList(files));
        //  file=new File(dirPath);
        //  files=file.listFiles();
   //   dao.changeDir();
//       dao.ls();
 //      dao.changeDir();
  //     dao.ls();
        Console1 console = new Console1();
  //      dao.changeDir();
   //     dao.creatFile("winpost.txt");
   //  dao.appendToFile("winpost.txt");

        System.out.println("Тут ручной ввод!!!!!!!!!!!!");
        while (true) {
            console.ascCommand(dao);
        }
        //  dao.deleteFile("winpost.txt");
    /*    try {
            dao.creatFile("winpost.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   dao.findFile("winpost.txt");
        }
    }
*/

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.print("ds");
        // будем сохранять вывод в консоль
       // PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
     //   System.setOut(out);
        File[] roots = File.listRoots();
        System.out.println(Arrays.asList(roots));

        String dirPath = "E:\\";
        File file = new File(dirPath);
        //      File[] files = file.listFiles();
        //   System.out.println( Arrays.asList(files));
        //   dirPath="E:\\Документы";
        DAO dao = new DAO();
        dao.setCurrentDir("E:\\");
        JPanel jPanel=new JPanel();
        Forma forma=new Forma(jPanel,dao);
        forma.Button();
        forma.Visuble();

        //   System.out.println( Arrays.asList(files));
        //  file=new File(dirPath);
        //  files=file.listFiles();
      // final Scanner in=new Scanner(System.in);
     //  String temp=in.nextLine();
    //   dao.changeDir(temp);
       dao.changeDir("\\Документы");
        dao.ls();
             dao.changeDir("\\Фильмы");
               dao.ls();

        dao.creatFile("winpost11.txt");
           dao.changeDir("..");
           dao.ls();

     //   dao.deleteFile("winpost.txt");
    dao.creatFile("winpost111.txt");
  //    dao.appendToFile("winpost1.txt");
   //   dao.deleteFile("winpost1.txt");
    Manager manager=new Manager();
        Console1 console = new Console1();
        dao.changeDir("..");
 /*     while (true){
   //    console.ascCommand(manager);
        dao.changeDir2();
      }*/

        //   dao.appendToFile("winpost.txt");
      /*  while (true) {
            console.ascCommand(dao);
        }*/
        //  dao.deleteFile("winpost.txt");
    /*    try {
            dao.creatFile("winpost.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
      */
        //   dao.findFile("winpost.txt");
    }
}
