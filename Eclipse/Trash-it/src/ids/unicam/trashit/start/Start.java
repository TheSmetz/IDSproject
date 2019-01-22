package ids.unicam.trashit.start;

import java.awt.EventQueue;
import ids.unicam.trashit.grafica.GuiMain;

/*	
 * TODO:Separare la Gui in diversi metodi
 * TODO:registrazione su Gui
 * TODO:
 * 
 * */

public class Start {
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
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
