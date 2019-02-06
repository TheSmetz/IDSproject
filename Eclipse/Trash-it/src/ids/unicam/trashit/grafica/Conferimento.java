package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.CestinoSmart;
import ids.unicam.trashit.console.Statistica;


public class Conferimento {

	private JPanel conferimento;
	private JLabel conflblScansioneProdotto;	
	private JButton confbtnProdottoVisualizzatoErrato;
	private JButton confbtnProdottoVisualizzatoCorretto;
	public static JLabel conflblImmagineProdotto;
	public static CestinoSmart cestinoSessione = new CestinoSmart();
	public static Statistica statisticaSessione;
	
	private void lblScansioneProdotto() {
		conflblScansioneProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		conflblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblScansioneProdotto.setForeground(Color.BLACK);
		conflblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		conflblScansioneProdotto.setBounds(416, 0, 629, 57);
		conferimento.add(conflblScansioneProdotto);	
	}

	private void btnProdottoVisualizzatoErrato() {
		confbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonSmall.png")));
		confbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestoreGrafica.switchPanel(GestoreGrafica.scansione.getJPanelScansione());
				GestoreGrafica.startTimer(30);
			}
		});
		confbtnProdottoVisualizzatoErrato.setOpaque(false);
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setBounds(749, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoErrato);
	}

	private void btnProdottoVisualizzatoCorretto() {
		confbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		confbtnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (Home.policySessione.isUtilizzoPunti()) {	//se la città prevede l'accredito lo faccio sulla tessera (se inserita)
					IstruzioniConferimento.istrlblPunti.setText("Punti Prodotto: " + Scansione.prodottoCorrente.getPunti());
					if (Scansione.tesseraLetta) {
						try {
							//guadagno punti
							Scansione.tesseraScansionata.accreditoPunti(Scansione.prodottoCorrente.getPunti(), true);
							//aggiorna statistica
							statisticaSessione = new Statistica(Scansione.prodottoCorrente.getcodiceABarre(), Scansione.tesseraScansionata.getIdTessera());
						} catch (IOException e1) {
							e1.printStackTrace();
						}						
					} else {
						statisticaSessione = new Statistica(Scansione.prodottoCorrente.getcodiceABarre(), "UNREGISTERED");
					}
				} else {
					IstruzioniConferimento.istrlblPunti.setText("L'area in cui ti trovi non prevede l'utilizzo dei punti");
					
				}
				
				IstruzioniConferimento.istrlblDescrizione.setText(Scansione.prodottoCorrente.getDescrizione());	//descrizione prodotto	
				GestoreGrafica.switchPanel(GestoreGrafica.istruzioniConferimento.getJPanelIstruzioni());
				GestoreGrafica.startTimer(30);
			}

		});
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
	
	public JButton getbtnProdottoVisualizzatoErrato() {
		return this.confbtnProdottoVisualizzatoErrato;
	}

	public JButton getbtnProdottoVisualizzatoCorretto() {
		return this.confbtnProdottoVisualizzatoCorretto;
	}
	

	public void setJPanelConferimento() {
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
		return conferimento;
	}
}