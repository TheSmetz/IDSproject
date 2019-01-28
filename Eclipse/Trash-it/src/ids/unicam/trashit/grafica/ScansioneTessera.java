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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.Tessera;

public class ScansioneTessera {

	public static JPanel scansioneTessera;
	private JLabel scanTesseralblBenvenuto;
	private JTextPane scanTesseratxtpnErr;
	private JLabel scanTesseralblScansionaProdotto;
	private JLabel scanTesseralblInputBackground;
	private JLabel scanTesseratxtBarcode;
	private JButton scanTesserabtnAvviaScansione;
	private JTextField scanTesseratxtInputCodice;
	private Home h;
	private Scansione s;
	static Tessera tesseraScansionata;
	@SuppressWarnings("unused")
	private int puntiTessera;

	private void lblInputBackground() {
		scanTesseralblInputBackground = new JLabel("");
		scanTesseralblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblInputBackground
				.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		scanTesseralblInputBackground.setBounds(430, 357, 615, 96);
		scansioneTessera.add(scanTesseralblInputBackground);
	}

	private void txtBarcode() {
		scanTesseratxtBarcode = new JLabel();
		scanTesseratxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtBarcode.setText("Codice:");
		scanTesseratxtBarcode.setBounds(426, 321, 619, 49);
		scanTesseratxtBarcode.setOpaque(false);
		scansioneTessera.add(scanTesseratxtBarcode);

	}

	private void lblScansionaProdotto() {
		scanTesseralblScansionaProdotto = new JLabel("Scansione Tessera");
		scanTesseralblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblScansionaProdotto.setForeground(Color.BLACK);
		scanTesseralblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanTesseralblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansioneTessera.add(scanTesseralblScansionaProdotto);

	}

	private void btnAvviaSessioneTessera() {
		scanTesserabtnAvviaScansione = new JButton("Avvia scansione",
				new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// seconds = 30;
				String idTessera = scanTesseratxtInputCodice.getText();
				tesseraScansionata = new Tessera(idTessera);
				if (tesseraScansionata.verificaPresenza()) {
					puntiTessera = tesseraScansionata.getPunti();
					RitiroPremio.ritirolblRitiroPremio.setText("Benvenuto " + String.valueOf(
							tesseraScansionata.getNome() + " " + String.valueOf(tesseraScansionata.getCognome())));
					RitiroPremio.ritirolblPuntiTessera.setText("Punti tessera: " + String.valueOf(puntiTessera));
					GestoreGrafica.switchPanel(RitiroPremio.ritiroPremio);
					GestoreGrafica.startTimer(60);
				} else {
					scanTesseratxtpnErr
							.setText("Attenzione riconoscimento fallito \n      " + "Vi invitiamo a riprovare");
					scanTesseratxtInputCodice.setText("");
				}
			}
		});
		scanTesserabtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setBorderPainted(false);
		scanTesserabtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnAvviaScansione.setForeground(Color.BLACK);
		scanTesserabtnAvviaScansione.setContentAreaFilled(false);
		scanTesserabtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansioneTessera.add(scanTesserabtnAvviaScansione);

	}

	public Tessera getTessera() {
		return tesseraScansionata;
	}

	private void txtTesseraErrata() {
		scanTesseratxtpnErr = new JTextPane();
		scanTesseratxtpnErr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scanTesseratxtpnErr.setText(" ");
		scanTesseratxtpnErr.setBounds(600, 484, 275, 66);
		scanTesseratxtpnErr.setBackground(null);
		scanTesseratxtpnErr.setBorder(null);
		scanTesseratxtpnErr.setOpaque(false);
		scansioneTessera.add(scanTesseratxtpnErr);
	}

	private void lblBenvenuto() {
		scanTesseralblBenvenuto = new JLabel("BENVENUTO");
		scanTesseralblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblBenvenuto.setForeground(Color.BLACK);
		scanTesseralblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanTesseralblBenvenuto.setBounds(426, 0, 619, 49);
		scansioneTessera.add(scanTesseralblBenvenuto);

	}

	private void txtInputCodice() {
		scanTesseratxtInputCodice = new JTextField();
		scanTesseratxtInputCodice.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtInputCodice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtInputCodice.setBounds(600, 383, 275, 44);
		scanTesseratxtInputCodice.setOpaque(false);
		scanTesseratxtInputCodice.setColumns(10);
		scansioneTessera.add(scanTesseratxtInputCodice);
	}

	public void setJPanelScansioneTessera() {
		scansioneTessera = new JPanel();
		scansioneTessera.setOpaque(false);
		scansioneTessera.setLayout(null);
		h = new Home();
		h.btnInfo(scansioneTessera);
		h.lblLogo(scansioneTessera);
		h.btnProblemiAssistenza(scansioneTessera);
		h.btnChiudiSessione(scansioneTessera);
		s = new Scansione();
		s.btnIndietro(scansioneTessera);
		txtInputCodice();
		lblBenvenuto();
		txtTesseraErrata();
		btnAvviaSessioneTessera();
		lblScansionaProdotto();
		txtBarcode();
		lblInputBackground();
	}

	public JButton getScanTesserabtnAvviaScansione() {
		return this.scanTesserabtnAvviaScansione;
	}

	public JPanel getJPanelScansioneTessera() {
		return scansioneTessera;
	}

}
