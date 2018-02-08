import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by triest on 11.03.2017.
 */
public class FileCommander {

    public static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath()));
                write(new FileInputStream(f), out);
            }
        }
    }

    private static final int BUFFER_SIZE = 1024;
    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
/*
    public static void FileCopy(String[] directyries, String patchTempDir){
            for (int i=0;i<directyries.length;i++){
                try {
                //    Files.copy(directyries[i],patchTempDir, REPLACE_EXISTING);
                    Files.copy(directyries[i], patchTempDir.);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
    }*/



    public static boolean copyFile(final String src, final String dst) {
        System.out.println("Копируем файл: " + src);
        final File srcFile = new File(src);
        final File dstFile = new File(dst);
        if (srcFile.exists() && srcFile.isFile() && !dstFile.exists()) {
            try (InputStream in = new FileInputStream(srcFile);
                 OutputStream out = new FileOutputStream(dstFile)) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytes;
                while ((bytes = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytes);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName())
                        .log(Level.SEVERE, null, ex);
                return false;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName())
                        .log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void copyDirectory(File sourceLocation , File targetLocation)
            throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    //эта функция будет перебипать директории из массивав, и вызывать функцию копирования
    public static void BustDirectory(File[] directories,File targetLocation) throws IOException {
        for (int i=0;i<directories.length;i++) {
            copyDirectory(directories[i],targetLocation);
        }
/*
      for (int i:directories){
          copyDirectory(directories[i],targetLocation);
      }*/
    }


    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { //some JVMs return null for empty dirs
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

}