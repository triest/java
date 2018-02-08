import java.awt.event.*;
import java.awt.*;
public class myWinAdapter extends WindowAdapter {
	Frame f;
	myWinAdapter(Frame fr) {
		f = fr;
	}
	public void windowClosing(WindowEvent e) {
		f.setVisible(false);
	}
}
