package sample;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 23/08/13
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
public class MyWindowApp extends JFrame{

    public MyWindowApp(){
        super("My First Window"); //Заголовок окна
        setBounds(100, 100, 200, 200); //Если не выставить размер и положение - то окно будет мелкое и незаметное

    }


    public static void main(String [] args)
    {
        JFrame f = new MyWindowApp();
        f.setBounds(100, 100, 400, 300);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }
}
