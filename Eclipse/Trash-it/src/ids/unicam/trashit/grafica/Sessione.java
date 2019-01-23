package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Sessione extends JFrame {
	
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public Sessione() {
		
		JPanel sessione = new JPanel();
		layeredPane.add(sessione, "name_793346484234400");
		sessione.setOpaque(true);
		sessione.setLayout(null);
		sessione.setBackground(Color.WHITE);
		
		
		
		
		JLabel sessionelblLogo = new JLabel(""); 
		sessionelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logog.png")));
		sessionelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblLogo.setBounds(0, 68, 1045, 505);
		sessione.add(sessionelblLogo);
		
		JLabel sessionelblSessione = new JLabel("Guadagna PREMI salvando l'ambiente!");
		sessionelblSessione.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblSessione.setForeground(Color.BLACK);
		sessionelblSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		sessionelblSessione.setBounds(0, 0, 1045, 57);
		sessione.add(sessionelblSessione);
		
		JButton sessionebtnAvviaScansione = new JButton("AVVIA SESSIONE", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
	    sessionebtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	switchPanel(home);
			//	seconds = 30;
			//	startTimer();			
			}
		});
		
		sessionebtnAvviaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		sessionebtnAvviaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setForeground(Color.BLACK);
		sessionebtnAvviaScansione.setFont(new Font("Calibri", Font.BOLD, 30));
		sessionebtnAvviaScansione.setContentAreaFilled(false);
		sessionebtnAvviaScansione.setBorderPainted(false);
		sessionebtnAvviaScansione.setBounds(0, 590, 1045, 96);
		sessione.add(sessionebtnAvviaScansione);
		
		JLabel sesslblFreccia = new JLabel("");
		sesslblFreccia.setToolTipText("");
		sesslblFreccia.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/freccia.gif")));
		sesslblFreccia.setBounds(728, 54, 240, 598);
		sessione.add(sesslblFreccia);
	}

}
