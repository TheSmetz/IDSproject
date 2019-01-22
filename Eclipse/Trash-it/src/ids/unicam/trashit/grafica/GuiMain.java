package ids.unicam.trashit.grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ids.unicam.trashit.console.AggiuntaDB;
import ids.unicam.trashit.console.CestinoSmart;
import ids.unicam.trashit.console.Policy;
import ids.unicam.trashit.console.Prodotto;
import ids.unicam.trashit.console.Tessera;
import ids.unicam.trashit.start.Start;

import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class GuiMain extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	//tessera
	private int puntiTessera;
	private String idTessera;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String nascitaTessera;
	
	private Tessera tesseraGui;
	
	
	// descrizione prodotto
	private String barcodeProdotto; // barcode
	//private String nomeProdotto; // nome
	//private String descrizioneProdotto; // decrizione
	//private byte[] imgProdotto; // immagine
	//private int puntiProdotto; //punti
	protected String[] args;
	private JTextField scantxtInputBarcode;	//input barcode
	
	private String citta = "AP";
	
	//TIMER
	private int seconds;
    private SimpleDateFormat df;
    private Timer timer;

    public void startTimer() {
    	if(timer.isRunning()) {
            timer.stop();
            System.out.println("STOP");
        }else {
            timer.start();
            System.out.println("START");   
        }
    }
    
	
	private Prodotto prodottoScansionato;
	private Policy policyProdotto;
	private JLabel scanlblBenvenuto;
	private JButton scannbtnInfo;
	private JTextField textField;
	private Tessera tesseraScansionata;
	private JTextField regtxtCodiceFiscale;
	private JTextField regtextFieldNome;
	private JTextField regtextFieldCognome;
	//public CestinoSmart cestinoS;	

	public void switchPanel(JPanel panelName) {
		layeredPane.removeAll();
		layeredPane.add(panelName);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public GuiMain() {
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


		//--------------DICHIARAZIONE PANEL--------------
		
		//SESSIONE
		JPanel sessione = new JPanel();
		layeredPane.add(sessione, "name_793346484234400");
		sessione.setOpaque(true);
		sessione.setLayout(null);
		sessione.setBackground(Color.WHITE);
		
		//HOME
		JPanel home = new JPanel();
		layeredPane.add(home, "name_781337426904700");
		home.setOpaque(false);
		home.setLayout(null);
		
		//REGISTRAZIONE
		JPanel registrazione = new JPanel();
		layeredPane.add(registrazione, "name_1727413037300");
		registrazione.setOpaque(false);
		registrazione.setLayout(null);	
		
		JLabel reglblCF = new JLabel("Codice Fiscale:");
		reglblCF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCF.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCF.setBounds(416, 113, 192, 31);
		registrazione.add(reglblCF);
		
		JLabel reglblNome = new JLabel("Nome:");
		reglblNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblNome.setBounds(416, 185, 192, 31);
		registrazione.add(reglblNome);
		
		JLabel reglblCognome = new JLabel("Cognome:");
		reglblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblCognome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblCognome.setBounds(416, 264, 192, 31);
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
		regdateChooser.setBounds(694, 328, 275, 45);
		regdateChooser.getJCalendar().setPreferredSize(new Dimension(400, 300));
		registrazione.add(regdateChooser);
		
		regtxtCodiceFiscale = new JTextField();
		regtxtCodiceFiscale.setOpaque(false);
		regtxtCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		regtxtCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtxtCodiceFiscale.setColumns(10);
		regtxtCodiceFiscale.setBounds(694, 106, 275, 44);
		registrazione.add(regtxtCodiceFiscale);
		
		JLabel reglblSfondoCodiceFiscale = new JLabel("");
		reglblSfondoCodiceFiscale.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCodiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCodiceFiscale.setBounds(620, 94, 425, 68);
		registrazione.add(reglblSfondoCodiceFiscale);
		
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
				}
				
//				tesseraGui = new Tessera(regtxtCodiceFiscale.getText());
				nascitaTessera = sdf.format(regdateChooser.getDate());
//				System.out.println(regtxtCodiceFiscale.getText());
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
		
		JLabel reglblRegistrazioneTessera = new JLabel("Registrazione tessera, inserisci i tuoi dati:");
		reglblRegistrazioneTessera.setHorizontalAlignment(SwingConstants.CENTER);
		reglblRegistrazioneTessera.setForeground(Color.BLACK);
		reglblRegistrazioneTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		reglblRegistrazioneTessera.setBounds(416, 0, 629, 57);
		registrazione.add(reglblRegistrazioneTessera);
		
		
		regtextFieldNome = new JTextField();
		regtextFieldNome.setOpaque(false);
		regtextFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldNome.setColumns(10);
		regtextFieldNome.setBounds(698, 178, 271, 44);
		registrazione.add(regtextFieldNome);
		
		
		
		regtextFieldCognome = new JTextField();
		regtextFieldCognome.setOpaque(false);
		regtextFieldCognome.setHorizontalAlignment(SwingConstants.CENTER);
		regtextFieldCognome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regtextFieldCognome.setColumns(10);
		regtextFieldCognome.setBounds(698, 256, 271, 44);
		registrazione.add(regtextFieldCognome);
		
		JLabel reglblDataDiNascita = new JLabel("Data di nascita:");
		reglblDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		reglblDataDiNascita.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reglblDataDiNascita.setBounds(416, 339, 192, 31);
		registrazione.add(reglblDataDiNascita);
		
		JLabel reglblSfondoNome = new JLabel("");
		reglblSfondoNome.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoNome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoNome.setBounds(620, 166, 429, 68);
		registrazione.add(reglblSfondoNome);
		
		JLabel reglblSfondoCognome = new JLabel("");
		reglblSfondoCognome.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		reglblSfondoCognome.setHorizontalAlignment(SwingConstants.CENTER);
		reglblSfondoCognome.setBounds(620, 244, 425, 68);
		registrazione.add(reglblSfondoCognome);
		
		//RITIROPREMIO
		JPanel ritiroPremio = new JPanel();
		layeredPane.add(ritiroPremio, "name_1042826559621000");
		ritiroPremio.setLayout(null);		
		ritiroPremio.setOpaque(false);
		
		//SCANSIONE TESSEERA
		JPanel scansioneTessera = new JPanel();
		layeredPane.add(scansioneTessera, "name_1043256396947700");
		scansioneTessera.setOpaque(false);
		scansioneTessera.setLayout(null);
		
		JTextField scanTesseratxtInputCodice = new JTextField();
		scanTesseratxtInputCodice.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtInputCodice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtInputCodice.setBounds(600, 383, 275, 44);
		scanTesseratxtInputCodice.setOpaque(false);
		scansioneTessera.add(scanTesseratxtInputCodice);
		scanTesseratxtInputCodice.setColumns(10);
		
		//SCANSIONE
		JPanel scansione = new JPanel();
		layeredPane.add(scansione, "name_47697602642643");
		scansione.setOpaque(false);
		scansione.setLayout(null);
		
		//CONFERIMENTO
		JPanel conferimento = new JPanel();
		layeredPane.add(conferimento, "name_47730555398847");
		conferimento.setOpaque(false);
		conferimento.setLayout(null);
		JLabel conflblImmagineProdotto = new JLabel("immagine prodotto");
		
		//ISTRUZIONI CONFERIMENTO
		JPanel istruzioneConf = new JPanel();
		layeredPane.add(istruzioneConf, "name_47764772881651");
		istruzioneConf.setOpaque(false);
		istruzioneConf.setLayout(null);
		String newLine = System.getProperty("line.separator");
		
		//ERRORE CONFERIMENTO
		JPanel erroreConf = new JPanel();
		erroreConf.setLayout(null);
		erroreConf.setOpaque(false);
		layeredPane.add(erroreConf, "name_2585705284100");
		
		//ASSISTENZA
		JPanel assistenza = new JPanel();
		layeredPane.add(assistenza, "name_783099324881200");
		assistenza.setLayout(null);
		assistenza.setOpaque(false);
		
		//ABOUT
		JPanel about = new JPanel();
		layeredPane.add(about, "name_962290729165700");
		about.setLayout(null);
		about.setOpaque(false);
	
		
		
		//--------------CONTENUTI PANEL--------------	
		
		
		//TIMER
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
            	}else {
            		System.out.println("TEMPO SCADUTO");
            		timer.stop();
            		
            		//salvare impostazioni
            		switchPanel(sessione);
            	}
            }
        });
		
		//SESSIONE
		JLabel sessionelblLogo = new JLabel(""); 
		sessionelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logog.png")));
		sessionelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblLogo.setBounds(0, 68, 1045, 505);
		sessione.add(sessionelblLogo);
		
		JLabel sessionelblSessione = new JLabel("Guadagna PREMI salvando l'ambiente!");
		sessionelblSessione.setHorizontalAlignment(SwingConstants.CENTER);
		sessionelblSessione.setForeground(Color.BLACK);
		sessionelblSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		sessionelblSessione.setBounds(0, 0, 1045, 57);
		sessione.add(sessionelblSessione);
		
		JButton sessionebtnAvviaScansione = new JButton("AVVIA SESSIONE", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		sessionebtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
				seconds = 30;
				startTimer();			
			}
		});
		
		sessionebtnAvviaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		sessionebtnAvviaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		sessionebtnAvviaScansione.setForeground(Color.BLACK);
		sessionebtnAvviaScansione.setFont(new Font("Calibri", Font.BOLD, 30));
		sessionebtnAvviaScansione.setContentAreaFilled(false);
		sessionebtnAvviaScansione.setBorderPainted(false);
		sessionebtnAvviaScansione.setBounds(0, 590, 1045, 96);
		sessione.add(sessionebtnAvviaScansione);
		
		JLabel sesslblFreccia = new JLabel("");
		sesslblFreccia.setToolTipText("");
		sesslblFreccia.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/freccia.gif")));
		sesslblFreccia.setBounds(728, 54, 240, 598);
		sessione.add(sesslblFreccia);
		
		//HOME		
		JLabel homelblBenvenuto = new JLabel("BENVENUTO");
		homelblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		homelblBenvenuto.setForeground(Color.BLACK);
		homelblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		homelblBenvenuto.setBounds(416, 0, 629, 57);
		home.add(homelblBenvenuto);
		
		JLabel homelblSelezionaOperazione = new JLabel("Seleziona un'operazione");
		homelblSelezionaOperazione.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSelezionaOperazione.setForeground(Color.BLACK);
		homelblSelezionaOperazione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		homelblSelezionaOperazione.setBounds(416, 97, 629, 57);
		home.add(homelblSelezionaOperazione);
		
		JButton homebtnScansione = new JButton("SCANSIONA PRODOTTO", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		homebtnScansione.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setMargin(new Insets(0, 0, 0, 0));
		homebtnScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnScansione.setForeground(Color.BLACK);
		homebtnScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnScansione.setContentAreaFilled(false);
		homebtnScansione.setBorderPainted(false);
		homebtnScansione.setBounds(416, 167, 629, 82);
		homebtnScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
				seconds = 30;
			}
		});
		home.add(homebtnScansione);
		
		JButton homebtnRitiroPremio = new JButton("RITIRO PREMI", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		homebtnRitiroPremio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(scansioneTessera);
				seconds = 30;
			}
		});
		homebtnRitiroPremio.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setMargin(new Insets(0, 0, 0, 0));
		homebtnRitiroPremio.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnRitiroPremio.setForeground(Color.BLACK);
		homebtnRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnRitiroPremio.setContentAreaFilled(false);
		homebtnRitiroPremio.setBorderPainted(false);
		homebtnRitiroPremio.setBounds(416, 276, 629, 72);
		home.add(homebtnRitiroPremio);
		SimpleAttributeSet centerT = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerT, StyleConstants.ALIGN_CENTER);

		
		JButton homebtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		homebtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		homebtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		homebtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnProblemiAssistenza.setForeground(Color.BLACK);
		homebtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnProblemiAssistenza.setContentAreaFilled(false);
		homebtnProblemiAssistenza.setBorderPainted(false);
		homebtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		home.add(homebtnProblemiAssistenza);
		
		JButton homebtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		homebtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		homebtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnInfo.setOpaque(false);
		homebtnInfo.setMargin(new Insets(0, 0, 0, 0));
		homebtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnInfo.setForeground(Color.BLACK);
		homebtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnInfo.setContentAreaFilled(false);
		homebtnInfo.setBorderPainted(false);
		homebtnInfo.setBounds(0, 456, 418, 57);
		home.add(homebtnInfo);
		
		JLabel homelblLogo = new JLabel("");
		homelblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		homelblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblLogo.setBounds(0, 0, 418, 488);
		home.add(homelblLogo);
		
		JButton homebtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		homebtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		homebtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnChiudiSessione.setOpaque(false);
		homebtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		homebtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnChiudiSessione.setForeground(Color.WHITE);
		homebtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnChiudiSessione.setContentAreaFilled(false);
		homebtnChiudiSessione.setBorderPainted(false);
		homebtnChiudiSessione.setBounds(416, 613, 629, 57);
		home.add(homebtnChiudiSessione);
		
		JButton homebtnCreaTessera = new JButton("CREA TESSERA", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/bluebuttonSmall.png")));
		homebtnCreaTessera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(registrazione);
				seconds = 60;
			}
		});
		homebtnCreaTessera.setVerticalTextPosition(SwingConstants.CENTER);
		homebtnCreaTessera.setMargin(new Insets(0, 0, 0, 0));
		homebtnCreaTessera.setHorizontalTextPosition(SwingConstants.CENTER);
		homebtnCreaTessera.setForeground(Color.WHITE);
		homebtnCreaTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		homebtnCreaTessera.setContentAreaFilled(false);
		homebtnCreaTessera.setBorderPainted(false);
		homebtnCreaTessera.setBounds(416, 438, 629, 96);
		home.add(homebtnCreaTessera);
		
		JLabel homelblSeiNuovo = new JLabel("Sei nuovo in Trash-it? Crea la tua tessera");
		homelblSeiNuovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		homelblSeiNuovo.setHorizontalAlignment(SwingConstants.CENTER);
		homelblSeiNuovo.setBounds(416, 400, 629, 40);
		home.add(homelblSeiNuovo);
		
		//RITIRO PREMI
		JLabel ritirolblLogo = new JLabel("");
		ritirolblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		ritirolblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblLogo.setBounds(0, 0, 418, 488);
		ritiroPremio.add(ritirolblLogo);
		
		
		
		
		
		
		JButton ritirobtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		ritirobtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnInfo.setOpaque(false);
		ritirobtnInfo.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnInfo.setForeground(Color.BLACK);
		ritirobtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnInfo.setContentAreaFilled(false);
		ritirobtnInfo.setBorderPainted(false);
		ritirobtnInfo.setBounds(0, 456, 418, 57);
		ritiroPremio.add(ritirobtnInfo);
		
		JButton ritirobtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		ritirobtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
			}
		});
		ritirobtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnProblemiAssistenza.setForeground(Color.BLACK);
		ritirobtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnProblemiAssistenza.setContentAreaFilled(false);
		ritirobtnProblemiAssistenza.setBorderPainted(false);
		ritirobtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		ritiroPremio.add(ritirobtnProblemiAssistenza);
		
		JButton ritirobtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		ritirobtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		ritirobtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		ritirobtnChiudiSessione.setOpaque(false);
		ritirobtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		ritirobtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		ritirobtnChiudiSessione.setForeground(Color.WHITE);
		ritirobtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		ritirobtnChiudiSessione.setContentAreaFilled(false);
		ritirobtnChiudiSessione.setBorderPainted(false);
		ritirobtnChiudiSessione.setBounds(416, 613, 629, 57);
		ritiroPremio.add(ritirobtnChiudiSessione);
		
		JLabel ritirolblSelezionePremio = new JLabel("Seleziona un premio");
		ritirolblSelezionePremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblSelezionePremio.setForeground(Color.BLACK);
		ritirolblSelezionePremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblSelezionePremio.setBounds(416, 56, 629, 57);
		ritiroPremio.add(ritirolblSelezionePremio);
		
		JLabel ritirolblRitiroPremio = new JLabel("RITIRO PREMI");
		ritirolblRitiroPremio.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblRitiroPremio.setForeground(Color.BLACK);
		ritirolblRitiroPremio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		ritirolblRitiroPremio.setBounds(416, 0, 629, 57);
		ritiroPremio.add(ritirolblRitiroPremio);
		
		JLabel ritirolblPuntiTessera = new JLabel("Punti tessera: ");
		ritirolblPuntiTessera.setHorizontalAlignment(SwingConstants.CENTER);
		ritirolblPuntiTessera.setForeground(Color.BLACK);
		ritirolblPuntiTessera.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		ritirolblPuntiTessera.setBounds(416, 113, 629, 57);
		ritiroPremio.add(ritirolblPuntiTessera);
		
		JButton ritirobtnRitira = new JButton("Ritira", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
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
		
		JRadioButton option10 = new JRadioButton(" 10%");
		option10.setFont(new Font("Dialog", Font.PLAIN, 30));
		option10.setBounds(465, 250, 127, 50);
		ritiroPremio.add(option10);
		option10.setOpaque(false);
		
		JRadioButton option30 = new JRadioButton(" 30%");
		option30.setFont(new Font("Dialog", Font.PLAIN, 30));
		option30.setBounds(465, 300, 127, 50);
		ritiroPremio.add(option30);
		option30.setOpaque(false);
		
		JRadioButton option50 = new JRadioButton(" 50%");
		option50.setFont(new Font("Dialog", Font.PLAIN, 30));
		option50.setBounds(465, 350, 127, 50);
		ritiroPremio.add(option50);
		option50.setOpaque(false);
		
		JRadioButton option75 = new JRadioButton(" 75%");
		option75.setFont(new Font("Dialog", Font.PLAIN, 30));
		option75.setBounds(465, 400, 127, 50);
		ritiroPremio.add(option75);
		option75.setOpaque(false);
		
		ButtonGroup buoniSconto = new ButtonGroup();
		buoniSconto.add(option10);
		buoniSconto.add(option30);
		buoniSconto.add(option50);
		buoniSconto.add(option75);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/ccc.png")));
		label.setBounds(609, 248, 424, 199);
		ritiroPremio.add(label);
		//SCANSIONE TESSERA
		JLabel scanTesseralblBenvenuto;
		scanTesseralblBenvenuto = new JLabel("BENVENUTO");
		scanTesseralblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblBenvenuto.setForeground(Color.BLACK);
		scanTesseralblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanTesseralblBenvenuto.setBounds(426, 0, 619, 49);
		scansioneTessera.add(scanTesseralblBenvenuto);

		JButton scanTesserabtnInfo;
		scanTesserabtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(about);
				seconds = 30;
			}
		});
		scanTesserabtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnInfo.setOpaque(false);
		scanTesserabtnInfo.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnInfo.setForeground(Color.BLACK);
		scanTesserabtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnInfo.setContentAreaFilled(false);
		scanTesserabtnInfo.setBorderPainted(false);
		scanTesserabtnInfo.setBounds(0, 456, 418, 57);
		scansioneTessera.add(scanTesserabtnInfo);

		// Avvia scansione		
		JButton scanTesserabtnAvviaScansione = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds = 30;
				idTessera = scanTesseratxtInputCodice.getText();
				tesseraScansionata = new Tessera(idTessera);
				if (tesseraScansionata.verificaPresenza()) {
					puntiTessera = tesseraScansionata.getPunti();
					ritirolblPuntiTessera.setText("Punti tessera: "+String.valueOf(puntiTessera));
					switchPanel(ritiroPremio);
				}		
			}
		});
		scanTesserabtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanTesserabtnAvviaScansione.setBorderPainted(false);
		scanTesserabtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		scanTesserabtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnAvviaScansione.setForeground(Color.BLACK);
		scanTesserabtnAvviaScansione.setContentAreaFilled(false);
		//scanTesserabtnAvviaScansione.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent arg0) {
//						//leggo il barcode in input
//						barcodeProdotto = scantxtInputBarcode.getText();
//						
//						//prodotto
//						prodottoScansionato = new Prodotto(barcodeProdotto);
//						
//						//VERIFICARE CORRETTEZZA CODICE A BARRE
//						
//						// output
//						if (prodottoScansionato.isPresenza()) {					
//							
//							//policy
//							policyProdotto = new Policy("AP", prodottoScansionato);					
//							prodottoScansionato.getDati();
//							
//							//cestinosmart				
//							CestinoSmart cestinoS = new CestinoSmart();
//							try {
//								cestinoS.conferimentoProdotto(prodottoScansionato);
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}			
//							
//							prodottoScansionato.getDati();
//					
//							ImageIcon image = new ImageIcon(prodottoScansionato.getImmagine());
//							Image im = image.getImage();
//							Image myImg = im.getScaledInstance(conflblImmagineProdotto.getWidth(),
//							conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
//							ImageIcon newImage = new ImageIcon(myImg);
//							conflblImmagineProdotto.setIcon(newImage);
//							conflblImmagineProdotto.setIcon(newImage);
//							
//							//prodotto nel db allora procedo con il conferimento
//							switchPanel(conferimento);
//							
//						} else {
//							System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");					
//							switchPanel(erroreConf);	//pannello di errore
//						}
//					}
//				});
		scanTesserabtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansioneTessera.add(scanTesserabtnAvviaScansione);

		JLabel scanTesseralblLogo = new JLabel("");
		scanTesseralblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		scanTesseralblLogo.setBounds(0, 0, 418, 488);
		scansioneTessera.add(scanTesseralblLogo);

		JLabel scanTesseralblScansionaProdotto = new JLabel("Scansione Tessera");
		scanTesseralblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblScansionaProdotto.setForeground(Color.BLACK);
		scanTesseralblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanTesseralblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansioneTessera.add(scanTesseralblScansionaProdotto);
		
		JLabel scanTesseratxtBarcode = new JLabel();
		scanTesseratxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseratxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scanTesseratxtBarcode.setText("Codice:");
		scanTesseratxtBarcode.setBounds(426, 321, 619, 49);
		scanTesseratxtBarcode.setOpaque(false);
		scansioneTessera.add(scanTesseratxtBarcode);		
		
		
		
		JLabel scanTesseralblInputBackground = new JLabel("");
		scanTesseralblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanTesseralblInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebutton.png")));
		scanTesseralblInputBackground.setBounds(430, 357, 615, 96);
		scansioneTessera.add(scanTesseralblInputBackground);
		
		JButton scanTesserabtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanTesserabtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		scanTesserabtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnProblemiAssistenza.setForeground(Color.BLACK);
		scanTesserabtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnProblemiAssistenza.setContentAreaFilled(false);
		scanTesserabtnProblemiAssistenza.setBorderPainted(false);
		scanTesserabtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		scansioneTessera.add(scanTesserabtnProblemiAssistenza);
		
		
		
		JButton scanTesserabtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		scanTesserabtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		
		scanTesserabtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		scanTesserabtnChiudiSessione.setOpaque(false);
		scanTesserabtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		scanTesserabtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		scanTesserabtnChiudiSessione.setForeground(Color.WHITE);
		scanTesserabtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanTesserabtnChiudiSessione.setContentAreaFilled(false);
		scanTesserabtnChiudiSessione.setBorderPainted(false);
		scanTesserabtnChiudiSessione.setBounds(416, 613, 629, 57);
		scansioneTessera.add(scanTesserabtnChiudiSessione);
		
		//SCANSIONE	
		JLabel scanlblBenvenuto;
		scanlblBenvenuto = new JLabel("BENVENUTO");
		scanlblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblBenvenuto.setForeground(Color.BLACK);
		scanlblBenvenuto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		scanlblBenvenuto.setBounds(426, 0, 619, 49);
		scansione.add(scanlblBenvenuto);

		JButton scanbtnInfo;
		scannbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scannbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(about);
				seconds = 30;
			}
		});
		scannbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		scannbtnInfo.setOpaque(false);
		scannbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		scannbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		scannbtnInfo.setForeground(Color.BLACK);
		scannbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scannbtnInfo.setContentAreaFilled(false);
		scannbtnInfo.setBorderPainted(false);
		scannbtnInfo.setBounds(0, 456, 418, 57);
		scansione.add(scannbtnInfo);

		// Avvia scansione		
		JButton scanbtnAvviaScansione = new JButton("Avvia scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnAvviaScansione.setVerticalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setHorizontalTextPosition(JButton.CENTER);
		scanbtnAvviaScansione.setBorderPainted(false);
		scanbtnAvviaScansione.setMargin(new Insets(0, 0, 0, 0));
		// btnScansionaProdotto.setIcon(new
		// ImageIcon(Main.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbutton.png")));
		scanbtnAvviaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnAvviaScansione.setForeground(Color.BLACK);
		scanbtnAvviaScansione.setContentAreaFilled(false);
		scanbtnAvviaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//avvia timer
				seconds = 30;
				
				//leggo il barcode in input
				barcodeProdotto = scantxtInputBarcode.getText();
				
				//prodotto
				prodottoScansionato = new Prodotto(barcodeProdotto);
				
				//VERIFICARE CORRETTEZZA CODICE A BARRE
				
				// output
				if (prodottoScansionato.isPresenza()) {					
					
					//policy
					policyProdotto = new Policy("AP", prodottoScansionato);					
					prodottoScansionato.getDati();
					
					//cestinosmart				
					CestinoSmart cestinoS = new CestinoSmart();
					try {
						cestinoS.conferimentoProdotto(prodottoScansionato);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
					prodottoScansionato.getDati();
			
					ImageIcon image = new ImageIcon(prodottoScansionato.getImmagine());
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(conflblImmagineProdotto.getWidth(),
					conflblImmagineProdotto.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newImage = new ImageIcon(myImg);
					conflblImmagineProdotto.setIcon(newImage);
					conflblImmagineProdotto.setIcon(newImage);
					
					//prodotto nel db allora procedo con il conferimento
					switchPanel(conferimento);
					
				} else {
					System.out.println("\nProdotto non presente nel DB, invia notifica per aggiungerlo");					
					switchPanel(erroreConf);	//pannello di errore
				}
			}
		});
		scanbtnAvviaScansione.setBounds(416, 212, 629, 96);
		scansione.add(scanbtnAvviaScansione);

		JLabel scanlblLogo = new JLabel("");
		scanlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		scanlblLogo.setBounds(0, 0, 418, 488);
		scansione.add(scanlblLogo);

		JLabel scanlblScansionaProdotto = new JLabel("Scansione Prodotto");
		scanlblScansionaProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblScansionaProdotto.setForeground(Color.BLACK);
		scanlblScansionaProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		scanlblScansionaProdotto.setBounds(416, 97, 629, 57);
		scansione.add(scanlblScansionaProdotto);
		
		scantxtInputBarcode = new JTextField();
		scantxtInputBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtInputBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtInputBarcode.setBounds(632, 384, 212, 44);
		scantxtInputBarcode.setOpaque(false);
		scansione.add(scantxtInputBarcode);
		scantxtInputBarcode.setColumns(10);
		
		JLabel scanlblInputBackground = new JLabel("");
		scanlblInputBackground.setHorizontalAlignment(SwingConstants.CENTER);
		scanlblInputBackground.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonsmall.png")));
		scanlblInputBackground.setBounds(430, 357, 615, 96);
		scansione.add(scanlblInputBackground);
		
		JButton scanbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		scanbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		scanbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		scanbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnProblemiAssistenza.setForeground(Color.BLACK);
		scanbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnProblemiAssistenza.setContentAreaFilled(false);
		scanbtnProblemiAssistenza.setBorderPainted(false);
		scanbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		scansione.add(scanbtnProblemiAssistenza);
		
		JLabel scantxtBarcode = new JLabel();
		scantxtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		scantxtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scantxtBarcode.setText("Barcode:");
		scantxtBarcode.setBounds(426, 321, 619, 49);
		scantxtBarcode.setOpaque(false);
		scansione.add(scantxtBarcode);		
		
		JButton scanbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		scanbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		
		scanbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setOpaque(false);
		scanbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		scanbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		scanbtnChiudiSessione.setForeground(Color.WHITE);
		scanbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		scanbtnChiudiSessione.setContentAreaFilled(false);
		scanbtnChiudiSessione.setBorderPainted(false);
		scanbtnChiudiSessione.setBounds(416, 613, 629, 57);
		scansione.add(scanbtnChiudiSessione);
		
		
		//ISTRUZIONI CONFERIMENTO
		JLabel istrlblConferimentoProdotto = new JLabel("ISTRUZIONI CONFERIMENTO");
		istrlblConferimentoProdotto.setForeground(Color.BLACK);
		istrlblConferimentoProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblConferimentoProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		istrlblConferimentoProdotto.setBounds(416, 0, 629, 57);
		istruzioneConf.add(istrlblConferimentoProdotto);

		JButton istrbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.setVerticalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setHorizontalTextPosition(JButton.CENTER);
		istrbtnProblemiAssistenza.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		istrbtnProblemiAssistenza.setOpaque(false);
		istrbtnProblemiAssistenza.setForeground(Color.BLACK);
		istrbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnProblemiAssistenza.setContentAreaFilled(false);
		istrbtnProblemiAssistenza.setBorderPainted(false);
		istrbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		istruzioneConf.add(istrbtnProblemiAssistenza);

		JButton istrbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		istrbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnInfo.setOpaque(false);
		istrbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		istrbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnInfo.setForeground(Color.BLACK);
		istrbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnInfo.setContentAreaFilled(false);
		istrbtnInfo.setBorderPainted(false);
		istrbtnInfo.setBounds(0, 456, 418, 57);
		istruzioneConf.add(istrbtnInfo);

		JLabel istrlblLogo = new JLabel("");
		istrlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		istrlblLogo.setBounds(0, 0, 418, 488);
		istruzioneConf.add(istrlblLogo);

		JLabel istrlblDescrizione = new JLabel("descrizione prodotto");
		istrlblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblDescrizione.setBounds(416, 137, 629, 136);
		istruzioneConf.add(istrlblDescrizione);
		
		//punti
		JLabel istrlblPunti = new JLabel("Punti guadagnati");
		istrlblPunti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		istrlblPunti.setHorizontalAlignment(SwingConstants.CENTER);
		istrlblPunti.setBounds(417, 258, 628, 69);
		istruzioneConf.add(istrlblPunti);
		
		//nuova scansione
		JButton istrbtnNuovaScansione = new JButton("Nuova scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		istrbtnNuovaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
				seconds = 30;
			}
		});
		istrbtnNuovaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnNuovaScansione.setOpaque(false);
		istrbtnNuovaScansione.setMargin(new Insets(0, 0, 0, 0));
		istrbtnNuovaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnNuovaScansione.setForeground(Color.BLACK);
		istrbtnNuovaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnNuovaScansione.setContentAreaFilled(false);
		istrbtnNuovaScansione.setBorderPainted(false);
		istrbtnNuovaScansione.setBounds(416, 456, 629, 57);
		istruzioneConf.add(istrbtnNuovaScansione);
		
		JButton istrbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		istrbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		istrbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		istrbtnChiudiSessione.setOpaque(false);
		istrbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		istrbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		istrbtnChiudiSessione.setForeground(Color.WHITE);
		istrbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		istrbtnChiudiSessione.setContentAreaFilled(false);
		istrbtnChiudiSessione.setBorderPainted(false);
		istrbtnChiudiSessione.setBounds(416, 613, 629, 57);
		istruzioneConf.add(istrbtnChiudiSessione);
		
		
		JLabel lblPuntiprodotto = new JLabel("PuntiProdotto");
		lblPuntiprodotto.setBounds(679, 398, 124, 23);
		
		//CONFERIMENTO
		JLabel conflblScansioneProdotto = new JLabel("CONFERIMENTO PRODOTTO");
		conflblScansioneProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblScansioneProdotto.setForeground(Color.BLACK);
		conflblScansioneProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		conflblScansioneProdotto.setBounds(416, 0, 629, 57);
		conferimento.add(conflblScansioneProdotto);		
		
		// prodotto errato		
		JButton confbtnProdottoVisualizzatoErrato = new JButton("Prodotto errato", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonSmall.png")));
		confbtnProdottoVisualizzatoErrato.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(scansione);
				seconds = 30;
			}
		});
		confbtnProdottoVisualizzatoErrato.setOpaque(false);
		confbtnProdottoVisualizzatoErrato.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoErrato.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoErrato.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoErrato.setBorderPainted(false);
		confbtnProdottoVisualizzatoErrato.setBounds(749, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoErrato);

		// prodotto corretto		
		JButton confbtnProdottoVisualizzatoCorretto = new JButton("Prodotto corretto", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		confbtnProdottoVisualizzatoCorretto.setVerticalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setHorizontalTextPosition(JButton.CENTER);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setMargin(new Insets(0, 0, 0, 0));
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(istruzioneConf);
				seconds = 30;
				
				// prendo il valore dalla variabile globale				
				istrlblPunti.setText("Punti guadagnati: " + String.valueOf(prodottoScansionato.getPunti()));
				
				//DA AGGIUNGERE DESCRIZIONE
				istrlblDescrizione.setText(prodottoScansionato.getDescrizione());
			}

		});
		confbtnProdottoVisualizzatoCorretto.setOpaque(false);
		confbtnProdottoVisualizzatoCorretto.setForeground(Color.BLACK);
		confbtnProdottoVisualizzatoCorretto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProdottoVisualizzatoCorretto.setContentAreaFilled(false);
		confbtnProdottoVisualizzatoCorretto.setBorderPainted(false);
		confbtnProdottoVisualizzatoCorretto.setBounds(470, 449, 255, 57);
		conferimento.add(confbtnProdottoVisualizzatoCorretto);

//		JLabel conflblImmagineProdotto = new JLabel("immagine prodotto");
		conflblImmagineProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		conflblImmagineProdotto.setBounds(600, 84, 269, 257);
		conferimento.add(conflblImmagineProdotto);

		JLabel conflblLogo = new JLabel("");
		conflblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		conflblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		conflblLogo.setBounds(0, 0, 418, 488);
		conferimento.add(conflblLogo);
		
		JButton confbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		confbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		confbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnProblemiAssistenza.setOpaque(false);
		confbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		confbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnProblemiAssistenza.setForeground(Color.BLACK);
		confbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnProblemiAssistenza.setContentAreaFilled(false);
		confbtnProblemiAssistenza.setBorderPainted(false);
		confbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		conferimento.add(confbtnProblemiAssistenza);
		
		JButton confbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		confbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(about);
				seconds = 30;
			}
		});
		confbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnInfo.setOpaque(false);
		confbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		confbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnInfo.setForeground(Color.BLACK);
		confbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnInfo.setContentAreaFilled(false);
		confbtnInfo.setBorderPainted(false);
		confbtnInfo.setBounds(0, 456, 418, 57);
		conferimento.add(confbtnInfo);		
		
		JButton confbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		confbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		confbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		confbtnChiudiSessione.setOpaque(false);
		confbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		confbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		confbtnChiudiSessione.setForeground(Color.WHITE);
		confbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		confbtnChiudiSessione.setContentAreaFilled(false);
		confbtnChiudiSessione.setBorderPainted(false);
		confbtnChiudiSessione.setBounds(416, 613, 629, 57);
		conferimento.add(confbtnChiudiSessione);
		
		//ERRORE CONFERIMENTO
		JLabel errlblErroreProdotto = new JLabel("ERRORE PRODOTTO");
		errlblErroreProdotto.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErroreProdotto.setForeground(Color.BLACK);
		errlblErroreProdotto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		errlblErroreProdotto.setBounds(416, 0, 629, 57);
		erroreConf.add(errlblErroreProdotto);
		
		JButton errbtnRitentaScansione = new JButton("Ritenta scansione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/whitebuttonSmall.png")));
		errbtnRitentaScansione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				try {
					Start.main(args);   //da controlla
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switchPanel(scansione);				
			}
		});
		errbtnRitentaScansione.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnRitentaScansione.setOpaque(false);
		errbtnRitentaScansione.setMargin(new Insets(0, 0, 0, 0));
		errbtnRitentaScansione.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnRitentaScansione.setForeground(Color.BLACK);
		errbtnRitentaScansione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnRitentaScansione.setContentAreaFilled(false);
		errbtnRitentaScansione.setBorderPainted(false);
		errbtnRitentaScansione.setBounds(416, 464, 628, 57);
		erroreConf.add(errbtnRitentaScansione);
		
		JButton errbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		errbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		errbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		errbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnProblemiAssistenza.setForeground(Color.BLACK);
		errbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnProblemiAssistenza.setContentAreaFilled(false);
		errbtnProblemiAssistenza.setBorderPainted(false);
		errbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		erroreConf.add(errbtnProblemiAssistenza);
		
		
		JButton errbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		errbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		errbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnInfo.setOpaque(false);
		errbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		errbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnInfo.setForeground(Color.BLACK);
		errbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnInfo.setContentAreaFilled(false);
		errbtnInfo.setBorderPainted(false);
		errbtnInfo.setBounds(0, 456, 418, 57);
		erroreConf.add(errbtnInfo);
		
		JLabel errlblErrorImage = new JLabel("Image Not Found");
		errlblErrorImage.setFont(new Font("Tahoma", Font.BOLD, 20));
		errlblErrorImage.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/errorimage.png")));
		errlblErrorImage.setHorizontalAlignment(SwingConstants.CENTER);
		errlblErrorImage.setHorizontalTextPosition(JLabel.CENTER);
		errlblErrorImage.setVerticalTextPosition(JLabel.BOTTOM);
		errlblErrorImage.setBounds(416, 128, 629, 309);
		erroreConf.add(errlblErrorImage);
		
		JLabel errlblLogo = new JLabel("");
		errlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		errlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		errlblLogo.setBounds(0, 0, 418, 488);
		erroreConf.add(errlblLogo);
		
		JTextPane errtxtpnErroreRecuperoImmagine = new JTextPane();
		errtxtpnErroreRecuperoImmagine.setEditable(false);
		errtxtpnErroreRecuperoImmagine.setFont(new Font("Tahoma", Font.PLAIN, 25));		
		StyledDocument doc = errtxtpnErroreRecuperoImmagine.getStyledDocument();
		errtxtpnErroreRecuperoImmagine.setOpaque(false);
		errtxtpnErroreRecuperoImmagine.setText("possibili cause: prodotto non presente nel nostro database oppure errore temporaneo (ritenta scansione)");
		errtxtpnErroreRecuperoImmagine.setBounds(426, 70, 629, 73);
		erroreConf.add(errtxtpnErroreRecuperoImmagine);
		
		JButton errbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		errbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		errbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		errbtnChiudiSessione.setOpaque(false);
		errbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		errbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		errbtnChiudiSessione.setForeground(Color.WHITE);
		errbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		errbtnChiudiSessione.setContentAreaFilled(false);
		errbtnChiudiSessione.setBorderPainted(false);
		errbtnChiudiSessione.setBounds(416, 613, 629, 57);
		erroreConf.add(errbtnChiudiSessione);
		
		//ASSISTENZA
		JLabel asslblAssistenza = new JLabel("ASSISTENZA");
		asslblAssistenza.setHorizontalAlignment(SwingConstants.CENTER);
		asslblAssistenza.setForeground(Color.BLACK);
		asslblAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		asslblAssistenza.setBounds(416, 0, 629, 57);
		assistenza.add(asslblAssistenza);
		
		JButton assbtnInfo = new JButton("About us", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		assbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(about);
				seconds = 30;
			}
		});
		assbtnInfo.setVerticalTextPosition(SwingConstants.CENTER);
		assbtnInfo.setOpaque(false);
		assbtnInfo.setMargin(new Insets(0, 0, 0, 0));
		assbtnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		assbtnInfo.setForeground(Color.BLACK);
		assbtnInfo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		assbtnInfo.setContentAreaFilled(false);
		assbtnInfo.setBorderPainted(false);
		assbtnInfo.setBounds(0, 456, 418, 57);
		assistenza.add(assbtnInfo);
		
		JLabel asslblLogo = new JLabel("");
		asslblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		asslblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		asslblLogo.setBounds(0, 0, 418, 488);
		assistenza.add(asslblLogo);
		
		JTextPane asstxtpnTelefonoEmail = new JTextPane();
		asstxtpnTelefonoEmail.setEditable(false);
		asstxtpnTelefonoEmail.setText("Telefono:");
		asstxtpnTelefonoEmail.setText(asstxtpnTelefonoEmail.getText() + newLine + "Email:");
		asstxtpnTelefonoEmail.setOpaque(false);
		asstxtpnTelefonoEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		asstxtpnTelefonoEmail.setBounds(416, 86, 629, 73);
		StyledDocument docAss = asstxtpnTelefonoEmail.getStyledDocument();
		assistenza.add(asstxtpnTelefonoEmail);
		
		JButton assbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		assbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		assbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		assbtnChiudiSessione.setOpaque(false);
		assbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		assbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		assbtnChiudiSessione.setForeground(Color.WHITE);
		assbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		assbtnChiudiSessione.setContentAreaFilled(false);
		assbtnChiudiSessione.setBorderPainted(false);
		assbtnChiudiSessione.setBounds(416, 613, 629, 57);
		assistenza.add(assbtnChiudiSessione);
		
		//ABOUT
		JLabel aboutlblLogo = new JLabel("");
		aboutlblLogo.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/logo.png")));
		aboutlblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		aboutlblLogo.setBounds(0, 0, 418, 488);
		about.add(aboutlblLogo);
		
		JLabel aboutlblInformazioniTrashit = new JLabel("INFORMAZIONI TRASH-IT");
		aboutlblInformazioniTrashit.setHorizontalAlignment(SwingConstants.CENTER);
		aboutlblInformazioniTrashit.setForeground(Color.BLACK);
		aboutlblInformazioniTrashit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		aboutlblInformazioniTrashit.setBounds(416, 0, 629, 57);
		about.add(aboutlblInformazioniTrashit);
		
		JButton aboutbtnProblemiAssistenza = new JButton("Problemi? Assistenza", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		aboutbtnProblemiAssistenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(assistenza);
				seconds = 30;
			}
		});
		aboutbtnProblemiAssistenza.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnProblemiAssistenza.setOpaque(false);
		aboutbtnProblemiAssistenza.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnProblemiAssistenza.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnProblemiAssistenza.setForeground(Color.BLACK);
		aboutbtnProblemiAssistenza.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnProblemiAssistenza.setContentAreaFilled(false);
		aboutbtnProblemiAssistenza.setBorderPainted(false);
		aboutbtnProblemiAssistenza.setBounds(0, 613, 418, 57);
		about.add(aboutbtnProblemiAssistenza);
		
		JButton aboutbtnChiudiSessione = new JButton("Chiudi sessione", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/redbuttonSmall.png")));
		aboutbtnChiudiSessione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(sessione);
				timer.stop();
			}
		});
		aboutbtnChiudiSessione.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnChiudiSessione.setOpaque(false);
		aboutbtnChiudiSessione.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnChiudiSessione.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnChiudiSessione.setForeground(Color.WHITE);
		aboutbtnChiudiSessione.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnChiudiSessione.setContentAreaFilled(false);
		aboutbtnChiudiSessione.setBorderPainted(false);
		aboutbtnChiudiSessione.setBounds(416, 613, 629, 57);
		about.add(aboutbtnChiudiSessione);
		
		JTextPane abouttextPaneInfo = new JTextPane();
		abouttextPaneInfo.setText("Trash-it e' un'applicazione destinata al corretto svolgimento " + 
				" della raccolta differenziata. \nScansionando il codice a barre di un prodotto," + 
				" si potranno ricevere informazioni sul materiale di cui il prodotto e' composto" + 
				" e le relative indicazioni su dove gettarlo. \nVerranno poi applicate le specifiche policy di riciclo per ogni comune" + 
				"\nIl vantaggio dell'uso di questo sistema sta nel guadagno punti per l'utente, in modo da ritirare premi." +
				" \nE' inoltre possibile accedere alle statistiche relative ai prodotti conferiti nel comune.");
		abouttextPaneInfo.setOpaque(false);
		abouttextPaneInfo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		abouttextPaneInfo.setEditable(false);
		abouttextPaneInfo.setBounds(441, 70, 604, 342);
		about.add(abouttextPaneInfo);
		
		JButton aboutbtnHome = new JButton("Home Page", new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/greenbuttonSmall.png")));
		aboutbtnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(home);
				seconds = 30;
			}
		});
		aboutbtnHome.setVerticalTextPosition(SwingConstants.CENTER);
		aboutbtnHome.setOpaque(false);
		aboutbtnHome.setMargin(new Insets(0, 0, 0, 0));
		aboutbtnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		aboutbtnHome.setForeground(Color.WHITE);
		aboutbtnHome.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		aboutbtnHome.setContentAreaFilled(false);
		aboutbtnHome.setBorderPainted(false);
		aboutbtnHome.setBounds(416, 509, 629, 57);
		about.add(aboutbtnHome);
		
		//BACKGROUND
		JLabel background = new JLabel("");
		background.setBounds(0, -14, 1045, 761);
		background.setIcon(new ImageIcon(GuiMain.class.getResource("/ids/unicam/trashit/grafica/immagini/home.jpg")));
		contentPane.add(background);
		
		
	}
}