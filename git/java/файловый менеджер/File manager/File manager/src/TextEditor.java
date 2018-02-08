import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;

import javax.swing.*;
public class TextEditor extends JFrame{
	JScrollPane sp = new JScrollPane();
	static JTextPane text = new JTextPane();
	JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Файл");
    JMenuItem save = new JMenuItem("Сохранить", KeyEvent.VK_S);
    static File f1;
    //Конструктор
	TextEditor(File f1) {
		this.f1 = f1;
		save.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
	            saveText(TextEditor.f1);
	        }
	    });
		fileMenu.add(save);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
		setTitle("Text-Editor");
		setSize(800,600);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				saveText(TextEditor.f1);
			}
		});
		sp.setViewportView(text);
		sp.setBounds(0, 0, 800, 550);	
		getContentPane().add(sp);
        setVisible(true);
        setResizable(false);
	}
	//загрузка текста
	void loadText(File f1) {
		try {
			int i = 0;
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (i == 0) {
				text.setText(text.getText()+line);
				} else {
					text.setText(text.getText()+"\n"+line);
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Сохранение текста
	public static void saveText(File f1) {
		try {
			f1.createNewFile();
			FileWriter fw = new FileWriter(f1);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text.getText());
			bw.close();
			GUI.tableModel.addFile(f1);
			text.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
