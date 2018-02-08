import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Iframe extends Frame{
	ImageIcon ic;
	myWinAdapter mwa = new myWinAdapter(this);
	public Iframe(File f) {
		ic = new ImageIcon(f.getPath());
		setTitle(f.getName());
		setSize(ic.getIconWidth(), ic.getIconHeight()+22);
		setResizable(false);
		addWindowListener(mwa);
	}
	public void paint(Graphics g) {
		ic.paintIcon(this, g, 0, 22);
	}
}
