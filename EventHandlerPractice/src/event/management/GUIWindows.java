package event.management;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GUIWindows {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame main = new MainFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				main.setSize(500, 485);
				main.setResizable(false);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
			}
		});
	}
}