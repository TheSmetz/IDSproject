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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.StyledDocument;

public class Assistenza extends JFrame {

	JPanel assistenza;
	JLabel asslblAssistenza;
	JTextPane asstxtpnTelefonoEmail;

	private void lblAssistenza() {
		JLabel asslblAssistenza = new JLabel("ASSISTENZA");
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
	
	private void setJPanelAssistenza() {
		assistenza = new JPanel();
		assistenza.setLayout(null);
		assistenza.setOpaque(false);
		lblAssistenza();
		txtpnTelefonoEmail();		
		Home.btnInfo(assistenza);		
		Home.lblLogo(assistenza);
		Home.btnChiudiSessione(assistenza);
		About.btnHomePage(assistenza);
	}
	
	public JPanel getJPanelAssistenza() {
		setJPanelAssistenza();
		return assistenza;
	}
}