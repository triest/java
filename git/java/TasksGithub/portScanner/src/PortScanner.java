import java.util.Scanner;

/**
 * Created by triest on 11.03.2017.
 */
public class PortScanner {
    String Ip;
    int minPort;
    int maxPort;

    public  void setIp(String ip) {
        Ip = ip;
    }

    public String getIp() {
        return Ip;
    }

    public Integer getMinPort() {
        return minPort;
    }

    public void setMinPort(Integer minPort) {
        this.minPort = minPort;
    }

    public Integer getMaxPort() {
        return maxPort;
    }

    public void setMaxPort(Integer maxPort) {
        this.maxPort = maxPort;
    }

    private static void postScan(String IP, int minPort, int MaxPort){
    }

    public void askIP(){
        System.out.println("Input IP");
        Scanner in=new Scanner(System.in);
        String ip= String.valueOf(in.next());
       setIp(ip);
    }

    public void askMinPort(){
        System.out.println("Input MinPort");
        Scanner in=new Scanner(System.in);
        Integer ip=in.nextInt();
               setMinPort(ip);
    }


    public void askMaxPort(){
        System.out.println("Input ManPort");
        Scanner in=new Scanner(System.in);
        Integer ip=in.nextInt();
        setMaxPort(ip);
    }
}
