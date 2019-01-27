package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import ids.unicam.trashit.console.AggiuntaDB;
import ids.unicam.trashit.console.Tessera;


public class Registrazione {
	
	public static JPanel registrazione;
	private JTextField regtxtCodiceFiscale;
	private JTextField regtextFieldNome;
	private JTextField regtextFieldCognome;
	private JLabel reglblSfondoCognome;
	private JLabel reglblDataDiNascita;
	private JTextPane regtxtPaneRegistrazioneTessera;
	private JButton regbtnStampaTessera;
	private JLabel reglblSfondoCodiceFiscale;
	private JDateChooser regdateChooser;
	private JLabel reglblCognome;
	private JLabel reglblNome;
	private JLabel reglblCF;
	private Home h;
	private Scansione s;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	

	private void lblCF() {
		reglblCF = new JLabel("Codice Fiscale:");
		reglblCF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCF.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCF.setBounds(416, 149, 192, 31);
		registrazione.add(reglblCF);
		
	}

	private void lblNome() {
		reglblNome = new JLabel("Nome:");
		reglblNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblNome.setBounds(416, 221, 192, 31);
		registrazione.add(reglblNome);
		
	}

	private void lblCognome() {
		reglblCognome = new JLabel("Cognome:");
		reglblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCognome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCognome.setBounds(416, 300, 192, 31);
		registrazione.add(reglblCognome);
		
	}

	private void dateChooser() {
		regdateChooser = new JDateChooser();
		regdateChooser.setBounds(694, 364, 275, 45);
		regdateChooser.getJCalendar().setPreferredSize(new Dimension(400, 300));
		registrazione.add(regdateChooser);
		
	}

	private void txtCodiceFiscale() {
		regtxtCodiceFiscale = new JTextField();
		regtxtCodiceFiscale.setOpaque(false);
		regtxtCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		regtxtCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtxtCodiceFiscale.setColumns(10);
		regtxtCodiceFiscale.setBounds(694, 142, 275, 44);
		registrazione.add(regtxtCodiceFiscale);
		
	}

	private void lblSfondoCodiceFiscale() {
		reglblSfondoCodiceFiscale = new JLabel("");
		reglblSfondoCodiceFiscale.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCodiceFiscale.setBounds(620, 130, 425, 68);
		registrazione.add(reglblSfondoCodiceFiscale);
	}
	
	private void resetCampi() {
		regtxtCodiceFiscale.setText(null);
		regdateChooser.setDate(null);
		regtextFieldCognome.setText(null);
		regtextFieldNome.setText(null);
		
	}

	private void btnStampaTessera() {
		regbtnStampaTessera = new JButton("Stampa tessera", new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/bluebuttonSmall.png")));
		regbtnStampaTessera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//verifica input corretti
				if (regtxtCodiceFiscale.getText() !=null && regtextFieldNome.getText() !=null && regtextFieldCognome.getText() !=null && regdateChooser.getDate()!=null && regtxtCodiceFiscale.getText().length()==16) {
					//verifica tessera già nel db
					Tessera tesseraGui = new Tessera(regtxtCodiceFiscale.getText());
					if(tesseraGui.verificaPresenza()==false) { //non presente nel db
						AggiuntaDB aggiungiTessera = new AggiuntaDB();
						String nascitaTessera = sdf.format(regdateChooser.getDate());
						//System.out.println(nascitaTessera);
						aggiungiTessera.registrazioneTessera(regtxtCodiceFiscale.getText(), 
								regtextFieldNome.getText(), regtextFieldCognome.getText(), nascitaTessera);
						JOptionPane.showMessageDialog(registrazione, tesseraGui.getDati());
						resetCampi();
					} else {
						JOptionPane.showMessageDialog(registrazione, "TESSERA GIA' NEL DATABASE.");
						GestoreGrafica.switchPanel(Home.home);
						//seconds = 30;
					}
				}else {
					JOptionPane.showMessageDialog(registrazione, "Tutti i campi devono essere compilati correttamente");
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
		
	}

	private void txtPaneRegistrazioneTessera() {
		regtxtPaneRegistrazioneTessera = new JTextPane();
		regtxtPaneRegistrazioneTessera.setFont(new Font("Tahoma", Font.BOLD, 28));
		regtxtPaneRegistrazioneTessera.setText("Registrazione tessera\ninserisci i tuoi dati:");
		regtxtPaneRegistrazioneTessera.setBounds(518, 11, 332, 95);
        registrazione.add(regtxtPaneRegistrazioneTessera);
        regtxtPaneRegistrazioneTessera.setBackground(null);
        regtxtPaneRegistrazioneTessera.setBorder(null);
        regtxtPaneRegistrazioneTessera.setOpaque(false);
		
	}

	private void txtFieldNome() {
		regtextFieldNome = new JTextField();
		regtextFieldNome.setOpaque(false);
		regtextFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldNome.setColumns(10);
		regtextFieldNome.setBounds(698, 214, 271, 44);
		registrazione.add(regtextFieldNome);	
		
	}

	private void txtFieldCognome() {
		regtextFieldCognome = new JTextField();
		regtextFieldCognome.setOpaque(false);
		regtextFieldCognome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldCognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldCognome.setColumns(10);
		regtextFieldCognome.setBounds(698, 292, 271, 44);
		registrazione.add(regtextFieldCognome);
	}

	private void lblDataDiNascita() {
		reglblDataDiNascita = new JLabel("Data di nascita:");
		reglblDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		reglblDataDiNascita.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblDataDiNascita.setBounds(416, 375, 192, 31);
		registrazione.add(reglblDataDiNascita);
		
	}

	private void lblSfondoNome() {
		JLabel reglblSfondoNome = new JLabel("");
		reglblSfondoNome.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoNome.setBounds(620, 202, 429, 68);
		registrazione.add(reglblSfondoNome);
		
	}

	private void lblSfondoCognome() {
		reglblSfondoCognome = new JLabel("");
		reglblSfondoCognome.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCognome.setBounds(620, 280, 425, 68);
		registrazione.add(reglblSfondoCognome);
	}
	
	public JButton getRegbtnStampaTessera() {
		return this.regbtnStampaTessera;
	}
	
	public void setJPanelRegistrazione() {
		registrazione = new JPanel();
		registrazione.setOpaque(false);
		registrazione.setLayout(null);	
		lblCF();
		lblNome();
		lblCognome();
		h=new Home();
		h.btnProblemiAssistenza(registrazione);
		h.btnInfo(registrazione);
		h.lblLogo(registrazione);
		h.btnChiudiSessione(registrazione);
		dateChooser();
		txtCodiceFiscale();
		lblSfondoCodiceFiscale();
		s=new Scansione();
		s.btnIndietro(registrazione);
		btnStampaTessera();
        txtPaneRegistrazioneTessera();	
		txtFieldNome();
		lblDataDiNascita();
		txtFieldCognome();
		lblSfondoNome();
		lblSfondoCognome();
		
		
	}
	
	public  JPanel getJPanelRegistrazione() {
		return registrazione;
	}
	
}
