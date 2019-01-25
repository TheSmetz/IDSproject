package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ids.unicam.trashit.start.Start;

public class Sessione {
	
	public static JPanel sessione;
	private JLabel sessionelblLogo;
	private JLabel sessionelblSessione;
	private JButton sessionebtnAvviaSessione;
	private JLabel sesslblFreccia;
	
	public JButton getsessionebtnAvviaSessione() {
		return this.sessionebtnAvviaSessione;
	}
	
	private void lblLogo() {
		sessionelblLogo = new JLabel(""); 
		sessionelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logog.png")));
		sessionelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblLogo.setBounds(0, 68, 1045, 505);
		sessione.add(sessionelblLogo);
	}
	
	
	private void lblSessione() {
		sessionelblSessione = new JLabel("Guadagna PREMI salvando l'ambiente!");
		sessionelblSessione.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblSessione.setForeground(Color.BLACK);
		sessionelblSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		sessionelblSessione.setBounds(0, 0, 1045, 57);
		sessione.add(sessionelblSessione);
	}
	
	private void btnAvviaSessione() {
		sessionebtnAvviaSessione = new JButton("AVVIA SESSIONE", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		sessionebtnAvviaSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start.switchPanel(Home.home);
			//	seconds = 30;
			//	startTimer();			
			}
		});
		
		sessionebtnAvviaSessione.setVerticalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaSessione.setMargin(new Insets(0, 0, 0, 0));
		sessionebtnAvviaSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaSessione.setForeground(Color.BLACK);
		sessionebtnAvviaSessione.setFont(new Font("Calibri", Font.BOLD, 30));
		sessionebtnAvviaSessione.setContentAreaFilled(false);
		sessionebtnAvviaSessione.setBorderPainted(false);
		sessionebtnAvviaSessione.setBounds(0, 590, 1045, 96);
		sessione.add(sessionebtnAvviaSessione);
	}
	
	private void lblFreccia() {
		sesslblFreccia = new JLabel("");
		sesslblFreccia.setToolTipText("");
		sesslblFreccia.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/freccia.gif")));
		sesslblFreccia.setBounds(728, 54, 240, 598);
		sessione.add(sesslblFreccia);
	}
	
	public void setJPanelSessione() {
		sessione = new JPanel();
		sessione.setOpaque(true);
		sessione.setLayout(null);
		sessione.setBackground(Color.WHITE);
		lblLogo();
		lblSessione();
		btnAvviaSessione();
		lblFreccia();
	}
	
	public static JPanel getJPanelSessione() {		
		return sessione;		
	}

}
