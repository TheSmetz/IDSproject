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

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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


	/**
	 * Create the frame.
	 */
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Gui/images/aaa.png")));
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
		
		JLabel lblBenvenuti = new JLabel("BENVENUTO");
		lblBenvenuti.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenuti.setForeground(Color.BLACK);
		lblBenvenuti.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblBenvenuti.setBounds(416, 0, 629, 57);
		homePanel.add(lblBenvenuti);
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblInfo.setBounds(0, 571, 418, 57);
		homePanel.add(lblInfo);
		
		
		JPanel scanPanel = new JPanel();
		layeredPane.add(scanPanel, "name_47730555398847");
		scanPanel.setOpaque(false);
		scanPanel.setLayout(null);
		
		JPanel gttPanel = new JPanel();
		layeredPane.add(gttPanel, "name_47764772881651");
		gttPanel.setOpaque(false);
		gttPanel.setLayout(null);
		
		JLabel lblGettareProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		lblGettareProdotto.setForeground(Color.BLACK);
		lblGettareProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblGettareProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblGettareProdotto.setBounds(416, 0, 629, 57);
		gttPanel.add(lblGettareProdotto);
		
		JLabel lblGettareProdottoNella = new JLabel("Gettare Prodotto nella bocchetta");
		lblGettareProdottoNella.setHorizontalAlignment(SwingConstants.CENTER);
		lblGettareProdottoNella.setForeground(Color.BLACK);
		lblGettareProdottoNella.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblGettareProdottoNella.setBounds(417, 221, 628, 57);
		gttPanel.add(lblGettareProdottoNella);
		
		JButton btnProblemiAssistenza = new JButton("Problemi? Assistenza");
		btnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProblemiAssistenza.setOpaque(false);
		btnProblemiAssistenza.setForeground(Color.WHITE);
		btnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProblemiAssistenza.setContentAreaFilled(false);
		btnProblemiAssistenza.setBorderPainted(false);
		btnProblemiAssistenza.setBounds(211, 482, 244, 57);
		gttPanel.add(btnProblemiAssistenza);
		
		JLabel label_6 = new JLabel("info");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_6.setBounds(0, 571, 418, 57);
		gttPanel.add(label_6);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/logo.png")));
		label_4.setBounds(0, 0, 418, 488);
		gttPanel.add(label_4);
		
		JLabel lblScansioneProdotto = new JLabel("SCANSIONE PRODOTTO");
		lblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblScansioneProdotto.setForeground(Color.BLACK);
		lblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblScansioneProdotto.setBounds(416, 0, 629, 57);
		scanPanel.add(lblScansioneProdotto);
		
		
		//prodotto corretto
		
		ImageIcon corretto = new ImageIcon(Main.class.getResource("/Gui/images/whitebutton.png"));
		JButton btnProdottoVisualizzatoCorretto = new JButton("Prodotto errato", corretto);
		btnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		btnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);		
		btnProdottoVisualizzatoCorretto.setBorderPainted(false);
		btnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		btnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		btnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		btnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		btnProdottoVisualizzatoCorretto.setOpaque(false);
		btnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		btnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		btnProdottoVisualizzatoCorretto.setBorderPainted(false);
		btnProdottoVisualizzatoCorretto.setBounds(417, 549, 628, 57);
		scanPanel.add(btnProdottoVisualizzatoCorretto);
		
		//errato
		ImageIcon errato = new ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png"));
		JButton btnProdottoVisualizzatoErrato = new JButton("Prodotto corretto", errato);
		btnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		btnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);		
		btnProdottoVisualizzatoErrato.setBorderPainted(false);
		btnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		btnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		btnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		btnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		btnProdottoVisualizzatoErrato.setOpaque(false);
		btnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		btnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		btnProdottoVisualizzatoErrato.setBorderPainted(false);
		btnProdottoVisualizzatoErrato.setBounds(417, 466, 628, 57);
		scanPanel.add(btnProdottoVisualizzatoErrato);
		
		JLabel label_2 = new JLabel("info");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_2.setBounds(0, 571, 418, 57);
		scanPanel.add(label_2);
		
		
		JLabel lblImmagineProdotto = new JLabel("immagine prodotto");
		lblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmagineProdotto.setBounds(600, 128, 269, 257);
		scanPanel.add(lblImmagineProdotto);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/logo.png")));
		label_3.setBounds(0, 0, 418, 488);
		scanPanel.add(label_3);
		
		
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
		
		//Avvia scansione
		ImageIcon scan_icon = new ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png"));
		JButton btnScansionaProdotto = new JButton("Avvia scansione", scan_icon);
		btnScansionaProdotto.setVerticalTextPosition(JButton.CENTER);
		btnScansionaProdotto.setHorizontalTextPosition(JButton.CENTER);
		
		btnScansionaProdotto.setBorderPainted(false);
		btnScansionaProdotto.setMargin(new Insets(0, 0, 0, 0));
		//btnScansionaProdotto.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/greenbutton.png")));
		btnScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnScansionaProdotto.setForeground(Color.BLACK);
		btnScansionaProdotto.setContentAreaFilled(false);
		btnScansionaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scanPanel);
				
//get image
				
				
				try {
					String host = "jdbc:mysql://localhost:3306/trash-it";	//database name
					String password = "";
					String username = "root";
					Connection con = DriverManager.getConnection(host, username, password);		//connessione

					Statement stmtProdotto = con.createStatement();
					String SQLProdotto = "SELECT * FROM prodotto WHERE nome = 'levissima 50cl'";
					ResultSet rsProdotto = stmtProdotto.executeQuery(SQLProdotto);
					
					//output
					System.out.println("\n----- PRODOTTO -----\n");
					while (rsProdotto.next()) {
						String br = rsProdotto.getString("barcode");
						//String descrizione_col = rsProdotti.getString("descrizione");
						System.out.println("Barcode: " + br);
						
						String desc = rsProdotto.getString("descrizione");
						//String descrizione_col = rsProdotti.getString("descrizione");
						System.out.println("Descrizione: " + desc);
						
						byte[] img = rsProdotto.getBytes("immagine");
						ImageIcon image = new ImageIcon(img);
						Image im = image.getImage();
						Image myImg = im.getScaledInstance(lblImmagineProdotto.getWidth(), lblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon newImage = new ImageIcon(myImg);
						lblImmagineProdotto.setIcon(newImage);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}			
			}
		});
		btnScansionaProdotto.setBounds(416, 212, 629, 96);
		homePanel.add(btnScansionaProdotto);
		
		JLabel logo_label = new JLabel("");
		logo_label.setHorizontalAlignment(SwingConstants.CENTER);
		logo_label.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/logo.png")));
		logo_label.setBounds(0, 0, 418, 488);
		homePanel.add(logo_label);
		
		JLabel lblScansionaProdotto = new JLabel("Scansione Prodotto");
		lblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblScansionaProdotto.setForeground(Color.BLACK);
		lblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		lblScansionaProdotto.setBounds(416, 97, 629, 57);
		homePanel.add(lblScansionaProdotto);
		
		JButton btnPanel3 = new JButton("GttProdotto");
		btnPanel3.setBounds(309, 13, 97, 25);
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		contentPane.add(btnPanel3);
		
		JLabel background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(Main.class.getResource("/Gui/images/home.jpg")));
		contentPane.add(background);
	}
}
