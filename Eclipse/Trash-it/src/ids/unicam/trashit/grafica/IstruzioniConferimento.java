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

public class IstruzioniConferimento{
	public static JPanel istruzioneConf;
	private JLabel istrlblConferimentoProdotto;
	private JButton istrbtnNuovaScansione;
	private JLabel istrlblDescrizione;
	private JLabel istrlblPunti;
	private Home h;
	private Scansione s;
	

	private void btnNuovaScansione() {
		 istrbtnNuovaScansione = new JButton("Nuova scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		 istrbtnNuovaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				switchPanel(scansione);
//				seconds = 30;
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
		
	}

	private void lblPunti() {
		istrlblPunti = new JLabel("Punti guadagnati");
		istrlblPunti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblPunti.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblPunti.setBounds(417, 258, 628, 69);
		//istrlblPunti.setText("Punti guadagnati: " + s.getProdotto().getPunti());
		istruzioneConf.add(istrlblPunti);
		
		
	}

	private void lblDescrizione() {
		istrlblDescrizione = new JLabel("descrizione prodotto");
		istrlblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblDescrizione.setBounds(416, 137, 629, 136);
		//istrlblDescrizione.setText("Descrizione " + s.getProdotto().getPunti());
		istruzioneConf.add(istrlblDescrizione);
		
	}

	private void lblConferimentoProdotto() {
		istrlblConferimentoProdotto = new JLabel("ISTRUZIONI CONFERIMENTO");
		istrlblConferimentoProdotto.setForeground(Color.BLACK);
		istrlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		istrlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		istruzioneConf.add(istrlblConferimentoProdotto);
		
	}

	public void setJPanelIstruzioni() {
		istruzioneConf = new JPanel();
		istruzioneConf.setOpaque(false);
		istruzioneConf.setLayout(null);
		
		//String newLine = System.getProperty("line.separator");
		lblConferimentoProdotto();
		h = new Home();
		h.btnProblemiAssistenza(istruzioneConf);
		h.btnInfo(istruzioneConf);
		h.lblLogo(istruzioneConf);
		h.btnChiudiSessione(istruzioneConf);	
		lblDescrizione();
		lblPunti();
		btnNuovaScansione();
		// prendo il valore dalla variabile globale				

		
		//DA AGGIUNGERE DESCRIZIONE
		
		
	}
	
	public JButton getIstrbtnNuovaScansione() {
		return this.istrbtnNuovaScansione;
	}
	
	public JPanel getJPanelIstruzioni() {
		return istruzioneConf;
	}
}