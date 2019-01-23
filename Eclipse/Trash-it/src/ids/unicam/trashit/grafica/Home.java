package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import ids.unicam.trashit.start.Start;

public class Home extends JPanel implements ActionListener{
	
	//COMPONENTI
	public static JPanel contentPane;
//	public static JLayeredPane layeredPane;
	public static JPanel home;
	JLabel homelblBenvenuto;
	JLabel homelblSelezionaOperazione;
	JButton homebtnScansione;
	JButton homebtnRitiroPremio;
	public static  JButton homebtnProblemiAssistenza;
	public static  JButton homebtnInfo;
	public static  JLabel homelblLogo;
	JButton homebtnCreaTessera;
	JLabel homelblSeiNuovo;
	public static JButton homebtnChiudiSessione;
	
//	public static ActionListener action;
	
//	public void listnerHome() {
//		action = new ActionListener() {			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(e.getSource() == homebtnScansione) {
//					System.out.println("BELLAAAAAA");
//				}
//			}
//		};
//	}

	
	private void setjPanel() {
		home = new JPanel();
		home.setOpaque(false);
		home.setLayout(null);
	}

	private void lblSelezionaOperazione() {
		homelblBenvenuto = new JLabel("BENVENUTO");
		homelblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblBenvenuto.setForeground(Color.BLACK);
		homelblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblBenvenuto.setBounds(416, 0, 629, 57);
		home.add(homelblBenvenuto);
	}
	
	private void btnScansione() {
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
				
			//	ScansionaProdotto h = new ScansionaProdotto();
				
			//	h.setVisible(true);
				
//				switchPanel(scansione);
//				seconds = 30;
//			}
//		});
		homebtnScansione.addActionListener(this);
		home.add(homebtnScansione);
	}
	
	private void btnRitiroPremio() {
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
		}
	
	public static void btnProblemiAssistenza(JPanel wherePanel) {
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
		wherePanel.add(homebtnProblemiAssistenza);
	}
	
	public static void btnInfo(JPanel wherePanel) {
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
		wherePanel.add(homebtnInfo);
	}
	
	public static void lblLogo(JPanel wherePanel) {
		homelblLogo = new JLabel("");
		homelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		homelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblLogo.setBounds(0, 0, 418, 488);
		wherePanel.add(homelblLogo);
	}
	
	public static void btnChiudiSessione(JPanel wherePanel) {
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
		wherePanel.add(homebtnChiudiSessione);
	}
	
	private void btnCreaTessera() {

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
	}
	
	private void lblSeiNuovo() {
		homelblSeiNuovo = new JLabel("Sei nuovo in Trash-it? Crea la tua tessera");
		homelblSeiNuovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		homelblSeiNuovo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSeiNuovo.setBounds(416, 400, 629, 40);
		home.add(homelblSeiNuovo);
	}

	private void creaAllLbl() {
		lblSelezionaOperazione();
		lblLogo(home);
		lblSeiNuovo();
		
	}

	private void creaAllBtn() {
		btnChiudiSessione(home);
		btnCreaTessera();
		btnScansione();
		btnRitiroPremio();
		btnProblemiAssistenza(home);	
		btnInfo(home);	
	}
	
	public void creaPanelHome() {
		setjPanel();
		creaAllBtn();
		creaAllLbl();	
		//listnerHome();
	}
	
	public JPanel getPanelHome() {
		creaPanelHome();
		return home;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homebtnScansione) {
			Start.switchPanel(Scansione.scansione);
		}else if (e.getSource() == homebtnChiudiSessione) {
			Start.switchPanel(Scansione.scansione);
		}
		
	}

}