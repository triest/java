import javax.swing.*;

/**
 * Created by triest on 21.05.2017.
 */
public class FileManagerForm {

    private JButton button1;
    private JList list1;
    private JPanel panelMain;
    //обработчик кнопки
    private DefaultListModel philosophers;

    public FileManagerForm() {


        JPanel jPanel = new JPanel();
        DAO dao = new DAO(new JList());
        Forma2 forma2 = new Forma2("", "");
   forma2.start();
      forma2.ShowFile(dao);
        forma2.isVisible();
       DefaultListModel listModel;
       listModel=new DefaultListModel();

        JList list1 = new JList(listModel);

        listModel.addElement("new item");
        for (int i=0;i<dao.ls2().length;i++){
            listModel.addElement((String.valueOf( dao.ls2()[i])));
        }

        /*
        JFrame jFrame = new JFrame("app");
//        FileManagerForm fileManagerForm = new FileManagerForm();
        jFrame.setContentPane(new FileManagerForm().panelMain);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);*/

     //   philosophers = new DefaultListModel();
       listModel.addElement( "Socrates" );
        philosophers.addElement( "Plato" );
        philosophers.addElement( "Aristotle" );
        philosophers.addElement( "St. Thomas Aquinas" );
        philosophers.addElement( "Soren Kierkegaard" );
        philosophers.addElement( "Immanuel Kant" );
        philosophers.addElement( "Friedrich Nietzsche" );
        philosophers.addElement( "Hannah Arendt" );

        // create a JList for philosophers DefaultListModel
        list1 = new JList( philosophers );

        // allow user to select only one philosopher at a time
        list1.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION );

    }
}
