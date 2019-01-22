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

public class IstruzioniConferimento extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public IstruzioniConferimento() {
		JPanel istruzioneConf = new JPanel();
		layeredPane.add(istruzioneConf, "name_47764772881651");
		istruzioneConf.setOpaque(false);
		istruzioneConf.setLayout(null);
		String newLine = System.getProperty("line.separator");
		
		JLabel istrlblConferimentoProdotto = new JLabel("ISTRUZIONI CONFERIMENTO");
		istrlblConferimentoProdotto.setForeground(Color.BLACK);
		istrlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		istrlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		istruzioneConf.add(istrlblConferimentoProdotto);

		JButton istrbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.setVerticalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setHorizontalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		istrbtnProblemiAssistenza.setOpaque(false);
		istrbtnProblemiAssistenza.setForeground(Color.BLACK);
		istrbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnProblemiAssistenza.setContentAreaFilled(false);
		istrbtnProblemiAssistenza.setBorderPainted(false);
		istrbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		istruzioneConf.add(istrbtnProblemiAssistenza);

		JButton istrbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		istrbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnInfo.setOpaque(false);
		istrbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		istrbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnInfo.setForeground(Color.BLACK);
		istrbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnInfo.setContentAreaFilled(false);
		istrbtnInfo.setBorderPainted(false);
		istrbtnInfo.setBounds(0, 456, 418, 57);
		istruzioneConf.add(istrbtnInfo);

		JLabel istrlblLogo = new JLabel("");
		istrlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		istrlblLogo.setBounds(0, 0, 418, 488);
		istruzioneConf.add(istrlblLogo);

		JLabel istrlblDescrizione = new JLabel("descrizione prodotto");
		istrlblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblDescrizione.setBounds(416, 137, 629, 136);
		istruzioneConf.add(istrlblDescrizione);
		
		//punti
		JLabel istrlblPunti = new JLabel("Punti guadagnati");
		istrlblPunti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblPunti.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblPunti.setBounds(417, 258, 628, 69);
		istruzioneConf.add(istrlblPunti);
		
		//nuova scansione
		JButton istrbtnNuovaScansione = new JButton("Nuova scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnNuovaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
				seconds = 30;
			}
		});
		istrbtnNuovaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnNuovaScansione.setOpaque(false);
		istrbtnNuovaScansione.setMargin(new Insets(0, 0, 0, 0));
		istrbtnNuovaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnNuovaScansione.setForeground(Color.BLACK);
		istrbtnNuovaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnNuovaScansione.setContentAreaFilled(false);
		istrbtnNuovaScansione.setBorderPainted(false);
		istrbtnNuovaScansione.setBounds(416, 456, 629, 57);
		istruzioneConf.add(istrbtnNuovaScansione);
		
		JButton istrbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		istrbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		istrbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnChiudiSessione.setOpaque(false);
		istrbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		istrbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnChiudiSessione.setForeground(Color.WHITE);
		istrbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnChiudiSessione.setContentAreaFilled(false);
		istrbtnChiudiSessione.setBorderPainted(false);
		istrbtnChiudiSessione.setBounds(416, 613, 629, 57);
		istruzioneConf.add(istrbtnChiudiSessione);
		
		
		JLabel lblPuntiprodotto = new JLabel("PuntiProdotto");
		lblPuntiprodotto.setBounds(679, 398, 124, 23);
		
	}
}