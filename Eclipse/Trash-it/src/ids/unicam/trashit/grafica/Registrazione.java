package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import ids.unicam.trashit.console.AggiuntaDB;
import ids.unicam.trashit.console.Tessera;

public class Registrazione extends JFrame {
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField regtxtCodiceFiscale;
	private JTextField regtextFieldNome;
	private JTextField regtextFieldCognome;
	
	public Registrazione() {
		
		JPanel registrazione = new JPanel();
		layeredPane.add(registrazione, "name_1727413037300");
		registrazione.setOpaque(false);
		registrazione.setLayout(null);	
		
		JLabel reglblCF = new JLabel("Codice Fiscale:");
		reglblCF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCF.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCF.setBounds(416, 149, 192, 31);
		registrazione.add(reglblCF);
		
		JLabel reglblNome = new JLabel("Nome:");
		reglblNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblNome.setBounds(416, 221, 192, 31);
		registrazione.add(reglblNome);
		
		JLabel reglblCognome = new JLabel("Cognome:");
		reglblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCognome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCognome.setBounds(416, 300, 192, 31);
		registrazione.add(reglblCognome);
		
		JLabel reglblLogo = new JLabel("");
		reglblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		reglblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		reglblLogo.setBounds(0, 0, 418, 488);
		registrazione.add(reglblLogo);
		
		JButton regbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		regbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		regbtnInfo.setOpaque(false);
		regbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		regbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		regbtnInfo.setForeground(Color.BLACK);
		regbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		regbtnInfo.setContentAreaFilled(false);
		regbtnInfo.setBorderPainted(false);
		regbtnInfo.setBounds(0, 456, 418, 57);
		registrazione.add(regbtnInfo);
		
		JButton regbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		regbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		regbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		regbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		regbtnProblemiAssistenza.setForeground(Color.BLACK);
		regbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		regbtnProblemiAssistenza.setContentAreaFilled(false);
		regbtnProblemiAssistenza.setBorderPainted(false);
		regbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		registrazione.add(regbtnProblemiAssistenza);
		
		JButton regChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		regChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		regChiudiSessione.setOpaque(false);
		regChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		regChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		regChiudiSessione.setForeground(Color.WHITE);
		regChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		regChiudiSessione.setContentAreaFilled(false);
		regChiudiSessione.setBorderPainted(false);
		regChiudiSessione.setBounds(416, 613, 629, 57);
		registrazione.add(regChiudiSessione);
		
		//data
		JDateChooser regdateChooser = new JDateChooser();
		regdateChooser.setBounds(694, 364, 275, 45);
		regdateChooser.getJCalendar().setPreferredSize(new Dimension(400, 300));
		registrazione.add(regdateChooser);
		
		regtxtCodiceFiscale = new JTextField();
		regtxtCodiceFiscale.setOpaque(false);
		regtxtCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		regtxtCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtxtCodiceFiscale.setColumns(10);
		regtxtCodiceFiscale.setBounds(694, 142, 275, 44);
		registrazione.add(regtxtCodiceFiscale);
		
		JLabel reglblSfondoCodiceFiscale = new JLabel("");
		reglblSfondoCodiceFiscale.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCodiceFiscale.setBounds(620, 130, 425, 68);
		registrazione.add(reglblSfondoCodiceFiscale);
		
		//indietro
		JButton regTesserabtnIndietro = new JButton("",new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		regTesserabtnIndietro.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/fv.png")));
		regTesserabtnIndietro.setBounds(938, 11, 97, 87);
		registrazione.add(regTesserabtnIndietro);
		regTesserabtnIndietro.setOpaque(false);
		regTesserabtnIndietro.setBorder(null);
		regTesserabtnIndietro.setContentAreaFilled(false);
		regTesserabtnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
				seconds = 30;
				//regTesseratxtpnErr.setText("");
			}
		});
		
		JButton regbtnStampaTessera = new JButton("Stampa tessera", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/bluebuttonSmall.png")));
		regbtnStampaTessera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//verifica input corretti
				if (regtxtCodiceFiscale.getText() !=null && regtextFieldNome.getText() !=null && regtextFieldCognome.getText() !=null && regdateChooser.getDate()!=null) {
					//verifica tessera già nel db
					tesseraGui = new Tessera(regtxtCodiceFiscale.getText());
					if(tesseraGui.verificaPresenza()==false) { //non presente nel db
						AggiuntaDB aggiungiTessera = new AggiuntaDB();
						nascitaTessera = sdf.format(regdateChooser.getDate());
						//System.out.println(nascitaTessera);
						aggiungiTessera.registrazioneTessera(regtxtCodiceFiscale.getText(), 
								regtextFieldNome.getText(), regtextFieldCognome.getText(), nascitaTessera);
					} else {
						//popup-tessera già presente
						System.out.println("TESSERA GIA' NEL DB");
						JOptionPane.showMessageDialog(registrazione, "TESSERA GIA' NEL DATABASE.");
						switchPanel(home);
						seconds = 30;
					}
				}else {
					JOptionPane.showMessageDialog(registrazione, "Tutti i campi devono essere compilati");
				}
			}
		});
		regbtnStampaTessera.setVerticalTextPosition(SwingConstants.CENTER);
		regbtnStampaTessera.setMargin(new Insets(0, 0, 0, 0));
		regbtnStampaTessera.setHorizontalTextPosition(SwingConstants.CENTER);
		regbtnStampaTessera.setForeground(Color.WHITE);
		regbtnStampaTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		regbtnStampaTessera.setContentAreaFilled(false);
		regbtnStampaTessera.setBorderPainted(false);
		regbtnStampaTessera.setBounds(416, 532, 629, 68);
		registrazione.add(regbtnStampaTessera);
		

		JTextPane regtxtPaneRegistrazioneTessera = new JTextPane();
		regtxtPaneRegistrazioneTessera.setFont(new Font("Tahoma", Font.BOLD, 28));
		regtxtPaneRegistrazioneTessera.setText("Registrazione tessera\ninserisci i tuoi dati:");
		regtxtPaneRegistrazioneTessera.setBounds(518, 11, 332, 95);
        registrazione.add(regtxtPaneRegistrazioneTessera);
        regtxtPaneRegistrazioneTessera.setBackground(null);
        regtxtPaneRegistrazioneTessera.setBorder(null);
        regtxtPaneRegistrazioneTessera.setOpaque(false);
		
		
		regtextFieldNome = new JTextField();
		regtextFieldNome.setOpaque(false);
		regtextFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldNome.setColumns(10);
		regtextFieldNome.setBounds(698, 214, 271, 44);
		registrazione.add(regtextFieldNome);		
		
		regtextFieldCognome = new JTextField();
		regtextFieldCognome.setOpaque(false);
		regtextFieldCognome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldCognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldCognome.setColumns(10);
		regtextFieldCognome.setBounds(698, 292, 271, 44);
		registrazione.add(regtextFieldCognome);
		
		JLabel reglblDataDiNascita = new JLabel("Data di nascita:");
		reglblDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		reglblDataDiNascita.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblDataDiNascita.setBounds(416, 375, 192, 31);
		registrazione.add(reglblDataDiNascita);
		
		JLabel reglblSfondoNome = new JLabel("");
		reglblSfondoNome.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoNome.setBounds(620, 202, 429, 68);
		registrazione.add(reglblSfondoNome);
		
		JLabel reglblSfondoCognome = new JLabel("");
		reglblSfondoCognome.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCognome.setBounds(620, 280, 425, 68);
		registrazione.add(reglblSfondoCognome);
	}
}
