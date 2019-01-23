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
	
	JLabel conflblImmagineProdotto;
	JLabel conflblScansioneProdotto;
	JButton confbtnProdottoVisualizzatoErrato;
	JButton confbtnProdottoVisualizzatoCorretto;
	JLabel conflblLogo;	
	JButton confbtnProblemiAssistenza;	
	JButton confbtnInfo;		
	JButton confbtnChiudiSessione;

	
	private void setJPanelConferimento() {
		conferimento = new JPanel();
		conferimento.setOpaque(false);
		conferimento.setLayout(null);
	}
	
	private void lblScansioneProdotto() {
		conflblScansioneProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		conflblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblScansioneProdotto.setForeground(Color.BLACK);
		conflblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		conflblScansioneProdotto.setBounds(416, 0, 629, 57);
		conferimento.add(conflblScansioneProdotto);
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
	
	private void lblImmagineProdotto() {
		conflblImmagineProdotto = new JLabel("immagine prodotto");
		conflblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblImmagineProdotto.setBounds(600, 84, 269, 257);
		conferimento.add(conflblImmagineProdotto);
	}

	private void btnProblemiAssistenza() {
		confbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		confbtnProblemiAssistenza.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanel(assistenza);
//				seconds = 30;
//			}
//		});
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
	}

	private void btnInfo() {
		confbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
//		confbtnInfo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanel(about);
//				seconds = 30;
//			}
//		});
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
	}

	private void btnChiudiSessione() {
		confbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
//		confbtnChiudiSessione.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				switchPanel(sessione);
//				timer.stop();
//			}
//		});
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
	}
	
	
	public JPanel getJPanelConferimento() {
		setJPanelConferimento();
		lblScansioneProdotto();
		btnProdottoVisualizzatoErrato();
		btnProdottoVisualizzatoCorretto();
		lblImmagineProdotto();
		Home.lblLogo(conferimento);
		btnProblemiAssistenza();		
		btnInfo();		
		btnChiudiSessione();	
		return conferimento;
	}	
}