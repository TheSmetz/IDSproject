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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.StyledDocument;

public class Assistenza extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public Assistenza() {
		JPanel assistenza = new JPanel();
		layeredPane.add(assistenza, "name_783099324881200");
		assistenza.setLayout(null);
		assistenza.setOpaque(false);
		
		JLabel asslblAssistenza = new JLabel("ASSISTENZA");
		asslblAssistenza.setHorizontalAlignment(SwingConstants.CENTER);
		asslblAssistenza.setForeground(Color.BLACK);
		asslblAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		asslblAssistenza.setBounds(416, 0, 629, 57);
		assistenza.add(asslblAssistenza);
		
		JButton assbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		assbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		assbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		assbtnInfo.setOpaque(false);
		assbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		assbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		assbtnInfo.setForeground(Color.BLACK);
		assbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		assbtnInfo.setContentAreaFilled(false);
		assbtnInfo.setBorderPainted(false);
		assbtnInfo.setBounds(0, 456, 418, 57);
		assistenza.add(assbtnInfo);
		
		JLabel asslblLogo = new JLabel("");
		asslblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		asslblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		asslblLogo.setBounds(0, 0, 418, 488);
		assistenza.add(asslblLogo);
		
		JTextPane asstxtpnTelefonoEmail = new JTextPane();
		asstxtpnTelefonoEmail.setEditable(false);
		asstxtpnTelefonoEmail.setText("Telefono:");
		asstxtpnTelefonoEmail.setText(asstxtpnTelefonoEmail.getText() + newLine + "Email:");
		asstxtpnTelefonoEmail.setOpaque(false);
		asstxtpnTelefonoEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		asstxtpnTelefonoEmail.setBounds(416, 86, 629, 73);
		StyledDocument docAss = asstxtpnTelefonoEmail.getStyledDocument();
		assistenza.add(asstxtpnTelefonoEmail);
		
		JButton assbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		assbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		assbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		assbtnChiudiSessione.setOpaque(false);
		assbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		assbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		assbtnChiudiSessione.setForeground(Color.WHITE);
		assbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		assbtnChiudiSessione.setContentAreaFilled(false);
		assbtnChiudiSessione.setBorderPainted(false);
		assbtnChiudiSessione.setBounds(416, 613, 629, 57);
		assistenza.add(assbtnChiudiSessione);
		
		//bottone homepage
		JButton assbtnHome = new JButton("Home Page", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		assbtnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
				seconds = 30;
			}
		});
		assbtnHome.setVerticalTextPosition(SwingConstants.CENTER);
		assbtnHome.setOpaque(false);
		assbtnHome.setMargin(new Insets(0, 0, 0, 0));
		assbtnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		assbtnHome.setForeground(Color.WHITE);
		assbtnHome.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		assbtnHome.setContentAreaFilled(false);
		assbtnHome.setBorderPainted(false);
		assbtnHome.setBounds(416, 509, 629, 57);
		assistenza.add(assbtnHome);		
	}
}