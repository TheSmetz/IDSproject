package ids.unicam.trashit.start;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ids.unicam.trashit.grafica.About;
import ids.unicam.trashit.grafica.Assistenza;
import ids.unicam.trashit.grafica.Conferimento;
import ids.unicam.trashit.grafica.GuiMain;
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
public class Start extends JFrame {

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
	private int seconds;
	public Timer timer;
	private JButton button;

	private void startTimer() {
		if (timer.isRunning()) {
			timer.stop();
			System.out.println("STOP");
		} else {
			timer.start();
			System.out.println("START");
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
					System.out.println(seconds);
					lblTimer.setText(String.valueOf(seconds));
					seconds--;
				} else {
					System.out.println("TEMPO SCADUTO");
					timer.stop();
					// salvare impostazioni
					switchPanel(Sessione.sessione);
				}
			}
		});
	}

	private void creaJFrame() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/aaa.png")));
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
		layeredPane.add(Sessione.sessione);

		h = new Home();
		h.setJPanelHome();
		layeredPane.add(h.getJPanelHome());

		c = new Scansione();
		c.setJPanelScansione();
		layeredPane.add(c.getJPanelScansione());

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

		scanTessera = new ScansioneTessera();
		scanTessera.setJPanelScansioneTessera();
		layeredPane.add(scanTessera.getJPanelScansioneTessera());

		istrConferimento = new IstruzioniConferimento();
		istrConferimento.setJPanelIstruzioni();
		layeredPane.add(istrConferimento.getJPanelIstruzioni());
	}
//
//	private void addActionListnerSessione() {
//		sess.getsessionebtnAvviaSessione().addActionListener(this);
//	}
//
//	private void addActionListnerHome() {
//		h.gethomebtnScansione().addActionListener(this);
//		h.gethomebtnRitiroPremio().addActionListener(this);
//		h.getHomebtnCreaTessera().addActionListener(this);
//		h.gethomebtnInfo().addActionListener(this);
//		h.getHomebtnProblemiAssistenza().addActionListener(this);
//	}
//
//	private void addActionListnerScansione() {
//		// c.getbtnIndietro().addActionListener(this);
//		c.getbtnAvviaScansione().addActionListener(this);
//	}
//
//	private void addActionListnerRitiroPremio() {
//		ritPremio.getritirobtnRitira().addActionListener(this);
//	}
//
//	private void addActionListnerAbout() {
//		ab.getaboutbtnHomePage().addActionListener(this);
//	}
//
//	private void addActionListnerAssistenza() {
//
//	}
//
//	private void addActionListnerConferimento() {
//		conf.getbtnProdottoVisualizzatoCorretto().addActionListener(this);
//		conf.getbtnProdottoVisualizzatoErrato().addActionListener(this);
//
//	}
//
//	private void addActionListnerIstruzioniConferimento() {
//		istrConferimento.getIstrbtnNuovaScansione().addActionListener(this);
//
//	}
//
//	private void addActionListnerRegistrazione() {
//		reg.getRegbtnStampaTessera().addActionListener(this);
//
//	}
//
//	private void addActionListnerScansioneTessera() {
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if (e.getSource() == button) {
//			switchPanel(h.getJPanelHome());
//		}
//
//		// SESSIONE
//		if (e.getSource() == sess.getsessionebtnAvviaSessione()) {
//			switchPanel(h.getJPanelHome());
//			seconds = 30;
//			startTimer();
//		}
//
//		// HOME
//		if (e.getSource() == h.gethomebtnScansione()) {
//			switchPanel(c.getJPanelScansione());
//			seconds = 30;
//		} else if (e.getSource() == h.gethomebtnRitiroPremio()) {
//			switchPanel(ritPremio.getJPanelRitiroPremio());
//			seconds = 30;
//		} else if (e.getSource() == h.getHomebtnCreaTessera()) {
//			switchPanel(reg.getJPanelRegistrazione());
//			seconds = 120;
//		} else if (e.getSource() == h.gethomebtnInfo()) {
//			switchPanel(ab.getJPanelAbout());
//			seconds = 30;
//		} else if (e.getSource() == h.getHomebtnProblemiAssistenza()) {
//			switchPanel(ass.getJPanelAssistenza());
//			seconds = 30;
//		}
//
//		// SCANSIONE
//		if (e.getSource() == c.getbtnAvviaScansione()) {
//			switchPanel(conf.getJPanelConferimento());
//			seconds = 30;
//		}
//
//		// CONFERIMENTO
//		if (e.getSource() == conf.getbtnProdottoVisualizzatoCorretto()) {
//			switchPanel(istrConferimento.getJPanelIstruzioni());
//			seconds = 60;
//		} else if (e.getSource() == conf.getbtnProdottoVisualizzatoErrato()) {
//			switchPanel(c.getJPanelScansione());
//			seconds = 30;
//		}
//
//		// ISTRUZIONI CONFERIMENTO
//		if (e.getSource() == istrConferimento.getIstrbtnNuovaScansione()) {
//			switchPanel(c.getJPanelScansione());
//			seconds = 30;
//		}
//
//		// RITIRO PREMIO
//		if (e.getSource() == ritPremio.getritirobtnRitira()) {
//			System.out.println("+++STAMPA BIGLIETTO+++");
//		}
//
//		// REGISTRAZIONE
//		if (e.getSource() == reg.getRegbtnStampaTessera()) {
//			System.out.println("AGGIUNTA AL DB E STAMPA TESSERA");
//		}
//
//		// ABOUT
//		if (e.getSource() == ab.getaboutbtnHomePage()) {
//			System.out.println("HOME");
//			switchPanel(h.getJPanelHome());
//			seconds = 30;
//		}
//	}

	public static void switchPanel(JPanel panelName) {
		layeredPane.removeAll();
		layeredPane.add(panelName);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private void background() {
		background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
	}

	public Start() {
		creaJFrame();
		creaJPanels();
//		addActionListnerSessione();
//		addActionListnerHome();
//		addActionListnerScansione();
//		addActionListnerRitiroPremio();
//		addActionListnerAssistenza();
//		addActionListnerConferimento();
//		addActionListnerIstruzioniConferimento();
//		addActionListnerRegistrazione();
//		addActionListnerScansioneTessera();
//		addActionListnerAbout();
		background();
	}

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}