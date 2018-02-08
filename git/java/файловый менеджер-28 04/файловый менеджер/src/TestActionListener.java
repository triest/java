import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by triest on 27.04.2017.
 */
public class TestActionListener implements ActionListener {
   DAO dao;

    public TestActionListener(DAO dao,Forma forma) {
        this.dao = dao;
    }

    public void actionPerformed(ActionEvent e) {
        //Код, который нужно выполнить при нажатии
        dao.getSelected();
        System.out.println("Selected "+(String)dao.getSelected2());

    }
}
