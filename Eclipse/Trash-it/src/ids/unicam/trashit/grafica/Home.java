package ids.unicam.trashit.grafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Home extends JFrame{
	
	//COMPONENTI
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	JPanel home;
	JLabel homelblBenvenuto;
	JLabel homelblSelezionaOperazione;
	JButton homebtnScansione;
	JButton homebtnRitiroPremio;
	JButton homebtnProblemiAssistenza;
	JButton homebtnInfo;
	JLabel homelblLogo;
	JButton homebtnCreaTessera;
	JLabel homelblSeiNuovo;
	JButton homebtnChiudiSessione;
	JLabel background;
	
	
	private void jpanel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/aaa.png")));
		setTitle("Trash-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void jlayeredpane() {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1045, 699);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
	}
	
	
	private void setjPanel() {
		
	}
	
	
	
	public Home() {		

		jpanel();
		jlayeredpane();
		
		//HOME
		home = new JPanel();
		layeredPane.add(home, "name_781337426904700");
		home.setOpaque(false);
		home.setLayout(null);
		
		//contenuti
		homelblBenvenuto = new JLabel("BENVENUTO");
		homelblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblBenvenuto.setForeground(Color.BLACK);
		homelblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblBenvenuto.setBounds(416, 0, 629, 57);
		home.add(homelblBenvenuto);
		
		homelblSelezionaOperazione = new JLabel("Seleziona un'operazione");
		homelblSelezionaOperazione.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSelezionaOperazione.setForeground(Color.BLACK);
		homelblSelezionaOperazione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		homelblSelezionaOperazione.setBounds(416, 97, 629, 57);
		home.add(homelblSelezionaOperazione);
		
		homebtnScansione = new JButton("SCANSIONA PRODOTTO", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		homebtnScansione.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setMargin(new Insets(0, 0, 0, 0));
		homebtnScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setForeground(Color.BLACK);
		homebtnScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnScansione.setContentAreaFilled(false);
		homebtnScansione.setBorderPainted(false);
		homebtnScansione.setBounds(416, 167, 629, 82);
//		homebtnScansione.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(scansione);
//				seconds = 30;
//			}
//		});
		home.add(homebtnScansione);
		
		homebtnRitiroPremio = new JButton("RITIRO PREMI", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		homebtnRitiroPremio.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanel(scansioneTessera);
//				seconds = 30;
//			}
//		});
		homebtnRitiroPremio.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setMargin(new Insets(0, 0, 0, 0));
		homebtnRitiroPremio.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setForeground(Color.BLACK);
		homebtnRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnRitiroPremio.setContentAreaFilled(false);
		homebtnRitiroPremio.setBorderPainted(false);
		homebtnRitiroPremio.setBounds(416, 276, 629, 72);
		home.add(homebtnRitiroPremio);
		SimpleAttributeSet centerT = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerT, StyleConstants.ALIGN_CENTER);

		
		homebtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		homebtnProblemiAssistenza.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(assistenza);
//				seconds = 30;
//			}
//		});
		homebtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		homebtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setForeground(Color.BLACK);
		homebtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnProblemiAssistenza.setContentAreaFilled(false);
		homebtnProblemiAssistenza.setBorderPainted(false);
		homebtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		home.add(homebtnProblemiAssistenza);
		
		homebtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		homebtnInfo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(about);
//				seconds = 30;
//			}
//		});
		homebtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnInfo.setOpaque(false);
		homebtnInfo.setMargin(new Insets(0, 0, 0, 0));
		homebtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnInfo.setForeground(Color.BLACK);
		homebtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnInfo.setContentAreaFilled(false);
		homebtnInfo.setBorderPainted(false);
		homebtnInfo.setBounds(0, 456, 418, 57);
		home.add(homebtnInfo);
		
		homelblLogo = new JLabel("");
		homelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		homelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblLogo.setBounds(0, 0, 418, 488);
		home.add(homelblLogo);
		
		homebtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
//		homebtnChiudiSessione.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(sessione);
//				timer.stop();
//			}
//		});
		homebtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnChiudiSessione.setOpaque(false);
		homebtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		homebtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnChiudiSessione.setForeground(Color.WHITE);
		homebtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnChiudiSessione.setContentAreaFilled(false);
		homebtnChiudiSessione.setBorderPainted(false);
		homebtnChiudiSessione.setBounds(416, 613, 629, 57);
		home.add(homebtnChiudiSessione);
		
		JButton homebtnCreaTessera = new JButton("CREA TESSERA", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/bluebuttonSmall.png")));
		homebtnCreaTessera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				switchPanel(registrazione);
//				seconds = 60;
			}
		});
		homebtnCreaTessera.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnCreaTessera.setMargin(new Insets(0, 0, 0, 0));
		homebtnCreaTessera.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnCreaTessera.setForeground(Color.WHITE);
		homebtnCreaTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnCreaTessera.setContentAreaFilled(false);
		homebtnCreaTessera.setBorderPainted(false);
		homebtnCreaTessera.setBounds(416, 438, 629, 96);
		home.add(homebtnCreaTessera);
		
		homelblSeiNuovo = new JLabel("Sei nuovo in Trash-it? Crea la tua tessera");
		homelblSeiNuovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		homelblSeiNuovo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSeiNuovo.setBounds(416, 400, 629, 40);
		home.add(homelblSeiNuovo);
		
		
		background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
		
	}

}
