package Gui;
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
import javax.swing.ImageIcon;
import java.awt.Color;

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
		lblBenvenuti.setForeground(Color.WHITE);
		lblBenvenuti.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblBenvenuti.setBounds(251, 117, 183, 57);
		homePanel.add(lblBenvenuti);
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblInfo.setBounds(924, 566, 73, 57);
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
		lblGettareProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblGettareProdotto.setBounds(178, 119, 359, 57);
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
		label_5.setBounds(872, 52, 183, 57);
		gttPanel.add(label_5);
		
		JLabel label_6 = new JLabel("info");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_6.setBounds(922, 568, 73, 57);
		gttPanel.add(label_6);
		
		JLabel lblScansioneProdotto = new JLabel("SCANSIONE PRODOTTO");
		lblScansioneProdotto.setForeground(Color.WHITE);
		lblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblScansioneProdotto.setBounds(149, 113, 359, 57);
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
		btnProdottoVisualizzatoCorretto.setBounds(220, 483, 79, 57);
		scanPanel.add(btnProdottoVisualizzatoCorretto);
		
		JLabel label_1 = new JLabel("TRASH-IT");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_1.setBounds(866, 46, 183, 57);
		scanPanel.add(label_1);
		
		JLabel label_2 = new JLabel("info");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		label_2.setBounds(916, 562, 73, 57);
		scanPanel.add(label_2);
		
		JButton btnNo = new JButton("NO");
		btnNo.setOpaque(false);
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnNo.setContentAreaFilled(false);
		btnNo.setBorderPainted(false);
		btnNo.setBounds(355, 483, 79, 57);
		scanPanel.add(btnNo);
		
		JLabel lblProdottoScansionatoCorretto = new JLabel("Prodotto scansionato corretto?");
		lblProdottoScansionatoCorretto.setForeground(Color.WHITE);
		lblProdottoScansionatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblProdottoScansionatoCorretto.setBounds(149, 215, 359, 57);
		scanPanel.add(lblProdottoScansionatoCorretto);
		
		JLabel lblImmagineProdotto = new JLabel("immagine prodotto");
		lblImmagineProdotto.setBounds(267, 312, 222, 160);
		scanPanel.add(lblImmagineProdotto);
		
		
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
		JButton btnScansionaProdotto = new JButton("Scansiona Prodotto");
		btnScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnScansionaProdotto.setForeground(Color.WHITE);
		//seguenti tre lineee per impostare JButton trasparente
		btnScansionaProdotto.setOpaque(false);
		btnScansionaProdotto.setContentAreaFilled(false);
		btnScansionaProdotto.setBorderPainted(false);
		btnScansionaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scanPanel);
			}
		});
		btnScansionaProdotto.setBounds(224, 286, 242, 57);
		homePanel.add(btnScansionaProdotto);
		
		JButton btnPanel3 = new JButton("GttProdotto");
		btnPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(gttPanel);
			}
		});
		btnPanel3.setBounds(309, 13, 97, 25);
		contentPane.add(btnPanel3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/images/home.jpg")));
		lblNewLabel.setBounds(0, -19, 1297, 766);
		contentPane.add(lblNewLabel);
	}
}
