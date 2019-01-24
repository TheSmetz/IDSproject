package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class Assistenza {

	private JPanel assistenza;
	private JLabel asslblAssistenza;
	private JTextPane asstxtpnTelefonoEmail;
	private Home h;
	private About a;

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
	
	@SuppressWarnings("unused")
	public void setJPanelAssistenza() {
		assistenza = new JPanel();
		assistenza.setLayout(null);
		assistenza.setOpaque(false);
		lblAssistenza();
		txtpnTelefonoEmail();	
		h=new Home();
		h.btnInfo(assistenza);		
		h.lblLogo(assistenza);
		h.btnChiudiSessione(assistenza);
		a=new About();
		a.btnHomePage(assistenza);
	}
	
	public JPanel getJPanelAssistenza() {
		return this.assistenza;
	}
}