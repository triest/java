import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.event.*;
//Графический интерфейс
public class GUI extends JFrame{
	private JTable table;
	public static FileTable tableModel;
	File f1;
	JLabel Lpath;
	Path copyPath;
	JButton open, go, copy, paste, delete, edit, run,create, createDir, back; 
	JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Файл");
    JMenu help = new JMenu("Помощь"); 
    JMenuItem exit = new JMenuItem("Выход", KeyEvent.VK_X);
    JMenuItem about = new JMenuItem("О программе", KeyEvent.VK_H);
    //Конструктор
	GUI() {
		setTitle("DFM");
		setSize(1124, 768);
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		fileMenu.add(exit);
		help.add(about);
		//Обработчик событий по нажатию на пунтк меню - Выход
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//Обработчик событий по нажатию на пунтк меню - О программе
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Автор: DenSoLo777");
			}
		});
		menuBar.add(fileMenu);
		menuBar.add(help);
		setJMenuBar(menuBar);
		JPanel PathPanel = new JPanel();
		Lpath = new JLabel("");
		PathPanel.add(Lpath);
		tableModel = new FileTable();
		table = new JTable(tableModel);
		//Добавление обработчика события выделение строки 
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
            }
        });
        JPanel filesPanel = new JPanel();
        filesPanel.setBorder(BorderFactory.createTitledBorder("Файлы"));
        filesPanel.setLayout(new BorderLayout());
        filesPanel.add(new JScrollPane(table),BorderLayout.CENTER);
        createDir = new JButton("Создать каталог"); 
        //Создание каталога
        createDir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String str = JOptionPane.showInputDialog("Введите имя директории:");
        		String path = Lpath.getText();
        		path+=" ";
        		if (path.contains(":\\ ")) {
        			path=path.trim()+str;
        			File f1 = new File(path);
        			f1.mkdir();
        		} else {
        		File f1 = new File(Lpath.getText()+"\\"+str);
        		f1.mkdir();
        		}
        		tableModel.addFile(f1);
        	}
        });
        createDir.setEnabled(true);
        create = new JButton("Создать файл"); 
        //Создание файла
        create.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name = JOptionPane.showInputDialog("Введите имя файла:");
        		String path=Lpath.getText();
        		path+=" ";
        		if (path.contains(":\\ ")) {
        			path=path.trim();
        			path=path+name;
        			File f1 = new File(path);
        			try {
						f1.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
        			tableModel.addFile(f1);
        		} else {
        			path=path.trim();
        			path=path+"\\"+name;
        			File f1 = new File(path);
        			try {
        				f1.createNewFile();
        			} catch (IOException e1) {
        				e1.printStackTrace();
        			}
        		}
        	}
        });
        create.setEnabled(true);
        delete = new JButton("Удалить");
        //удаление файла/директории
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (table.getSelectedRow() == -1) {
        			JOptionPane.showMessageDialog(null, "Файл не выбран");
        		} else {
        		File f1 = tableModel.getFile(table.getSelectedRow());
        		if (f1.isDirectory()) {
        		deleteDir(f1);
        		} else {
        			if (f1.delete()) {
            			JOptionPane.showMessageDialog(null, "Файл успешно удалён.");
            			tableModel.clearFile(table.getSelectedRow());
            		} else {
            			JOptionPane.showMessageDialog(null, "Удалить файл не удалось.");
            		}
        		}
        	}
        	}
        });
        delete.setEnabled(false);
        copy = new JButton("Копировать");
        //копирование файла
        copy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (table.getSelectedRow() == -1) {
        			JOptionPane.showMessageDialog(null, "Файл не выбран");
        		} else {
        			copyPath = tableModel.getFile(table.getSelectedRow()).toPath();
        		}
        	}
        });
        copy.setEnabled(false);
        run = new JButton("Запустить");
        //запуск exe-файла
        run.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (table.getSelectedRow() == -1) {
        			JOptionPane.showMessageDialog(null, "Файл не выбран");
        		} else {
        			File f1 = tableModel.getFile(table.getSelectedRow());
        			try {
						Runtime.getRuntime().exec(f1.getPath());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Не удалось запустить файл");
					}
        	}
        	}
        });
        run.setEnabled(false);
        open = new JButton("Открыть");
        open.setEnabled(false);
        //Открытие файла
        open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Файл не выбран");
				} else {
				File f1 = tableModel.getFile(table.getSelectedRow());
				String str = (String) tableModel.getValueAt(table.getSelectedRow(), 4);
				switch (str) {
				case "jpg":
					Iframe f = new Iframe(f1);
					f.setVisible(true);
					break;
				case "bmp":
					Iframe fr = new Iframe(f1);
					fr.setVisible(true);
				case "png":
					Iframe fra = new Iframe(f1);
					fra.setVisible(true);
				case "gif":
					Iframe fram = new Iframe(f1);
					fram.setVisible(true);	
				case "txt":
					TextEditor te = new TextEditor(f1);
					te.loadText(f1);
					try {
						Files.deleteIfExists(f1.toPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					tableModel.clearFile(table.getSelectedRow());
					break;
				case "html":
					TextEditor te2 = new TextEditor(f1);
					te2.loadText(f1);
					try {
						Files.deleteIfExists(f1.toPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					tableModel.clearFile(table.getSelectedRow());
					break;
				}
				}
			}
        });
        paste = new JButton("Вставить");
        //вставка файла
        paste.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		File f1 = copyPath.toFile();
        		String path = Lpath.getText();
        		path+=" ";
        		File f2;
        		if (path.contains(":\\ ")) {
        			path=path.trim();
        			path+=f1.getName();
        			f2 = new File(path);
        		} else {
        			path=path.trim();
        			path=path+"\\"+f1.getName();
        			f2 = new File(path);
        		}
        		try {
					Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
					tableModel.addFile(f2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        });
        paste.setEnabled(false);
        go = new JButton("Перейти");
        //переход в выделенную директорию
        go.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (table.getSelectedRow() == -1) {
        			
        		} else {
        		String path = Lpath.getText();
        		path+=" ";
        		String target;
        		String newPath;
        		if (path.contains(":\\ ")) {
        			path = path.trim();
        			target = path.concat(tableModel.getFile(table.getSelectedRow()).getName());
        			Lpath.setText(target);
        			File f1 = new File(target);
        			String s[] = f1.list();
        			tableModel.clearTable();
        			for (int i = 0; i<s.length; i++) {
        				newPath=target.trim()+"\\"+s[i];
        				tableModel.addFile(new File(newPath));
        			}
        		} else {
        			target = path.trim().concat("\\".concat(tableModel.getFile(table.getSelectedRow()).getName()));
        			Lpath.setText(target);
        			File f1 = new File(target);
        			String s[] = f1.list();
        			tableModel.clearTable();
        			back.setEnabled(true);
        			for (int i = 0; i<s.length; i++) {
        				newPath=target.trim()+"\\"+s[i];
        				tableModel.addFile(new File(newPath));
        			}
        		}
        	}
        	}
        });
        go.setEnabled(false);
        back = new JButton("Назад");
        //переход в родительский каталог
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		File f1 = new File(Lpath.getText());
				String path = f1.getParent();
				File f2 = new File(f1.getParent());
				String target;
				String s[] = f2.list();
				tableModel.clearTable();
				Lpath.setText(path);
				for (int i = 0;i<s.length; i++) {
					tableModel.addFile(new File(Lpath.getText()+"\\"+s[i]));
				}
				path+=" ";
				if (path.contains(":\\ ")) {
					back.setEnabled(false);
				} else {
					back.setEnabled(true);
				}
        	}
        });
        back.setEnabled(false);
        edit = new JButton("Изменить путь");
        //Изменение пути
        edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lpath.setText(JOptionPane.showInputDialog("Введите путь:"));
				tableModel.clearTable();
				String path = Lpath.getText();
				path+=" ";
				if (path.contains(":\\ ")) {
					File f2 = new File(path);
					String s[] = f2.list();
					back.setEnabled(false);
				for (int i = 1; i<s.length; i++) {
					String target = path.trim().concat(s[i]);
					tableModel.addFile(new File(target));
				}
				} else {
					File f2 = new File(path);
					String s[] = f2.list();
					back.setEnabled(true);
					for (int i = 1; i<s.length; i++) {
						String target = path.trim().concat("\\".concat(s[i]));
						tableModel.addFile(new File(target));
					}
				}
			}	
        });
        edit.setEnabled(true);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(back);
        buttonPanel.add(createDir);
        buttonPanel.add(create);
        buttonPanel.add(delete);
        buttonPanel.add(copy);
        buttonPanel.add(paste);
        buttonPanel.add(run);
        buttonPanel.add(edit);
        buttonPanel.add(open);
        buttonPanel.add(go);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(PathPanel, BorderLayout.NORTH);
        getContentPane().add(filesPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        Lpath.setText("C:\\");
        File file = new File(Lpath.getText());
        String newFiles[] = file.list();
        for (int i =0; i <newFiles.length; i++) {
        	tableModel.addFile(new File(Lpath.getText()+newFiles[i]));
        }
	}
	//метод удаления
	void deleteDir(File f) {
		String s[] = f.list();
		File f2;
		if (s == null) {
			try {
				Files.delete(f.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int i=0; i<s.length;i++) {
			f2 = new File(f.getPath()+"\\"+s[i]);
			if (f2.isFile()) {
				try {
					Files.delete(f2.toPath());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Не удалось удалить файл");
				}
			} else {
				del(f2);
				try {
					Files.delete(f2.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			Files.delete(f.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableModel.clearFile(table.getSelectedRow());
		JOptionPane.showMessageDialog(null, "Файл успешно удалён");
	}
	//метод удаления
	void del(File f) {
		String s[] = f.list();
		File f2;
		for (int i=0; i<s.length;i++) {
			f2 = new File(f.getPath()+"\\"+s[i]);
			if (f2.isFile()) {
				try {
					Files.delete(f2.toPath());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Не удалось удалить файл");
				}
			} else {
				del(f2);
				try {
					Files.delete(f2.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//изменение состояния кнопок
	protected void tableSelectionChanged() {
		f1 = tableModel.getFile(table.getSelectedRow());
		if (f1 == null) {
			
		} else {
		if (f1.isFile()) {
			String str = (String) tableModel.getValueAt(table.getSelectedRow(), 4);
			str=str.toLowerCase();
			switch (str) {
				case "jpg":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;	
				case "bmp":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "png":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "gif":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "txt":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "exe":
					delete.setEnabled(true);
					open.setEnabled(false);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(true);
					break;
				case "doc":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "html":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
				case "java":
					delete.setEnabled(true);
					open.setEnabled(true);
					copy.setEnabled(true);
					paste.setEnabled(true);
					go.setEnabled(false);
					run.setEnabled(false);
					break;
			}
		
		} else {
			delete.setEnabled(true);
			open.setEnabled(false);
			copy.setEnabled(true);
			paste.setEnabled(true);
			go.setEnabled(true);
			run.setEnabled(false);
			if (f1.getParent() !=null) {
				back.setEnabled(true);
			} else {
				back.setEnabled(false);
			}
		}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI manager = new GUI();
                manager.setVisible(true);
            }
        });
	}
}