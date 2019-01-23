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

public class Conferimento extends JPanel {

	JPanel conferimento;
	JLabel conflblScansioneProdotto;	
	JButton confbtnProdottoVisualizzatoErrato;
	JButton confbtnProdottoVisualizzatoCorretto;
	JLabel conflblImmagineProdotto;
	JLabel conflblLogo;
	JButton confbtnProblemiAssistenza;	
	JButton confbtnInfo;			
	JButton confbtnChiudiSessione;
	
	private void lblScansioneProdotto() {
		conflblScansioneProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		conflblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblScansioneProdotto.setForeground(Color.BLACK);
		conflblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		conflblScansioneProdotto.setBounds(416, 0, 629, 57);
		conferimento.add(conflblScansioneProdotto);	
	}

	private void btnProdottoVisualizzatoErrato() {
		confbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonSmall.png")));
		confbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
//		confbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(scansione);
//				seconds = 30;
//			}
//		});
		confbtnProdottoVisualizzatoErrato.setOpaque(false);
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setBounds(749, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoErrato);
	}

	private void btnProdottoVisualizzatoCorretto() {
		confbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		confbtnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
//		confbtnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(istruzioneConf);
//				seconds = 30;
//				
//				// prendo il valore dalla variabile globale				
//				istrlblPunti.setText("Punti guadagnati: " + String.valueOf(prodottoScansionato.getPunti()));
//				
//				//DA AGGIUNGERE DESCRIZIONE
//				istrlblDescrizione.setText(prodottoScansionato.getDescrizione());
//			}
//
//		});
		confbtnProdottoVisualizzatoCorretto.setOpaque(false);
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setBounds(470, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoCorretto);
	}

	private void lblImmagineProdotto() {
		conflblImmagineProdotto = new JLabel("immagine prodotto");
		conflblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblImmagineProdotto.setBounds(600, 84, 269, 257);
		conferimento.add(conflblImmagineProdotto);
	}
	
	//da fare metodo set immagine prodotto da database
	
	private void setJPanelConferimento() {
		conferimento = new JPanel();
		conferimento.setOpaque(false);
		conferimento.setLayout(null);
		lblScansioneProdotto();		
		btnProdottoVisualizzatoErrato();			
		btnProdottoVisualizzatoCorretto();		
		lblImmagineProdotto();
		Home.lblLogo(conferimento);
		Home.btnProblemiAssistenza(conferimento);
		Home.btnInfo(conferimento);
		Home.btnChiudiSessione(conferimento);	
	}
	
	public JPanel getJPanelConferimento() {
		setJPanelConferimento();		
		return this.conferimento;
	}
}