import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by triest on 22.04.2017.
 */
public class DAO {
    String currentDir;
    Manager manager;

    public String getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(String currentDir) {
        this.currentDir = currentDir;
    }


    public String[] namesFiles; //тут будут имена файлов
    //текущая дирректория


    public String[] getNamesFiles() {
        return namesFiles;
    }

    public void setNamesFiles(String[] namesFiles) {
        this.namesFiles = namesFiles;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public DAO() {
        this.setCurrentDir("E:"+File.separator);
        manager=new Manager();
    }

    // просмотр дирректории
    public void ls(){
        File file = new File(this.getCurrentDir());
        System.out.println("CurrentDir"+this.getCurrentDir());
        File[] files = file.listFiles();
        if (files!=null) {
            System.out.println(Arrays.asList(files));
        }
    }


    public String[] ls2(){
        File file = new File(this.getCurrentDir());
        System.out.println("CurrentDir"+this.getCurrentDir());
        File[] files = file.listFiles();
        if (files!=null) {
            //в окне не надо
        //    System.out.println(Arrays.asList(files));
        }
        // тут будем преобразовывать в строковое представление
        String[] tempArray = new String[files.length];


        for(int i=0;i<files.length;++i){
            tempArray[i]=files[i].getName();
        }

        namesFiles=Arrays.copyOf(tempArray,tempArray.length);
        return namesFiles;
    }


    //смена каталога
    //не работает
    public void changeDir(String dirname) {
        System.out.println("Dirname "+dirname);
        if (dirname.equals("..")) {
            //тут будет переход на строку выше
            String filename = this.getCurrentDir();
            System.out.println(filename);
            //надо отсечь символы после последнего \\
            String sCurrentUser = filename;
            int index = filename.lastIndexOf("\\");
            System.out.println(index);
            sCurrentUser = sCurrentUser.substring(0, index + 1);
            System.out.println(sCurrentUser);
            this.setCurrentDir(sCurrentUser);
            this.getCurrentDir();
        } else {
            System.out.println("else run");
      //     dirname="\\"+dirname;
            String s=this.getCurrentDir() + File.separator+dirname;
            System.out.println("s: "+s);
           currentDir=s;
           System.out.println( this.getCurrentDir());
        }
    }

  //не работает

    public void changeDir2() {
    //  String parametr=manager.AskStringParametr(" dir parametr");
        System.out.println("input parametr ls");
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        changeDir(s1);
    }

    //удаление файла
    public  void deleteFile(String nameFile) throws FileNotFoundException {
        String patch=this.getCurrentDir()+"\\"+nameFile;
        System.out.println(patch);
        File file = new File(patch);
        file.delete();
    }

    //удаление файла
    public  void deleteFile() throws FileNotFoundException {
        String nameFile=manager.AskStringParametr("Name file to delete");
        String patch=this.getCurrentDir()+"\\"+nameFile;
        System.out.println(patch);
        File file = new File(patch);
        file.delete();
    }

    //создание файла
    public void creatFile(String nameFile) throws IOException {
        String patch=this.getCurrentDir()+"\\"+nameFile;
        File f = new File(patch);

        f.getParentFile().mkdirs();
        f.createNewFile();
    }

    public void creatFile() throws IOException {
        String nameFile=manager.AskStringParametr("Name file to creat");
        String patch=this.getCurrentDir()+"\\"+nameFile;
        File f = new File(patch);

        f.getParentFile().mkdirs();
        f.createNewFile();
    }

    //поиск файла
    static void func(String path, String find) {
        File f = new File(path);
        boolean flag = false;
        String[] list = f.list();     //список файлов в текущей папке
        for (String file : list) {      //проверка на совпадение
            if (find.equals(file)) {
                flag=true;
                System.out.println(path + "\\" + file + " !!!!!!!!!!!!!!!!!!");  //если найден, то выход
                return;
            }
            if (!path.endsWith("\\")) {
                path += "\\";
            }
            File tempfile = new File(path + file);
            System.out.println(path + file);
            if (!file.equals(".") && !file.equals("..")) {        //!!!
                if (tempfile.isDirectory()) {      //иначе проверяем, если это папка
                    //path += file;
                    func(path + file, find);               //то рекурсивный вызов этой функции
                    if(flag) return;
                }
            }
        }
    }

    public void findFile(String name) {

        String fileName = name;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
               if (Desktop.isDesktopSupported()) {
                    try {
                       Desktop.getDesktop().edit(file);
                        System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                  System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");
    }

    public void findFile() {

        String fileName = manager.AskStringParametr("Input file to search:");
        String name=fileName;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
            /*   if (Desktop.isDesktopSupported()) {
                    try {
                       Desktop.getDesktop().edit(file);
                        System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }*/
/*
                System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");
    }

    public void appendToFile(String name) {

        String fileName = name;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
               if (Desktop.isDesktopSupported()) {
                    try {
                       Desktop.getDesktop().edit(file);
      //                  System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            //    System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");
    }

    public void appendToFile() {

        String name = manager.AskStringParametr("Input name file to append");
        String fileName=name;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().edit(file);
                        //                  System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                //    System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");
    }

//}

    String currentDir;
    public String getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(String currentDir) {
        this.currentDir = currentDir;
    }

    //текущая дирректория


    public DAO() {
        this.setCurrentDir("E:\\");
    }

    // просмотр дирректории
    public void ls(){
        File file = new File(this.getCurrentDir());
        System.out.println(this.getCurrentDir());
        File[] files = file.listFiles();
        System.out.println(Arrays.asList(files));
    }

    //смена каталога
    public void changeDir(String dirname) {
        if (dirname.equals("..")) {
            //тут будет переход на строку выше
            String filename = this.getCurrentDir();
            System.out.println(filename);
            //надо отсечь символы после последнего \\
            String sCurrentUser = filename;
            int index = filename.lastIndexOf("\\");
            System.out.println(index);
            sCurrentUser = sCurrentUser.substring(0, index + 1);
            System.out.println(sCurrentUser);
            setCurrentDir(sCurrentUser);
        } else {
            setCurrentDir(getCurrentDir() + "\\" + dirname);
        }
    }


    //удаление файла
    public  void deleteFile(String nameFile) throws FileNotFoundException {
        String patch=this.getCurrentDir()+"\\"+nameFile;
        System.out.println(patch);
        File file = new File(patch);
        file.delete();
    }

    //создание файла
    public void creatFile(String nameFile) throws IOException {
        String patch=this.getCurrentDir()+"\\"+nameFile;
        File f = new File(patch);

        f.getParentFile().mkdirs();
        f.createNewFile();
    }

    //поиск файла


    static void func(String path, String find) {
        File f = new File(path);
        boolean flag = false;
        String[] list = f.list();     //список файлов в текущей папке
        for (String file : list) {      //проверка на совпадение
            if (find.equals(file)) {
                flag=true;
                System.out.println(path + "\\" + file + " !!!!!!!!!!!!!!!!!!");  //если найден, то выход
                return;
            }
            if (!path.endsWith("\\")) {
                path += "\\";
            }
            File tempfile = new File(path + file);
            System.out.println(path + file);
            if (!file.equals(".") && !file.equals("..")) {        //!!!
                if (tempfile.isDirectory()) {      //иначе проверяем, если это папка
                    //path += file;
                    func(path + file, find);               //то рекурсивный вызов этой функции
                    if(flag) return;
                }
            }
        }
    }

    public void findFile(String name) {

        String fileName = name;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
            /*   if (Desktop.isDesktopSupported()) {
                    try {
                       Desktop.getDesktop().edit(file);
                        System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }*/

                System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");

    }

    public void appendToFile() {
        String name=manager.AskStringParametr("Input filenamr");
        String fileName = name;
        String path = this.getCurrentDir();
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            name = file.getName();
            if (name.equals(fileName)) {
                System.out.println(name);
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().edit(file);
                        //                  System.out.println("File "+fileName+" found in this directory");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                //    System.out.println("File "+fileName+" found in this directory");
                return;
            }
        }
        System.out.println(fileName + " not found in " + path + " directory");

    }
}

