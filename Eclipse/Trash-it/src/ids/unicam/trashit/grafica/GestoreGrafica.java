package ids.unicam.trashit.grafica;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ids.unicam.trashit.grafica.About;
import ids.unicam.trashit.grafica.Assistenza;
import ids.unicam.trashit.grafica.Conferimento;
import ids.unicam.trashit.grafica.Home;
import ids.unicam.trashit.grafica.IstruzioniConferimento;
import ids.unicam.trashit.grafica.Registrazione;
import ids.unicam.trashit.grafica.RitiroPremio;
import ids.unicam.trashit.grafica.Scansione;
import ids.unicam.trashit.grafica.ScansioneTessera;
import ids.unicam.trashit.grafica.Sessione;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class GestoreGrafica extends JFrame {
	public static JPanel contentPane;
	public static JLayeredPane layeredPane;
	private JLabel background;
	public static Sessione sessione;
	public static Home home;
	public static Scansione scansione;
	public static RitiroPremio ritiroPremio;
	public static Registrazione registrazione;
	public static Assistenza assistenza;
	public static About about;
	public static Conferimento conferimento;
	public static ScansioneTessera scanTessera;
	public static IstruzioniConferimento istruzioniConferimento;
	// TIMER
	private static int seconds;
	public static Timer timer;
	
	public static void startTimer(int durata) {
		seconds = durata;
		if (timer.isRunning()) {
			timer.stop();			
			timer.start();
		} else {
			timer.start();			
		}
	}

	private void timer() {
		// TIMER
		JLabel lblTimer = new JLabel("Timer Sessione");
		lblTimer.setBounds(0, 0, 281, 45);
		contentPane.add(lblTimer);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 30));

		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seconds >= 0) {
					lblTimer.setText(String.valueOf(seconds));
					seconds--;
				} else {
					timer.stop();
					// salvare impostazioni
					switchPanel(sessione.getJPanelSessione());
				}
			}
		});
	}

	private void creaJFrame() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ids/unicam/trashit/grafica/immagini/aaa.png")));
		setTitle("Trash-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1045, 699);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		timer();
	}

	private void creaJPanels(String citta) {
		sessione = new Sessione();
		sessione.setJPanelSessione();
		layeredPane.add(sessione.getJPanelSessione());

		home = new Home();
		home.setJPanelHome();
		home.setCitta(citta);
		layeredPane.add(home.getJPanelHome());

		scansione = new Scansione();
		scansione.setJPanelScansione();
		layeredPane.add(scansione.getJPanelScansione());

		scanTessera = new ScansioneTessera();
		scanTessera.setJPanelScansioneTessera();
		layeredPane.add(scanTessera.getJPanelScansioneTessera());

		ritiroPremio = new RitiroPremio();
		ritiroPremio.setJPanelRitiro();
		layeredPane.add(ritiroPremio.getJPanelRitiroPremio());

		registrazione = new Registrazione();
		registrazione.setJPanelRegistrazione();
		layeredPane.add(registrazione.getJPanelRegistrazione());

		about = new About();
		about.setJPanelAbout();
		layeredPane.add(about.getJPanelAbout());

		assistenza = new Assistenza();
		assistenza.setJPanelAssistenza();
		layeredPane.add(assistenza.getJPanelAssistenza());

		conferimento = new Conferimento();
		conferimento.setJPanelConferimento();
		layeredPane.add(conferimento.getJPanelConferimento());

		istruzioniConferimento = new IstruzioniConferimento();
		istruzioniConferimento.setJPanelIstruzioni();
		layeredPane.add(istruzioniConferimento.getJPanelIstruzioni());
	}

	public static void switchPanel(JPanel panelName) {
		layeredPane.removeAll();
		layeredPane.add(panelName);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private void background() {
		background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(getClass().getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
	}

	public GestoreGrafica(String citta) {
		creaJFrame();
		creaJPanels(citta);
		background();
	}
}
