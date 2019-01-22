package ids.unicam.trashit.start;

import java.awt.EventQueue;
import ids.unicam.trashit.grafica.GuiMain;
import ids.unicam.trashit.grafica.Home;



public class Start {
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
