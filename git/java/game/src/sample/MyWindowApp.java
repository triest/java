package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: triest
 * Date: 20/08/13
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */


    public class MyWindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

        public MyWindowApp(){
            super("My First Window"); //Заголовок окна
            setBounds(100, 100, 200, 200); //Если не выставить размер и положение - то окно будет мелкое и незаметное
        }

        public static void main2() { //эта функция может быть и в другом классе
            MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
            app.setVisible(true); //С этого момента приложение запущено!
        }

}
