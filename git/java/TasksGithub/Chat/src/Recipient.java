/**
 * Created by triest on 30.03.2017.
 */

class Recipient{


/*
    static SomeThing someThing;
    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket ds = new DatagramSocket(1050);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
            }
        }
        catch(Exception e){
            System.out.println(e);

        }
    }*/

    static SomeThing someThing;
    public static void main(String[] args) {
        someThing=new SomeThing();
        someThing.start();
        Sender sndr = new Sender("localhost", 1052);
        String[] st = {"d", "ds"};
        while (true){
            sndr.askMessage();}
    }
}