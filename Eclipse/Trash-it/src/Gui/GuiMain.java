package Gui;

import Console.CestinoSmart;
import Console.Policy;
import Console.Prodotto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	// descrizione prodotto
	private String barcodeProdotto; // barcode
	//private String nomeProdotto; // nome
	//private String descrizioneProdotto; // decrizione
	//private byte[] imgProdotto; // immagine
	//private int puntiProdotto; //punti
	protected String[] args;
	private JTextField scantxtInputBarcode;	//input barcode
	
	private String citta = "AP";
	
	public Prodotto prodottoScansionato;
	public Policy policyProdotto;
	private JLabel scanlblBenvenuto;
	private JButton scannbtnInfo;
	//public CestinoSmart cestinoS;	

	public void switchPanel(JPanel panelName) {
		layeredPane.removeAll();
		layeredPane.add(panelName);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public static boolean verifyBarcode(String s) {
		boolean corretto = false;
		int lenght = s.length();		
		System.out.println("---INPUT BARCODE--- ");
		System.out.println("Text: " + s);
		System.out.println("Lunghezza: " + lenght);
		
		
		char[] sequenza = s.toCharArray();
		
		if (lenght == 13) {
			for (int i = 0; i < 13; i++) {
				try {
					Integer.parseInt(Character.toString(sequenza[i]));
					corretto = true;
					
				} catch (Exception e) {
					corretto = false;
				}
			}
		}
		System.out.println("Corretto: " + corretto);
		return corretto;
		}

	/**
	 * Create the frame.
	 */
	public GuiMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/Gui/images/aaa.png")));
		setTitle("Trash-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1045, 734);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));


		//--------------DICHIARAZIONE PANEL--------------
		
		//SESSIONE
		JPanel sessione = new JPanel();
		layeredPane.add(sessione, "name_793346484234400");
		sessione.setOpaque(true);
		sessione.setLayout(null);
		sessione.setBackground(Color.WHITE);
		
		//HOME
		JPanel home = new JPanel();
		layeredPane.add(home, "name_781337426904700");
		home.setOpaque(false);
		home.setLayout(null);
		
		//SCANSIONE
		JPanel scansione = new JPanel();
		layeredPane.add(scansione, "name_47697602642643");
		scansione.setOpaque(false);
		scansione.setLayout(null);
		
		//CONFERIMENTO
		JPanel conferimento = new JPanel();
		layeredPane.add(conferimento, "name_47730555398847");
		conferimento.setOpaque(false);
		conferimento.setLayout(null);
		JLabel conflblImmagineProdotto = new JLabel("immagine prodotto");
		
		//ISTRUZIONI CONFERIMENTO
		JPanel istruzioneConf = new JPanel();
		layeredPane.add(istruzioneConf, "name_47764772881651");
		istruzioneConf.setOpaque(false);
		istruzioneConf.setLayout(null);
		
		//ERRORE CONFERIMENTO
		JPanel erroreConf = new JPanel();
		erroreConf.setLayout(null);
		erroreConf.setOpaque(false);
		layeredPane.add(erroreConf, "name_2585705284100");
		
		//ASSISTENZA
		JPanel assistenza = new JPanel();
		layeredPane.add(assistenza, "name_783099324881200");
		assistenza.setLayout(null);
		assistenza.setOpaque(false);

		// BOTTONI NAVIGAZIONE SCHEDE (provvisori)
//		JButton btnPanel1 = new JButton("HOME");
//		btnPanel1.setBackground(Color.WHITE);
//		btnPanel1.setForeground(Color.BLACK);
//		btnPanel1.setBounds(12, 13, 97, 25);
//		btnPanel1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(home);
//			}
//		});
//		contentPane.add(btnPanel1);
//
//		JButton btnPanel2 = new JButton("ScProdotto");
//		btnPanel2.setBackground(Color.WHITE);
//		btnPanel2.setForeground(Color.BLACK);
//		btnPanel2.setBounds(131, 13, 97, 25);
//		btnPanel2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanel(conferimento);
//			}
//		});
//		contentPane.add(btnPanel2);
//
//		JButton btnPanel3 = new JButton("GttProdotto");
//		btnPanel3.setBackground(Color.WHITE);
//		btnPanel3.setForeground(Color.BLACK);
//		btnPanel3.setBounds(250, 13, 97, 25);
//		btnPanel3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(istruzioneConf);
//			}
//		});
//		contentPane.add(btnPanel3);
//		
//		JButton btnAsspanel = new JButton("AssPanel");
//		btnAsspanel.setBackground(Color.WHITE);
//		btnAsspanel.setForeground(Color.BLACK);
//		btnAsspanel.setBounds(355, 13, 97, 25);
//		btnAsspanel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(assistenza);				
//			}
//		});
//		contentPane.add(btnAsspanel);
		
		
		//--------------CONTENUTI PIU' UTILIZZATI--------------
		
		
		//--------------CONTENUTI PANEL--------------		
		
		//SESSIONE
		JLabel sessionelblLogo = new JLabel("");
		sessionelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logog.png")));
		sessionelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblLogo.setBounds(0, 84, 1045, 505);
		sessione.add(sessionelblLogo);
		
		JLabel sessionelblSessione = new JLabel("Guadagna PREMI salvando l'ambiente!");
		sessionelblSessione.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblSessione.setForeground(Color.BLACK);
		sessionelblSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		sessionelblSessione.setBounds(0, 13, 1045, 57);
		sessione.add(sessionelblSessione);
		
		JButton sessionebtnAvviaScansione = new JButton("AVVIA SESSIONE", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbutton.png")));
		sessionebtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
			}
		});
		sessionebtnAvviaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		sessionebtnAvviaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setForeground(Color.BLACK);
		sessionebtnAvviaScansione.setFont(new Font("Calibri", Font.BOLD, 30));
		sessionebtnAvviaScansione.setContentAreaFilled(false);
		sessionebtnAvviaScansione.setBorderPainted(false);
		sessionebtnAvviaScansione.setBounds(0, 625, 1045, 96);
		sessione.add(sessionebtnAvviaScansione);
		
		JLabel sesslblFreccia = new JLabel("");
		sesslblFreccia.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/freccia.png")));
		sesslblFreccia.setBounds(728, 54, 264, 598);
		sessione.add(sesslblFreccia);
		
		//HOME		
		JLabel homelblBenvenuto = new JLabel("BENVENUTO");
		homelblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblBenvenuto.setForeground(Color.BLACK);
		homelblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblBenvenuto.setBounds(416, 0, 629, 57);
		home.add(homelblBenvenuto);
		
		JLabel homelblSelezionaOperazione = new JLabel("Seleziona operazione");
		homelblSelezionaOperazione.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSelezionaOperazione.setForeground(Color.BLACK);
		homelblSelezionaOperazione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		homelblSelezionaOperazione.setBounds(416, 97, 629, 57);
		home.add(homelblSelezionaOperazione);
		
		JButton homebtnScansione = new JButton("Scansiona prodotto", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		homebtnScansione.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setMargin(new Insets(0, 0, 0, 0));
		homebtnScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setForeground(Color.BLACK);
		homebtnScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnScansione.setContentAreaFilled(false);
		homebtnScansione.setBorderPainted(false);
		homebtnScansione.setBounds(416, 212, 629, 96);
		homebtnScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
			}
		});
		home.add(homebtnScansione);
		
		JButton homebtnRitiroPremio = new JButton("Ritiro premio", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		homebtnRitiroPremio.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setMargin(new Insets(0, 0, 0, 0));
		homebtnRitiroPremio.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setForeground(Color.BLACK);
		homebtnRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnRitiroPremio.setContentAreaFilled(false);
		homebtnRitiroPremio.setBorderPainted(false);
		homebtnRitiroPremio.setBounds(416, 321, 629, 96);
		home.add(homebtnRitiroPremio);
		SimpleAttributeSet centerT = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerT, StyleConstants.ALIGN_CENTER);

		
		JButton homebtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		homebtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
			}
		});
		homebtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		homebtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setForeground(Color.BLACK);
		homebtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnProblemiAssistenza.setContentAreaFilled(false);
		homebtnProblemiAssistenza.setBorderPainted(false);
		homebtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		home.add(homebtnProblemiAssistenza);
		
		JButton homebtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		homebtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JLabel homelblLogo = new JLabel("");
		homelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		homelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblLogo.setBounds(0, 0, 418, 488);
		home.add(homelblLogo);
		
		JButton homebtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		homebtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
			}
		});
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
		
		//SCANSIONE	
		JLabel scanlblBenvenuto;
		scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(416, 0, 629, 57);
		scansione.add(scanlblBenvenuto);

		JButton scanbtnInfo;
		scannbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		scannbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		scannbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		scannbtnInfo.setOpaque(false);
		scannbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		scannbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		scannbtnInfo.setForeground(Color.BLACK);
		scannbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scannbtnInfo.setContentAreaFilled(false);
		scannbtnInfo.setBorderPainted(false);
		scannbtnInfo.setBounds(0, 456, 418, 57);
		scansione.add(scannbtnInfo);

		// Avvia scansione		
		JButton scanbtnAvviaScansione = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		scanbtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setBorderPainted(false);
		scanbtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png")));
		scanbtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnAvviaScansione.setForeground(Color.BLACK);
		scanbtnAvviaScansione.setContentAreaFilled(false);
		scanbtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//leggo il barcode in input
				barcodeProdotto = scantxtInputBarcode.getText();
				
				//prodotto
				prodottoScansionato = new Prodotto(barcodeProdotto);
				
				//VERIFICARE CORRETTEZZA CODICE A BARRE
				
				// output
				if (prodottoScansionato.isPresenza()) {					
					
					//policy
					policyProdotto = new Policy("AP", prodottoScansionato);					
					prodottoScansionato.getDati();
					
					//cestinosmart				
					CestinoSmart cestinoS = new CestinoSmart();
					try {
						cestinoS.conferimentoProdotto(prodottoScansionato);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
					prodottoScansionato.getDati();
			
					ImageIcon image = new ImageIcon(prodottoScansionato.getImmagine());
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(conflblImmagineProdotto.getWidth(),
					conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newImage = new ImageIcon(myImg);
					conflblImmagineProdotto.setIcon(newImage);
					conflblImmagineProdotto.setIcon(newImage);
					
					//prodotto nel db allora procedo con il conferimento
					switchPanel(conferimento);
					
				} else {
					System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");					
					switchPanel(erroreConf);	//pannello di errore
				}
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);

		JLabel scanlblLogo = new JLabel("");
		scanlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		scanlblLogo.setBounds(0, 0, 418, 488);
		scansione.add(scanlblLogo);

		JLabel scanlblScansionaProdotto = new JLabel("Scansione Prodotto");
		scanlblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansionaProdotto.setForeground(Color.BLACK);
		scanlblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanlblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansione.add(scanlblScansionaProdotto);
		
		scantxtInputBarcode = new JTextField();
		scantxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtInputBarcode.setBounds(632, 384, 212, 44);
		scantxtInputBarcode.setOpaque(false);
		scansione.add(scantxtInputBarcode);
		scantxtInputBarcode.setColumns(10);
		
		JLabel scanlblInputBackground = new JLabel("");
		scanlblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonsmall.png")));
		scanlblInputBackground.setBounds(430, 357, 615, 96);
		scansione.add(scanlblInputBackground);
		
		JButton scanbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		scanbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
			}
		});
		scanbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		scanbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setForeground(Color.BLACK);
		scanbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProblemiAssistenza.setContentAreaFilled(false);
		scanbtnProblemiAssistenza.setBorderPainted(false);
		scanbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		scansione.add(scanbtnProblemiAssistenza);
		
		JLabel scantxtBarcode = new JLabel();
		scantxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtBarcode.setText("Barcode:");
		scantxtBarcode.setBounds(426, 321, 619, 49);
		scantxtBarcode.setOpaque(false);
		scansione.add(scantxtBarcode);		
		
		JButton scanbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		scanbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
			}
		});
		
		scanbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setOpaque(false);
		scanbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		scanbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setForeground(Color.WHITE);
		scanbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnChiudiSessione.setContentAreaFilled(false);
		scanbtnChiudiSessione.setBorderPainted(false);
		scanbtnChiudiSessione.setBounds(416, 613, 629, 57);
		scansione.add(scanbtnChiudiSessione);
		
		//ISTRUZIONI CONFERIMENTO
		JLabel istrlblConferimentoProdotto = new JLabel("ISTRUZIONI CONFERIMENTO");
		istrlblConferimentoProdotto.setForeground(Color.BLACK);
		istrlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		istrlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		istruzioneConf.add(istrlblConferimentoProdotto);

		JButton istrbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.setVerticalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setHorizontalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
			}
		});
		istrbtnProblemiAssistenza.setOpaque(false);
		istrbtnProblemiAssistenza.setForeground(Color.BLACK);
		istrbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnProblemiAssistenza.setContentAreaFilled(false);
		istrbtnProblemiAssistenza.setBorderPainted(false);
		istrbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		istruzioneConf.add(istrbtnProblemiAssistenza);

		JButton istrbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
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
		istrlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
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
		JButton istrbtnNuovaScansione = new JButton("Nuova scansione", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		istrbtnNuovaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
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
		
		JButton istrbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		istrbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
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
		String newLine = System.getProperty("line.separator");
		
		JLabel lblPuntiprodotto = new JLabel("PuntiProdotto");
		lblPuntiprodotto.setBounds(679, 398, 124, 23);
		
		//CONFERIMENTO
		JLabel conflblScansioneProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		conflblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblScansioneProdotto.setForeground(Color.BLACK);
		conflblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		conflblScansioneProdotto.setBounds(416, 0, 629, 57);
		conferimento.add(conflblScansioneProdotto);		
		
		// prodotto errato		
		JButton confbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		confbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
			}
		});
		confbtnProdottoVisualizzatoErrato.setOpaque(false);
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setBounds(749, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoErrato);

		// prodotto corretto		
		JButton confbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		confbtnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(istruzioneConf);
				
				// prendo il valore dalla variabile globale				
				istrlblPunti.setText("Punti guadagnati: " + String.valueOf(prodottoScansionato.getPunti()));
				
				//DA AGGIUNGERE DESCRIZIONE
				istrlblDescrizione.setText(prodottoScansionato.getDescrizione());
			}

		});
		confbtnProdottoVisualizzatoCorretto.setOpaque(false);
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setBounds(470, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoCorretto);

//		JLabel conflblImmagineProdotto = new JLabel("immagine prodotto");
		conflblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblImmagineProdotto.setBounds(600, 84, 269, 257);
		conferimento.add(conflblImmagineProdotto);

		JLabel conflblLogo = new JLabel("");
		conflblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		conflblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		conflblLogo.setBounds(0, 0, 418, 488);
		conferimento.add(conflblLogo);
		
		JButton confbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		confbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(assistenza);
			}
		});
		confbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnProblemiAssistenza.setOpaque(false);
		confbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		confbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnProblemiAssistenza.setForeground(Color.BLACK);
		confbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProblemiAssistenza.setContentAreaFilled(false);
		confbtnProblemiAssistenza.setBorderPainted(false);
		confbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		conferimento.add(confbtnProblemiAssistenza);
		
		JButton confbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		confbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnInfo.setOpaque(false);
		confbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		confbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnInfo.setForeground(Color.BLACK);
		confbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnInfo.setContentAreaFilled(false);
		confbtnInfo.setBorderPainted(false);
		confbtnInfo.setBounds(0, 456, 418, 57);
		conferimento.add(confbtnInfo);		
		
		JButton confbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		confbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
			}
		});
		confbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnChiudiSessione.setOpaque(false);
		confbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		confbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnChiudiSessione.setForeground(Color.WHITE);
		confbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnChiudiSessione.setContentAreaFilled(false);
		confbtnChiudiSessione.setBorderPainted(false);
		confbtnChiudiSessione.setBounds(416, 613, 629, 57);
		conferimento.add(confbtnChiudiSessione);
		
		//ERRORE CONFERIMENTO
		JLabel errlblErroreProdotto = new JLabel("ERRORE PRODOTTO");
		errlblErroreProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErroreProdotto.setForeground(Color.BLACK);
		errlblErroreProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		errlblErroreProdotto.setBounds(416, 0, 629, 57);
		erroreConf.add(errlblErroreProdotto);
		
		JButton errbtnRitentaScansione = new JButton("Ritenta scansione", new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		errbtnRitentaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GuiMain.main(args);
				switchPanel(scansione);				
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
		
		JButton errbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		errbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
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
		
		
		JButton errbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
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
		errlblErrorImage.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/errorimage.png")));
		errlblErrorImage.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErrorImage.setHorizontalTextPosition(JLabel.CENTER);
		errlblErrorImage.setVerticalTextPosition(JLabel.BOTTOM);
		errlblErrorImage.setBounds(416, 128, 629, 309);
		erroreConf.add(errlblErrorImage);
		
		JLabel errlblLogo = new JLabel("");
		errlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
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
		
		JButton errbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		errbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
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
		
		//ASSISTENZA
		JLabel asslblAssistenza = new JLabel("ASSISTENZA");
		asslblAssistenza.setHorizontalAlignment(SwingConstants.CENTER);
		asslblAssistenza.setForeground(Color.BLACK);
		asslblAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		asslblAssistenza.setBounds(416, 0, 629, 57);
		assistenza.add(asslblAssistenza);
		
		JButton assbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
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
		asslblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
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
		
		JButton assbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/Gui/images/redbuttonSmall.png")));
		assbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
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
		
		JLabel background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/home.jpg")));
		contentPane.add(background);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain frame = new GuiMain();
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

