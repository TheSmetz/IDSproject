package ids.unicam.trashit.start;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ids.unicam.trashit.grafica.About;
import ids.unicam.trashit.grafica.Conferimento;
import ids.unicam.trashit.grafica.GuiMain;
import ids.unicam.trashit.grafica.Home;
import ids.unicam.trashit.grafica.IstruzioniConferimento;
import ids.unicam.trashit.grafica.Registrazione;
import ids.unicam.trashit.grafica.RitiroPremio;
import ids.unicam.trashit.grafica.Scansione;
import ids.unicam.trashit.grafica.ScansioneTessera;
import ids.unicam.trashit.grafica.Sessione;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JLayeredPane;



public class Start extends JFrame implements ActionListener{
	
	public static JPanel contentPane;
	public static JLayeredPane layeredPane;
	private JLabel background;
	private Sessione sess;
	private Home h;
	private Scansione c;
	private RitiroPremio ritPremio;
	private Registrazione reg;
	private About ab;
	private Conferimento conf;
	private ScansioneTessera scanTessera;
	private IstruzioniConferimento istrConferimento;
	
	private void creaJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/aaa.png")));
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
	}
	
	private void creaJPanels() {
		h = new Home();		
		h.setJPanelHome();
		layeredPane.add(h.getJPanelHome());
		
		c = new Scansione();
		c.setJPanelScansione();
		layeredPane.add(c.getJPanelScansione());
//		
//		sess = new Sessione();
//		layeredPane.add(sess.getJPanelSessione());
//		
		ritPremio = new RitiroPremio();
		ritPremio.setJPanelRitiro();
		layeredPane.add(ritPremio.getJPanelRitiroPremio());
//		
//		reg = new Registrazione();
//		layeredPane.add(reg.getJPanelRegistrazione());
//		
//		ab = new About();
//		layeredPane.add(ab.getJPanelAbout());
//		
//		conf = new Conferimento();
//		layeredPane.add(conf.getJPanelConferimento());
//
//		scanTessera = new ScansioneTessera();
//		layeredPane.add(scanTessera.getJPanelScansioneTessera());
//		
//		istrConferimento = new IstruzioniConferimento();
//		layeredPane.add(istrConferimento.getJPanelIstruzioni());
	}
	
	private void addActionListnerHome() {
		h.gethomebtnScansione().addActionListener(this);
		h.gethomebtnRitiroPremio().addActionListener(this);
		h.getHomebtnCreaTessera().addActionListener(this);
		h.gethomebtnInfo().addActionListener(this);
		h.getHomebtnProblemiAssistenza().addActionListener(this);
		h.gethomebtnChiudiSessione().addActionListener(this);
	}
	
	private void addActionListnerScansione() {
		c.getBtnIndietro().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//HOME
		if (e.getSource() == h.gethomebtnScansione()) {
			System.out.println("SCANSIONE");
			switchPanel(c.getJPanelScansione());
		}else if (e.getSource() == h.gethomebtnRitiroPremio()) {
			switchPanel(ritPremio.getJPanelRitiroPremio());
		}else if (e.getSource() == h.getHomebtnCreaTessera()) {
			System.out.println("TESSERA");
		}else if (e.getSource() == h.gethomebtnInfo()) {
			System.out.println("INFO");
		}else if (e.getSource() == h.getHomebtnProblemiAssistenza()) {
			System.out.println("PROBLEMI");
		}else if (e.getSource() == h.gethomebtnChiudiSessione()) {
			System.out.println("SESSIONE");
		}
		
		//SCANSIONE
		if (e.getSource() == c.getBtnIndietro()) {
			switchPanel(h.getJPanelHome());
		}
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
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
	}
	
	public Start() {
		creaJFrame();
		creaJPanels();
		addActionListnerHome();
		addActionListnerScansione();
		background();	
	}
	
	
	
    public static void main(String[] args) throws Exception{
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