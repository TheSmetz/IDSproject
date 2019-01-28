package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.Policy;
import ids.unicam.trashit.console.Prodotto;
import ids.unicam.trashit.console.Statistica;
import ids.unicam.trashit.console.Tessera;
import ids.unicam.trashit.grafica.Home;

public class Scansione {

	public static JPanel scansione;
	private JLabel scanlblScansionaProdotto;
	private JTextField scantxtInputBarcode;
	private JButton scanbtnAvviaScansione;
	private JLabel scantxtBarcode;
	private JButton scanbtnIndietro;
	private Home h;
	private ImageIcon image;
	private Image im;
	private Image myImg;
	private ImageIcon newImage;
	private JLabel scanlblInputBackground;
	private JLabel scanlblBenvenuto;
	private JTextArea txtrNbAutenticarsiPrima;
	private final String filename = "src\\ids\\unicam\\trashit\\grafica\\txt\\ProdottiDaAggiungere.txt";
	private FileWriter fw;
	private BufferedWriter bw;
	
	//Tessera sessione
	private static String barcodeInput;
	public static Tessera tesseraScansionata;
	public static boolean tesseraLetta = false;
	public static Prodotto prodottoCorrente;
	public static Policy policyProdotto;

	public static String getBarcodeSessione() {
		return barcodeInput;
	}

	public JButton getbtnIndietro() {
		return this.scanbtnIndietro;
	}

	public JButton getbtnAvviaScansione() {
		return this.scanbtnAvviaScansione;
	}

	public void btnIndietro(JPanel wherePanel) {
		scanbtnIndietro = new JButton("",
				new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro.setBounds(938, 11, 97, 87);
		scanbtnIndietro.setOpaque(false);
		scanbtnIndietro.setBorder(null);
		scanbtnIndietro.setContentAreaFilled(false);
		scanbtnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCampi();
				GestoreGrafica.switchPanel(Home.home);
				GestoreGrafica.startTimer(30);
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
		scanlblInputBackground = new JLabel("");
		scanlblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInputBackground.setIcon(
				new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonsmall.png")));
		scanlblInputBackground.setBounds(430, 357, 615, 96);
		scansione.add(scanlblInputBackground);

	}

	private void txtBarcode() {
		scantxtInputBarcode = new JTextField();
		scantxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtInputBarcode.setBounds(632, 384, 212, 44);
		scantxtInputBarcode.setOpaque(false);
		scantxtInputBarcode.setColumns(10);
		scansione.add(scantxtInputBarcode);
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
				new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setBorderPainted(false);
		scanbtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		scanbtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnAvviaScansione.setForeground(Color.BLACK);
		scanbtnAvviaScansione.setContentAreaFilled(false);
		scanbtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				barcodeInput = scantxtInputBarcode.getText();
				if(barcodeInput.length()==0) {
					JOptionPane.showMessageDialog(scansione, "Barcode non rilevato");
				}
				if (Conferimento.cestinoSessione.controlloVuoto()){	//cestino vuoto
					try {
						scanProdotto();
					} catch (IOException e) {
						e.printStackTrace();
					}
					scantxtInputBarcode.setText("");
				}else {
					JOptionPane.showMessageDialog(scansione, "Cestino pieno, necessaria assistenza");
					resetCampi();
					GestoreGrafica.switchPanel(Assistenza.assistenza);
					GestoreGrafica.startTimer(30);
					}
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);
	}

	private void setImmagineProdotto() {
		image = new ImageIcon(prodottoCorrente.getImmagine());
		im = image.getImage();
		myImg = im.getScaledInstance(Conferimento.conflblImmagineProdotto.getWidth(),
				Conferimento.conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
		newImage = new ImageIcon(myImg);
		Conferimento.conflblImmagineProdotto.setIcon(newImage);
	}

	public void scanProdotto() throws IOException {
//		boolean flag1 = barcodeInput.substring(0, 1).matches("\\d"); // Controllo che i primi 3 caratteri non siano numeri
//		boolean flag2 = barcodeInput.substring(1, 2).matches("\\d"); // Questo per vedere se viene scannerizzata una tessera
//																// o un prodotto
//		boolean flag3 = barcodeInput.substring(2, 3).matches("\\d");
//
//		if (!flag1 && !flag2 && !flag3) {
//			TESSERAsessione = barcodeInput;
//			gestioneTessera(TESSERAsessione);
//		} else {
			//se prodotto
//			BARCODEsessione = barcodeInput;
//			prodottoScansionato = new Prodotto(BARCODEsessione);
//			if (prodottoScansionato.isPresenza()) {
//				//prodotto valido
//				Policy policyProdotto = new Policy("AP", prodottoScansionato);
//				try {
//					//assistenza? perche non su confermineto?
//					//recupero descrizione su dove buttare prodotto
//					Assistenza.cestinoS.conferimentoProdotto(prodottoScansionato);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				setImmagineProdotto();
//				if (policyProdotto.isUtilizzoPunti()) {
////					@SuppressWarnings("unused")  //nel caso in cui non si scannerizza la tessera ma si butti solo i prodotti
////					tesseraScansionata = new Tessera(BARCODEsessione);
//					IstruzioniConferimento.istrlblPunti.setText("Punti Prodotto: " + prodottoScansionato.getPunti());
//				} else {
//					IstruzioniConferimento.istrlblPunti.setText("L'area in cui ti trovi non prevede l'utilizzo dei punti");
//				}
//				IstruzioniConferimento.istrlblDescrizione.setText("Descrizione : " + prodottoScansionato.getDescrizione());
//				// prodotto nel db allora procedo con il conferimento
//				//da passare a conferimento: prodotto, tessera(se scannerizzata)
//				Conferimento.statisticaSessione = new Statistica(prodottoScansionato.getcodiceABarre(), tesseraScansionata.getIdTessera());
//				GestoreGrafica.switchPanel(Conferimento.conferimento);
//				GestoreGrafica.startTimer(60);
//				// timer
//			} else {
//				JOptionPane.showMessageDialog(scansione,
//						"Prodotto non presente nel DB, invia notifica per aggiungerlo");
//				aggiungiProdotto();
//			}
//		}
		
//		Tessera t = new Tessera(barcodeInput);
//		System.out.println(t.verificaPresenza());
		if (barcodeInput.length()==16 && checkTessera(barcodeInput)) {	//tessera
			gestioneTessera(barcodeInput);
		} else {	//prodotto
			prodottoCorrente = new Prodotto(barcodeInput);
			if (prodottoCorrente.isPresenza()) {	//esiste
				policyProdotto = new Policy("AP", prodottoCorrente);
				try {
					Conferimento.cestinoSessione.conferimentoProdotto(prodottoCorrente);	//recupero descrizione su dove buttare prodotto
				} catch (IOException e) {
					e.printStackTrace();
				}
				setImmagineProdotto();
				resetCampi();
				GestoreGrafica.switchPanel(Conferimento.conferimento);
				GestoreGrafica.startTimer(60);
			} else {
				JOptionPane.showMessageDialog(scansione, "Prodotto non presente nel DB, invia notifica per aggiungerlo");
				//aggiungiProdotto();
				//pagina aggiunta prodotto?
			}
		}		
	}
	
	public static boolean checkTessera(String code) {
		boolean flag1 = code.substring(0,5).matches("[a-zA-Z]+");
		boolean flag2 = code.substring(6,7).matches("\\d+");
		boolean flag3 = Character.isLetter(code.charAt(8));
		boolean flag4 = code.substring(9,10).matches("\\d+");
		boolean flag5 = Character.isLetter(code.charAt(11));
		boolean flag6 = code.substring(12,14).matches("\\d+");
		boolean flag7 = Character.isLetter(code.charAt(15));
		if(code.length() == 16 && flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
			return true;
		}else return false;
	}
	

	private void gestioneTessera(String codiceTessera) {
		//JOptionPane.showMessageDialog(scansione, "Tessera autenticata per l'acquisizione dei punti");
		tesseraScansionata = new Tessera(codiceTessera);
		tesseraLetta = true;
		scanlblBenvenuto.setText("Benvenuto "+tesseraScansionata.getNome()+" "+tesseraScansionata.getCognome());
		txtrNbAutenticarsiPrima.setText("\t    Tessera autenticata \n\t per l'acquisizione dei punti");
		GestoreGrafica.startTimer(60);
	}
	
	private void resetCampi() {
		scanlblBenvenuto.setText("Benvenuto");
		txtrNbAutenticarsiPrima.setText(
				"               !ATTENZIONE! \r\nSCANSIONARE PRIMA LA TESSERA, POI I PRODOTTI,\r\n     AFFINCHE' I PUNTI VENGANO ACCREDITATI");
	}
	
	public static boolean tesseraLetta() {
		return tesseraLetta;
	}

	private void aggiungiProdotto() {
		try {
			fw = new FileWriter(filename, true);
			bw = new BufferedWriter(fw);
			bw.write("- " + scantxtInputBarcode.getText() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void lblAttenzioneTessera() {
		txtrNbAutenticarsiPrima = new JTextArea();
		txtrNbAutenticarsiPrima.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrNbAutenticarsiPrima.setEditable(false);
		txtrNbAutenticarsiPrima.setText(
				"               !ATTENZIONE! \r\nSCANSIONARE PRIMA LA TESSERA, POI I PRODOTTI,\r\n     AFFINCHE' I PUNTI VENGANO ACCREDITATI");
		txtrNbAutenticarsiPrima.setBounds(502, 472, 504, 125);
		txtrNbAutenticarsiPrima.setOpaque(false);
		scansione.add(txtrNbAutenticarsiPrima);
	}

	private void lblBenvenuto() {
		scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(426, 0, 619, 49);
		scansione.add(scanlblBenvenuto);

	}

	public Prodotto getProdotto() {
		return Scansione.prodottoCorrente;
	}

	// CONTROLLARE
	public void setJPanelScansione() {
		scansione = new JPanel();
		scansione.setOpaque(false);
		scansione.setLayout(null);
		scansione.setVisible(true);
		btnIndietro(scansione);
		lblBenvenuto();
		h = new Home();
		h.btnInfo(scansione);
		h.lblLogo(scansione);
		h.btnProblemiAssistenza(scansione);
		h.btnChiudiSessione(scansione);
		btnAvviaScansione();
		lblScanProdotto();
		txtBarcode();
		lblInputBackground();
		lblBarcode();
		lblAttenzioneTessera();
	}

	public JPanel getJPanelScansione() {
		return scansione;
	}

}
