import java.io.File;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//Модель таблицы
public class FileTable extends AbstractTableModel{
	private static final String[] columnNames = {"Имя файла","Размер","Дата последней модификации","Доступ","Расширение","Тип"};
	private static final Class[] columnClasses = {String.class, String.class, String.class, String.class, String.class, String.class};
	public static ArrayList<File> files = new ArrayList<File>();
	public String path = "C:\\";
	//Добавление файла
	public void addFile(File file) {
        files.add(file);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
	//Получение файла
	public File getFile(int row) {
		if (row < 0 | row>files.size()) {
			return null;
		} else {
        return files.get(row);
		}
    }
	//Очистка таблицы
	public void clearTable() {
		if (files.size()==0) {
			
		} else {
		fireTableRowsDeleted(0,files.size()-1);
	    files.clear();
		}
	}
	//Очищение определённой строки 
	public void clearFile(int row) {
        files.remove(row);
        fireTableRowsDeleted(row,row);
    }
	//Получение имён столбцов
	public String getColumnName(int col) {
        return columnNames[col];
    }
	//Получение классов столбцов
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }
    //Получение количества столбцов
	public int getColumnCount() {
		return columnNames.length;
	}
	//получение количество строк
	public int getRowCount() {
		return files.size();
	}
	//получение значения из ячейки [row,col]
	public Object getValueAt(int row, int col) {
		File f1 = files.get(row);
        switch (col) {
            case 0: return f1.getName();
            case 1: long size = f1.length();
            	String res;
            	if (size >=1024) {
            		if (size >= 1024*1024) {
            			if (size >= 1024*1024*1024) {
            				if (size >= 1024*1024*1024*1024) {
            					size=(long) size/1024;
            					size=(long) size/1024;
            					size=(long) size/1024;
            					size=(long) size/1024;
            					res = Long.toString(size) + " ТБ";
            					return res;
            				}
            				size=(long) size/1024;
        					size=(long) size/1024;
        					size=(long) size/1024;
        					res = Long.toString(size) + " ГБ";
        					return res;
            			}
            			size=(long) size/1024;
    					size=(long) size/1024;
    					res = Long.toString(size) + " МБ";
    					return res;
            		}
            		size=(long) size/1024;
            		res = Long.toString(size) + " КБ";
            	} 
                 if (size == -1) {
                	 return "";
                 } else {
                	 res = Long.toString(size) + " Б";
                 }
                 return res;
            case 2: Date date = new Date(f1.lastModified());
            Formatter fmt = new Formatter();
            fmt.format("%tH:%tM:%tS %td %tB %tY", date,date,date,date,date,date);
            return fmt;
            case 3:String access = "";
            if (f1.canRead()) { access+="r"; } else { access+="-"; }
            if (f1.canWrite()) { access+="w"; } else { access+="-"; }
            if (f1.canExecute()) { access+="x"; } else {access += "-"; }
            return access;
            case 4: if (f1.isFile()) {
            	String name = f1.getName();
            	if (name.contains(".")) {
            	name = name.substring(name.lastIndexOf('.')+1, name.length());
            	return name;
            	} else {
            		return "-";
            	}
            } else {
            	return "-";
            }
            case 5: if (f1.isFile()) { return "Файл"; } else {return "Директория";} 
        }
        return "";
	}
}
