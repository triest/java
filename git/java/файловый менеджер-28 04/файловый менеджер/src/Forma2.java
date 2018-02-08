import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by triest on 20.05.2017.
 */
public class Forma2 extends JFrame
{
    //переменныя с списком файлов
    JList filelist;
  Forma2 forma2;

    public Forma2(String aNew, String s) {
    }

    // создаем фрейм
    public void start() {
        JFrame frame = new JFrame();
        //устанавливаем размер
        frame.setSize(400,400);
        frame.setVisible(true);
    }

    //процедура отрисовки окна с файлами
    public void ShowFile(DAO dao){

        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < 25; i++) {
            listModel.addElement("Элемент списка " + i);
        }

        //create the list
       filelist = new JList<>(listModel);
        add(filelist);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //******************

        //тут кнопка
        //*************
        JButton button=new JButton("Select");
        // добавляем слушателя
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //тут размер
        button.setSize(100,50);
        forma2=new Forma2("new",dao.ls2().toString());
        //добавляем кнопку
        this.add(button);
        //*********

    }
}
