package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Assistenza {

	public static JPanel assistenza;
	private JLabel asslblAssistenza;
	private JTextPane asstxtpnTelefonoEmail;
	private JButton btnSvuotaCestini;

	private void lblAssistenza() {
		asslblAssistenza = new JLabel("ASSISTENZA");
		asslblAssistenza.setHorizontalAlignment(SwingConstants.CENTER);
		asslblAssistenza.setForeground(Color.BLACK);
		asslblAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		asslblAssistenza.setBounds(416, 0, 629, 57);
		assistenza.add(asslblAssistenza);
	}

	private void txtpnTelefonoEmail() {
		asstxtpnTelefonoEmail = new JTextPane();
		asstxtpnTelefonoEmail.setEditable(false);
		asstxtpnTelefonoEmail.setText("Telefono: 000000000");
		asstxtpnTelefonoEmail.setText(asstxtpnTelefonoEmail.getText() + "\n\nEmail: trashit@gmail.com");
		asstxtpnTelefonoEmail.setOpaque(false);
		asstxtpnTelefonoEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		asstxtpnTelefonoEmail.setBounds(450, 86, 629, 100);
		assistenza.add(asstxtpnTelefonoEmail);
	}
	
	private void btnSvuotaCestini() {
		btnSvuotaCestini = new JButton("Svuota Cestini", new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/bluebuttonSmall.png")));
		btnSvuotaCestini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(assistenza, "Cestini svuotati, il macchinario può ricominciare a funzionare correttamente");
				Conferimento.cestinoSessione.svuotaTuttiCestini();
				GestoreGrafica.startTimer(30);
			}
		});
		btnSvuotaCestini.setVerticalTextPosition(SwingConstants.CENTER);
		btnSvuotaCestini.setMargin(new Insets(0, 0, 0, 0));
		btnSvuotaCestini.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSvuotaCestini.setForeground(Color.WHITE);
		btnSvuotaCestini.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnSvuotaCestini.setContentAreaFilled(false);
		btnSvuotaCestini.setBorderPainted(false);
		btnSvuotaCestini.setBounds(416, 400, 629, 96);
		assistenza.add(btnSvuotaCestini);
		
	}

	public void setJPanelAssistenza() {
		assistenza = new JPanel();
		assistenza.setLayout(null);
		assistenza.setOpaque(false);
		lblAssistenza();
		txtpnTelefonoEmail();
		Home.btnInfo(assistenza);
		Home.lblLogo(assistenza);
		Home.btnChiudiSessione(assistenza);
		About.btnHomePage(assistenza);
		btnSvuotaCestini();
	}

	public JPanel getJPanelAssistenza() {
		return assistenza;
	}
}