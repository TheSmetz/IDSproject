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
	
	JPanel about;
	JLabel aboutlblInformazioniTrashit;
	JButton aboutbtnProblemiAssistenza;
	JButton aboutbtnChiudiSessione;
	JTextPane abouttextPaneInfo;
	JButton aboutbtnHome;
	
	public void setJPanelAbout() {
		about = new JPanel();
		about.setLayout(null);
		about.setOpaque(false);
	}
	
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
	
	private void btnChiudiSessione() {
		aboutbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
//		aboutbtnChiudiSessione.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(sessione);
//				timer.stop();
//			}
//		});
		aboutbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnChiudiSessione.setOpaque(false);
		aboutbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnChiudiSessione.setForeground(Color.WHITE);
		aboutbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnChiudiSessione.setContentAreaFilled(false);
		aboutbtnChiudiSessione.setBorderPainted(false);
		aboutbtnChiudiSessione.setBounds(416, 613, 629, 57);
		about.add(aboutbtnChiudiSessione);
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

	private void btnHome() {
		aboutbtnHome = new JButton("Home Page", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		aboutbtnHome.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(home);
//				seconds = 30;
//			}
//		});
		aboutbtnHome.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnHome.setOpaque(false);
		aboutbtnHome.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnHome.setForeground(Color.WHITE);
		aboutbtnHome.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnHome.setContentAreaFilled(false);
		aboutbtnHome.setBorderPainted(false);
		aboutbtnHome.setBounds(416, 509, 629, 57);
		about.add(aboutbtnHome);
	}
	
	public JPanel getJPanelAbout() {
		setJPanelAbout();
		lblInformazioniTrashit();
		btnProblemiAssistenza();
		btnChiudiSessione();
		textPaneInfo();
		btnHome();
		Home.lblLogo(this.about);
		return about;
	}






	



	
}