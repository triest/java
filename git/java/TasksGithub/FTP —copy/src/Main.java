import com.sun.deploy.net.HttpResponse;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import sun.net.www.http.HttpClient;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import java.io.*;

public class Main {
/*
    public static void main(String argv[]) throws IOException {

        Console console=new Console ();
        console.ascCommand ();

        try {
            System.out.println ();
            FTPClient client = new FTPClient ();
            String hostname="127.0.0.1";
       //   client.connect (hostname);
            //check connect to FTP
         //     boolean login1 = client.login ("user1", "7225");

            boolean answer=client.sendNoOp ();
            FTPfunction ftpfunction=new FTPfunction ();
       //     ftpfunction.connect (client,hostname,"user1","7225");
            boolean connectRezult=ftpfunction.connect (client,hostname,"user1","7225");

            if(connectRezult==true){
                  //   System.out.println("Remote system is " + client.getSystemName());
                  String[] ftpFile = client.listNames ();
                  //     System.out.println("file:  " + Arrays.asList(ftpFile));
                  System.out.println ();
                  client.changeWorkingDirectory ("RSE");
                  boolean rez = ftpfunction.downloadFile (client, "sw2.txt");
                  //конец скачки
                  boolean rez1 = ftpfunction.uploadFile (client, "E:/Dropbox/file111.txt");
              } else {
                  System.out.println ("Fals connect");
              }
              //закрываем соединение
              client.disconnect ();
          }
              catch (IOException e){
            e.printStackTrace();
            }

        }
*/

public static void main(String[] args) throws IOException {
    HttpClient client = new DefaultHttpClient();
    //args[0] ="http://hostname:port/xyz/zbc";
    HttpGet request1 = new HttpGet(args[0]);
    HttpResponse response1 = client.execute(request1);
    int code = response1.getStatusLine().getStatusCode();

    try(BufferedReader br = new BufferedReader(new InputStreamReader((response1.getEntity().getContent())));){
        // Read in all of the post results into a String.
        String output = "";
        Boolean keepGoing = true;
        while (keepGoing) {
            String currentLine = br.readLine();
            if (currentLine == null) {
                keepGoing = false;
            } else {
                output += currentLine;
            }
        }
        System.out.println("Response-->"+output);
    }

    catch(Exception e){
        System.out.println("Exception"+e);

    }
}




    public boolean connect(FTPClient ftpClient, String hostname, String username, String password) {
        try {
            ftpClient.connect(hostname);
            boolean login=ftpClient.login (username,password);
            boolean answer=ftpClient.sendNoOp ();
            if (login==true&&answer==true){
                return true;
            }
            else {return false;}

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    //
public static boolean downloadFTPDir(String localDir, FTPClient ftpClient) {
        OutputStream output = null;
        try {

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        /*
         * Use passive mode as default because most of us are behind
         * firewalls these days.
         */
            ftpClient.enterLocalPassiveMode();

            FTPFile[] fileList = ftpClient.listFiles();

            for (FTPFile ftpFile : fileList) {
                if(ftpFile.isDirectory()){
                    String tempDir = localDir + File.separatorChar+ftpFile.getName();
                    try {
                        File temp = new File(tempDir);
                        temp.mkdirs();
                    } catch (Exception e) {
                        System.out.println("Could not create local directory "+tempDir);
                        return false;
                    }
                    if(ftpClient.changeWorkingDirectory(ftpFile.getName())) {
                        downloadFTPDir(tempDir, ftpClient);
                    } else {
                        System.out.println("Could change directory to "+ftpFile.getName()+" on FTP server");
                        return false;
                    }

                } else {
                    output = new FileOutputStream(localDir + File.separatorChar + ftpFile.getName());
                    if (!ftpClient.retrieveFile(ftpFile.getName(), output)) {
                        System.out.println("Unable to download file from FTP server : " + ftpFile.getName());
                        File tmp = null;
                        try {
                            output.close();
                        /*tmp = new File(localDir + File.separatorChar + ftpFile.getName());
                        tmp.delete();
                        logger.info("Deleted corrupt downloaded file : " + tmp.getAbsolutePath());*/
                        } catch (FTPConnectionClosedException e) {
                            System.out.println("Connection to FTP server  is closed ");
                            return false;
                        } catch (Exception e1) {
                            System.out.println("Unable to delete corrupt file from local directory : " + tmp.getAbsolutePath());
                            return false;
                        }
                    }
                    output.close();
                    System.out.println("FTP file download successful : " + ftpFile.getName());
                }

            }

        } catch (FTPConnectionClosedException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            try {
                output.close();
            } catch (Exception e4) {
                e3.printStackTrace();
            }
            return false;
        } finally{
            try {
                if(output!=null)
                    output.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return true;
    }

/*

public static boolean downloadFile( FTPClient ftpClient,String Filename) {

        OutputStream output = null;
        try {
            //***********
             String remoteFile1 = Filename;
             File downloadFile1=new File("E:/Dropbox/"+remoteFile1);
             OutputStream outputStream1 = new BufferedOutputStream (new FileOutputStream (downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            System.out.println(success);
            outputStream1.close();
            if (success == true) {
                System.out.println ("Download success!");
                return true;
            }
            else System.out.println("False");

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

public static boolean uploadFile(FTPClient ftpClient,String patchname) {

        OutputStream output = null;
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //тут попробуем залить
            // client.enterLocalActiveMode();
            System.out.println();
            System.out.println("Start upload");
            //       client.setFileType(FTP.BINARY_FILE_TYPE);
            File file = new File (patchname);
       //     String patch="E:/Dropbox/HQ2.txt";
            String testName = file.getName();

            if ((!file.exists()) || (!file.canRead())){
                System.err.println("File Not Found or Unreadable: " + file.getName());
            }
            FileInputStream fis = new FileInputStream(file);
            boolean result = ftpClient.storeFile(testName, fis);

            System.out.println(file.getPath());
            if (result == true) {
                System.out.println("File was upload");
                return result;
            } else {
                System.out.println("FAIL upload");
                return result;
            }
            // конец заливки.

        /*
         * Use passive mode as default because most of us are behind
         * firewalls these days.

        return true;

    }catch (IOException e){
        e.printStackTrace();
    }
return false;
}
*/

}
