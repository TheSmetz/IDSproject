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

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

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


	/**
	 * Create the frame.
	 */
	public GuiMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/Gui/images/icon.png")));
		setTitle("Trash-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(59, 51, 1183, 658);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = new JPanel();
		layeredPane.add(homePanel, "name_47697602642643");
		homePanel.setOpaque(false);
		homePanel.setLayout(null);
		
		JLabel lblBenvenuti = new JLabel("BENVENUTO");
		lblBenvenuti.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenuti.setForeground(Color.WHITE);
		lblBenvenuti.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblBenvenuti.setBounds(0, 50, 710, 57);
		homePanel.add(lblBenvenuti);
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblInfo.setBounds(926, 565, 73, 57);
		homePanel.add(lblInfo);
		
		JLabel lblTrashit = new JLabel("TRASH-IT");
		lblTrashit.setForeground(Color.WHITE);
		lblTrashit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblTrashit.setBounds(874, 50, 183, 57);
		homePanel.add(lblTrashit);
		
		
		JPanel scanPanel = new JPanel();
		layeredPane.add(scanPanel, "name_47730555398847");
		scanPanel.setOpaque(false);
		scanPanel.setLayout(null);
		
		JPanel gttPanel = new JPanel();
		layeredPane.add(gttPanel, "name_47764772881651");
		gttPanel.setOpaque(false);
		gttPanel.setLayout(null);
		
		JLabel lblGettareProdotto = new JLabel("GETTARE PRODOTTO");
		lblGettareProdotto.setForeground(Color.WHITE);
		lblGettareProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblGettareProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblGettareProdotto.setBounds(0, 50, 710, 57);
		gttPanel.add(lblGettareProdotto);
		
		JLabel lblGettareProdottoNella = new JLabel("Gettare Prodotto nella bocchetta");
		lblGettareProdottoNella.setForeground(Color.WHITE);
		lblGettareProdottoNella.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblGettareProdottoNella.setBounds(155, 221, 399, 57);
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
		
		JLabel label_5 = new JLabel("TRASH-IT");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_5.setBounds(874, 50, 183, 57);
		gttPanel.add(label_5);
		
		JLabel label_6 = new JLabel("info");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_6.setBounds(926, 565, 73, 57);
		gttPanel.add(label_6);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		label_4.setBounds(760, 117, 397, 414);
		gttPanel.add(label_4);
		
		JLabel lblScansioneProdotto = new JLabel("SCANSIONE PRODOTTO");
		lblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblScansioneProdotto.setForeground(Color.WHITE);
		lblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblScansioneProdotto.setBounds(0, 50, 710, 57);
		scanPanel.add(lblScansioneProdotto);
		
		JButton btnProdottoVisualizzatoCorretto = new JButton("SI");
		btnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		btnProdottoVisualizzatoCorretto.setOpaque(false);
		btnProdottoVisualizzatoCorretto.setForeground(Color.WHITE);
		btnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		btnProdottoVisualizzatoCorretto.setBorderPainted(false);
		btnProdottoVisualizzatoCorretto.setBounds(220, 543, 79, 57);
		scanPanel.add(btnProdottoVisualizzatoCorretto);
		
		JLabel label_1 = new JLabel("TRASH-IT");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_1.setBounds(874, 50, 183, 57);
		scanPanel.add(label_1);
		
		JLabel label_2 = new JLabel("info");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_2.setBounds(926, 565, 73, 57);
		scanPanel.add(label_2);
		
		JButton btnNo = new JButton("NO");
		btnNo.setOpaque(false);
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnNo.setContentAreaFilled(false);
		btnNo.setBorderPainted(false);
		btnNo.setBounds(355, 543, 79, 57);
		scanPanel.add(btnNo);
		
		JLabel lblProdottoScansionatoCorretto = new JLabel("Il prodotto scansionato \u00E8 corretto?");
		lblProdottoScansionatoCorretto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdottoScansionatoCorretto.setForeground(Color.WHITE);
		lblProdottoScansionatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblProdottoScansionatoCorretto.setBounds(0, 215, 711, 57);
		scanPanel.add(lblProdottoScansionatoCorretto);
		
		JLabel lblImmagineProdotto = new JLabel("immagine prodotto");
		lblImmagineProdotto.setBounds(220, 215, 269, 257);
		scanPanel.add(lblImmagineProdotto);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		label_3.setBounds(760, 117, 397, 414);
		scanPanel.add(label_3);
		
		JButton btnGetImg = new JButton("get IMG");
		btnGetImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnGetImg.setBounds(39, 312, 97, 25);
		scanPanel.add(btnGetImg);
		
		
		JButton btnPanel1 = new JButton("HOME");
		btnPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(homePanel);
			}
		});
		btnPanel1.setBounds(60, 13, 97, 25);
		contentPane.add(btnPanel1);
		
		JButton btnPanel2 = new JButton("ScProdotto");
		btnPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scanPanel);
			}
		});
		btnPanel2.setBounds(189, 13, 97, 25);
		contentPane.add(btnPanel2);
		
		//
		JButton btnScansionaProdotto = new JButton("");
		btnScansionaProdotto.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/scanner.png")));
		btnScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnScansionaProdotto.setForeground(Color.WHITE);
		//seguenti tre lineee per impostare JButton trasparente
		btnScansionaProdotto.setOpaque(false);
		btnScansionaProdotto.setContentAreaFilled(false);
		btnScansionaProdotto.setBorderPainted(false);
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
					String SQLProdotto = "SELECT * FROM prodotto WHERE barcode = '4006381115575'";
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
		btnScansionaProdotto.setBounds(273, 350, 135, 96);
		homePanel.add(btnScansionaProdotto);
		
		JLabel logo_label = new JLabel("");
		logo_label.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/logo.png")));
		logo_label.setBounds(760, 117, 397, 414);
		homePanel.add(logo_label);
		
		JLabel lblScansionaProdotto = new JLabel("Scansiona Prodotto");
		lblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		lblScansionaProdotto.setForeground(Color.WHITE);
		lblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		lblScansionaProdotto.setBounds(0, 222, 710, 57);
		homePanel.add(lblScansionaProdotto);
		
		JButton btnPanel3 = new JButton("GttProdotto");
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		btnPanel3.setBounds(309, 13, 97, 25);
		contentPane.add(btnPanel3);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/Gui/images/home.jpg")));
		background.setBounds(0, -19, 1297, 766);
		contentPane.add(background);
	}
}
