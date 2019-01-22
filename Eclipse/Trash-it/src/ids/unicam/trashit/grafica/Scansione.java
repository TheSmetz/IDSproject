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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ids.unicam.trashit.console.CestinoSmart;
import ids.unicam.trashit.console.Policy;
import ids.unicam.trashit.console.Prodotto;

public class Scansione extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	public Scansione() {
		JPanel scansione = new JPanel();
		layeredPane.add(scansione, "name_47697602642643");
		scansione.setOpaque(false);
		scansione.setLayout(null);
		
		JLabel scanlblBenvenuto;
		scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(426, 0, 619, 49);
		scansione.add(scanlblBenvenuto);

		JButton scanbtnInfo;
		scanbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(about);
				seconds = 30;
			}
		});
		scanbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnInfo.setOpaque(false);
		scanbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		scanbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnInfo.setForeground(Color.BLACK);
		scanbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnInfo.setContentAreaFilled(false);
		scanbtnInfo.setBorderPainted(false);
		scanbtnInfo.setBounds(0, 456, 418, 57);
		scansione.add(scanbtnInfo);

		// Avvia scansione		
		JButton scanbtnAvviaScansione = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
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
				
				//avvia timer
				seconds = 30;
				
				//leggo il barcode in input
				barcodeProdotto = scantxtInputBarcode.getText();
				
				//prodotto
				prodottoScansionato = new Prodotto(barcodeProdotto);
				
				//VERIFICARE CORRETTEZZA CODICE A BARRE
				
				// output
				if (prodottoScansionato.isPresenza()) {					
					
					//policy
					policyProdotto = new Policy("AP", prodottoScansionato);					
					prodottoScansionato.getDati();
					
					//cestinosmart				
					CestinoSmart cestinoS = new CestinoSmart();
					try {
						cestinoS.conferimentoProdotto(prodottoScansionato);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
					prodottoScansionato.getDati();
			
					ImageIcon image = new ImageIcon(prodottoScansionato.getImmagine());
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(conflblImmagineProdotto.getWidth(),
					conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newImage = new ImageIcon(myImg);
					conflblImmagineProdotto.setIcon(newImage);
					conflblImmagineProdotto.setIcon(newImage);
					
					//prodotto nel db allora procedo con il conferimento
					switchPanel(conferimento);
					
				} else {
					System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");					
					switchPanel(erroreConf);	//pannello di errore
				}
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);

		JLabel scanlblLogo = new JLabel("");
		scanlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		scanlblLogo.setBounds(0, 0, 418, 488);
		scansione.add(scanlblLogo);

		JLabel scanlblScansionaProdotto = new JLabel("Scansione Prodotto");
		scanlblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansionaProdotto.setForeground(Color.BLACK);
		scanlblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanlblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansione.add(scanlblScansionaProdotto);
		
		scantxtInputBarcode = new JTextField();
		scantxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtInputBarcode.setBounds(632, 384, 212, 44);
		scantxtInputBarcode.setOpaque(false);
		scansione.add(scantxtInputBarcode);
		scantxtInputBarcode.setColumns(10);
		
		JLabel scanlblInputBackground = new JLabel("");
		scanlblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonsmall.png")));
		scanlblInputBackground.setBounds(430, 357, 615, 96);
		scansione.add(scanlblInputBackground);
		
		JButton scanbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		scanbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		scanbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setForeground(Color.BLACK);
		scanbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProblemiAssistenza.setContentAreaFilled(false);
		scanbtnProblemiAssistenza.setBorderPainted(false);
		scanbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		scansione.add(scanbtnProblemiAssistenza);
		
		JLabel scantxtBarcode = new JLabel();
		scantxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtBarcode.setText("Barcode:");
		scantxtBarcode.setBounds(426, 321, 619, 49);
		scantxtBarcode.setOpaque(false);
		scansione.add(scantxtBarcode);		
		
		JButton scanbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		scanbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		
		scanbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setOpaque(false);
		scanbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		scanbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setForeground(Color.WHITE);
		scanbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnChiudiSessione.setContentAreaFilled(false);
		scanbtnChiudiSessione.setBorderPainted(false);
		scanbtnChiudiSessione.setBounds(416, 613, 629, 57);
		scansione.add(scanbtnChiudiSessione);
		
		//indietro
		JButton scanbtnIndietro = new JButton("",new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
        scanbtnIndietro.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
        scanbtnIndietro.setBounds(938, 11, 97, 87);
        scansione.add(scanbtnIndietro);
        scanbtnIndietro.setOpaque(false);
        scanbtnIndietro.setBorder(null);
        scanbtnIndietro.setContentAreaFilled(false);
        scanbtnIndietro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(home);
                seconds = 30;
            }
        });
		
		
	}
}