package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RitiroPremio extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public RitiroPremio() {
		JPanel ritiroPremio = new JPanel();
		layeredPane.add(ritiroPremio, "name_1042826559621000");
		ritiroPremio.setLayout(null);		
		ritiroPremio.setOpaque(false);
		JLabel ritirolblLogo = new JLabel("");
		ritirolblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		ritirolblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblLogo.setBounds(0, 0, 418, 488);
		ritiroPremio.add(ritirolblLogo);		
		
		JButton ritirobtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		ritirobtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnInfo.setOpaque(false);
		ritirobtnInfo.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnInfo.setForeground(Color.BLACK);
		ritirobtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnInfo.setContentAreaFilled(false);
		ritirobtnInfo.setBorderPainted(false);
		ritirobtnInfo.setBounds(0, 456, 418, 57);
		ritiroPremio.add(ritirobtnInfo);
		
		JButton ritirobtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
			}
		});
		ritirobtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnProblemiAssistenza.setForeground(Color.BLACK);
		ritirobtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnProblemiAssistenza.setContentAreaFilled(false);
		ritirobtnProblemiAssistenza.setBorderPainted(false);
		ritirobtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		ritiroPremio.add(ritirobtnProblemiAssistenza);
		
		JButton ritirobtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		ritirobtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		ritirobtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnChiudiSessione.setOpaque(false);
		ritirobtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnChiudiSessione.setForeground(Color.WHITE);
		ritirobtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnChiudiSessione.setContentAreaFilled(false);
		ritirobtnChiudiSessione.setBorderPainted(false);
		ritirobtnChiudiSessione.setBounds(416, 613, 629, 57);
		ritiroPremio.add(ritirobtnChiudiSessione);
		
		JLabel ritirolblSelezionePremio = new JLabel("Seleziona un premio");
		ritirolblSelezionePremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblSelezionePremio.setForeground(Color.BLACK);
		ritirolblSelezionePremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblSelezionePremio.setBounds(416, 56, 629, 57);
		ritiroPremio.add(ritirolblSelezionePremio);
		
		JLabel ritirolblRitiroPremio = new JLabel("RITIRO PREMI");
		ritirolblRitiroPremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblRitiroPremio.setForeground(Color.BLACK);
		ritirolblRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		ritirolblRitiroPremio.setBounds(416, 0, 629, 57);
		ritiroPremio.add(ritirolblRitiroPremio);
		
		JLabel ritirolblPuntiTessera = new JLabel("Punti tessera: ");
		ritirolblPuntiTessera.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblPuntiTessera.setForeground(Color.BLACK);
		ritirolblPuntiTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblPuntiTessera.setBounds(416, 113, 629, 57);
		ritiroPremio.add(ritirolblPuntiTessera);
		
		JButton ritirobtnRitira = new JButton("Ritira", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnRitira.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnRitira.setOpaque(false);
		ritirobtnRitira.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnRitira.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnRitira.setForeground(Color.BLACK);
		ritirobtnRitira.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnRitira.setContentAreaFilled(false);
		ritirobtnRitira.setBorderPainted(false);
		ritirobtnRitira.setBounds(416, 526, 629, 57);
		ritiroPremio.add(ritirobtnRitira);
		
		JRadioButton ritirooption10 = new JRadioButton(" 10%");
		ritirooption10.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption10.setBounds(465, 250, 127, 50);
		ritiroPremio.add(ritirooption10);
		ritirooption10.setOpaque(false);
		
		JRadioButton ritirooption30 = new JRadioButton(" 30%");
		ritirooption30.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption30.setBounds(465, 300, 127, 50);
		ritiroPremio.add(ritirooption30);
		ritirooption30.setOpaque(false);
		
		JRadioButton ritirooption50 = new JRadioButton(" 50%");
		ritirooption50.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption50.setBounds(465, 350, 127, 50);
		ritiroPremio.add(ritirooption50);
		ritirooption50.setOpaque(false);
		
		JRadioButton ritirooption75 = new JRadioButton(" 75%");
		ritirooption75.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption75.setBounds(465, 400, 127, 50);
		ritiroPremio.add(ritirooption75);
		ritirooption75.setOpaque(false);
		
		ButtonGroup buoniSconto = new ButtonGroup();
		buoniSconto.add(ritirooption10);
		buoniSconto.add(ritirooption30);
		buoniSconto.add(ritirooption50);
		buoniSconto.add(ritirooption75);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/ccc.png")));
		label.setBounds(609, 248, 424, 199);
		ritiroPremio.add(label);
		
	}
}