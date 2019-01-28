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
	public Sessione sess;
	private Home h;
	private Scansione c;
	private RitiroPremio ritPremio;
	private Registrazione reg;
	private Assistenza ass;
	private About ab;
	private Conferimento conf;
	private ScansioneTessera scanTessera;
	private IstruzioniConferimento istrConferimento;
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
					switchPanel(Sessione.sessione);
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

	private void creaJPanels() {
		sess = new Sessione();
		sess.setJPanelSessione();
		layeredPane.add(sess.getJPanelSessione());

		h = new Home();
		h.setJPanelHome();
		layeredPane.add(h.getJPanelHome());

		c = new Scansione();
		c.setJPanelScansione();
		layeredPane.add(c.getJPanelScansione());

		scanTessera = new ScansioneTessera();
		scanTessera.setJPanelScansioneTessera();
		layeredPane.add(scanTessera.getJPanelScansioneTessera());

		ritPremio = new RitiroPremio();
		ritPremio.setJPanelRitiro();
		layeredPane.add(ritPremio.getJPanelRitiroPremio());

		reg = new Registrazione();
		reg.setJPanelRegistrazione();
		layeredPane.add(reg.getJPanelRegistrazione());

		ab = new About();
		ab.setJPanelAbout();
		layeredPane.add(ab.getJPanelAbout());

		ass = new Assistenza();
		ass.setJPanelAssistenza();
		layeredPane.add(ass.getJPanelAssistenza());

		conf = new Conferimento();
		conf.setJPanelConferimento();
		layeredPane.add(conf.getJPanelConferimento());

		istrConferimento = new IstruzioniConferimento();
		istrConferimento.setJPanelIstruzioni();
		layeredPane.add(istrConferimento.getJPanelIstruzioni());
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

	public GestoreGrafica() {
		creaJFrame();
		creaJPanels();
		background();
	}
}
