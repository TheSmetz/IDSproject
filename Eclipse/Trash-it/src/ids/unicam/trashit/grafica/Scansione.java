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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.CestinoSmart;
import ids.unicam.trashit.console.Policy;
import ids.unicam.trashit.console.Prodotto;
import ids.unicam.trashit.grafica.Home;
import ids.unicam.trashit.start.Start;

public class Scansione {

	public static JPanel scansione;
	private JLabel scanlblScansionaProdotto;
	private JTextField scantxtInputBarcode;
	private JButton scanbtnAvviaScansione;
	private JLabel scantxtBarcode;
	private JButton scanbtnIndietro;
	private Home h;
	private String barcode;
	public static Prodotto prodottoScansionato;
	private Policy policyProdotto;
	private CestinoSmart cestinoS;
	private ImageIcon image;
	private Image im;
	private Image myImg;
	private ImageIcon newImage;
	private JLabel scanlblInputBackground;
	private JLabel scanlblBenvenuto;
	
	
	public JButton getbtnIndietro() {
		return this.scanbtnIndietro;
	}
	
	public JButton getbtnAvviaScansione() {
		return this.scanbtnAvviaScansione;
	}

	public void btnIndietro(JPanel wherePanel) {
		scanbtnIndietro = new JButton("",
				new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro
				.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		scanbtnIndietro.setBounds(938, 11, 97, 87);
		scanbtnIndietro.setOpaque(false);
		scanbtnIndietro.setBorder(null);
		scanbtnIndietro.setContentAreaFilled(false);
		scanbtnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start.switchPanel(Home.home);
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
				scanProdotto();
				scantxtInputBarcode.setText("");
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);
	}
	
	private void setImmagineProdotto() {
        image = new ImageIcon(prodottoScansionato.getImmagine());
        im = image.getImage();
        myImg = im.getScaledInstance(Conferimento.conflblImmagineProdotto.getWidth(),
                Conferimento.conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
        newImage = new ImageIcon(myImg);
        Conferimento.conflblImmagineProdotto.setIcon(newImage);
    }
	
	public void scanProdotto() {
        //leggo il barcode in input
        barcode = scantxtInputBarcode.getText();
        //prodotto
       prodottoScansionato = new Prodotto(barcode);
        //VERIFICARE CORRETTEZZA CODICE A BARRE
        if (prodottoScansionato.isPresenza()) {
            //policy
            policyProdotto = new Policy("AP", prodottoScansionato);
            prodottoScansionato.getDati();
            //cestinosmart
            cestinoS = new CestinoSmart();
            try {
                cestinoS.conferimentoProdotto(prodottoScansionato);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            prodottoScansionato.getDati();
            setImmagineProdotto();
            
            //prodotto nel db allora procedo con il conferimento
            Start.switchPanel(Conferimento.conferimento);
            //timer
        } else {
        	JOptionPane.showMessageDialog(scansione, "Prodotto sbagliato o non presente nel DB, invia notifica per aggiungerlo");
            System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");
        }
    }
	
	public Prodotto getProdotto() {
		return Scansione.prodottoScansionato;
	}

	private void lblBenvenuto() {
		scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(426, 0, 619, 49);
		scansione.add(scanlblBenvenuto);

	}
	
	//CONTROLLARE
	public void setJPanelScansione() {
		scansione = new JPanel();
		scansione.setOpaque(false);
		scansione.setLayout(null);
		scansione.setVisible(true);
		btnIndietro(scansione);
		lblBenvenuto();
		h=new Home();
		h.btnInfo(scansione);
		h.lblLogo(scansione);
		h.btnProblemiAssistenza(scansione);
		h.btnChiudiSessione(scansione);
		btnAvviaScansione();
		lblScanProdotto();
		txtBarcode();
		lblInputBackground();
		lblBarcode();
		
	}	

	public JPanel getJPanelScansione() {
		return scansione;
	}

}
