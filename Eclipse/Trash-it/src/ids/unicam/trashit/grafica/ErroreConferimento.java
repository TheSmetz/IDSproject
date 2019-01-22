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

public class ErroreConferimento extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public ErroreConferimento() {
		JPanel erroreConf = new JPanel();
		erroreConf.setLayout(null);
		erroreConf.setOpaque(false);
		layeredPane.add(erroreConf, "name_2585705284100");
		
		JLabel errlblErroreProdotto = new JLabel("ERRORE PRODOTTO");
		errlblErroreProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErroreProdotto.setForeground(Color.BLACK);
		errlblErroreProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		errlblErroreProdotto.setBounds(416, 0, 629, 57);
		erroreConf.add(errlblErroreProdotto);
		
		JButton errbtnRitentaScansione = new JButton("Ritenta scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonSmall.png")));
		errbtnRitentaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scansione);
	            scantxtInputBarcode.setText("");
			}
		});
		errbtnRitentaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnRitentaScansione.setOpaque(false);
		errbtnRitentaScansione.setMargin(new Insets(0, 0, 0, 0));
		errbtnRitentaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnRitentaScansione.setForeground(Color.BLACK);
		errbtnRitentaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnRitentaScansione.setContentAreaFilled(false);
		errbtnRitentaScansione.setBorderPainted(false);
		errbtnRitentaScansione.setBounds(416, 464, 628, 57);
		erroreConf.add(errbtnRitentaScansione);
		
		JButton errbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		errbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		errbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		errbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnProblemiAssistenza.setForeground(Color.BLACK);
		errbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnProblemiAssistenza.setContentAreaFilled(false);
		errbtnProblemiAssistenza.setBorderPainted(false);
		errbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		erroreConf.add(errbtnProblemiAssistenza);
		
		
		JButton errbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		errbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		errbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnInfo.setOpaque(false);
		errbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		errbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnInfo.setForeground(Color.BLACK);
		errbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnInfo.setContentAreaFilled(false);
		errbtnInfo.setBorderPainted(false);
		errbtnInfo.setBounds(0, 456, 418, 57);
		erroreConf.add(errbtnInfo);
		
		JLabel errlblErrorImage = new JLabel("Image Not Found");
		errlblErrorImage.setFont(new Font("Tahoma", Font.BOLD, 20));
		errlblErrorImage.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/errorimage.png")));
		errlblErrorImage.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErrorImage.setHorizontalTextPosition(JLabel.CENTER);
		errlblErrorImage.setVerticalTextPosition(JLabel.BOTTOM);
		errlblErrorImage.setBounds(416, 128, 629, 309);
		erroreConf.add(errlblErrorImage);
		
		JLabel errlblLogo = new JLabel("");
		errlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		errlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		errlblLogo.setBounds(0, 0, 418, 488);
		erroreConf.add(errlblLogo);
		
		JTextPane errtxtpnErroreRecuperoImmagine = new JTextPane();
		errtxtpnErroreRecuperoImmagine.setEditable(false);
		errtxtpnErroreRecuperoImmagine.setFont(new Font("Tahoma", Font.PLAIN, 25));		
		StyledDocument doc = errtxtpnErroreRecuperoImmagine.getStyledDocument();
		errtxtpnErroreRecuperoImmagine.setOpaque(false);
		errtxtpnErroreRecuperoImmagine.setText("possibili cause: prodotto non presente nel nostro database oppure errore temporaneo (ritenta scansione)");
		errtxtpnErroreRecuperoImmagine.setBounds(426, 70, 629, 73);
		erroreConf.add(errtxtpnErroreRecuperoImmagine);
		
		JButton errbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		errbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		errbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnChiudiSessione.setOpaque(false);
		errbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		errbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnChiudiSessione.setForeground(Color.WHITE);
		errbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnChiudiSessione.setContentAreaFilled(false);
		errbtnChiudiSessione.setBorderPainted(false);
		errbtnChiudiSessione.setBounds(416, 613, 629, 57);
		erroreConf.add(errbtnChiudiSessione);
		
		
	}
}