import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by triest on 26.04.2017.
 */
 class Forma extends JFrame implements ActionListener{

    JPanel pnlButton = new JPanel();
    // Buttons
    JButton btnAddFlight = new JButton("Add Flight");
    JFrame frame;
    JLabel label1;
    JLabel label3;
    JLabel label2;
    JList filelist;


    JTextArea tf = new JTextArea();

    public Forma(JPanel pnlButton,DAO dao) {
        this.pnlButton = pnlButton;
        frame=new JFrame();
        label1=new JLabel("my text", SwingConstants.CENTER);

        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        label2 = new JLabel("Text-Only Label");
        label3 = new JLabel();

        //создаем слушателя
        //ActionListener2 actionListener2=new ActionListener2(this);
      //  btnAddFlight.addActionListener(actionPerformed(enableEvents()));
     //    btnAddFlight.addActionListener();
 //кнопка



        //окно выбора файла
        setBounds(500,500,500,500);
        //    JFileChooser dialog=new JFileChooser();
        //  dialog.showOpenDialog(this);
        setVisible(true);
        filelist=new JList(dao.ls2()); // список файлов для отображения
        filelist.setLayoutOrientation(JList.VERTICAL);
        filelist.setVisible(true);


        //тут образец листа
        DefaultListModel<String> listModel = new DefaultListModel<>();
/*
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");

*/
this.shovFolders(dao,listModel);

        //   add(showFiles(dao));
        //  File[] filelist2=showFiles(dao);

        /// пример листа
        JButton button = new JButton("Print");
        // JScrollPane pane = new JScrollPane(list);
/**/

//тут обработка перехода
     ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnAddFlight){
                    if(filelist.getSelectedValue()!=null) {
                        String value = filelist.getSelectedValue().toString();
                        System.out.println("Button test: " + value);
                        dao.changeDir(value);
                    }
                }
            }
        };


        btnAddFlight.addActionListener(listener);
/*
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        m.setLeadAnchorNotificationEnabled(false);
        list.setSelectionModel(m);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(e.toString());
            }
        });
     //   button.addActionListener(new PrintListener());

        add(pane, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);*/
    }

    public void shovFolders(DAO dao, DefaultListModel<String> listModel){
        for (int i=0;i<dao.ls2().length;i++){
            listModel.addElement((String.valueOf( dao.ls2()[i])));
        }
        filelist = new JList<>(listModel);
        add(filelist);
    }

    public void Visuble(){
        frame.setVisible(true);
    }


    public String getSelectedIndex(){
        if (filelist.getSelectedValue()!=null){
                String value=filelist.getSelectedValue().toString();
            return value;
        }
                else {return null;}

    }

    public void Button(){
        // FlightInfo setbounds
        //    btnAddFlight.setBounds(60, 100, 100, 30);

        // JPanel bounds
        pnlButton.setBounds(100, 100, 200, 100);

        // Adding to JFrame
        pnlButton.add(btnAddFlight);
        frame.add(pnlButton);

        // JFrame properties
        frame.setSize(400, 400);
        frame.setBackground(Color.BLACK);
        frame.setTitle("Air Traffic Control");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnAddFlight.setVisible(true);
        filelist.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


/*
    JList showFiles(DAO dao) {
        add(tf);
     String files;
        String fileNames = "";
      // File folder = new File(path);
       // File[] listOfFiles = folder.listFiles();
         File[] listOfFiles=dao.ls2();
        for (int i = 0; i < listOfFiles.length; i++)
        {

            if (listOfFiles[i].isFile())
            {
                files = listOfFiles[i].getName();
                if (files.endsWith(".txt") || files.endsWith(".TXT"))
                {
                    fileNames += "\n" + files;
                }
            }
        }
        tf.setText( fileNames );
    //  return listOfFiles;
    }
*/
    //тут диалог выбора файлов

}
