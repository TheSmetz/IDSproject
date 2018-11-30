package Gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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

@SuppressWarnings("serial")
public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	private boolean connectionFail = false; // se c'è un errore con la connessione, gestisco errore visualizzazione
											// prodotto

	// descrizione prodotto
	private String barcodeProdotto; // barcode
	private String nomeProdotto; // nome
	private String descrizioneProdotto; // decrizione
	private byte[] imgProdotto; // immagine
	protected String[] args;
	private JTextField hometxtInputBarcode;	//input barcode

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
	

	public void searchDBProduct(String barcodeQuery) {
		try {
			String host = "jdbc:mysql://localhost:3306/trash-it"; // database name
			String password = "";
			String username = "root";
			Connection con = DriverManager.getConnection(host, username, password); // connessione

			Statement stmtProdotto = con.createStatement();
			String SQLProdotto = "SELECT * FROM prodotto WHERE barcode = "+barcodeQuery; // "SELECT * FROM prodotto WHERE nome = 'igieneplus'"
			ResultSet rsProdotto = stmtProdotto.executeQuery(SQLProdotto);

			// output
			while (rsProdotto.next()) {
				barcodeProdotto = rsProdotto.getString("barcode");
				nomeProdotto = rsProdotto.getString("nome");
				descrizioneProdotto = rsProdotto.getString("descrizione");
				imgProdotto = rsProdotto.getBytes("immagine");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connectionFail = true; // se la connessione non funziona
			System.out.println(e.getMessage());
			System.out.println("\nFailed to Connect to Trash-it DataBase");

		}
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
		layeredPane.setBounds(0, 51, 1045, 683);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		// INIZIALIZZAZIONE PANEL

		// HOME PANEL
		JPanel homePanel = new JPanel();
		layeredPane.add(homePanel, "name_47697602642643");
		homePanel.setOpaque(false);
		homePanel.setLayout(null);
		
		JLabel homelblBenvenuto = new JLabel("BENVENUTO");
		homelblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblBenvenuto.setForeground(Color.BLACK);
		homelblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblBenvenuto.setBounds(416, 0, 629, 57);
		homePanel.add(homelblBenvenuto);

		JLabel homelblInfo = new JLabel("info");
		homelblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblInfo.setForeground(Color.BLACK);
		homelblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblInfo.setBounds(0, 571, 418, 57);
		homePanel.add(homelblInfo);
		
		//ERROR PANEL
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(null);
		errorPanel.setOpaque(false);
		layeredPane.add(errorPanel, "name_2585705284100");
		
		JLabel errlblErroreProdotto = new JLabel("ERRORE PRODOTTO");
		errlblErroreProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErroreProdotto.setForeground(Color.BLACK);
		errlblErroreProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		errlblErroreProdotto.setBounds(416, 0, 629, 57);
		errorPanel.add(errlblErroreProdotto);
		
		JButton errbtnTornaIndietro = new JButton("Ritenta scansione", new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		errbtnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GuiMain.main(args);
				switchPanel(homePanel);				
			}
		});
		errbtnTornaIndietro.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnTornaIndietro.setOpaque(false);
		errbtnTornaIndietro.setMargin(new Insets(0, 0, 0, 0));
		errbtnTornaIndietro.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnTornaIndietro.setForeground(Color.BLACK);
		errbtnTornaIndietro.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnTornaIndietro.setContentAreaFilled(false);
		errbtnTornaIndietro.setBorderPainted(false);
		errbtnTornaIndietro.setBounds(417, 549, 628, 57);
		errorPanel.add(errbtnTornaIndietro);
		
		JLabel errInfo = new JLabel("info");
		errInfo.setHorizontalAlignment(SwingConstants.CENTER);
		errInfo.setForeground(Color.BLACK);
		errInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		errInfo.setBounds(0, 571, 418, 57);
		errorPanel.add(errInfo);
		
		JLabel errlblErrorImage = new JLabel("Image Not Found");
		errlblErrorImage.setFont(new Font("Tahoma", Font.BOLD, 20));
		errlblErrorImage.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/errorimage.png")));
		errlblErrorImage.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErrorImage.setHorizontalTextPosition(JLabel.CENTER);
		errlblErrorImage.setVerticalTextPosition(JLabel.BOTTOM);
		errlblErrorImage.setBounds(416, 128, 629, 309);
		errorPanel.add(errlblErrorImage);
		
		JLabel errlblLogo = new JLabel("");
		errlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		errlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		errlblLogo.setBounds(0, 0, 418, 488);
		errorPanel.add(errlblLogo);
		
		JTextPane errtxtpnNonStato = new JTextPane();
		errtxtpnNonStato.setEditable(false);
		errtxtpnNonStato.setFont(new Font("Tahoma", Font.PLAIN, 25));		
		//allign center
		SimpleAttributeSet centerText = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerText, StyleConstants.ALIGN_CENTER);
		StyledDocument doc = errtxtpnNonStato.getStyledDocument();
		doc.setParagraphAttributes(0, 104, centerText, false);
		errtxtpnNonStato.setOpaque(false);
		errtxtpnNonStato.setText("Non \u00E8 stato possibile recuperare l'immagine del prodotto");
		errtxtpnNonStato.setBounds(416, 86, 629, 73);
		errorPanel.add(errtxtpnNonStato);

		// SCAN PANEL
		JPanel scanPanel = new JPanel();
		layeredPane.add(scanPanel, "name_47730555398847");
		scanPanel.setOpaque(false);
		scanPanel.setLayout(null);
		
		//ASSISTENZA PANEL
		JPanel assPanel = new JPanel();
		assPanel.setLayout(null);
		assPanel.setOpaque(false);
		layeredPane.add(assPanel, "name_8556421918800");
		

		// GTT PANEL
		JPanel gttPanel = new JPanel();
		layeredPane.add(gttPanel, "name_47764772881651");
		gttPanel.setOpaque(false);
		gttPanel.setLayout(null);

		// BOTTONI NAVIGAZIONE SCHEDE (provvisori)
		JButton btnPanel1 = new JButton("HOME");
		btnPanel1.setBackground(Color.WHITE);
		btnPanel1.setForeground(Color.BLACK);
		btnPanel1.setBounds(60, 13, 97, 25);
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(homePanel);
			}
		});
		contentPane.add(btnPanel1);

		JButton btnPanel2 = new JButton("ScProdotto");
		btnPanel2.setBackground(Color.WHITE);
		btnPanel2.setForeground(Color.BLACK);
		btnPanel2.setBounds(189, 13, 97, 25);
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scanPanel);
			}
		});
		contentPane.add(btnPanel2);

		JButton btnPanel3 = new JButton("GttProdotto");
		btnPanel3.setBackground(Color.WHITE);
		btnPanel3.setForeground(Color.BLACK);
		btnPanel3.setBounds(309, 13, 97, 25);
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		contentPane.add(btnPanel3);
		
		JButton btnAsspanel = new JButton("AssPanel");
		btnAsspanel.setBackground(Color.WHITE);
		btnAsspanel.setForeground(Color.BLACK);
		btnAsspanel.setBounds(440, 13, 97, 25);
		btnAsspanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assPanel);				
			}
		});
		contentPane.add(btnAsspanel);
		
		
		
		// contenuti GTT
		JLabel gttlblConferimentoProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		gttlblConferimentoProdotto.setForeground(Color.BLACK);
		gttlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		gttlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		gttPanel.add(gttlblConferimentoProdotto);

		JButton gttbtnProblemiAssistenza = new JButton("Problemi? Assistenza");
		gttbtnProblemiAssistenza.setVerticalTextPosition(JButton.CENTER);
		gttbtnProblemiAssistenza.setHorizontalTextPosition(JButton.CENTER);
		gttbtnProblemiAssistenza.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		gttbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assPanel);
			}
		});
		gttbtnProblemiAssistenza.setOpaque(false);
		gttbtnProblemiAssistenza.setForeground(Color.BLACK);
		gttbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		gttbtnProblemiAssistenza.setContentAreaFilled(false);
		gttbtnProblemiAssistenza.setBorderPainted(false);
		gttbtnProblemiAssistenza.setBounds(416, 613, 629, 57);
		gttPanel.add(gttbtnProblemiAssistenza);

		JLabel gttlblInfo = new JLabel("info");
		gttlblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblInfo.setForeground(Color.BLACK);
		gttlblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		gttlblInfo.setBounds(0, 571, 418, 57);
		gttPanel.add(gttlblInfo);

		JLabel gttlblLogo = new JLabel("");
		gttlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		gttlblLogo.setBounds(0, 0, 418, 488);
		gttPanel.add(gttlblLogo);

		JLabel gttlblDescrizione = new JLabel("descrizione prodotto");
		gttlblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gttlblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblDescrizione.setBounds(416, 336, 629, 180);
		gttPanel.add(gttlblDescrizione);

		JTextPane gttTxtIstruzioni = new JTextPane();
		gttTxtIstruzioni.setEditable(false);
		gttTxtIstruzioni.setFont(new Font("Tahoma", Font.PLAIN, 25));		
		//allign center
		SimpleAttributeSet centerIstruzioni = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerIstruzioni, StyleConstants.ALIGN_CENTER);
		StyledDocument docIstruzioni = gttTxtIstruzioni.getStyledDocument();
		docIstruzioni.setParagraphAttributes(0, 104, centerIstruzioni, false);
		gttTxtIstruzioni.setOpaque(false);
		gttTxtIstruzioni.setText("Non \u00E8 stato possibile recuperare l'immagine del prodotto");
		gttTxtIstruzioni.setBounds(416, 86, 629, 73);
		gttPanel.add(gttTxtIstruzioni);
		
		JLabel gttlblImmagineProdotto = new JLabel("immagine prodotto");
		gttlblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblImmagineProdotto.setBounds(600, 128, 269, 257);
		gttPanel.add(gttlblImmagineProdotto);
		
		
		//contenuti assistenza
		JLabel lblAssistenza = new JLabel("ASSISTENZA");
		lblAssistenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssistenza.setForeground(Color.BLACK);
		lblAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblAssistenza.setBounds(416, 0, 629, 57);
		assPanel.add(lblAssistenza);
				
		JLabel label_1 = new JLabel("info");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_1.setBounds(0, 571, 418, 57);
		assPanel.add(label_1);
				
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 418, 488);
		assPanel.add(label_2);
				
		JTextPane txtpnTel = new JTextPane();
		txtpnTel.setEditable(false);
		txtpnTel.setText("Telefono:");
		String newLine = System.getProperty("line.separator");    
		txtpnTel.setText(txtpnTel.getText() + newLine + "Email:");
		txtpnTel.setOpaque(false);
		txtpnTel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtpnTel.setBounds(416, 86, 629, 73);
		//allign center
		SimpleAttributeSet centerAss = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerAss, StyleConstants.ALIGN_CENTER);
		StyledDocument docAss = txtpnTel.getStyledDocument();
		docAss.setParagraphAttributes(0, 104, centerAss, false);
		assPanel.add(txtpnTel);


		// contenuti SCAN
		JLabel scanlblScansioneProdotto = new JLabel("SCANSIONE PRODOTTO");
		scanlblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansioneProdotto.setForeground(Color.BLACK);
		scanlblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblScansioneProdotto.setBounds(416, 0, 629, 57);
		scanPanel.add(scanlblScansioneProdotto);
		
		
		// prodotto errato

		
		JButton scanbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		scanbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		scanbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);
		scanbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		scanbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		scanbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		scanbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		scanbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(homePanel);
			}
		});
		scanbtnProdottoVisualizzatoErrato.setOpaque(false);
		scanbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		scanbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		scanbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		scanbtnProdottoVisualizzatoErrato.setBounds(749, 449, 255, 57);
		scanPanel.add(scanbtnProdottoVisualizzatoErrato);

		// prodotto corretto
		
		JButton scanbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		scanbtnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		scanbtnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);
		scanbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		scanbtnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		scanbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		scanbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		scanbtnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
				// prendo il valore dalla variabile globale
				gttlblDescrizione.setText(descrizioneProdotto);
				gttPanel.remove(gttTxtIstruzioni);
			}

		});
		scanbtnProdottoVisualizzatoCorretto.setOpaque(false);
		scanbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		scanbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		scanbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		scanbtnProdottoVisualizzatoCorretto.setBounds(470, 449, 255, 57);
		scanPanel.add(scanbtnProdottoVisualizzatoCorretto);

		JLabel scanlblInfo = new JLabel("info");
		scanlblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInfo.setForeground(Color.BLACK);
		scanlblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblInfo.setBounds(0, 571, 418, 57);
		scanPanel.add(scanlblInfo);

		JLabel scanlblImmagineProdotto = new JLabel("immagine prodotto");
		scanlblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblImmagineProdotto.setBounds(600, 128, 269, 257);
		scanPanel.add(scanlblImmagineProdotto);

		JLabel scanlblLogo = new JLabel("");
		scanlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		scanlblLogo.setBounds(0, 0, 418, 488);
		scanPanel.add(scanlblLogo);
		
		JButton btnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebuttonSmall.png")));
		btnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(assPanel);
			}
		});
		btnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		btnProblemiAssistenza.setOpaque(false);
		btnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		btnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProblemiAssistenza.setForeground(Color.BLACK);
		btnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProblemiAssistenza.setContentAreaFilled(false);
		btnProblemiAssistenza.setBorderPainted(false);
		btnProblemiAssistenza.setBounds(416, 613, 628, 57);
		scanPanel.add(btnProblemiAssistenza);

		// contenuti HOME

		// Avvia scansione
		
		JButton homebtnScansionaProdotto = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbuttonSmall.png")));
		homebtnScansionaProdotto.setVerticalTextPosition(JButton.CENTER);
		homebtnScansionaProdotto.setHorizontalTextPosition(JButton.CENTER);
		homebtnScansionaProdotto.setBorderPainted(false);
		homebtnScansionaProdotto.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png")));
		homebtnScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnScansionaProdotto.setForeground(Color.BLACK);
		homebtnScansionaProdotto.setContentAreaFilled(false);
		homebtnScansionaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//leggo il barcode in input
				barcodeProdotto = hometxtInputBarcode.getText();
				
				//verifico che sia un barcode della forma corretta
				verifyBarcode(barcodeProdotto);
				
				//8029241107035	igiene plus
				//4006381115575 stabilo
				//8001050026066 levissima
				
				// eseguo ricerca prodotto
				searchDBProduct(barcodeProdotto);
				
				switchPanel(scanPanel);

				// output
				if (connectionFail == false && verifyBarcode(barcodeProdotto)) {
					System.out.println("\n----- PRODOTTO -----\n");
					System.out.println("Barcode:" + barcodeProdotto);
					System.out.println("Nome:" + nomeProdotto);
					System.out.println("Descrizione:" + descrizioneProdotto);
					ImageIcon image = new ImageIcon(imgProdotto);
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(scanlblImmagineProdotto.getWidth(),
					scanlblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newImage = new ImageIcon(myImg);
					scanlblImmagineProdotto.setIcon(newImage);
					gttlblImmagineProdotto.setIcon(newImage);
					
				} else {
					System.out.println("\nNon e' stato possibile ottenere il prodotto"); //connectionFail == true
					
					//pannello di errore
					switchPanel(errorPanel);
				}

			}
		});
		homebtnScansionaProdotto.setBounds(416, 212, 629, 96);
		homePanel.add(homebtnScansionaProdotto);

		JLabel homelblLogo = new JLabel("");
		homelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		homelblLogo.setBounds(0, 0, 418, 488);
		homePanel.add(homelblLogo);

		JLabel homelblScansionaProdotto = new JLabel("Scansione Prodotto");
		homelblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblScansionaProdotto.setForeground(Color.BLACK);
		homelblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		homelblScansionaProdotto.setBounds(416, 97, 629, 57);
		homePanel.add(homelblScansionaProdotto);
		
		hometxtInputBarcode = new JTextField();
		hometxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		hometxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hometxtInputBarcode.setBounds(595, 321, 272, 44);
		hometxtInputBarcode.setOpaque(false);
		homePanel.add(hometxtInputBarcode);
		hometxtInputBarcode.setColumns(10);
		
		JLabel homeInputBackground = new JLabel("");
		homeInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		homeInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebutton.png")));
		homeInputBackground.setBounds(426, 295, 607, 96);
		homePanel.add(homeInputBackground);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/home.jpg")));
		contentPane.add(background);
	}
}
