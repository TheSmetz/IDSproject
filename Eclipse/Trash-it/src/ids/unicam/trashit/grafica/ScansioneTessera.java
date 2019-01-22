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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.Tessera;

public class ScansioneTessera extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public ScansioneTessera() {
		JPanel scansioneTessera = new JPanel();
		layeredPane.add(scansioneTessera, "name_1043256396947700");
		scansioneTessera.setOpaque(false);
		scansioneTessera.setLayout(null);
		
		JTextField scanTesseratxtInputCodice = new JTextField();
		scanTesseratxtInputCodice.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtInputCodice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtInputCodice.setBounds(600, 383, 275, 44);
		scanTesseratxtInputCodice.setOpaque(false);
		scansioneTessera.add(scanTesseratxtInputCodice);
		scanTesseratxtInputCodice.setColumns(10);
		
		JLabel scanTesseralblBenvenuto;
		scanTesseralblBenvenuto = new JLabel("BENVENUTO");
		scanTesseralblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblBenvenuto.setForeground(Color.BLACK);
		scanTesseralblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanTesseralblBenvenuto.setBounds(426, 0, 619, 49);
		scansioneTessera.add(scanTesseralblBenvenuto);

		JButton scanTesserabtnInfo;
		scanTesserabtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(about);
				seconds = 30;
			}
		});
		scanTesserabtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnInfo.setOpaque(false);
		scanTesserabtnInfo.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnInfo.setForeground(Color.BLACK);
		scanTesserabtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnInfo.setContentAreaFilled(false);
		scanTesserabtnInfo.setBorderPainted(false);
		scanTesserabtnInfo.setBounds(0, 456, 418, 57);
		scansioneTessera.add(scanTesserabtnInfo);
		
		//tessera errata
		JTextPane scanTesseratxtpnErr = new JTextPane();
        scanTesseratxtpnErr.setFont(new Font("Tahoma", Font.PLAIN, 18));
        scanTesseratxtpnErr.setText(" ");
        scanTesseratxtpnErr.setBounds(600, 484, 275, 66);
        scansioneTessera.add(scanTesseratxtpnErr);
        scanTesseratxtpnErr.setBackground(null);
        scanTesseratxtpnErr.setBorder(null);
        scanTesseratxtpnErr.setOpaque(false);

		// Avvia scansione		
		JButton scanTesserabtnAvviaScansione = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                seconds = 30;
                idTessera = scanTesseratxtInputCodice.getText();
                tesseraScansionata = new Tessera(idTessera);
                if (tesseraScansionata.verificaPresenza()) {
                    puntiTessera = tesseraScansionata.getPunti();
                    ritirolblPuntiTessera.setText("Punti tessera: "+String.valueOf(puntiTessera));
                    switchPanel(ritiroPremio);
                }else {
                    scanTesseratxtpnErr.setText("Attenzione riconoscimento fallito \n      "
                                                 + "Vi invitiamo a riprovare");
                    scanTesseratxtInputCodice.setText("");
                }
            }
		});
		scanTesserabtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setBorderPainted(false);
		scanTesserabtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		scanTesserabtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnAvviaScansione.setForeground(Color.BLACK);
		scanTesserabtnAvviaScansione.setContentAreaFilled(false);
		scanTesserabtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansioneTessera.add(scanTesserabtnAvviaScansione);

		JLabel scanTesseralblLogo = new JLabel("");
		scanTesseralblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		scanTesseralblLogo.setBounds(0, 0, 418, 488);
		scansioneTessera.add(scanTesseralblLogo);

		JLabel scanTesseralblScansionaProdotto = new JLabel("Scansione Tessera");
		scanTesseralblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblScansionaProdotto.setForeground(Color.BLACK);
		scanTesseralblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanTesseralblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansioneTessera.add(scanTesseralblScansionaProdotto);
		
		JLabel scanTesseratxtBarcode = new JLabel();
		scanTesseratxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtBarcode.setText("Codice:");
		scanTesseratxtBarcode.setBounds(426, 321, 619, 49);
		scanTesseratxtBarcode.setOpaque(false);
		scansioneTessera.add(scanTesseratxtBarcode);		
		
		
		
		JLabel scanTesseralblInputBackground = new JLabel("");
		scanTesseralblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		scanTesseralblInputBackground.setBounds(430, 357, 615, 96);
		scansioneTessera.add(scanTesseralblInputBackground);
		
		JButton scanTesserabtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		scanTesserabtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnProblemiAssistenza.setForeground(Color.BLACK);
		scanTesserabtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnProblemiAssistenza.setContentAreaFilled(false);
		scanTesserabtnProblemiAssistenza.setBorderPainted(false);
		scanTesserabtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		scansioneTessera.add(scanTesserabtnProblemiAssistenza);
		
		
		
		JButton scanTesserabtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		scanTesserabtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
				scanTesseratxtpnErr.setText("");
			}
		});
		
		scanTesserabtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnChiudiSessione.setOpaque(false);
		scanTesserabtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnChiudiSessione.setForeground(Color.WHITE);
		scanTesserabtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnChiudiSessione.setContentAreaFilled(false);
		scanTesserabtnChiudiSessione.setBorderPainted(false);
		scanTesserabtnChiudiSessione.setBounds(416, 613, 629, 57);
		scansioneTessera.add(scanTesserabtnChiudiSessione);
		
		//indietro
		JButton scanTesserabtnIndietro = new JButton("",new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanTesserabtnIndietro.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanTesserabtnIndietro.setBounds(938, 11, 97, 87);
		scansioneTessera.add(scanTesserabtnIndietro);
		scanTesserabtnIndietro.setOpaque(false);
		scanTesserabtnIndietro.setBorder(null);
		scanTesserabtnIndietro.setContentAreaFilled(false);
		scanTesserabtnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
				seconds = 30;
				scanTesseratxtpnErr.setText("");
			}
		});
		
		
	}
}
