package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class About extends JPanel {
	public About() {
	}
	
	JPanel about;
	JLabel aboutlblInformazioniTrashit;
	JButton aboutbtnProblemiAssistenza;
	JTextPane abouttextPaneInfo;
	static JButton aboutbtnHomePage;
	
	private void lblInformazioniTrashit() {
		aboutlblInformazioniTrashit = new JLabel("INFORMAZIONI TRASH-IT");
		aboutlblInformazioniTrashit.setHorizontalAlignment(SwingConstants.CENTER);
		aboutlblInformazioniTrashit.setForeground(Color.BLACK);
		aboutlblInformazioniTrashit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		aboutlblInformazioniTrashit.setBounds(416, 0, 629, 57);
		about.add(aboutlblInformazioniTrashit);
	}
	
	private void btnProblemiAssistenza() {
		aboutbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		aboutbtnProblemiAssistenza.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(assistenza);
//				seconds = 30;
//			}
//		});
		aboutbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnProblemiAssistenza.setOpaque(false);
		aboutbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnProblemiAssistenza.setForeground(Color.BLACK);
		aboutbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnProblemiAssistenza.setContentAreaFilled(false);
		aboutbtnProblemiAssistenza.setBorderPainted(false);
		aboutbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		about.add(aboutbtnProblemiAssistenza);
	}
	
	private void textPaneInfo() {
		abouttextPaneInfo = new JTextPane();
		abouttextPaneInfo.setText("Trash-it e' un'applicazione destinata al corretto svolgimento " + 
				" della raccolta differenziata. \nScansionando il codice a barre di un prodotto," + 
				" si potranno ricevere informazioni sul materiale di cui il prodotto e' composto" + 
				" e le relative indicazioni su dove gettarlo. \nVerranno poi applicate le specifiche policy di riciclo per ogni comune" + 
				"\nIl vantaggio dell'uso di questo sistema sta nel guadagno punti per l'utente, in modo da ritirare premi." +
				" \nE' inoltre possibile accedere alle statistiche relative ai prodotti conferiti nel comune.");
		abouttextPaneInfo.setOpaque(false);
		abouttextPaneInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		abouttextPaneInfo.setEditable(false);
		abouttextPaneInfo.setBounds(441, 70, 604, 342);
		about.add(abouttextPaneInfo);
	}

	public static void btnHomePage(JPanel wherePanel) {
		aboutbtnHomePage = new JButton("Home Page", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		aboutbtnHome.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(home);
//				seconds = 30;
//			}
//		});
		aboutbtnHomePage.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnHomePage.setOpaque(false);
		aboutbtnHomePage.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnHomePage.setForeground(Color.WHITE);
		aboutbtnHomePage.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnHomePage.setContentAreaFilled(false);
		aboutbtnHomePage.setBorderPainted(false);
		aboutbtnHomePage.setBounds(416, 509, 629, 57);
		wherePanel.add(aboutbtnHomePage);
	}
	
	private void setJPanelAbout() {
		about = new JPanel();
		about.setLayout(null);
		about.setOpaque(false);
		lblInformazioniTrashit();
		btnProblemiAssistenza();
		Home.btnChiudiSessione(about);
		textPaneInfo();
		btnHomePage(about);
		Home.lblLogo(this.about);
	}
	
	public JPanel getJPanelAbout() {
		setJPanelAbout();
		
		return about;
	}






	



	
}