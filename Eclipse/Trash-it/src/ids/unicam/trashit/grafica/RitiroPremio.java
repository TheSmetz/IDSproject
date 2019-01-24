package ids.unicam.trashit.grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RitiroPremio extends JPanel{
	JPanel ritiroPremio;
	JLabel label;
	JLabel RitirolblCoupon;
	ButtonGroup buoniSconto;
	JRadioButton ritirooption10;
	JRadioButton ritirooption30;
	JRadioButton ritirooption50;
	JRadioButton ritirooption75;
	JButton ritirobtnRitira;
	JLabel ritirolblPuntiTessera;
	JLabel ritirolblRitiroPremio;
	JLabel ritirolblSelezionePremio;
	JButton ritirobtnChiudiSessione;
	JLabel ritirolblLogo;
	

	private void setJPanelRitiro() {
		ritiroPremio = new JPanel();
		ritiroPremio.setLayout(null);		
		ritiroPremio.setOpaque(false);
		Home.lblLogo(ritiroPremio);
		Home.btnInfo(ritiroPremio);
		Home.btnProblemiAssistenza(ritiroPremio);
		Home.btnChiudiSessione(ritiroPremio);
		lblSelezionePremio();
		lblRitiroPremio();
		lblPuntiTessera();
		btnRitira();
		btnsSconti();
//		lblCoupon();
	}

	private void lblSelezionePremio() {
		ritirolblSelezionePremio = new JLabel("Seleziona un premio");
		ritirolblSelezionePremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblSelezionePremio.setForeground(Color.BLACK);
		ritirolblSelezionePremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblSelezionePremio.setBounds(416, 56, 629, 57);
		ritiroPremio.add(ritirolblSelezionePremio);
	}

	private void lblRitiroPremio() {
		ritirolblRitiroPremio = new JLabel("RITIRO PREMI");
		ritirolblRitiroPremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblRitiroPremio.setForeground(Color.BLACK);
		ritirolblRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		ritirolblRitiroPremio.setBounds(416, 0, 629, 57);
		ritiroPremio.add(ritirolblRitiroPremio);
		
	}

	private void lblPuntiTessera() {
		ritirolblPuntiTessera = new JLabel("Punti tessera: ");
		ritirolblPuntiTessera.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblPuntiTessera.setForeground(Color.BLACK);
		ritirolblPuntiTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblPuntiTessera.setBounds(416, 113, 629, 57);
		ritiroPremio.add(ritirolblPuntiTessera);
		
	}

	private void btnRitira() {
		ritirobtnRitira = new JButton("Ritira", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnRitira.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnRitira.setOpaque(false);
		ritirobtnRitira.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnRitira.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnRitira.setForeground(Color.BLACK);
		ritirobtnRitira.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnRitira.setContentAreaFilled(false);
		ritirobtnRitira.setBorderPainted(false);
		ritirobtnRitira.setBounds(416, 526, 629, 57);
		ritiroPremio.add(ritirobtnRitira);
		
	}

	private void btnsSconti() {  //DA CONTROLLARE
		ritirooption10 = new JRadioButton(" 10%");
		ritirooption10.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption10.setBounds(465, 250, 127, 50);
		ritirooption10.setOpaque(false);
		ritiroPremio.add(ritirooption10);
		
		ritirooption30 = new JRadioButton(" 30%");
		ritirooption30.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption30.setBounds(465, 300, 127, 50);
		ritirooption30.setOpaque(false);
		ritiroPremio.add(ritirooption30);
		
		ritirooption50 = new JRadioButton(" 50%");
		ritirooption50.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption50.setBounds(465, 350, 127, 50);
		ritirooption50.setOpaque(false);
		ritiroPremio.add(ritirooption50);
		
		ritirooption75 = new JRadioButton(" 75%");
		ritirooption75.setFont(new Font("Dialog", Font.PLAIN, 30));
		ritirooption75.setBounds(465, 400, 127, 50);
		ritirooption75.setOpaque(false);
		ritiroPremio.add(ritirooption75);
		
		buoniSconto = new ButtonGroup();
		buoniSconto.add(ritirooption10);
		buoniSconto.add(ritirooption30);
		buoniSconto.add(ritirooption50);
		buoniSconto.add(ritirooption75);
		
	}

	private void lblCoupon() {
		RitirolblCoupon = new JLabel("");
		label.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/ccc.png")));
		label.setBounds(609, 248, 424, 199);
		ritiroPremio.add(label);
		
	}
	public JPanel getJPanelRitiroPremio() {
		setJPanelRitiro();
		return ritiroPremio;
		
	}
	
}