package ids.unicam.trashit.start;

import java.awt.EventQueue;
import ids.unicam.trashit.grafica.GestoreGrafica;

public class Start {
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestoreGrafica frame = new GestoreGrafica();
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