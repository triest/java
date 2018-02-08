import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;
/**
 * Created by triest on 11.03.2017.
 */
/*
*Create Zip File Maker – The user enters various files from different directories and maybe even another computer on
* the network and the program transfers them and zips them up into a zip file. For added complexity, apply actual
* compression to the files.*/

public class Main {
     public static void main(String[] args) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("E:/Dropbox/new/archive.zip"));
      //  File[] files=new File[10];
       File patch=new File("E:/Dropbox/new");
        File file2=new File("E:/Dropbox/new/direct1/");
        File file3=new File("E:/Dropbox/new/direct2/");
       File tempDir = new File("E:/Dropbox/new/temp/");
        File[] directories= new File[2];
        directories[0]=file2;
        directories[1]=file3;
       FileCommander fileCommander=new FileCommander();
        fileCommander.BustDirectory(directories,tempDir);
        //копируем директорию
        fileCommander.copyDirectory(file2,tempDir);
       // создаем временную директорию, кула будем копировать файлы
       File temp=new File(patch+"/temp");
       //создаем архив
        fileCommander.doZip(temp, out);
        out.close();
        //удаляем временную папку
       fileCommander.deleteFolder(tempDir);
    }




}