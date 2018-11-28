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

@SuppressWarnings("serial")
public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	//descrizione prodotto
	private String barcodeProdotto; //barcode
	private String nomeProdotto;	//nome
	private String descrizioneProdotto; //decrizione		
	private byte[] imgProdotto;	//immagine
	
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
	
	
	public void switchPanel (JPanel panelName) {
		
		layeredPane.removeAll();
		layeredPane.add(panelName);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public void searchDBProduct(String query) {
		try {
			String host = "jdbc:mysql://localhost:3306/trash-it";	//database name
			String password = "";
			String username = "root";
			Connection con = DriverManager.getConnection(host, username, password);		//connessione

			Statement stmtProdotto = con.createStatement();
			String SQLProdotto = query;	//"SELECT * FROM prodotto WHERE nome = 'igieneplus'"
			ResultSet rsProdotto = stmtProdotto.executeQuery(SQLProdotto);
				
			//output
			while (rsProdotto.next()) {
				barcodeProdotto = rsProdotto.getString("barcode");		
				nomeProdotto = rsProdotto.getString("nome");
				descrizioneProdotto = rsProdotto.getString("descrizione");
				imgProdotto = rsProdotto.getBytes("immagine");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
		
		JPanel homePanel = new JPanel();
		layeredPane.add(homePanel, "name_47697602642643");
		homePanel.setOpaque(false);
		homePanel.setLayout(null);
		
		
		//INIZIALIZZAZIONE PANEL
		
		//HOME PANEL
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
		
		
		//SCAN PANEL
		JPanel scanPanel = new JPanel();
		layeredPane.add(scanPanel, "name_47730555398847");
		scanPanel.setOpaque(false);
		scanPanel.setLayout(null);
		
		//GTT PANEL
		JPanel gttPanel = new JPanel();
		layeredPane.add(gttPanel, "name_47764772881651");
		gttPanel.setOpaque(false);
		gttPanel.setLayout(null);
		
		//BOTTONI NAVIGAZIONE SCHEDE (provvisori)
		JButton btnPanel1 = new JButton("HOME");
		btnPanel1.setBounds(60, 13, 97, 25);
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(homePanel);
			}
		});
		contentPane.add(btnPanel1);
		
		JButton btnPanel2 = new JButton("ScProdotto");
		btnPanel2.setBounds(189, 13, 97, 25);
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scanPanel);
			}
		});
		contentPane.add(btnPanel2);
		
		
		JButton btnPanel3 = new JButton("GttProdotto");
		btnPanel3.setBounds(309, 13, 97, 25);
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		contentPane.add(btnPanel3);
		
		
		
		//contenuti GTT
		JLabel gttlblConferimentoProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		gttlblConferimentoProdotto.setForeground(Color.BLACK);
		gttlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		gttlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		gttlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		gttPanel.add(gttlblConferimentoProdotto);
		
		JButton gttbtnProblemiAssistenza = new JButton("Problemi? Assistenza");
		gttbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		gttlblDescrizione.setBounds(416, 260, 629, 180);
		gttPanel.add(gttlblDescrizione);
		
		JTextPane gttTxtIstruzioni = new JTextPane();
		gttTxtIstruzioni.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gttTxtIstruzioni.setText("Gettare il prodotto nella bocchetta seguendo le istruzioni:");
		gttTxtIstruzioni.setBounds(416, 129, 629, 126);
		gttTxtIstruzioni.setOpaque(false);
		gttPanel.add(gttTxtIstruzioni);
		
		JLabel scanlblScansioneProdotto = new JLabel("SCANSIONE PRODOTTO");
		scanlblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansioneProdotto.setForeground(Color.BLACK);
		scanlblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblScansioneProdotto.setBounds(416, 0, 629, 57);
		scanPanel.add(scanlblScansioneProdotto);
		
		//contenuti SCAN
			//prodotto corretto
		
				ImageIcon corretto = new ImageIcon(GuiMain.class.getResource("/Gui/images/whitebutton.png"));
				JButton scanbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", corretto);
				scanbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
				scanbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);		
				scanbtnProdottoVisualizzatoErrato.setBorderPainted(false);
				scanbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
				scanbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
				scanbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
				scanbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
				scanbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switchPanel(gttPanel);
					}
				});
				scanbtnProdottoVisualizzatoErrato.setOpaque(false);
				scanbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
				scanbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
				scanbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
				scanbtnProdottoVisualizzatoErrato.setBorderPainted(false);
				scanbtnProdottoVisualizzatoErrato.setBounds(417, 549, 628, 57);
				scanPanel.add(scanbtnProdottoVisualizzatoErrato);
				
				//errato
				ImageIcon errato = new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbutton.png"));
				JButton scanbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", errato);
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
						//prendo il valore dalla variabile globale
						gttlblDescrizione.setText(descrizioneProdotto);
					}
							
				});
				scanbtnProdottoVisualizzatoCorretto.setOpaque(false);
				scanbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
				scanbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
				scanbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
				scanbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
				scanbtnProdottoVisualizzatoCorretto.setBounds(417, 466, 628, 57);
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
		
		
		
				//contenuti HOME
				
				//Avvia scansione
				ImageIcon scan_icon = new ImageIcon(GuiMain.class.getResource("/Gui/images/greenbutton.png"));
				JButton homebtnScansionaProdotto = new JButton("Avvia scansione", scan_icon);
				homebtnScansionaProdotto.setVerticalTextPosition(JButton.CENTER);
				homebtnScansionaProdotto.setHorizontalTextPosition(JButton.CENTER);
				
				homebtnScansionaProdotto.setBorderPainted(false);
				homebtnScansionaProdotto.setMargin(new Insets(0, 0, 0, 0));
				//btnScansionaProdotto.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png")));
				homebtnScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
				homebtnScansionaProdotto.setForeground(Color.BLACK);
				homebtnScansionaProdotto.setContentAreaFilled(false);
				homebtnScansionaProdotto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						switchPanel(scanPanel);
						
						//eseguo ricerca prodotto
						searchDBProduct("SELECT * FROM prodotto WHERE nome = 'igieneplus'");
						
						//output
						System.out.println("\n----- PRODOTTO -----\n");
						System.out.println("Barcode:"+barcodeProdotto);
						System.out.println("Nome:"+nomeProdotto);
						System.out.println("Descrizione:"+descrizioneProdotto);
						ImageIcon image = new ImageIcon(imgProdotto);
						Image im = image.getImage();
						Image myImg = im.getScaledInstance(scanlblImmagineProdotto.getWidth(), scanlblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon newImage = new ImageIcon(myImg);
						scanlblImmagineProdotto.setIcon(newImage);
																
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
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/home.jpg")));
		contentPane.add(background);
	}
}