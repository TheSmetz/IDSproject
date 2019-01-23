package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ids.unicam.trashit.grafica.Home;

public class Scansione extends JPanel {

	public static JPanel scansione;
	public JLabel scanlblScansionaProdotto;
	private JTextField scantxtInputBarcode;
	private JButton scanbtnAvviaScansione;
	private JLabel scantxtBarcode;
	private JButton scanbtnChiudiSessione;
	public static JButton scanbtnIndietro;
	ActionListener action;

	public static void btnIndietro(JPanel wherePanel) {
		scanbtnIndietro = new JButton("",
				new ImageIcon(Home.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro
				.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro.setBounds(938, 11, 97, 87);

		scanbtnIndietro.setOpaque(false);
		scanbtnIndietro.setBorder(null);
		scanbtnIndietro.setContentAreaFilled(false);
		scanbtnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Home.home.removeAll();
//            	scansione.removeAll();
//				Home.home.add(homepage.setta());
//            	Home.home.revalidate();
//            	Home.home.repaint();
				// switchPanel(home);
				// seconds = 30;
			}
		});
		wherePanel.add(scanbtnIndietro);
	}



	private void lblBarcode() {
		scantxtBarcode = new JLabel();
		scantxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtBarcode.setText("Barcode:");
		scantxtBarcode.setBounds(426, 321, 619, 49);
		scantxtBarcode.setOpaque(false);
		scansione.add(scantxtBarcode);

	}

	private void lblInputBackground() {
		JLabel scanlblInputBackground = new JLabel("");
		scanlblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInputBackground.setIcon(
				new ImageIcon(Home.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonsmall.png")));
		scanlblInputBackground.setBounds(430, 357, 615, 96);
		scansione.add(scanlblInputBackground);

	}

	private void txtBarcode() {
		scantxtInputBarcode = new JTextField();
		scantxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtInputBarcode.setBounds(632, 384, 212, 44);
		scantxtInputBarcode.setOpaque(false);
		scansione.add(scantxtInputBarcode);
		scantxtInputBarcode.setColumns(10);
	}

	private void lblScanProdotto() {
		scanlblScansionaProdotto = new JLabel("Scansione Prodotto");
		scanlblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansionaProdotto.setForeground(Color.BLACK);
		scanlblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanlblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansione.add(scanlblScansionaProdotto);
	}

	private void btnAvviaScansione() { // DA RIDURRE
		scanbtnAvviaScansione = new JButton("Avvia scansione",
				new ImageIcon(Home.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setBorderPainted(false);
		scanbtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		scanbtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnAvviaScansione.setForeground(Color.BLACK);
		scanbtnAvviaScansione.setContentAreaFilled(false);
		scanbtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//DA FAREEE	SU UN ALTRO METODO			
//				//avvia timer
//				seconds = 30;
//				
//				//leggo il barcode in input
//				barcodeProdotto = scantxtInputBarcode.getText();
//				
//				//prodotto
//				prodottoScansionato = new Prodotto(barcodeProdotto);
//				
//				//VERIFICARE CORRETTEZZA CODICE A BARRE
//				
//				// output
//				if (prodottoScansionato.isPresenza()) {					
//					
//					//policy
//					policyProdotto = new Policy("AP", prodottoScansionato);					
//					prodottoScansionato.getDati();
//					
//					//cestinosmart				
//					CestinoSmart cestinoS = new CestinoSmart();
//					try {
//						cestinoS.conferimentoProdotto(prodottoScansionato);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}			
//					
//					prodottoScansionato.getDati();
//			
//					ImageIcon image = new ImageIcon(prodottoScansionato.getImmagine());
//					Image im = image.getImage();
//					Image myImg = im.getScaledInstance(conflblImmagineProdotto.getWidth(),
//					conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
//					ImageIcon newImage = new ImageIcon(myImg);
//					conflblImmagineProdotto.setIcon(newImage);
//					conflblImmagineProdotto.setIcon(newImage);
//					
//					//prodotto nel db allora procedo con il conferimento
//					switchPanel(conferimento);
//					
//				} else {
//					System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");					
//					switchPanel(erroreConf);	//pannello di errore
//				}
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);
	}
	
	private void lblBenvenuto() {
		JLabel scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(426, 0, 619, 49);
		scansione.add(scanlblBenvenuto);

	}

	private void setJPanelScansione() {
		scansione = new JPanel();
		scansione.setOpaque(false);
		scansione.setLayout(null);
		scansione.setVisible(true);
		btnIndietro(scansione);
		lblBenvenuto();
		Home.btnInfo(scansione);
		Home.lblLogo(scansione);
		Home.btnProblemiAssistenza(scansione);
		btnAvviaScansione();
		lblScanProdotto();
		txtBarcode();
		lblInputBackground();
		lblBarcode();
		Home.btnChiudiSessione(scansione);
	}	

	public JPanel getJPanelScansione() {
		setJPanelScansione();
		return scansione;
	}

}
